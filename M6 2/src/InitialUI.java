//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.Parent;
//
//import java.io.IOException;
//
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class InitialUI {
//    private Button nextDay;
//    private static Label moneyLabel;
//    private Label dateLabel;
//    protected static Label plot1 = new Label("Mature");
//    protected static Label plot2 = new Label("Seed");
//    protected static Label plot3 = new Label("Immature");
//    protected static Label plot4 = new Label("Seed");
//    protected static Label plot5 = new Label("Immature");
//    protected static Label plot6 = new Label("Mature");
//    protected static Label plot7 = new Label("Mature");
//    protected static Label plot8 = new Label("Seed");
//    protected static Label plot9 = new Label("Immature");
//    protected static Label plot10 = new Label("Mature");
//    protected static Label plot11 = new Label("Immature");
//    protected static Label plot12 = new Label("Mature");
//    private HBox topMenu;
//    protected static GridPane plotGrid;
//    private BorderPane overallBorderPane;
//    private BorderPane self;
//    private static String level;
//    protected static int beginMoney;
//    private Button inventory;
//    protected Inventory inv = new Inventory();
//    private Button harvest;
//    private Button market;
//    protected int harvestNum;
//    protected static int days = 0;
//    private List<Label> conditions = new LinkedList<>();
//    private static TextField updateMoney;
//
//
//    /**
//     * This is the method that return game screen
//     *
//     * @param playerInfo player info array
//     * @param day        starting day
//     * @return pane that contain game screen
//     * @throws IOException that required
//     */
//    public Parent uiConstructor(String[] playerInfo, int day) throws
//            IOException {
//
//        days = day;
//
//        Market mar = new Market();
//        market = new Button("Market");
//        market.setOnAction(e -> {
//            Scene scene = new Scene(mar.constructInitial());
//            Main.mainPage.setScene(scene);
//        });
//        try {
//            level = playerInfo[3];
//        } catch (IndexOutOfBoundsException ioe) {
//            System.out.println("there is no index 3 in playerInfo.");
//        } catch (NullPointerException iae) {
//            System.out.println("The user didn't have level put in");
//        }
//
//        nextDay = new Button("Next Day");
//        dateLabel = new Label("Day " + day);
//        nextDay.setOnAction(e -> {
//            InitialUI uI = new InitialUI();
//            uI.days++;
//            dateLabel.setText("Day " + days);
//        });
//
//        System.out.println(beginMoney);
//        moneyLabel = new Label("$: " + beginMoney);
//        //moneyLabel.textProperty().bind(updateMoney.textProperty());
//
//        //put labels into the scene by HBox layout
//        topMenu = new HBox(20);
//
//        //set up the plot position
//        plotGrid = new GridPane();
//        plotGrid.setMinSize(400, 200);
//
//        //make the grid not directly contacting the border
//        plotGrid.setPadding(new Insets(10, 10, 10, 10));
//        plotGrid.setVgap(5);
//        plotGrid.setHgap(5);
//        //add the inventory button
//        inventory = new Button("Inventory");
//        inventory.setOnAction(e -> {
//            Main.mainPage.setScene(new Scene(inv.constructInv(topMenu)));
//        });
//
//
//        market.setOnAction(e -> {
//            Main.mainPage.setScene(new Scene(mar.constructInitial()));
//        });
//
//        //put all texts in an array so we can count
//        conditions.add(plot1);
//        conditions.add(plot2);
//        conditions.add(plot3);
//        conditions.add(plot4);
//        conditions.add(plot5);
//        conditions.add(plot6);
//        conditions.add(plot7);
//        conditions.add(plot8);
//        conditions.add(plot9);
//        conditions.add(plot10);
//        conditions.add(plot11);
//        conditions.add(plot12);
//
//
//        //the Harvest Button
//        harvest = new Button("Harvest");
//        harvest.setOnAction(e -> {
//            for (int i = 0; i < 12; i++) {
//                if (conditions.get(i).getText().equals("Mature")) {
//                    harvestNum++;
//                    conditions.get(i).setText("Empty");
//                }
//            }
//            inv.updateInv(playerInfo[1], harvestNum, false);
//        });
//
//        //now put plots in the grid
//        plotGrid.setConstraints(plot1, 0, 0);
//        plotGrid.setConstraints(plot2, 2, 0);
//        plotGrid.setConstraints(plot3, 4, 0);
//        plotGrid.setConstraints(plot4, 6, 0);
//        plotGrid.setConstraints(plot5, 0, 2);
//        plotGrid.setConstraints(plot6, 2, 2);
//        plotGrid.setConstraints(plot7, 4, 2);
//        plotGrid.setConstraints(plot8, 6, 2);
//        plotGrid.setConstraints(plot9, 0, 4);
//        plotGrid.setConstraints(plot10, 2, 4);
//        plotGrid.setConstraints(plot11, 4, 4);
//        plotGrid.setConstraints(plot12, 6, 4);
//        //add the inventory button
//
//        //now put them all in the grid
//        topMenu.getChildren().addAll(moneyLabel, dateLabel, nextDay, inventory, harvest, market);
//        plotGrid.getChildren().addAll(plot1, plot2, plot3, plot4, plot5, plot6,
//                plot7, plot8, plot9, plot10, plot11, plot12);
//
//        overallBorderPane = new BorderPane();
//        plotGrid.setAlignment(Pos.CENTER);
//        overallBorderPane.setTop(topMenu);
//        overallBorderPane.setCenter(plotGrid);
//        overallBorderPane.setMinSize(500, 500);
//        return overallBorderPane;
//    }
//
//    /**
//     * return beginMoney
//     *
//     * @return money amount
//     */
//    public static int getBeginMoney() {
//        return beginMoney;
//    }
//
//    /**
//     * return level
//     *
//     * @return level in string
//     */
//    public String getLevel() {
//        return level;
//    }
//
//    /**
//     * return plotGrid
//     *
//     * @return plotGrid
//     */
//    public GridPane getPlotGrid() {
//        return plotGrid;
//    }
//
//    /**
//     * return beginMoney
//     *
//     * @return money amount
//     */
//
//    public int getDays() {
//        return days;
//    }
//
//    /**
//     * @param money player's money
//     *              return beginMoney
//     */
//    public static void setMoney(int money) {
//        beginMoney = money;
//
//    }
//
//    /**
//     * update money money
//     *
//     * @param called called
//     * @param value  value
//     * @param level  level
//     */
//    public static void updateMoney(boolean called, int value, String level) {
//        try {
//            if (!called) {
//                if (level == "Easy") {
//                    beginMoney = 100;
//                } else if (level == "Hard") {
//                    beginMoney = 75;
//                } else if (level == "Expert") {
//                    beginMoney = 50;
//                }
//            } else {
//                beginMoney = value;
//            }
//        } catch (Exception e) {
//            System.out.println("The info passed in is illegal");
//        }
//
//
//    }
//}