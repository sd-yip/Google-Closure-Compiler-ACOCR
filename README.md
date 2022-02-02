# Google Closure Compiler ACOCR

Google Closure Compiler with the internal option `assumeClosuresOnlyCaptureReferences` set to true
to enable optimization around curried functions.
For more context, see https://github.com/google/closure-compiler/issues/3713.

This NPM package tries to reuse official binaries from the `google-closure-compiler-java` package
while providing an alternative entry point that always sets `assumeClosuresOnlyCaptureReferences` to true.
By default, the latest version of `google-closure-compiler-java` is included.
You may need to pin the version in use as an explicit dependency or with `package-lock.json` (or any lock equivalents).

# Installation
*(Java 8 or later required)*
```sh
npm install google-closure-compiler-acocr
```

# Example Usage
```sh
google-closure-compiler-acocr -O ADVANCED --js index.js --js_output_file index.min.js
```
