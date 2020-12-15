package model;

public class PlotCollection {
    private Plot[] plotArray = new Plot[12];
    /*
        a1 a2 a3 a4
        b1 b2 b3 b4
        c1 c2 c3 c4
    **/
    /**
     * Add this method on next day button
     * */

    public PlotCollection() {
        for (int i = 0; i <= 11; i++) {
            plotArray[i] = new Plot();
        }
    }

    /**
     * get plot array
     * @return plot array
     */
    public Plot[] getPlotArray() {
        return plotArray;
    }

    /**
     * set plot array
     * @param plotArrayIn plot array
     */
    public void setPlotArray(Plot[] plotArrayIn) {
        plotArray = plotArrayIn;
    }
}
