package com.thalesdeluca.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Metric {
  MGDM(0), MEHLICH(1), CMOL(2);

  private int value;
  private static Map<Integer, Metric> map = Arrays.stream(values()).collect(Collectors.toMap(k -> k.value, k -> k));

  private Metric(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static Metric castFromInt(final int id) {
    return map.getOrDefault(id, MGDM);
  }
}