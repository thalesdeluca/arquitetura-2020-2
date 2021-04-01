package com.thalesdeluca.app;

import com.thalesdeluca.contents.*;
import com.thalesdeluca.enums.*;

public class PotassiumCorrection {
  public static double getActualPotassiumSoilCTC(Content content, double potassiumDesired) {
    double HAL = 5.35;
    double scmolWithHAL = CTCEquilibriumCorrection.getSCmol(0.15, 5.76, 1.63) + HAL;
    double result = (content.getOnGround()) / scmolWithHAL * 100;

    return result;
  }

  public static double getIdealPotassiumCTC(GroundTexture texture) {
    if (texture == GroundTexture.CLAYISH) {
      return 3;
    } else if (texture == GroundTexture.AVG_TEXTURE) {
      return 3;
    }

    return 0;
  }

  public static double getPostCorrectionPotassiumCTC(double potassiumDesired) {
    if (potassiumDesired <= 0.001) {
      return 0;
    }

    return potassiumDesired;
  }

  public static double getSourceContent(PotassiumSource source) {
    if (source == PotassiumSource.POTASSIUM_CHLORIDE) {
      return 58;
    }

    if (source == PotassiumSource.POTASSIUM_SULFATE) {
      return 52;
    }

    if (source == PotassiumSource.POTASSIUM_MAGNESIUM_SULFATE) {
      return 22;
    }

    if (source.getValue() == 4) {
      return 44;
    }

    return 0;
  }

  public static double getToBeApplied(PotassiumSource source, float efficiency, double potassiumDesired,
      Content content) {
    double kToAdd = (content.getOnGround() * (potassiumDesired * 100)
        / getActualPotassiumSoilCTC(content, potassiumDesired)) - content.getOnGround();
    double offsetCheck = kToAdd < 0.01 ? 0 : kToAdd;

    double cmoldm3ToMgdm = offsetCheck * 39.1 * 10;
    double mgdmToKgha = cmoldm3ToMgdm * 2;
    double kghaToK20 = mgdmToKgha * 1.2;
    double k20WithEfficiency = kghaToK20 * 100 / (efficiency / 100) / 100;

    double kgHectare = k20WithEfficiency * 100 / getSourceContent(source);
    return kgHectare;
  }

  public static double getCost(PotassiumSource source, float efficiency, double potassiumDesired, Content content,
      float costTon) {
    double kgBushel = getToBeApplied(source, efficiency, potassiumDesired, content) * 2.42;
    return (kgBushel * costTon / 1000) / 2.42;
  }
}