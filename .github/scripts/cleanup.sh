#!/usr/bin/env bash

echo "Cleaning up all decrypted files ..."
echo

# Remove all decrypted files
for file in ./homework/src/test/resources/*
do
  case $file in
    *.gpg) true ;;
    *) rm -Rvf "$file"
  esac
done

echo
echo "Cleaning up finished!"
