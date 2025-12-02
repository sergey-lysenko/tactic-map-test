#!/bin/bash

dir="$( dirname -- "$( readlink -f -- "$0"; )"; )"

start=$(date +"%s")
errors="${dir}/target/runs/errors"
mkdir -p "${errors}"

log() {
 echo "[$(date +"%s")] ${1}"
}

pushd "${dir}" || exit

 log "Starting Test execution from Shade Jar ..."
 java -jar target/bot-*-uber-jar.jar 2> "${errors}/${start}.errors.log"
 code=$?
 
popd || exit

finish=$(date +"%s")
runtime=$(bc <<< "${finish}"-"${start}")
log "Test execution took ${runtime} seconds"
exit ${code}