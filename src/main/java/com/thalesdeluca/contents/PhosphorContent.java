package com.thalesdeluca.contents;

import com.thalesdeluca.enums.*;

public final class PhosphorContent extends Content {
  public PhosphorContent(String name, Metric metric, double onGround) {
    super(name, metric, onGround);
  }

  public double getIdeal(int groundTexture) {
    GroundTexture texture = GroundTexture.castFromInt(groundTexture);

    if (texture == GroundTexture.CLAYISH) {
      return 9.0f;
    }

    if (texture == GroundTexture.AVG_TEXTURE) {
      return 12.0f;
    }

    return 0;
  }
}