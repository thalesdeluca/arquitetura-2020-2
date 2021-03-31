package com.thalesdeluca.contents;

import com.thalesdeluca.enums.*;

public final class PhosphorContent extends Content {
  public PhosphorContent(String name, Metric metric, float onGround) {
    super(name, metric, onGround);
  }

  public float getIdeal(int groundTexture) {
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