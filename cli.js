#!/usr/bin/env node
const { spawn } = require('child_process')
const { delimiter, resolve } = require('path')

const entryPoint = [
  '-cp',
  `${resolve(__dirname, 'classes')}${delimiter}${require('google-closure-compiler-java')}`,
  'io.lemm.acocr.AcocrCommandLineRunner'
]
spawn('java', entryPoint.concat(process.argv.slice(2)), { stdio: 'inherit' }).on('exit', process.exit)
