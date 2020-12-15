//import javafx.geometry.Insets;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextField;
//import javafx.scene.control.Alert;
//import javafx.scene.layout.GridPane;
//
//import java.io.IOException;
//
//
//public class Market {
//    protected int numbers = 20;
//    protected int[] inventory = new int[8];
//    private static GridPane jRootPane;
//    private Button buy;
//    private Button sell;
//    private Button backToFarm;
//
//
//    private Label sunflower;
//    private Label basil;
//    private Label soyBean;
//    private Label hemp;
//
//    private Label sunflowerSeed;
//    private Label basilSeed;
//    private Label soyBeanSeed;
//    private Label hempSeed;
//    private Label moneyDisplay;
//
//    private TextField sunflowerL;
//    private TextField basilL;
//    private TextField soyBeanL;
//    private TextField hempL;
//
//    private TextField sunflowerSeedL;
//    private TextField basilSeedL;
//    private TextField soyBeanSeedL;
//    private TextField hempSeedL;
//    private TextField moneyDisplayL;
//
//
////    private String difficulty = UserInputScreen.getPlayerInfo()[3];
//    private String result;
//    private ComboBox<String> seedList;
//    private TextField quantity;
//    private int totalPrice;
//
//    private int difficultyMultiplier;
//    private static final int SUNFLOWER_PRICE = 7;
//    private static final int BASIL_PRICE = 2;
//    private static final int HEMP_PRICE = 10;
//    private static final int SOYBEAN_PRICE = 3;
//    private int buyingMult;
//    private static final int SUN_SEED_PRICE = 3;
//    private static final int BASIL_SEED_PRICE = 2;
//    private static final int HEMP_SEED_PRICE = 5;
//    private static final int SOYBEAN_SEED_PRICE = 1;
////    protected Inventory inv = new Inventory();
//
//    /**
//     * set label method
//     * */
//    private void setLabel() {
//        inventory = inv.getInventorySituation();
//        sunflower = new Label("Sunflower :" + inventory[4]);
//        basil = new Label("Basil :" + inventory[5]);
//        soyBean = new Label("Soy Bean :" + inventory[6]);
//        hemp = new Label("Hemp :" + inventory[7]);
//        System.out.println(inventory[4]);
//        System.out.println("begin mo" + InitialUI.getBeginMoney());
//
//
//        sunflowerSeed = new Label("Sunflower Seed :" + inventory[0]);
//        basilSeed = new Label("Basil Seed :" + inventory[1]);
//        soyBeanSeed = new Label("Soy Bean Seed :" + inventory[2]);
//        hempSeed = new Label("Hemp Seed :" + inventory[3]);
//        moneyDisplay = new Label("Money: " + InitialUI.getBeginMoney());
//    }
//
//    /**
//     * helper method to determine selling multiple based on difficulty
//     */
//    private void difficultyMult() {
//        if (difficulty.equals("Easy")) {
//            difficultyMultiplier = 3;
//            buyingMult = 1;
//
//        } else if (difficulty.equals("Hard")) {
//            difficultyMultiplier = 2;
//            buyingMult = 2;
//        } else if (difficulty.equals("Expert")) {
//            difficultyMultiplier = 1;
//            buyingMult = 3;
//        }
//    }
//
//    /**
//     * functions allowing for buying and selling
//     * catch any illegal operation from users
//     *
//     * @return Parent root representing market page
//     */
//    public Parent constructInitial() {
//        sell = new Button("Sell");
//        buy = new Button("Buy");
//        seedList = new ComboBox<>();
//        seedList.getItems().addAll("Sunflower", "Basil", "Soy Bean", "Hemp");
//        seedList.setPromptText("Please select seed/crops");
//        quantity = new TextField();
//        jRootPane = new GridPane();
//        backToFarm = new Button("Back to Farm");
//        backToFarm.setOnAction(e -> {
//            Scene scene = null;
//            String[] info = UserInputScreen.getPlayerInfo();
//            InitialUI farmPage = new InitialUI();
//            GridPane plots = farmPage.getPlotGrid();
//            int day = farmPage.getDays();
//            try {
//                scene = new Scene(farmPage.uiConstructor(info, day));
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//            Main.mainPage.setScene(scene);
//        });
//        quantity.setPromptText("Enter quantity of seeds/crops");
//        setLabel();
//
//        sell.setOnAction(e -> {
//            try {
//                if (inventory.length == 0) {
//                    throw new IllegalArgumentException();
//                }
//                if (seedList.getValue().isEmpty() || quantity.getText().isEmpty()) {
//                    throw new NullPointerException();
//                }
//
//                result = seedList.getValue();
//
//                int quantityFinal = Integer.parseInt(quantity.getText());
//
//                switch (result) {
//                case "Sunflower":
//                    if (quantityFinal <= inventory[4]) {
//                        difficultyMult();
//                        InitialUI.updateMoney(true, InitialUI.getBeginMoney()
//                                + (SUNFLOWER_PRICE * difficultyMultiplier * quantityFinal), "");
//                        inv.updateInv("Sunflower", -quantityFinal, false);
//                    } else {
//                        throw new NoSuchFieldException();
//                    }
//                    break;
//                case "Basil":
//                    if (quantityFinal <= inventory[5]) {
//                        difficultyMult();
//                        InitialUI.updateMoney(true, InitialUI.getBeginMoney()
//                                + (BASIL_PRICE * difficultyMultiplier * quantityFinal), "");
//                        inv.updateInv("Basil", -quantityFinal, false);
//                    } else {
//                        throw new NoSuchFieldException();
//                    }
//                    break;
//
//                case "Hemp":
//                    if (quantityFinal <= inventory[7]) {
//                        difficultyMult();
//                        InitialUI.updateMoney(true, InitialUI.getBeginMoney()
//                                + (HEMP_PRICE * difficultyMultiplier * quantityFinal), "");
//                        inv.updateInv("Hemp", -quantityFinal, false);
//                    } else {
//                        throw new NoSuchFieldException();
//                    }
//                    break;
//                case "Soy Bean":
//                    if (quantityFinal <= inventory[6]) {
//                        difficultyMult();
//                        InitialUI.updateMoney(true, InitialUI.getBeginMoney()
//                                + (SOYBEAN_PRICE * difficultyMultiplier * quantityFinal), "");
//                        inv.updateInv("Soy Bean", -quantityFinal, false);
//                    } else {
//                        throw new NoSuchFieldException();
//                    }
//                    break;
//                default:
//                    break;
//                }
//                moneyDisplayL = new TextField("Money: " + InitialUI.getBeginMoney());
//
//                sunflowerL = new TextField("Sunflower :" + inventory[4]);
//                sunflower.textProperty().bind(sunflowerL.textProperty());
//                basilL = new TextField("Basil :" + inventory[5]);
//                basil.textProperty().bind(basilL.textProperty());
//                soyBeanL = new TextField("Soy Bean :" + inventory[6]);
//                soyBean.textProperty().bind(soyBeanL.textProperty());
//                hempL = new TextField("Hemp :" + inventory[7]);
//                hemp.textProperty().bind(hempL.textProperty());
//
//
//                moneyDisplay.textProperty().bind(moneyDisplayL.textProperty());
//
//
//            } catch (Exception exception) {
//
//                Alert a = new Alert(Alert.AlertType.ERROR);
//                a.setTitle("Error");
//                a.setHeaderText("Invalid Action");
//
//                if (exception instanceof IllegalArgumentException) {
//                    a.setContentText("You have nothing to sell");
//                }
//                if (exception instanceof NullPointerException) {
//                    a.setContentText("You have to select something to sell");
//                }
//                if (exception instanceof NumberFormatException) {
//                    a.setContentText("You have to enter a number for quantity");
//                }
//                if (exception instanceof NoSuchFieldException) {
//                    a.setContentText("You don't have enough crops to sell");
//                }
//                a.showAndWait();
//            }
//
//
//        });
//
//        buy.setOnAction(e -> {
//            try {
//                if (InitialUI.beginMoney <= 0) {
//                    throw new IllegalArgumentException();
//                }
//                if (seedList.getValue().isEmpty() || quantity.getText().isEmpty()) {
//                    throw new NullPointerException();
//                }
//
//                int quantityFinal = Integer.parseInt(quantity.getText());
//
//                int num = Integer.parseInt(quantity.getText());
//                result = seedList.getValue();
//                int total = 0;
//                for (int i = 0; i < inventory.length; i++) {
//                    total += inventory[i];
//                }
//                if (total + num > 20) {
//                    throw new IndexOutOfBoundsException();
//                }
//                switch (result) {
//                case "Sunflower":
//                    difficultyMult();
//                    totalPrice = SUN_SEED_PRICE * buyingMult * num;
//                    if (totalPrice <= InitialUI.getBeginMoney()) {
//                        InitialUI.updateMoney(true, (InitialUI.getBeginMoney() - totalPrice), "");
//                        inv.updateInv("Sunflower", num, true);
//                    } else {
//                        throw new NoSuchFieldException();
//                    }
//                    break;
//                case "Basil":
//                    totalPrice = BASIL_SEED_PRICE * buyingMult * num;
//                    if (totalPrice <= InitialUI.getBeginMoney()) {
//                        InitialUI.updateMoney(true, InitialUI.getBeginMoney() - totalPrice, "");
//                        inv.updateInv("Basil", num, true);
//                    } else {
//                        throw new NoSuchFieldException();
//                    }
//                    break;
//                case "Hemp":
//                    totalPrice = HEMP_SEED_PRICE * buyingMult * num;
//                    if (totalPrice <= InitialUI.getBeginMoney()) {
//                        InitialUI.updateMoney(true, InitialUI.getBeginMoney() - totalPrice, "");
//                        inv.updateInv("Hemp", num, true);
//                    } else {
//                        throw new NoSuchFieldException();
//                    }
//                    break;
//
//                case "Soy Bean":
//                    totalPrice = SOYBEAN_SEED_PRICE * buyingMult * num;
//                    if (totalPrice <= InitialUI.getBeginMoney()) {
//                        InitialUI.updateMoney(true, InitialUI.getBeginMoney() - totalPrice, "");
//                        inv.updateInv("Soy Bean", num, true);
//                    } else {
//                        throw new NoSuchFieldException();
//                    }
//                    break;
//                default:
//                    break;
//                }
//
//                sunflowerSeedL = new TextField("Sunflower Seed :" + inventory[0]);
//                sunflowerSeed.textProperty().bind(sunflowerSeedL.textProperty());
//                basilSeedL = new TextField("Basil Seed :" + inventory[1]);
//                basilSeed.textProperty().bind(basilSeedL.textProperty());
//                soyBeanSeedL = new TextField("Soy Bean Seed :" + inventory[2]);
//                soyBeanSeed.textProperty().bind(soyBeanSeedL.textProperty());
//                hempSeedL = new TextField("Hemp Seed :" + inventory[3]);
//                hempSeed.textProperty().bind(hempSeedL.textProperty());
//
//                moneyDisplayL = new TextField("Money: " + InitialUI.getBeginMoney());
//                moneyDisplay.textProperty().bind(moneyDisplayL.textProperty());
//
//                //seedList.getSelectionModel().clearSelection();
//                //quantity.setText("");
//
//
//            } catch (Exception exception) {
//                Alert a = new Alert(Alert.AlertType.ERROR);
//                a.setTitle("Error");
//                a.setHeaderText("Invalid Action");
//
//                if (exception instanceof IllegalArgumentException) {
//                    a.setContentText("Try to sell your crops first");
//                }
//                if (exception instanceof NullPointerException) {
//                    a.setContentText("You have to select something to buy");
//                }
//                if (exception instanceof NumberFormatException) {
//                    a.setContentText("You have to enter a number for quantity");
//                }
//                if (exception instanceof NoSuchFieldException) {
//                    a.setContentText("You don't have enough money to buy, try to buy less");
//                }
//
//                if (exception instanceof IndexOutOfBoundsException) {
//                    a.setContentText("You have reach the your inventory capacity(20)");
//                }
//
//                a.showAndWait();
//
//            }
//
//
//        });
//
//        jRootPane.setPadding(new Insets(10, 10, 10, 10));
//        jRootPane.add(seedList, 5, 5);
//
//        jRootPane.add(sell, 3, 5);
//        jRootPane.add(quantity, 7, 5);
//        jRootPane.add(buy, 9, 5);
//
//        jRootPane.add(backToFarm, 10, 0);
//
//        jRootPane.add(sunflowerSeed, 5, 6);
//        jRootPane.add(basilSeed, 5, 7);
//        jRootPane.add(hempSeed, 5, 8);
//        jRootPane.add(soyBeanSeed, 5, 9);
//
//        jRootPane.add(sunflower, 5, 10);
//        jRootPane.add(basil, 5, 11);
//        jRootPane.add(hemp, 5, 12);
//        jRootPane.add(soyBean, 5, 13);
//        jRootPane.add(moneyDisplay, 0, 0);
//
//
//        jRootPane.setVgap(5);
//        jRootPane.setHgap(5);
//
//        jRootPane.setMinSize(500, 500);
//
//        return jRootPane;
//    }
//
//
//}
