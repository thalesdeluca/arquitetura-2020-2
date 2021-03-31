package com.thalesdeluca.contents;

import com.thalesdeluca.enums.Metric;

public final class AluminiumContent extends Content {
  public AluminiumContent(String name, Metric metric, float onGround) {
    super(name, metric, onGround);
  }

  public float getIdeal(int groundTexture) {
    return 0;
  }
}