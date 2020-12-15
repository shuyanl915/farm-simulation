package model;

public class seed {
    private int seed;
    private int crop;
    private int pest;
    public void seed() {
        seed = 0;
        crop = 0;
        pest = 0;
    }

    public int getSeedNum() {
        return seed;
    }
    void setSeedNum(int num){
        seed += num;
    }
    int getCrop(){
        return crop;
    }

    void setCrop(int num) {
        crop += num;
    }
    int getPest(){
        return pest;
    }
    void setPest(int num) {
        pest += num;
    }




}
