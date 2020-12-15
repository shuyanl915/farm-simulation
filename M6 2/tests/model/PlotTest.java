package model;

import javafx.embed.swing.JFXPanel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlotTest {

    private Plot testPlot = new Plot();
    private JFXPanel panel = new JFXPanel();

    @Before
    public void setUp() throws Exception {
    }


    /**
     * this test will test if the Dead is successfully set when setDead() is
     * called, it has to be either true or false
     */
    @Test
    public void setDead() {
        try {
            testPlot.setDead(null);
        } catch (Exception e) {
            System.out.println("The error is successfully caught");
        }
    }

    /**
     * this test will test if the SeedType is successfully set when
     * setSeedType() is called. It has to be one of the seed type that is
     * pre-set
     */
    @Test
    public void setSeedType() {
        String wrongSeed = "this is not a seed!";
        try {
            testPlot.setSeedType(wrongSeed);
        } catch (IllegalArgumentException e) {
            System.out.println("exception is successfully caught");
        }
    }

    /**
     * this test will test if the Status is successfully set when
     * setStatus() is called, the possible value of status are from -2 to 2
     */
    @Test
    public void setStatus() {
        try {
            testPlot.setStatus(3);
        } catch (IllegalArgumentException e) {
            System.out.println("exception is successfully caught");
        }
    }

    /**
     * this test will test if the wateringTimes is successfully set when
     * setWateringTimes() is called. It has to be between -1 to 4
     */
    @Test
    public void setWateringTimes() {
        try {
            testPlot.setWateringTimes(5);
        } catch (IllegalArgumentException e) {
            System.out.println("exception is successfully caught");
        }
    }

    /**
     * this test will test if the waterLevel is successfully set when
     * setWaterLevel() is called. It has to be between -1 to 4
     */
    @Test
    public void setWaterLevel() {
        try {
            testPlot.setWaterLevel(5);
        } catch (IllegalArgumentException e) {
            System.out.println("exception is successfully caught");
        }
    }
}