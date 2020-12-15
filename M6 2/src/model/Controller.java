package model;

import javafx.scene.text.Text;

import java.util.LinkedList;
import java.util.List;

public class Controller {

    private static String name;              //name of the player
    private static String difficulty;           //game difficulty
    private static String seedType;             //seed type
    private static String season;

    private static int capacity = 100;       //maximum cap
    private static int currentCapacity;      //current cap; seed's cap = 1, crop's cap = 3
    private static int money;
    private static int date = 1;
    private static int remainingCapacity = capacity - currentCapacity;
    private static List<Text> conditions = new LinkedList<>();
    private static PlotCollection plots = new PlotCollection();

    private static int pesticidesNum;
    private static int ferNum;
    private static int maxHarvest = 5;
    private static int maxWaterTimes = 5;
    private static int harvestTimes;
    private static int waterTimes;
    private static int buy = 0;
    private static boolean tractor = false;
    private static boolean irrigation = false;


    /**
     * controller
     */
    public Controller() {


    }

    /**
     * initial
     */
    public static void initialSetMoney() {
        if (Controller.getDifficulty().equals("Easy")) {
            money = 100;
        }
        if (Controller.getDifficulty().equals("Hard")) {
            money = 75;
        }
        if (Controller.getDifficulty().equals("Expert")) {
            money = 50;
        }
    }

    /**
     * get difficulty
     *
     * @return difficulty
     */
    public static String getDifficulty() {
        return difficulty;
    }

    /**
     * set difficulty
     *
     * @param difficulty difficulty
     */
    public static void setDifficulty(String difficulty) {
        Controller.difficulty = difficulty;
    }

    /**
     * get season
     *
     * @return season
     */
    public static String getSeason() {
        return season;
    }

    /**
     * set season
     *
     * @param season season
     */
    public static void setSeason(String season) {
        Controller.season = season;
    }

    /**
     * get seed type
     *
     * @return seed type
     */
    public static String getSeedType() {
        return seedType;
    }


    /**
     * set seed type
     *
     * @param seedType seed type
     */
    public static void setSeedType(String seedType) {
        Controller.seedType = seedType;
    }

    /**
     * set money
     *
     * @param newMoney money
     */
    public static void setMoney(int newMoney) {
        money = newMoney;
    }

    /**
     * get money
     *
     * @return money
     */
    public static int getMoney() {
        return money;
    }

    /**
     * set data
     *
     * @param newDate date
     */
    public static void setDate(int newDate) {
        date = newDate;
    }

    /**
     * get date
     *
     * @return date
     */
    public static int getDate() {
        return date;
    }

    /**
     * set condition
     *
     * @param newList condition
     */
    public static void setConditions(List<Text> newList) {
        conditions = newList;
    }

    /**
     * get condition
     *
     * @return condition
     */
    public static List<Text> getConditions() {
        return conditions;
    }




    /**
     * get name
     *
     * @return name
     */
    public static String getName() {
        return name;
    }

    /**
     * set name
     *
     * @param name name
     */
    public static void setName(String name) {
        Controller.name = name;
    }

    /**
     * get plots
     *
     * @return plots
     */
    public static PlotCollection getPlots() {
        return plots;
    }

    /**
     * getter
     *
     * @return int
     */
    public static int getPesticidesNum() {
        return pesticidesNum;
    }

    /**
     * get Ferlize Number
     * @return fertilize number
     */
    public static int getFerNum() {
        return ferNum;
    }

    /**
     * set fertilize number
     * @param fer the number to set
     */
    public static void setFerNum(int fer) {
        ferNum += fer;
    }

    /**
     * getter
     *
     * @param pesticides num
     */
    public static void setPesticidesNum(int pesticides) {
        pesticidesNum += pesticides;
    }
    /**
     * setter
     * @param maxH naxHarvest
     */
    public static void setMaxHarvest(int maxH) {maxHarvest = maxH; }

    /**
     * getter
     * @return max harvest
     */
    public static int getMaxHarvest() {return maxHarvest; }

    /**
     * setter
     * @param maxW max water time
     */
    public static void setMaxWaterTimes(int maxW) { maxWaterTimes += maxW; }

    /**
     * getter
     * @return max water time
     */
    public static int getMaxWaterTimes() { return maxWaterTimes; }

    /**
     * change water time
     * @param water add on water time
     */
    public static void updateWaterTimes(int water) {waterTimes += water;}

    /**
     * getter
     * @return water time
     */
    public static int getWaterTimes() { return waterTimes;}

    /**
     * setter for water times
     * @param w water times
     */
    public static void setWaterTimes(int w) {waterTimes = w;}

    /**
     * change harvest time
     * @param harvest add on harvest time
     */
    public static void updateHarvestTimes(int harvest) {harvestTimes += harvest;}

    /**
     * getter
     * @return harvest time
     */
    public static int getHarvestTimes() {return harvestTimes;}

    /**
     * setter
     * @param h harvest time
     */
    public static void setHarvestTimes(int h) { harvestTimes = h;}

    /**
     * setter
     * @param b buy or not
     */
    public static void setBuy(int b) { buy = b; }

    /**
     * getter
     * @return buy or not
     */
    public static int getBuy() {return buy;}

    /**
     * getter
     * @return tractor
     */
    public static boolean getTractor() {return tractor;}

    /**
     * getter
     * @return irrigation
     */
    public static boolean getIrrigation() {return irrigation;}

    /**
     * setter
     * @param bool new boolean
     */
    public static void setTractor(boolean bool) {tractor = bool;}
    /**
     * setter
     * @param bool new boolean
     */
    public static void setIrrigation(boolean bool) {irrigation = bool;}
}
