package model;


public class fertilizer extends farmSupply {
    public fertilizer(seed fertSeed){
        this.seedSpecial = fertSeed;
         supplyNum = 0;
    }
    @Override
    void function(int num) {
        //seedSpecial.setPest(num);

    }
}