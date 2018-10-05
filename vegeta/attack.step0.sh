#!/bin/bash

echo "POST $1" | vegeta attack -rate "${RATE:-500}" -header 'content-type:application/json' -body .body.step0.json -duration "${DURATION:-50s}" | vegeta report -type=text
