package com.thalesdeluca.contents;

import com.thalesdeluca.enums.*;

public abstract class Content {
  protected String name;
  protected Metric metric;
  protected float onGround;

  public Content(String name, Metric metric, float onGround) {
    this.name = name;
    this.metric = metric;
    this.onGround = onGround;
  }

  public String getName() {
    return name;
  }

  public Metric getMetric() {
    return metric;
  }

  public float getOnGround() {
    return onGround;
  }

}
