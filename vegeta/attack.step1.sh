#!/bin/bash
cd `dirname $0`

echo "GET $1?companySize=12&minPrice=1000&maxPrice=2000" | vegeta attack -rate "${RATE:-500}" -duration "${DURATION:-50s}" | vegeta report -type=text
