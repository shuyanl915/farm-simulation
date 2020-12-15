package model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class RandomEvents {


    private static Plot[] plotsArray = Controller.getPlots().getPlotArray();
    private static String difficulty = Controller.getDifficulty();


    /**
     * constructor for random event
     */
    public RandomEvents() {
    }

    /**
     * increase the yield of a plot
     * @return int for the yield increased
     */
    public static int increaseYield() {
        Random rand = new Random();
        int randInt = rand.nextInt(20);
        if (randInt % 5 == 0) {
            return 3;
        } else if (randInt % 3 == 0) {
            return 2;
        } else {
            return 1;
        }
    }


    /**
     * generate the event
     * @return string for inform
     */
    public static String generateEvent() {
        Random rand = new Random();
        int randInt = rand.nextInt(6); //0 - 5

        if (randInt == 0) { //0 is rain
            int waterLeverInc = rain();
            return "Today is raining, the water level will be increased by " + waterLeverInc;
        } else if (randInt == 1) { //1 is drought
            int waterLevelDec = drought();
            return "Today is drought, the water level will be decreased by " + waterLevelDec;
        } else if (randInt == 2) { //2 is locusts
            LinkedList<Integer> deadList = locusts();
            String prtStr = Arrays.toString(deadList.toArray());
            return "Today is locusts, plots " + prtStr + " is killed.";
        }
        return "nothing happens today";
    }


    /**
     * method for rain
     * @return water level that need to be added
     */
    public static int rain() {
        Random rand = new Random();
        int randInt = rand.nextInt(2) + 1;

        for (int i = 0; i < 12; i++) {
            plotsArray[i].setWaterLevel(plotsArray[i].getWaterLevel() + randInt);
            if (plotsArray[i].getWaterLevel() >= 4) {
                plotsArray[i].setWaterLevel(4);
            } else if (plotsArray[i].getWaterLevel() <= -1) {
                plotsArray[i].setWaterLevel(-1);
            }
        }
        return randInt;
    }


    /**
     * method for drought
     * @return the water level that need to obe subtracted
     */
    public static int drought() {
        Random rand = new Random();
        int randInt = rand.nextInt(2) + 1;

        for (int i = 0; i < 12; i++) {
            plotsArray[i].setWaterLevel(plotsArray[i].getWaterLevel() - randInt);
            if (plotsArray[i].getWaterLevel() >= 4) {
                plotsArray[i].setWaterLevel(4);
            } else if (plotsArray[i].getWaterLevel() <= -1) {
                plotsArray[i].setWaterLevel(-1);
            }
        }
        return randInt;
    }


    /**
     * locusts method
     * @return the plot that died
     */
    public static LinkedList<Integer> locusts() {
        Random rand = new Random();
        LinkedList<Integer> deadPlots = new LinkedList();

        if (difficulty.equals("Easy")) {
            //2 plot kill
            int count = 0;
            while (count < 2) {
                int rand1 = rand.nextInt(12) + 1;
                if (!deadPlots.contains(rand1)) {
                    deadPlots.addLast(rand1);
                    count++;
                }
            }
        } else if (difficulty.equals("Hard")) {
            //4 plots kill
            int count = 0;
            while (count < 4) {
                int rand1 = rand.nextInt(12) + 1;
                if (!deadPlots.contains(rand1)) {
                    deadPlots.addLast(rand1);
                    count++;
                }
            }
        } else if (difficulty.equals("Expert")) {
            //6 plots kill
            int count = 0;
            while (count < 6) {
                int rand1 = rand.nextInt(12) + 1;
                if (!deadPlots.contains(rand1)) {
                    deadPlots.addLast(rand1);
                    count++;
                }
            }
        }
        killPlots(deadPlots);

        String prtStr = Arrays.toString(deadPlots.toArray());
        System.out.println(prtStr);
        return deadPlots;
    }


    /**
     * change the linked list to string
     * @param deadPlots the linked list for dead plot
     */
    private static void killPlots(LinkedList<Integer> deadPlots) {
        for (int each : deadPlots) {
            if (plotsArray[each - 1].getStatus() != -1 && !plotsArray[each - 1].isPesticides()) {
                plotsArray[each - 1].setDead(true);
                plotsArray[each - 1].setStatus(-2);
            }
        }
    }

}
