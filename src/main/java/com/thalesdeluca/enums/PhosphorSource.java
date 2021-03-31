package com.thalesdeluca.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.thalesdeluca.contents.PhosphorContent;

public enum PhosphorSource {
  SIMPLE_SUPERPHOSPHATE(1), TRIPLE_SUPERPHOSPHATE(2), MAP(3), DAP(4), YOORIN_TERMALPHOSPHATE(5),
  REACTIVE_ARAD_PHOSPHATE(6), REACTIVE_GARFSA_PHOSPHATE(7), REACTIVE_DAOUI_PHOSPHATE(8),
  PATOS_DE_MINAS_NATIVE_PHOSPHATE(9), THOMAS_SLAG(10), PHOSPHORIC_ACID(11), MAGNESIUM_MULTIPHOSPHATE(12);

  private int value;

  private static Map<Integer, PhosphorSource> map = Arrays.stream(values())
      .collect(Collectors.toMap(k -> k.value, k -> k));

  private PhosphorSource(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static PhosphorSource castFromInt(final int id) {
    return map.get(id);
  }

}
