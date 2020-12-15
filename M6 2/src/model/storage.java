package model;

public class storage {
    private static int capacity;
    private static int currentC = 0;

    public static int getCapacity() {return capacity;}
    public static void setCapacity(int num) {
        capacity += num;
    }
    public static int getCurrent() {return currentC;}
    public static void setCurrent(int num) {
        currentC += num;
    }

}
