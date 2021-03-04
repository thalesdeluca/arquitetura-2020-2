package com.thalesdeluca.app;

public abstract class Content {
  protected String name;
  protected Metric metric;
  protected float onGround;

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



