package com.thalesdeluca.app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.thalesdeluca.contents.*;
import com.thalesdeluca.enums.*;

public class PhosphorCorrection {
  private static final int MAX_RESIDUALS = 2;

  public static double getCost(PhosphorSource source, float costTon, float contentDesired, float efficiency,
      PhosphorContent content) {
    double needToAdd = contentDesired - content.getOnGround();
    double baseMgdm = needToAdd < 0.01 ? 0 : needToAdd;
    double kgka = baseMgdm * 2;
    double p2o5 = kgka * 2.29;
    double p2o5WithEfficiency = p2o5 * 100.0 / (efficiency / 100.0) / 100.0;
    double kgHectare = (p2o5WithEfficiency * 100.0) / getSourceContent(source);
    double kgBushel = kgHectare * 2.42;

    return ((costTon * kgBushel) / 2.42) / 1000;
  }

  private static float getSourceContent(PhosphorSource source) {
    switch (source) {
    case SIMPLE_SUPERPHOSPHATE:
      return 18;

    case TRIPLE_SUPERPHOSPHATE:
      return 41;

    case MAP:
      return 48;

    case DAP:
      return 45;

    case YOORIN_TERMALPHOSPHATE:
      return 18;

    case REACTIVE_ARAD_PHOSPHATE:
      return 33;

    case REACTIVE_GARFSA_PHOSPHATE:
      return 29;

    case REACTIVE_DAOUI_PHOSPHATE:
      return 32;

    case PATOS_DE_MINAS_NATIVE_PHOSPHATE:
      return 24;

    case THOMAS_SLAG:
      return 18.5f;

    case PHOSPHORIC_ACID:
      return 52;

    case MAGNESIUM_MULTIPHOSPHATE:
      return 18;
    default:
      return 0;
    }
  }

  public static Map<String, Double> getResiduals(PhosphorSource source, float contentDesired, float efficiency,
      PhosphorContent content) {
    double[] values = new double[MAX_RESIDUALS];
    String[] keys = new String[MAX_RESIDUALS];

    keys[0] = "";
    keys[1] = "";
    values[0] = 0;
    values[1] = 0;

    double needToAdd = contentDesired - content.getOnGround();
    double baseMgdm = needToAdd < 0.01 ? 0 : needToAdd;
    double kgka = baseMgdm * 2;
    double p2o5 = kgka * 2.29;
    double p2o5WithEfficiency = p2o5 * 100.0 / (efficiency / 100.0) / 100.0;
    double kgHectare = (p2o5WithEfficiency * 100.0) / getSourceContent(source);
    double kgBushel = kgHectare * 2.42;

    double factor = 1;

    switch (source) {
    case SIMPLE_SUPERPHOSPHATE:
      keys[0] = "Enxofre";
      keys[1] = "CÁLCIO";
      values[0] = kgBushel * 0.1 / 2.42;
      factor = 0.28;
      break;

    case TRIPLE_SUPERPHOSPHATE:
      keys[1] = "CÁLCIO";
      factor = 0.2;
      break;

    case MAP:
      keys[1] = "NITROGÊNIO";
      factor = 0.09;
      break;

    case DAP:
      keys[1] = "NITROGÊNIO";

      factor = 0.16;
      break;

    case YOORIN_TERMALPHOSPHATE:
      keys[1] = "CÁLCIO";
      keys[0] = "Magnésio";
      values[0] = kgHectare * 0.15;
      factor = 0.28;
      break;

    case REACTIVE_ARAD_PHOSPHATE:
      keys[1] = "CÁLCIO";
      factor = 0.52;
      break;

    case REACTIVE_GARFSA_PHOSPHATE:
      keys[1] = "CÁLCIO";
      factor = 0.52;
      break;

    case REACTIVE_DAOUI_PHOSPHATE:
      keys[1] = "CÁLCIO";
      factor = 0.45;
      break;

    case PATOS_DE_MINAS_NATIVE_PHOSPHATE:
      keys[1] = "CÁLCIO";
      factor = 0.28;
      break;

    case THOMAS_SLAG:
      keys[1] = "CÁLCIO";
      factor = 0.44;
      break;

    case PHOSPHORIC_ACID:
      factor = 0;
      break;

    case MAGNESIUM_MULTIPHOSPHATE:
      keys[0] = "Enxofre";
      values[0] = kgBushel * 0.11 / 2.42;
      factor = 0.18;
      break;
    }

    values[1] = (kgBushel * factor) / 2.42;

    HashMap<String, Double> map = new HashMap<String, Double>();

    for (int i = 0; i < keys.length; i++) {
      map.put(keys[i], values[i]);
    }

    return map;
  }
}