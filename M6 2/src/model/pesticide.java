package model;

public class pesticide extends farmSupply{
    public pesticide(seed seedToPest ) {
        this.seedSpecial = seedToPest;
    }
    @Override
    void function(int num) {
        seedSpecial.setPest(num);
    }
}
