#!/usr/bin/env bash

echo "Secret files decrypting ..."

# Decrypt the files
gpg --quiet --batch --yes --decrypt --passphrase="$DECRYPTION_KEY" \
--output ./homework/src/test/resources/config.txt \
./homework/src/test/resources/config.txt.gpg

gpg --quiet --batch --yes --decrypt --passphrase="$DECRYPTION_KEY" \
--output ./homework/src/test/resources/Izumi_Sagiri.png \
./homework/src/test/resources/Izumi_Sagiri.png.gpg

echo "All files are decrypted!"
