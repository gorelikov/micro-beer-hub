#!/bin/bash
cd `dirname $0`

source ../.java.env-current.sh

function print_random_word {
  # The dictionary file. It contains one word per line.
  breeds=./dogs/breeds
  adjectives=./dogs/adjectives

  # The number of words in the dictionary file.
  num_words_in_breeds=$(wc -l $breeds | awk '{print $1}')
  num_words_in_adj=$(wc -l $adjectives | awk '{print $1}')

  # A random number corresponding to a line in the dictionary file.
  # This takes random data from /dev/random, converts it to an unsigned integer, and scales it by the number of words available.
  random_line_number_breeds=$(($(cat /dev/random | od -N3 -An -D) % $num_words_in_breeds))
  random_line_number_adj=$(($(cat /dev/random | od -N3 -An -D) % $num_words_in_adj))

  # Prints the word corresponding to the random line calculated above.
  random_breed=`awk "NR == $random_line_number_breeds" $breeds`
  random_adj=`awk "NR == $random_line_number_adj" $adjectives`
  echo "$random_adj-$random_breed"
}

for i in `seq 1 $1`
do
   java -jar -Dmicro.label $JAVA_OPTS -Dmicronaut.application.name=`print_random_word` build/libs/bar-tender-*-all.jar &
done


