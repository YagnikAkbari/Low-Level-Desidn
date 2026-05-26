#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$ROOT_DIR"

mkdir -p out

mapfile -t SOURCES < <(find src -name '*.java' -print)

if [ "${#SOURCES[@]}" -eq 0 ]; then
  echo "No Java sources found under src/"
  exit 1
fi

javac -d out "${SOURCES[@]}"
java -cp out com.Main "$@"
