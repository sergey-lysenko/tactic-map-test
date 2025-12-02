#!/bin/bash

dir="$( dirname -- "$( readlink -f -- "$0"; )"; )"

if [ -n "$1" ]; then
  name="$1"
else
  name=$(awk -F "#" '{print $1}' < "$dir/etc/device" | xargs)
fi
line=$(awk -F "#" '{print $1}' < "$dir/etc/params" | xargs)

echo "Starting device '${name}' with params ${line}"

rm "${HOME}/.android/avd/${name}.avd/*.lock"
emulator -avd "${name}" ${line}