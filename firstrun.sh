#!/bin/bash
mkdir -p eclipse/.metadata/.plugins/{org.eclipse.core.resources/.projects/Minecraft/,org.eclipse.core.runtime/.settings/}
touch eclipse/.metadata/.plugins/org.eclipse.core.resources/.projects/Minecraft/.location
touch eclipse/.metadata/.plugins/org.eclipse.core.runtime/.settings/org.eclipse.jdt.core.prefs
git submodule update --init --recursive
#gradle cleancache --refresh-dependencies
gradle setupdecompworkspace
gradle eclipse

mkdir -p build
cp -R ~/bin/lwjgl/natives build/
