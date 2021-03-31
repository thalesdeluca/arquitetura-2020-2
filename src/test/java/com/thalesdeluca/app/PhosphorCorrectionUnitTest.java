package com.thalesdeluca.app;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import com.thalesdeluca.contents.PhosphorContent;
import com.thalesdeluca.enums.Metric;
import com.thalesdeluca.enums.PhosphorSource;

import org.junit.Test;

public class PhosphorCorrectionUnitTest {
  @Test
  public void testGetResiduals() {
    PhosphorContent content = new PhosphorContent("Fósforo", Metric.MGDM, 8.59f);
    Map<String, Double> results = PhosphorCorrection.getResiduals(PhosphorSource.SIMPLE_SUPERPHOSPHATE, 12, 70,
        content);

    assertEquals(12.4, results.get("Enxofre"), 0.01);
    assertEquals(34.7, results.get("CÁLCIO"), 0.01);
  }

  @Test
  public void testGetCost() {
    PhosphorContent content = new PhosphorContent("Fósforo", Metric.MGDM, 8.59f);
    double result = PhosphorCorrection.getCost(PhosphorSource.SIMPLE_SUPERPHOSPHATE, 1256f, 12f, 70f, content);

    assertEquals(155.68, result, 0.01);
  }

}