package com.thalesdeluca.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum CultivationSystem {
  DIRECT_PLANT(1), CONVENTIONAL(2);

  private int value;
  private static Map<Integer, CultivationSystem> map = Arrays.stream(values())
      .collect(Collectors.toMap(k -> k.value, k -> k));

  private CultivationSystem(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static CultivationSystem castFromInt(final int id) {
    return map.getOrDefault(id, DIRECT_PLANT);
  }
}