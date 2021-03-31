package com.thalesdeluca.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CTCEquilibriumCorrectionTest {
  @Test
  public void testSCmol() {
    assertEquals(7.54, CTCEquilibriumCorrection.getSCmol(0.15, 5.76, 1.63), 0);
  }

  @Test
  public void testCTCCmol() {
    assertEquals(12.89, CTCEquilibriumCorrection.getCTCCmol(0.15, 5.76, 1.63, 5.35), 0);
  }

  @Test
  public void testVPercentual() {
    assertEquals(58.494957331264544,
        CTCEquilibriumCorrection.getVPercentual(CTCEquilibriumCorrection.getSCmol(0.15, 5.76, 1.63),
            CTCEquilibriumCorrection.getCTCCmol(0.15, 5.76, 1.63, 5.35)),
        0);
  }

  @Test
  public void testMOPercentual() {
    assertEquals(3.07, CTCEquilibriumCorrection.getMOPercentual(30.7), 0);
  }

  @Test
  public void testCarbon() {
    assertEquals(17.848837209302324, CTCEquilibriumCorrection.getCarbon(CTCEquilibriumCorrection.getMOPercentual(30.7)),
        0.00001);
  }
}
