package com.thalesdeluca.contents;

import com.thalesdeluca.enums.*;

public final class PotassiumContent extends Content {
  public PotassiumContent(String name, Metric metric, double onGround) {
    super(name, metric, onGround);
  }

  public double getIdeal(int groundTexture) {
    GroundTexture texture = GroundTexture.castFromInt(groundTexture);

    if (texture == GroundTexture.CLAYISH) {
      return 0.35f;
    }

    if (texture == GroundTexture.AVG_TEXTURE) {
      return 0.25f;
    }

    return 0;
  }
}