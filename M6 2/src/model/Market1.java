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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Market1 implements Initializable {

    public Button buyTractor;
    public Button buyIrrigation;
    @FXML
    private ComboBox<String> crop;

    @FXML
    private Button sell;

    @FXML
    private Button buy;

    @FXML
    private TextField sellQ;

    @FXML
    private TextField buyQ;

    @FXML
    private Button backFarm;

    @FXML
    private Label displayM;

    @FXML
    private Label sunf;

    @FXML
    private Label basil;

    @FXML
    private Label soyb;

    @FXML
    private Label hemp;

    @FXML
    private Label sunSeed;

    @FXML
    private Label basilSeed;

    @FXML
    private Label soyBeanSeed;

    @FXML
    private Label hempSeed;



    private String result;

    private String difficulty;

    protected static int buyingMult;

    protected static int difficultyMultiplier;

    private int totalPrice;

    private static final int SUN_SEED_PRICE = 3;
    private static final int BASIL_SEED_PRICE = 2;
    private static final int HEMP_SEED_PRICE = 5;
    private static final int SOYBEAN_SEED_PRICE = 1;
    private static final int SUNFLOWER_PRICE = 7;
    private static final int BASIL_PRICE = 2;
    private static final int HEMP_PRICE = 10;
    private static final int SOYBEAN_PRICE = 3;
    private static final int TRACTPR_PRICE = 10;
    private static final int IRRIGATION_PRICE = 7;
    private static storage warehouse = new storage();


    @FXML
    private Label sunf1;

    @FXML
    private Label basil1;

    @FXML
    private Label soyb1;

    @FXML
    private Label hemp1;

    @FXML
    private ComboBox<String> boxWithp;

    @FXML
    private TextField sellQ1;

    @FXML
    private Button sell1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list
                = FXCollections.observableArrayList("Sunflower", "Basil", "Soy Bean", "Hemp");
        crop.setItems(list);
        boxWithp.setItems(list);
        displayM.setText(displayM.getText() + Controller.getMoney());
        if (inputC.sun.getCrop() != 0) {
            sunf.setText("Sunflower: " + inputC.sun.getCrop() );
        } else {
            sunf.setText("");
        }
        if (inputC.sun.getSeedNum() != 0) {
            sunSeed.setText("Sunflower seed: " + inputC.sun.getSeedNum());
        } else {
            sunSeed.setText("");
        }
        if (inputC.ba.getCrop() != 0) {
            basil.setText("Basil: " + inputC.ba.getCrop());
        } else {
            basil.setText("");
        }
        if (inputC.ba.getSeedNum() != 0) {
            basilSeed.setText("Basil seed: " + inputC.ba.getSeedNum());
        } else {
            basilSeed.setText("");
        }
        if (inputC.he.getCrop() != 0) {
            hemp.setText("Hemp: " + inputC.he.getCrop() );
        } else {
            hemp.setText("");
        }
        if (inputC.he.getSeedNum() != 0) {
            hempSeed.setText("Hemp seed: " + inputC.he.getSeedNum());
        } else {
            hempSeed.setText("");
        }
        if (inputC.soy.getCrop() != 0) {
            soyb.setText("Soy bean: " + inputC.soy.getCrop() );
        } else {
            soyb.setText("");
        }
        if (inputC.soy.getSeedNum()!= 0) {
            soyBeanSeed.setText("Soy bean seed: " + inputC.soy.getSeedNum());
        } else {
            soyBeanSeed.setText("");
        }
        if (inputC.sun.getPest() != 0) {
            sunf1.setText(inputC.sun.getPest() + " (w/ Pesticides)");
        } else {
            sunf1.setText("");
        }
        if (inputC.ba.getPest() != 0) {
            basil1.setText(inputC.ba.getPest() + " (w/ Pesticides)");
        } else {
            basil1.setText("");
        }
        if (inputC.soy.getPest() != 0) {
            soyb1.setText(inputC.soy.getPest() + " (w/ Pesticides)");
        } else {
            soyb1.setText("");
        }
        if (inputC.he.getPest() != 0) {
            hemp1.setText(inputC.he.getPest() + " (w/ Pesticides)");
        } else {
            hemp1.setText("");
        }

        /*
    @FXML
    private ComboBox<?> boxWithp;

    @FXML
    private TextField sellQ1;

    @FXML
    private Button sell1;*/


    }

    /**
     * update money and crop number in the controller's class
     *
     * @param event after buy button is clicked
     * @throws NoSuchFieldException if no enough money
     */
    @FXML
    void buyCrop(ActionEvent event) throws NoSuchFieldException {
        try {
            if (Controller.getMoney() <= 0) {
                throw new IllegalArgumentException();
            }
            if (crop.getValue().isEmpty() || buyQ.getText().isEmpty()) {
                throw new NullPointerException();
            }
            result = crop.getValue();
            int num = Integer.parseInt(buyQ.getText());
            int total = 0;
            if (warehouse.getCurrent() + num >= warehouse.getCapacity()) {
                throw new IndexOutOfBoundsException();
            }
            if (total + num > 20) {
                throw new IndexOutOfBoundsException();
            }
            difficultyMult();
            switch (result) {
            case "Sunflower":
                difficultyMult();
                totalPrice = SUN_SEED_PRICE * buyingMult * num;
                if (totalPrice <= Controller.getMoney()) {
                    Controller.setMoney(Controller.getMoney() - totalPrice);
                    inputC.sun.setSeedNum(num);
                    sunSeed.setText("sunflower seed: " + inputC.sun.getSeedNum());
                    warehouse.setCurrent(num);
                } else {
                    throw new NoSuchFieldException();
                }
                break;
            case "Basil":
                totalPrice = BASIL_SEED_PRICE * buyingMult * num;
                if (totalPrice <= Controller.getMoney()) {
                    Controller.setMoney(Controller.getMoney() - totalPrice);
                    inputC.ba.setSeedNum(num);
                    basilSeed.setText("basil seed: " + inputC.ba.getSeedNum());
                    warehouse.setCurrent(num);

                } else {
                    throw new NoSuchFieldException();
                }
                break;
            case "Hemp":
                totalPrice = HEMP_SEED_PRICE * buyingMult * num;
                if (totalPrice <= Controller.getMoney()) {
                    Controller.setMoney(Controller.getMoney() - totalPrice);
                    inputC.he.setSeedNum(num);
                    hempSeed.setText("hemp seed: " + inputC.he.getSeedNum());
                    warehouse.setCurrent(num);
                } else {
                    throw new NoSuchFieldException();
                }
                break;

            case "Soy Bean":
                totalPrice = SOYBEAN_SEED_PRICE * buyingMult * num;
                if (totalPrice <= Controller.getMoney()) {
                    Controller.setMoney(Controller.getMoney() - totalPrice);
                    inputC.soy.setSeedNum(num);
                    soyBeanSeed.setText("soy bean seed：" + inputC.soy.getSeedNum());
                    warehouse.setCurrent(num);
                } else {
                    throw new NoSuchFieldException();
                }
                break;
            default:
                break;
            }
            displayM.setText("Money：" + Controller.getMoney());
        } catch (Exception exception) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid Action");

            if (exception instanceof IllegalArgumentException) {
                a.setContentText("Try to sell your crops first");
            }
            if (exception instanceof NullPointerException) {
                a.setContentText("You have to select something to buy");
            }
            if (exception instanceof NumberFormatException) {
                a.setContentText("You have to enter a number for quantity");
            }
            if (exception instanceof NoSuchFieldException) {
                a.setContentText("You don't have enough money to buy, try to buy less");
            }

            if (exception instanceof IndexOutOfBoundsException) {
                a.setContentText("You have reach the your inventory capacity(20)");
            }

            a.showAndWait();

        }

    }

    /**
     * receive difficulty level
     *
     * @param difficulty difficulty level
     */
    protected void receiveInfo(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * determine the multiplier for selling and buying by dififfulty level
     */
    protected static void difficultyMult() {
        if (Controller.getDifficulty().equals("Easy")) {
            difficultyMultiplier = 3;
            buyingMult = 1;

        } else if (Controller.getDifficulty().equals("Hard")) {
            difficultyMultiplier = 2;
            buyingMult = 2;
        } else if (Controller.getDifficulty().equals("Expert")) {
            difficultyMultiplier = 1;
            buyingMult = 3;
        }
    }

    /**
     * update money and seed numbers in inventory
     *
     * @param event after sell button is clicked
     * @throws NoSuchFieldException if user did not enter anything
     */
    @FXML
    void sellCrop(ActionEvent event) throws NoSuchFieldException {

        try {
            if (crop.getValue().isEmpty() || sellQ.getText().isEmpty()) {
                throw new NullPointerException();
            }
            result = crop.getValue();
            int quantityFinal = Integer.parseInt(sellQ.getText());
            difficultyMult();
            switch (result) {
            case "Sunflower":
                if (quantityFinal <= inputC.sun.getCrop()) {
                    difficultyMult();
                    Controller.setMoney(Controller.getMoney()
                                + SUNFLOWER_PRICE * difficultyMultiplier * quantityFinal);
                    inputC.sun.setCrop(-quantityFinal);
                    if (inputC.sun.getCrop()  != 0) {
                        sunf.setText("Sunflower: " + inputC.sun.getCrop() );
                    } else {
                        sunf.setText("");
                    }
                    warehouse.setCurrent(-quantityFinal);
                } else {
                    throw new NoSuchFieldException();
                }
                break;
            case "Basil":
                if (quantityFinal <= inputC.ba.getCrop()) {
                    difficultyMult();
                    Controller.setMoney(Controller.getMoney()
                            + BASIL_PRICE * difficultyMultiplier * quantityFinal);
                    inputC.ba.setCrop(-quantityFinal);
                    if (inputC.ba.getCrop() != 0) {
                        basil.setText("Basil: " + inputC.ba.getCrop());
                    } else {
                        basil.setText("");
                    }
                    warehouse.setCurrent(-quantityFinal);
                } else {
                    throw new NoSuchFieldException();
                }
                break;

            case "Hemp":
                if (quantityFinal <= inputC.he.getCrop() ) {
                    difficultyMult();
                    Controller.setMoney(Controller.getMoney()
                                + HEMP_PRICE * difficultyMultiplier * quantityFinal);
                    inputC.he.setCrop(-quantityFinal);
                    if (inputC.he.getCrop() != 0) {
                        hemp.setText("Hemp: " + inputC.he.getCrop() );
                    } else {
                        hemp.setText("");
                    }
                    warehouse.setCurrent(-quantityFinal);
                } else {
                    throw new NoSuchFieldException();
                }
                break;
            case "Soy Bean":
                if (quantityFinal <= inputC.soy.getCrop() ) {
                    difficultyMult();
                    Controller.setMoney(Controller.getMoney()
                                + SOYBEAN_PRICE * difficultyMultiplier * quantityFinal);
                    inputC.soy.setCrop(-quantityFinal);
                    if (inputC.soy.getCrop()  != 0) {
                        soyb.setText("Soybean: " + inputC.soy.getCrop());
                    } else {
                        soyb.setText("");
                    }
                    warehouse.setCurrent(-quantityFinal);
                } else {
                    throw new NoSuchFieldException();
                }
                break;
            default:
                break;
            }
            displayM.setText("Money：" + Controller.getMoney());
            if (Controller.getMoney() > 200) {
                sceneChange(event, "winGame.fxml");
            }
        } catch (Exception exception) {

            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid Action");

            if (exception instanceof IllegalArgumentException) {
                a.setContentText("You have nothing to sell");
            }
            if (exception instanceof NullPointerException) {
                a.setContentText("You have to select something to sell");
            }
            if (exception instanceof NumberFormatException) {
                a.setContentText("You have to enter a number for quantity");
            }
            if (exception instanceof NoSuchFieldException) {
                a.setContentText("You don't have enough crops to sell");
            }
            a.showAndWait();
        }
    }

    /**
     * switch scene back to farm
     *
     * @param event after go back button is clicked
     */
    @FXML
    void goBack(ActionEvent event) {
        sceneChange(event, "UIScene.fxml");
    }

    /**
     * scene change helper
     *
     * @param actionEvent event passed in
     * @param fxmlName    fxml file
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
     * not used class
     *
     * @param event action event for combo box
     */
    @FXML
    void chooseCrop(ActionEvent event) {

    }


    /**
     * @param actionEvent mouse event
     */
    public void boxWithP(ActionEvent actionEvent) {
    }

    /**
     * @param actionEvent mouse event
     */
    public void sellP(ActionEvent actionEvent) {
    }

    /**
     * Supply method provide Supply
     * @param event mouse event
     */
    @FXML
    void supplies(ActionEvent event) {
        sceneChange(event, "Supply.fxml");

    }

    /**
     * @param actionEvent mouse event
     *
     */
    public void sellCroppp(ActionEvent actionEvent) {
        if (sellQ1.getText().isEmpty()) {
            throw new IllegalArgumentException();
        }
        try {
            result = boxWithp.getValue();
            int quantityFinal = Integer.parseInt(sellQ1.getText());
            int discount = 1;
            difficultyMult();
            switch (result) {
            case "Sunflower":
                if (quantityFinal <= inputC.sun.getPest()) {
                    difficultyMult();
                    Controller.setMoney(Controller.getMoney()
                            + SUNFLOWER_PRICE * difficultyMultiplier
                            * quantityFinal - discount); // $1 cheaper
                    inputC.he.setPest(-quantityFinal);
                    if (inputC.sun.getPest() != 0) {
                        sunf1.setText("Sunflower with Pesticides : "
                                + inputC.sun.getPest());
                    } else {
                        sunf1.setText("");
                    }
                    warehouse.setCurrent(-quantityFinal);
                } else {
                    throw new NoSuchFieldException();
                }
                break;
            case "Basil":
                if (quantityFinal <= inputC.ba.getPest()) {
                    difficultyMult();
                    Controller.setMoney(Controller.getMoney()
                            + BASIL_PRICE * difficultyMultiplier
                            * quantityFinal - discount);
                    inputC.ba.setPest(-quantityFinal);
                    if (inputC.ba.getPest() != 0) {
                        basil1.setText("Basil with Pesticides : "
                                + inputC.ba.getPest());
                    } else {
                        basil1.setText("");
                    }
                    warehouse.setCurrent(-quantityFinal);
                } else {
                    throw new NoSuchFieldException();
                }
                break;

            case "Hemp":
                if (quantityFinal <= inputC.he.getPest()) {
                    difficultyMult();
                    Controller.setMoney(Controller.getMoney()
                            + HEMP_PRICE * difficultyMultiplier * quantityFinal - discount);
                    inputC.he.setPest(-quantityFinal);
                    if (inputC.he.getPest()!= 0) {
                        hemp1.setText("Hemp with Pesticides : "
                                + inputC.he.getPest());
                    } else {
                        hemp1.setText("");
                    }
                    warehouse.setCurrent(-quantityFinal);;
                } else {
                    throw new NoSuchFieldException();
                }
                break;
            case "Soy Bean":
                if (quantityFinal <= inputC.soy.getPest()) {
                    difficultyMult();
                    Controller.setMoney(Controller.getMoney()
                            + SOYBEAN_PRICE
                            * difficultyMultiplier * quantityFinal - discount);
                    inputC.soy.setPest(-quantityFinal);
                    if (inputC.soy.getPest() != 0) {
                        soyb1.setText("Soybean with Pesticides : "
                                + inputC.soy.getPest());
                    } else {
                        soyb1.setText("");
                    }
                    warehouse.setCurrent(-quantityFinal);;
                } else {
                    throw new NoSuchFieldException();
                }
                break;
            default:
                break;
            }
            displayM.setText("Money：" + Controller.getMoney());
            if (Controller.getMoney() > 200) {
                sceneChange(actionEvent, "winGame.fxml");
            }

        } catch (Exception exception) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid Action");

            if (exception instanceof IllegalArgumentException) {
                a.setContentText("You have nothing to sell");
            }
            if (exception instanceof NullPointerException) {
                a.setContentText("You have to select something to sell");
            }
            if (exception instanceof NumberFormatException) {
                a.setContentText("You have to enter a number for quantity");
            }
            if (exception instanceof NoSuchFieldException) {
                a.setContentText("You don't have enough crops to sell");
            }
            a.showAndWait();


        }
    }

    public void buyTractor(ActionEvent actionEvent) {

        if (!Controller.getTractor() && Controller.getMoney() - 50 > 0) {
            Controller.setMaxHarvest(12);
            Controller.setMoney(Controller.getMoney() - 50);
            displayM.setText("Money：" + Controller.getMoney());
            Controller.setTractor(true);
            InitialUI2.setHarvestChanceLeft(7);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid");
            a.setContentText("You already have a tractor, you cannot buy another one.");
            a.showAndWait();
        }
        System.out.println(Controller.getMaxHarvest());
    }

    public void buyIrrigation(ActionEvent actionEvent) {

        if (!Controller.getIrrigation() && Controller.getMoney() - 30 > 0) {
            Controller.setMaxWaterTimes(20);
            Controller.setMoney(Controller.getMoney() - 30);
            displayM.setText("Money：" + Controller.getMoney());
            Controller.setIrrigation(true);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid");
            a.setContentText("You already have a Irrigation, you cannot buy another one.");
            a.showAndWait();
        }


    }

    public void butPlot(ActionEvent actionEvent) {
        if (Controller.getBuy() >= 2) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid");
            a.setContentText("All the available plots are sold!");
            a.showAndWait();
        } else if (Controller.getBuy() == 0){
            if ((Controller.getMoney() - 20) < 0) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Invalid");
                a.setContentText("You don't have enough money!");
                a.showAndWait();
            } else {
                Controller.setBuy(Controller.getBuy() + 1);
                Controller.setMoney(Controller.getMoney() - 20);
                displayM.setText("Money：" + Controller.getMoney());

            }
        } else if (Controller.getBuy() == 1) {
            if ((Controller.getMoney() - 40) < 0) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Invalid");
                a.setContentText("You don't have enough money!");
                a.showAndWait();
            } else {
                Controller.setBuy(Controller.getBuy() + 1);
                Controller.setMoney(Controller.getMoney() - 40);
                displayM.setText("Money：" + Controller.getMoney());
            }
        }
        System.out.println(Controller.getBuy());

    }
}


