package com.thalesdeluca.contents;

import com.thalesdeluca.enums.Metric;

public final class AluminiumContent extends Content {
  public AluminiumContent(String name, Metric metric, double onGround) {
    super(name, metric, onGround);
  }

  public double getIdeal(int groundTexture) {
    return 0;
  }
}