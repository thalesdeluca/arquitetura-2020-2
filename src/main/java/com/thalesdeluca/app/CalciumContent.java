package com.thalesdeluca.app;

public final class PhosporContent extends Content {
  public float getIdeal(int groundTexture) {
    GroundTexture texture = groundTexture;

    if(texture == GroundTexture.CLAYISH) {
      return 6;
    }

    if(texture == GroundTexture.AVG_TEXTURE) {
      return 4;
    }

    return 0;
  }
}