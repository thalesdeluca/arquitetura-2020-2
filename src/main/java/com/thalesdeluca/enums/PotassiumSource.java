package com.thalesdeluca.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum PotassiumSource {
  POTASSIUM_CHLORIDE(1), POTASSIUM_SULFATE(2), POTASSIUM_MAGNESIUM_SULFATE(3);

  private int value;
  private static Map<Integer, PotassiumSource> map = Arrays.stream(values())
      .collect(Collectors.toMap(k -> k.value, k -> k));

  private PotassiumSource(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static PotassiumSource castFromInt(final int id) {
    return map.get(id);
  }
}
