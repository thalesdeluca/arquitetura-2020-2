package com.thalesdeluca.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum GroundTexture {
  CLAYISH(1), AVG_TEXTURE(2);

  private int value;
  private static Map<Integer, GroundTexture> map = Arrays.stream(values())
      .collect(Collectors.toMap(k -> k.value, k -> k));

  private GroundTexture(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static GroundTexture castFromInt(final int id) {
    return map.getOrDefault(id, CLAYISH);
  }
}