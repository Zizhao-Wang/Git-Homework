#!/usr/bin/env bash

echo "Secret files decrypting ..."
echo

# Decrypt the files
gpg --batch --yes --decrypt --passphrase="$DECRYPTION_KEY" \
--output ./homework/src/test/resources/config.txt \
./homework/src/test/resources/config.txt.gpg

gpg --batch --yes --decrypt --passphrase="$DECRYPTION_KEY" \
--output ./homework/src/test/resources/Izumi_Sagiri.png \
./homework/src/test/resources/Izumi_Sagiri.png.gpg

echo
echo "All files are decrypted!"
