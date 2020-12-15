
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InitialUI2 implements Initializable {
    @FXML
    public Text maxHarvestText;
    @FXML
    public Text maxWaterTimesText;
    @FXML
    public Rectangle block11;
    @FXML
    public Rectangle block10;
    @FXML
    private Text moneyText;
    @FXML
    private Text dayText;
    @FXML
    private StackPane plot1;
    @FXML
    private StackPane plot2;
    @FXML
    private Text text1;
    @FXML
    private StackPane plot3;
    @FXML
    private StackPane plot4;
    @FXML
    private StackPane plot5;
    @FXML
    private StackPane plot6;
    @FXML
    private StackPane plot7;
    @FXML
    private StackPane plot8;
    @FXML
    private StackPane plot9;
    @FXML
    private StackPane plot10;
    @FXML
    private StackPane plot11;
    @FXML
    private StackPane plot12;
    @FXML
    private Text fer1;
    @FXML
    private Text fer2;
    @FXML
    private Text fer3;
    @FXML
    private Text fer4;
    @FXML
    private Text fer5;
    @FXML
    private Text fer6;
    @FXML
    private Text fer7;
    @FXML
    private Text fer8;
    @FXML
    private Text fer9;
    @FXML
    private Text fer10;
    @FXML
    private Text fer11;
    @FXML
    private Text fer12;
    @FXML
    private Text text2;
    @FXML
    private Text text3;
    @FXML
    private Text text4;
    @FXML
    private Text text5;
    @FXML
    private Text text6;
    @FXML
    private Text text7;
    @FXML
    private Text text8;
    @FXML
    private Text text9;
    @FXML
    private Text text10;
    @FXML
    private Text text11;
    @FXML
    private Text text12;
    @FXML
    private Text water1;
    @FXML
    private Text water2;
    @FXML
    private Text water3;
    @FXML
    private Text water4;
    @FXML
    private Text water5;
    @FXML
    private Text water6;
    @FXML
    private Text water7;
    @FXML
    private Text water8;
    @FXML
    private Text water9;
    @FXML
    private Text water10;
    @FXML
    private Text water11;
    @FXML
    private Text water12;

    @FXML
    private Text textp1;

    @FXML
    private Text textp2;

    @FXML
    private Text textp3;

    @FXML
    private Text textp4;

    @FXML
    private Text textp5;

    @FXML
    private Text textp6;

    @FXML
    private Text textp7;

    @FXML
    private Text textp8;

    @FXML
    private Text textp9;

    @FXML
    private Text textp10;

    @FXML
    private Text textp11;

    @FXML
    private Text textp12;


    @FXML
    private TextField plotLocation;

    @FXML
    private ComboBox<String> seedTypeCB;

    @FXML
    private Button nextDay;


    @FXML
    private Button plant;

    @FXML
    private Button addPesticides;

    @FXML
    private TextField ppLocation;
    @FXML
    private TextField sellQ;

    @FXML
    private TextField buyQ;

    @FXML
    private static Label moneyLabel;
    @FXML
    private Label dateLabel;


    @FXML
    private static String level;
    protected static int beginMoney;
    protected Inventory2 inv = new Inventory2();
    protected static int harvestNum;
    protected static int harvestSunFlowerNum;
    protected static int harvestBasilNum;
    protected static int harvestHempNum;
    protected static int harvestSoyBeanNum;
    protected static int harvestSunFlowerNumWithp;
    protected static int harvestBasilNumWithp;
    protected static int harvestHempNumWithp;
    protected static int harvestSoyBeanNumWithp;
    protected static int days = 0;
    private Text[] waterList;
    private Text[] ferList;
    private static TextField updateMoney;
    private static PlotCollection plots;
    protected static Plot[] plotsArray = Controller.getPlots().getPlotArray();
    protected static Text[] conditions;
    private static Text[] pesticidesConditions;
    private Button[] waterButton;
    private static RandomEvents randomEvt;
    private storage storehouse = new storage();
    private static int harvestCount = 0;
    private static int harvestChanceLeft = Controller.getMaxHarvest();




    /**
     * initialize
     */
    public InitialUI2() {

    }

    /**
     * initialize
     *
     * @param location url
     * @param resource resource
     */
    public void initialize(URL location, ResourceBundle resource) {
        storehouse.setCapacity(30);
        System.out.println(Controller.getMoney());
        ObservableList<String> list2
                = FXCollections.observableArrayList("Sunflower", "Basil", "Soy Bean", "Hemp");
        seedTypeCB.setItems(list2);


        moneyText.setText("$ " + Controller.getMoney());
        dayText.setText("Day " + Controller.getDate());
        maxHarvestText.setText("Max Harvest: " + Controller.getMaxHarvest());
        maxWaterTimesText.setText("Max water times: " + Controller.getMaxWaterTimes());


        this.conditions
                = new Text[]
                {text1, text2, text3, text4, text5,
                        text6, text7, text8, text9, text10, text11, text12};
        this.pesticidesConditions
                = new Text[]
                {textp1, textp2, textp3, textp4, textp5,
                        textp6, textp7, textp8, textp9, textp10, textp11, textp12};
        this.waterList
                = new Text[]
                {water1, water2, water3, water4,
                        water5, water6, water7, water8, water9, water10, water11, water12};
        this.ferList
                = new Text[]
                {fer1, fer2, fer3, fer4, fer5,
                        fer6, fer7, fer8, fer9, fer10, fer11, fer12};
        for (int i = 0; i < 12; i++) {
            pesticidesConditions[i].setText("Pesticides : " + plotsArray[i].isPesticides());
            if (plotsArray[i].getStatus() == -1) {
                conditions[i].setText("Empty");
            }
            if (plotsArray[i].getStatus() == 0) {
                conditions[i].setText(plotsArray[i].getSeedType() + " Sprout");
            }
            if (plotsArray[i].getStatus() == 1) {
                conditions[i].setText("seedling");
            }
            if (plotsArray[i].getStatus() == 2) {
                conditions[i].setText("Vegetative");
            }
            if (plotsArray[i].getStatus() == 3) {
                conditions[i].setText("Budding");
            }
            if (plotsArray[i].getStatus() == 4) {
                conditions[i].setText("Flowering");
            }
            if (plotsArray[i].getStatus() == 5) {
                conditions[i].setText("Ripe");
            }
            if (plotsArray[i].getDead()) {
                conditions[i].setText("Dead");
            }
            waterList[i].setText("Water Level: " + plotsArray[i].getWateringTimes());
            ferList[i].setText("Fertilizer Level: " + plotsArray[i].getFerLevel());

        }
        initializeInv(Controller.getSeedType());
        if (Controller.getBuy() == 2) {
            block10.toBack();
            block11.toBack();
        } else if (Controller.getBuy() == 1) {
            block10.toBack();
        }

    }

    /**
     * next day
     *
     * @param actionEvent action event
     */
    public void nextDay(ActionEvent actionEvent) {
        days = Controller.getDate() + 1;
        Controller.setDate(days);
        dayText.setText("Day " + Controller.getDate());

        //randomEvent
        String warningText = randomEvt.generateEvent();
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Warning");
        a.setHeaderText("Warning");
        a.setContentText(warningText);
        a.showAndWait();


        plotsArray = Controller.getPlots().getPlotArray();
        for (int i = 0; i < 12; i++) {
            if (plotsArray[i].getStatus() == -1) { //empty
                if (plotsArray[i].getWaterLevel() > -1) {
                    int newWater = plotsArray[i].getWaterLevel() - 1;
                    plotsArray[i].setWaterLevel(newWater);
                    waterList[i].setText("Water Level: " + plotsArray[i].getWateringTimes());
                }
                if (plotsArray[i].getFerLevel() > 0) {
                    plotsArray[i].setFerLevel(-1);
                    ferList[i].setText("Fertilize Level: " + plotsArray[i].getFerLevel());
                }
            } else if (plotsArray[i].getDead()) { //dead
                if (plotsArray[i].getWaterLevel() != -1) {
                    int newWater = plotsArray[i].getWaterLevel() - 1;
                    plotsArray[i].setWaterLevel(newWater);
                    waterList[i].setText("Water Level: " + plotsArray[i].getWateringTimes());
                }
                if (plotsArray[i].getFerLevel() > 0) {
                    plotsArray[i].setFerLevel(-1);
                    ferList[i].setText("Fertilize Level: " + plotsArray[i].getFerLevel());
                }
                conditions[i].setText("Dead");
            } else {
                plotsArray[i].grow();
                waterList[i].setText("Water Level: " + plotsArray[i].getWateringTimes());
                ferList[i].setText("Fertilize Level: " + plotsArray[i].getFerLevel());
                if (plotsArray[i].getStatus() == -1) {
                    conditions[i].setText("Empty");
                } else if (plotsArray[i].getStatus() == 0 && !plotsArray[i].getDead()) {
                    conditions[i].setText("Sprout");
                } else if (plotsArray[i].getStatus() == 1 && !plotsArray[i].getDead()) {
                    conditions[i].setText("Seedling");
                } else if (plotsArray[i].getStatus() == 2 && !plotsArray[i].getDead()) {
                    conditions[i].setText("Vegetative");
                } else if (plotsArray[i].getStatus() == 3 && !plotsArray[i].getDead()) {
                    conditions[i].setText("Budding");
                } else if (plotsArray[i].getStatus() == 4 && !plotsArray[i].getDead()) {
                    conditions[i].setText("Flowering");
                } else if (plotsArray[i].getStatus() == 5 && !plotsArray[i].getDead()) {
                    conditions[i].setText("Ripe");
                } else {
                    conditions[i].setText("Dead");
                }
            }
        }

        Controller.getPlots().setPlotArray(plotsArray);
        Controller.setHarvestTimes(0); //clear the harvest times for the day
        Controller.setWaterTimes(0);
        harvestChanceLeft = Controller.getMaxHarvest();


        checkConditions(actionEvent);
    }


    private void checkConditions(ActionEvent actionEvent) {

        boolean allDead = true;
        int end = Controller.getBuy() + 10;
        for (int i = 0; i < end; i++) {
            if (!plotsArray[i].getDead()) {
                allDead = false;
            }
        }
        int result = SeedNumberCalculator.calculator(inputC.sun.getSeedNum(), inputC.ba.getSeedNum(), inputC.he.getSeedNum(), inputC.soy.getSeedNum());
        boolean allDead2 = false;
        if (Controller.getMoney() < 4 && result == 0) {
            for (int i = 0; i < end; i++) {
                if (plotsArray[i].getDead() || plotsArray[i].getStatus() == -1) {
                    allDead2 = true;
                } else {
                    allDead2 = false;
                }
            }
        }
        //allDead &&
        if (allDead && Controller.getMoney() < 4 && result == 0) {
            sceneChange(actionEvent, "endgame.fxml");
        } else if (allDead2) {
            sceneChange(actionEvent, "endgame.fxml");
        }
    }


    /**
     * harvest
     *
     * @param actionEvent action event
     */
    public void harvest(ActionEvent actionEvent) {
        harvestSunFlowerNum = 0;
        harvestBasilNum = 0;
        harvestHempNum = 0;
        harvestSoyBeanNum = 0;

        harvestSunFlowerNumWithp = 0;
        harvestBasilNumWithp = 0;
        harvestHempNumWithp = 0;
        harvestSoyBeanNumWithp = 0;

        for (int i = 0; i < 12; i++) {
            if (conditions[i].getText().equals("Ripe")) {
                harvestCount++;
            }
        }
        if (harvestCount > Controller.getMaxHarvest()) {
            Controller.setHarvestTimes(Controller.getMaxHarvest());
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid");
            a.setContentText("You have reached the maximum harvest times, only the first " + Controller.getMaxHarvest() + "will be harvested, the rest of them will be cleaned automaticlly.");
            a.showAndWait();
        }

        if (harvestChanceLeft > 0) {
            for (int i = 0; i < 12; i++) {
                if (conditions[i].getText().equals("Ripe")) {
//                    if error, check this
//                    Controller.updateHarvestTimes(1);
                    if (plotsArray[i].getSeedType().equals("Sunflower")) {
                        if (plotsArray[i].isPesticides()) {
                            harvestSunFlowerNumWithp++;
                        } else {
                            if (plotsArray[i].getFerLevel() > 0) {
                                harvestSunFlowerNum += randomEvt.increaseYield();

                            } else {
                                harvestSunFlowerNum++;
                            }
                        }
                    } else if (plotsArray[i].getSeedType().equals("Basil")) {
                        if (plotsArray[i].isPesticides()) {
                            harvestBasilNumWithp++;
                        } else {
                            if (plotsArray[i].getFerLevel() > 0) {
                                harvestBasilNum += randomEvt.increaseYield();
                            } else {
                                harvestBasilNum++;

                            }
                        }
                    } else if (plotsArray[i].getSeedType().equals("Hemp")) {
                        if (plotsArray[i].isPesticides()) {
                            harvestHempNumWithp++;
                        } else {
                            if (plotsArray[i].getFerLevel() > 0) {
                                harvestHempNum += randomEvt.increaseYield();
                            } else {
                                harvestHempNum++;

                            }
                        }
                    } else if (plotsArray[i].getSeedType().equals("Soy Bean")) {
                        if (plotsArray[i].isPesticides()) {
                            harvestSoyBeanNumWithp++;
                        } else {
                            if (plotsArray[i].getFerLevel() > 0) {
                                harvestSoyBeanNum += randomEvt.increaseYield();
                            } else {
                                harvestSoyBeanNum++;

                            }
                        }
                    }

                    harvestChanceLeft--;
                    plotsArray[i].setStatus(-1);
                    conditions[i].setText("Empty");
                    pesticidesConditions[i].setText("Pesticides : False");
                    if (harvestChanceLeft <= 0) {
                        break;
                    }
                }
            }
        }


        updateInv(harvestSunFlowerNum, harvestBasilNum,
                harvestSoyBeanNum, harvestHempNum);
        updateInv2(harvestSunFlowerNumWithp, harvestBasilNumWithp,
                harvestSoyBeanNumWithp, harvestHempNumWithp);
        harvestCount = 0;

    }

    /**
     * uptdate Inventory
     *
     * @param sunFlowerNum num of sunFlower harvest
     * @param basilNum     num of basil harvest
     * @param soyBeanNum   num of soy bean harvest
     * @param hempNum      num of hemp harvest
     */
    public void updateInv(int sunFlowerNum, int basilNum, int soyBeanNum,
                          int hempNum) {
        inputC.sun.setCrop(sunFlowerNum);
        inputC.ba.setCrop(basilNum);
        inputC.soy.setCrop(soyBeanNum);
        inputC.he.setCrop(hempNum);

    }


    /**
     * @param harvestBasilNumWithp     harvestBasilNumWithp
     * @param harvestHempNumWithp      harvestHempNumWithp
     * @param harvestSoyBeanNumWithp   harvestSoyBeanNumWithp
     * @param harvestSunFlowerNumWithp harvestSunFlowerNumWithp
     */
    public void updateInv2(int harvestSunFlowerNumWithp, int harvestBasilNumWithp,
                           int harvestSoyBeanNumWithp,
                           int harvestHempNumWithp) {

        inputC.sunPest.function(harvestSunFlowerNumWithp);
        inputC.baPest.function(harvestBasilNumWithp);
        inputC.soyPest.function(harvestSoyBeanNumWithp);
        inputC.hePest.function(harvestHempNumWithp);

    }


    /**
     * inventory
     *
     * @param actionEvent action event
     */
    public void inventory(ActionEvent actionEvent) {
        sceneChange(actionEvent, "InventoryScene.fxml");
    }

    /**
     * scene change
     *
     * @param actionEvent action event
     * @param fxmlName    fxml name
     */
    public void sceneChange(ActionEvent actionEvent, String fxmlName) {
        try {
            Parent configParent = FXMLLoader.load(getClass().getResource(fxmlName));
            Scene scene = new Scene(configParent);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException var6) {
            System.out.println("fail to change scenes");
        }

    }

    /**
     * go market
     *
     * @param actionEvent event
     */
    public void goMarket(ActionEvent actionEvent) {
        market(actionEvent);
    }

    /**
     * market
     *
     * @param actionEvent event
     */
    public void market(ActionEvent actionEvent) {
        sceneChange(actionEvent, "market.fxml");
    }

    /**
     * scene change
     *
     * @param actionEvent event
     * @param fxmlName    fxml
     */
    public void sceneChangeToMarket(ActionEvent actionEvent, String fxmlName) {
        try {
            Parent configParent = FXMLLoader.load(getClass().getResource(fxmlName));
            Scene scene = new Scene(configParent);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException var6) {
            System.out.println("Does not exist");
        }

    }


    /**
     * @param event a
     */
    @FXML
    void ferA(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[0].fertilizing();
        ferList[0].setText("Fertilize Level: " + plotsArray[0].getFerLevel());


    }

    /**
     * @param event a
     */
    @FXML
    void ferB(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[1].fertilizing();
        ferList[1].setText("Fertilize Level: " + plotsArray[1].getFerLevel());

    }

    /**
     * @param event a
     */
    @FXML
    void ferC(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[2].fertilizing();
        ferList[2].setText("Fertilize Level: " + plotsArray[2].getFerLevel());

    }

    /**
     * @param event a
     */
    @FXML
    void ferD(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[3].fertilizing();
        ferList[3].setText("Fertilize Level: " + plotsArray[3].getFerLevel());

    }

    /**
     * @param event a
     */
    @FXML
    void ferE(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[4].fertilizing();
        ferList[4].setText("Fertilize Level: " + plotsArray[4].getFerLevel());

    }

    /**
     * @param event a
     */
    @FXML
    void ferF(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[5].fertilizing();
        ferList[5].setText("Fertilize Level: " + plotsArray[5].getFerLevel());

    }

    /**
     * @param event a
     */
    @FXML
    void ferG(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[6].fertilizing();
        ferList[6].setText("Fertilize Level: " + plotsArray[6].getFerLevel());

    }

    /**
     * @param event a
     */
    @FXML
    void ferH(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[7].fertilizing();
        ferList[7].setText("Fertilize Level: " + plotsArray[7].getFerLevel());

    }

    /**
     * @param event a
     */
    @FXML
    void ferI(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[8].fertilizing();
        ferList[8].setText("Fertilize Level: " + plotsArray[8].getFerLevel());

    }

    /**
     * @param event a
     */
    @FXML
    void ferJ(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[9].fertilizing();
        ferList[9].setText("Fertilize Level: " + plotsArray[9].getFerLevel());

    }

    /**
     * @param event a
     */
    @FXML
    void ferK(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[10].fertilizing();
        ferList[10].setText("Fertilize Level: " + plotsArray[10].getFerLevel());
    }

    /**
     * @param event a
     */
    @FXML
    void ferL(ActionEvent event) {
        plotsArray = Controller.getPlots().getPlotArray();
        plotsArray[11].fertilizing();
        ferList[11].setText("Fertilize Level: " + plotsArray[11].getFerLevel());

    }

    /**
     * initialize
     *
     * @param type type
     */
    public void initializeInv(String type) {
    }

    /**
     * plant plot
     *
     * @param actionEvent event
     */
    public void plantPlot(ActionEvent actionEvent) {
        plotsArray = Controller.getPlots().getPlotArray();
        try {
            if (plotLocation.getText().isEmpty()) {
                throw new NullPointerException();
            }
            int num = Integer.parseInt(plotLocation.getText()); // throw error if not int
            int index = num - 1;
            if (!(num > 0 && num < 13)) {
                throw new NullPointerException();
            }
            if (seedTypeCB.getValue().equals("Sunflower")) {
                if (inputC.sun.getSeedNum() == 0) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("Invalid Input");
                    a.setContentText("You don't have enough seeds to be planted.");
                    a.showAndWait();
                } else {
                    if (plotsArray[index].getStatus() == -1 || plotsArray[index].getDead()
                            || plotsArray[index].getStatus() == -2) {

                        //code added here
                        if (Controller.getBuy() == 0 && (index == 10 || index == 11)) {
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setTitle("Error");
                            a.setHeaderText("Invalid Input");
                            a.setContentText("this plot has not been bought yet");
                            a.showAndWait();
                        } else if (Controller.getBuy() == 1 && index == 11) {
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setTitle("Error");
                            a.setHeaderText("Invalid Input");
                            a.setContentText("this plot has not been bought yet");
                            a.showAndWait();
                        } else {
                            plotsArray[index].setStatus(0);
                            plotsArray[index].setSeedType(seedTypeCB.getValue());
                            plotsArray[index].setDead(false);
                            conditions[index].setText(seedTypeCB.getValue() + "  sprout");
                            inputC.sun.setSeedNum(-1);
                        }


                    } else {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setHeaderText("Invalid Input");
                        a.setContentText("You have crops on this plot. "
                                + "Please choose another plot!");
                        a.showAndWait();
                    }
                }
            }
            if (seedTypeCB.getValue().equals("Hemp")) {
                if (inputC.he.getSeedNum() == 0) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("Invalid Input");
                    a.setContentText("You don't have enough seeds to be planted.");
                    a.showAndWait();
                } else {
                    if (plotsArray[index].getStatus() == -1
                            || plotsArray[num].getDead() || plotsArray[index].getStatus() == -2) {

                        if (Controller.getBuy() == 0 && (index == 10 || index == 11)) {
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setTitle("Error");
                            a.setHeaderText("Invalid Input");
                            a.setContentText("this plot has not been bought yet");
                            a.showAndWait();
                        } else if (Controller.getBuy() == 1 && index == 11) {
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setTitle("Error");
                            a.setHeaderText("Invalid Input");
                            a.setContentText("this plot has not been bought yet");
                            a.showAndWait();
                        } else {
                            plotsArray[index].setStatus(0);
                            plotsArray[index].setSeedType(seedTypeCB.getValue());
                            plotsArray[index].setDead(false);
                            conditions[index].setText(seedTypeCB.getValue() + "  Seed");
                            inputC.he.setSeedNum(-1);
                        }


                    } else {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setHeaderText("Invalid Input");
                        a.setContentText("You have crops on this plot. "
                                + "Please choose another plot!");
                        a.showAndWait();
                    }
                }
            }
            if (seedTypeCB.getValue().equals("Basil")) {
                if (inputC.ba.getSeedNum() == 0) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("Invalid Input");
                    a.setContentText("You don't have enough seeds to be planted.");
                    a.showAndWait();
                } else {
                    if (plotsArray[index].getStatus() == -1
                            || plotsArray[num].getDead() || plotsArray[index].getStatus() == -2) {

                        if (Controller.getBuy() == 0 && (index == 10 || index == 11)) {
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setTitle("Error");
                            a.setHeaderText("Invalid Input");
                            a.setContentText("this plot has not been bought yet");
                            a.showAndWait();
                        } else if (Controller.getBuy() == 1 && index == 11) {
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setTitle("Error");
                            a.setHeaderText("Invalid Input");
                            a.setContentText("this plot has not been bought yet");
                            a.showAndWait();
                        } else {
                            plotsArray[index].setStatus(0);
                            plotsArray[index].setSeedType(seedTypeCB.getValue());
                            plotsArray[index].setDead(false);
                            conditions[index].setText(seedTypeCB.getValue() + "  Seed");
                            inputC.ba.setSeedNum(-1);
                        }


                    } else {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setHeaderText("Invalid Input");
                        a.setContentText("You have crops on this plot. "
                                + "Please choose another plot!");
                        a.showAndWait();
                    }
                }
            }
            if (seedTypeCB.getValue().equals("Soy Bean")) {
                if (inputC.soy.getSeedNum() == 0) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("Invalid Input");
                    a.setContentText("You don't have enough seeds to be planted.");
                    a.showAndWait();
                } else {
                    if (plotsArray[index].getStatus() == -1
                            || plotsArray[num].getDead() || plotsArray[index].getStatus() == -2) {

                        if (Controller.getBuy() == 0 && (index == 10 || index == 11)) {
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setTitle("Error");
                            a.setHeaderText("Invalid Input");
                            a.setContentText("this plot has not been bought yet");
                            a.showAndWait();
                        } else if (Controller.getBuy() == 1 && index == 11) {
                            Alert a = new Alert(Alert.AlertType.ERROR);
                            a.setTitle("Error");
                            a.setHeaderText("Invalid Input");
                            a.setContentText("this plot has not been bought yet");
                            a.showAndWait();
                        } else {
                            plotsArray[index].setStatus(0);
                            plotsArray[index].setSeedType(seedTypeCB.getValue());
                            plotsArray[index].setDead(false);
                            conditions[index].setText(seedTypeCB.getValue() + "  Seed");
                            inputC.soy.setSeedNum(-1);
                        }


                    } else {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setHeaderText("Invalid Input");
                        a.setContentText("You have crops on this plot. "
                                + "Please choose another plot!");
                        a.showAndWait();
                    }
                }
            }
            plotsArray[index].setPesticides(false);
            pesticidesConditions[index].setText("Pesticides : " + plotsArray[index].isPesticides());
            seedTypeCB.getSelectionModel().clearSelection();
            plotLocation.setText("");
        } catch (NullPointerException ee) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid Input");
            a.setContentText("You cannot add an invalid name ,and must select options");
            a.showAndWait();
        }

    }

    /**
     * get text field
     *
     * @param actionEvent event
     */
    public void getTextFiled(ActionEvent actionEvent) {

    }

    /**
     * pick seed type
     *
     * @param actionEvent event
     */
    public void pickSeedType(ActionEvent actionEvent) {
        System.out.println();
    }

    /**
     * @param actionEvent event
     * @FXML private Button addPesticides;
     * @FXML private TextField ppLocation;
     */
    public void addpp(ActionEvent actionEvent) {
        int plotNum;
        try {
            if (ppLocation.getText().isEmpty()) {
                throw new IllegalArgumentException();
            }
            plotNum = Integer.parseInt(ppLocation.getText());
            if (plotNum < 1 || plotNum > 12) {
                throw new IllegalArgumentException();
            }
            if (Controller.getPesticidesNum() < 1) {
                throw new IllegalArgumentException();
            }
            if (plotsArray[plotNum - 1].isPesticides()) {
                throw new NullPointerException();
            }
            plotsArray[plotNum - 1].setPesticides(true);
            Controller.setPesticidesNum(-1);
            pesticidesConditions[plotNum - 1].setText("Pesticides : "
                    + plotsArray[plotNum - 1].isPesticides());
        } catch (Exception ee) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid Action");
            if (ee instanceof IllegalArgumentException) {
                a.setContentText("You must enter number and plot num from 1-12"
                        + "or You don't have enough Pesticides");
            }
            if (ee instanceof NullPointerException) {
                a.setContentText("You already have the Pesticides.");
            } else {
                a.setContentText("You don't have enough Pesticides");
            }
            a.showAndWait();

        }

    }

    @FXML
    public void watering(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String id = button.getId();
        id = id.substring(id.length() - 2, id.length());

        if (Controller.getWaterTimes() >= Controller.getMaxWaterTimes()) {
            button.setDisable(true);
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid");
            a.setContentText("You have reached the maximum water times");
            a.showAndWait();
        } else {
            int i = Integer.parseInt(id);
            plotsArray[i].watering();
            waterList[i].setText("Water Level: " + plotsArray[i].getWateringTimes());
            Controller.updateWaterTimes(1);
        }
        button.setDisable(false);
    }

    /**
     * way to change the harvest chance left
     *
     * @param hcl harvest chance left
     */
    public static void setHarvestChanceLeft(int hcl) {
        harvestChanceLeft = hcl;
    }
}


