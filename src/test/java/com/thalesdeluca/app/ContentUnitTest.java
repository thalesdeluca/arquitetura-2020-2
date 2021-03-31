package com.thalesdeluca.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.thalesdeluca.contents.*;
import com.thalesdeluca.enums.*;

import org.junit.Test;

public class ContentUnitTest {
    @Test
    public void testAluminiumContent() {
        AluminiumContent aluminium = new AluminiumContent("Aluminium", Metric.MGDM, 0);
        assertEquals(0f, aluminium.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
        assertEquals(0f, aluminium.getIdeal(GroundTexture.AVG_TEXTURE.getValue()), 0);
    }

    @Test
    public void testCalciumContent() {
        CalciumContent calcium = new CalciumContent("Calcium", Metric.CMOL, 0);
        assertEquals(6f, calcium.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
        assertEquals(4f, calcium.getIdeal(GroundTexture.AVG_TEXTURE.getValue()), 0);
    }

    @Test
    public void testMagniesiumContent() {
        MagnesiumContent magnesium = new MagnesiumContent("Magnesium", Metric.CMOL, 0);
        assertEquals(1.5f, magnesium.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
        assertEquals(1f, magnesium.getIdeal(GroundTexture.AVG_TEXTURE.getValue()), 0);
    }

    @Test
    public void testPhosphorContent() {
        PhosphorContent phosphor = new PhosphorContent("Phosphor", Metric.MEHLICH, 0);
        assertEquals(9f, phosphor.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
        assertEquals(12f, phosphor.getIdeal(GroundTexture.AVG_TEXTURE.getValue()), 0);
    }

    @Test
    public void testPotassiumContent() {
        PotassiumContent potassium = new PotassiumContent("Potassium", Metric.CMOL, 0);
        assertEquals(0.35f, potassium.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
        assertEquals(0.25f, potassium.getIdeal(GroundTexture.AVG_TEXTURE.getValue()), 0);
    }

    @Test
    public void testSulfurContent() {
        SulfurContent sulfur = new SulfurContent("Sulfur", Metric.MGDM, 0);
        assertEquals(9f, sulfur.getIdeal(GroundTexture.CLAYISH.getValue()), 0);
        assertEquals(6f, sulfur.getIdeal(GroundTexture.AVG_TEXTURE.getValue()), 0);
    }

}
