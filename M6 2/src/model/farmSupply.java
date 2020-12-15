package model;

public abstract class farmSupply {
    seed seedSpecial;
    int supplyNum;
    abstract void function(int num);
    int getSupplyNum() {
        return supplyNum;
    }
    void setSupplyNum(int num) {
        supplyNum += num;
    }
}
