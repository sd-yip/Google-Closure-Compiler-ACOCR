package io.lemm.acocr;

import com.google.javascript.jscomp.CommandLineRunner;
import com.google.javascript.jscomp.CompilerOptions;

import java.util.logging.Logger;

import static java.util.logging.Level.OFF;

class AcocrCommandLineRunner extends CommandLineRunner {
  AcocrCommandLineRunner(String[] args) {
    super(args);
  }

  @Override
  protected CompilerOptions createOptions() {
    CompilerOptions options = super.createOptions();
    options.setAssumeClosuresOnlyCaptureReferences(true);
    return options;
  }

  public static void main(String[] args) {
    String phaseOptimizer = "com.google.javascript.jscomp.PhaseOptimizer";

    try {
      Class.forName(phaseOptimizer);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    Logger.getLogger(phaseOptimizer).setLevel(OFF);
    AcocrCommandLineRunner runner = new AcocrCommandLineRunner(args);

    if (runner.shouldRunCompiler()) {
      runner.run();
    }
    if (runner.hasErrors()) {
      System.exit(-1);
    }
  }
}
