package model;

public class Plot {

    private String seedType;
    private int status;

    private int waterLevel;
    private boolean isDead;
    private boolean pesticides;
    private int ferLevel;

    /**
     * get isPesticides
     *
     * @return boolean
     */
    public boolean isPesticides() {
        return pesticides;
    }

    /**
     * set isPesticides
     *
     * @param pesticides boolean
     */
    public void setPesticides(boolean pesticides) {
        this.pesticides = pesticides;
    }

    /**
     * get dead
     *
     * @return dead
     */
    public Boolean getDead() {
        return isDead;
    }

    /**
     * set isDead
     *
     * @param dead isdead
     */
    public void setDead(Boolean dead) {
        isDead = dead;
    }

    /**
     * constructor of plot
     */
    public Plot() {
        seedType = "";
        status = -1;
        waterLevel = 0;
        isDead = false;
        ferLevel = 0;
    }

    /**
     * method to water the plot
     */
    public void watering() {
        if (waterLevel < 4) { // the max waterLevel= 4;
            this.waterLevel++;
        }

        if (waterLevel >= 4 || waterLevel <= -1) {
            isDead = true;
            status = -2;
        }
    }

    /**
     * this method fertilize the plot
     */
    public void fertilizing() {
        if (Controller.getFerNum() > 0) {
            Controller.setFerNum(-1);
            if (status < 5 && status >= 0) {
                this.status++;
            }
            if (ferLevel < 3) {
                this.ferLevel++;
            }
        }
    }

    /**
     * method for seed to grow
     */
    public void grow() {

        if (waterLevel > -1) {
            waterLevel--;
        }
        System.out.println("water level"+ waterLevel);
        if (status == -2 || waterLevel > 3 || waterLevel < 0) {
            isDead = true;
            status = -2;
        }
        if (!isDead && status < 6) { // the max status value is = 3;
            status++;
            if (status == 6) {
                isDead = true;
                status = -2;
            }
        }
        if (ferLevel > 0) {
            ferLevel--;
        }
    }

    /**
     * method to get seed type
     *
     * @return seed type
     */
    public String getSeedType() {
        return seedType;
    }


    //"Sunflower", "Basil", "Soy Bean", "Hemp"

    /**
     * set seed type
     *
     * @param seedType seed type
     */
    public void setSeedType(String seedType) {
        this.seedType = seedType;
    }

    /**
     * Status = -2 Dead
     * Status = -1, empty
     * Status = 0 , seed
     * status = 1-4 , Immature plant
     * status = 5 , Mature plant
     * dead --> isDead== true;
     */
    /**
     * method to get status
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * set status
     *
     * @param status status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * get watering times
     *
     * @return eatering times
     */
    public int getWateringTimes() {
        return waterLevel;
    }

    /**
     * set watering times
     *
     * @param wateringTimes watering times
     */
    public void setWateringTimes(int wateringTimes) {
        this.waterLevel = wateringTimes;
    }

    /**
     * get water level
     *
     * @return water level
     */
    public int getWaterLevel() {
        return waterLevel;
    }

    /**
     * set water level
     *
     * @param waterLevel water level
     */
    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    /**
     * get fertilize level
     * @return fertilize level
     */
    public int getFerLevel() {
        return ferLevel; }

    /**
     * set fertilize level
     * @param ferLevel num for fertilize level
     */
    public void setFerLevel(int ferLevel) {
        this.ferLevel = ferLevel; }
}
