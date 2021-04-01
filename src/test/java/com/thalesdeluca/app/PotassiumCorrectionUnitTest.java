package com.thalesdeluca.app;

import static org.junit.Assert.assertEquals;

import com.thalesdeluca.contents.*;
import com.thalesdeluca.enums.*;

import org.junit.Test;

public class PotassiumCorrectionUnitTest {
  @Test
  public void testGetActualPotassiumSoilCTC() {
    assertEquals(1.2,
        PotassiumCorrection.getActualPotassiumSoilCTC(new PotassiumContent("Potássio", Metric.CMOL, 0.15f), 2), 0.05);
  }

  @Test
  public void testGetPostCorrectionPotassiumCTC() {
    assertEquals(2, PotassiumCorrection.getPostCorrectionPotassiumCTC(2), 0);
  }

  @Test
  public void testGetIdealPotassiumCTC() {
    assertEquals(3, PotassiumCorrection.getIdealPotassiumCTC(GroundTexture.CLAYISH), 0);
  }

  @Test
  public void testGetToBeApplied() {
    assertEquals(205.19, PotassiumCorrection.getToBeApplied(PotassiumSource.POTASSIUM_CHLORIDE, 85, 2,
        new PotassiumContent("Potássio", Metric.CMOL, 0.15f)), 0.01);
  }

  @Test
  public void testGetCost() {
    assertEquals(512.98, PotassiumCorrection.getCost(PotassiumSource.POTASSIUM_CHLORIDE, 85, 2,
        new PotassiumContent("Potássio", Metric.CMOL, 0.15f), 2500), 0.01);
  }
}
