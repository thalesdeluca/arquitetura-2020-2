package com.thalesdeluca.contents;

import com.thalesdeluca.enums.*;

public final class CalciumContent extends Content {
  public CalciumContent(String name, Metric metric, float onGround) {
    super(name, metric, onGround);
  }

  public float getIdeal(int groundTexture) {
    GroundTexture texture = GroundTexture.castFromInt(groundTexture);

    if (texture == GroundTexture.CLAYISH) {
      return 6f;
    }

    if (texture == GroundTexture.AVG_TEXTURE) {
      return 4f;
    }

    return 0;
  }
}