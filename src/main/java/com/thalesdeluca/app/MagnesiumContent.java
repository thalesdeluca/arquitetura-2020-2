package com.thalesdeluca.app;

public final class PhosporContent extends Content {
  public float getIdeal(int groundTexture) {
    GroundTexture texture = groundTexture;

    if(texture == GroundTexture.CLAYISH) {
      return 1.5;
    }

    if(texture == GroundTexture.AVG_TEXTURE) {
      return 1;
    }

    return 0;
  }
}