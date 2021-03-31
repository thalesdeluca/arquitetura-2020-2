package com.thalesdeluca.contents;

import com.thalesdeluca.enums.*;

public final class MagnesiumContent extends Content {
  public MagnesiumContent(String name, Metric metric, float onGround) {
    super(name, metric, onGround);
  }

  public float getIdeal(int groundTexture) {
    GroundTexture texture = GroundTexture.castFromInt(groundTexture);

    if (texture == GroundTexture.CLAYISH) {
      return 1.5f;
    }

    if (texture == GroundTexture.AVG_TEXTURE) {
      return 1f;
    }

    return 0;
  }
}