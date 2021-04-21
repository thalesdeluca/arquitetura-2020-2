package com.thalesdeluca.contents;

import com.thalesdeluca.enums.*;

public abstract class Content {
  protected String name;
  protected Metric metric;
  protected double onGround;

  public Content(String name, Metric metric, double onGround) {
    this.name = name;
    this.metric = metric;
    this.onGround = onGround;
  }

  public double getOnGround() {
    return onGround;
  }

}
