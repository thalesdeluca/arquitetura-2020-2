package com.thalesdeluca.app;

public final class PhosporContent extends Content {
  public float getIdeal(int groundTexture) {
    GroundTexture texture = groundTexture;

    if(texture == GroundTexture.CLAYISH) {
      return 0.35;
    }

    if(texture == GroundTexture.AVG_TEXTURE) {
      return 0.25;
    }

    return 0;
  }
}