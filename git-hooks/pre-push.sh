#!C:/Program\ Files/Git/usr/bin/sh.exe

echo "Running static analysis."

./gradlew ktlintCheck
./gradlew detekt