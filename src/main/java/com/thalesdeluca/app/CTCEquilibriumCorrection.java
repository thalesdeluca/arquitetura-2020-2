package com.thalesdeluca.app;

public class CTCEquilibriumCorrection {
  public static double getSCmol(double potassium, double calcium, double magnesium) {
    return potassium + calcium + magnesium;
  }

  public static double getCTCCmol(double potassium, double calcium, double magnesium, double aluminiumHydrogen) {
    return getSCmol(potassium, calcium, magnesium) + aluminiumHydrogen;
  }

  public static double getVPercentual(double Scmol, double CTCmol) {
    if (Scmol > 0 && CTCmol > 0) {
      return Scmol / CTCmol * 100f;
    }

    return 0f;
  }

  public static double getMOPercentual(double mo) {
    if (mo > 0) {
      return mo / 10;
    }

    return 0f;
  }

  public static double getCarbon(double moPercentual) {
    if (moPercentual > 0) {
      return moPercentual / 1.72f * 10f;
    }

    return 0f;
  }
}
