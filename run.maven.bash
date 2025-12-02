#!/bin/bash

dir="$( dirname -- "$( readlink -f -- "$0"; )"; )"

start=$(date +"%s")
errors="${dir}/target/runs/errors"
mkdir -p "${errors}"

log() {
 echo "[$(date +"%s")] ${1}"
}

pushd "${dir}" || exit

 log "Starting Test Execution as Maven Build ..."
 mvn install exec:java 2> "${errors}/${start}.errors.log"
 code=$?
 
popd || exit

finish=$(date +"%s")
runtime=$(bc <<< "${finish}"-"${start}")
log "Test execution took ${runtime} seconds"
exit ${code}