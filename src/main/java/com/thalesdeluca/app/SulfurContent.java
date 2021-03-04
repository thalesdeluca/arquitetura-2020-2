package com.thalesdeluca.app;

public final class PhosporContent extends Content {
  public float getIdeal(int groundTexture) {
    GroundTexture texture = groundTexture;

    if(texture == GroundTexture.CLAYISH) {
      return 9.0;
    }

    if(texture == GroundTexture.AVG_TEXTURE) {
      return 6;
    }

    return 0;
  }
}