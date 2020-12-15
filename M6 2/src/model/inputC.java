package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class inputC implements Initializable {

    public static boolean isSaved = false;

    protected static seed sun = new sunflower();

    protected static seed ba = new basil();

    protected static seed he = new hemp();

    protected static seed soy = new soyBean();

    protected static farmSupply sunPest = new pesticide(sun);
    protected static farmSupply baPest = new pesticide(ba);
    protected static farmSupply soyPest = new pesticide(soy);
    protected static farmSupply hePest = new pesticide(he);

    @FXML
    private ComboBox<String> season;

    @FXML
    private ComboBox<String> difficulty;

    @FXML
    private ComboBox<String> seedType;

    @FXML
    private TextField nameF;

    @FXML
    private Button createAccount;

    @FXML
    private Button clear;

    @FXML
    private Button start;

    public static void resetData() {

        isSaved = false;
        sun = new sunflower();
        ba = new basil();
        he = new hemp();
        soy = new soyBean();

        sunPest = new pesticide(sun);
        baPest = new pesticide(ba);
        soyPest = new pesticide(soy);
        hePest = new pesticide(he);
    }
    /**
     * @return scene
     * @throws IOException throw IO
     */
    public Parent userInputControllerScene() throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("view/userInput.fxml"));
        return root2;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list
                = FXCollections.observableArrayList("Sunflower", "Basil", "Soy Bean", "Hemp");
        seedType.setItems(list);

        ObservableList<String> seasonChoice
                = FXCollections.observableArrayList("Spring", "Summer", "Fall", "Winter");
        season.setItems(seasonChoice);

        ObservableList<String> difficultyChoice
                = FXCollections.observableArrayList("Easy", "Hard", "Expert");
        difficulty.setItems(difficultyChoice);


    }

    /**
     * @param actionEvent  action event
     * */
    public void getInput(ActionEvent actionEvent) {

    }
    /**
     * @param actionEvent  event
     * */
    public void create(ActionEvent actionEvent) {
        try {
            if (nameF.getText().isEmpty() || season.getValue().isEmpty()
                    || seedType.getValue().isEmpty()
                    || difficulty.getValue().isEmpty()) {
                throw new NullPointerException();
            } else if (nameF.getText().trim().isEmpty()) {
                throw new NullPointerException();
            } else {
                //put the info to the data class
                Controller.setName(nameF.getText().toString());
                Controller.setDifficulty(difficulty.getValue().toString());
                Controller.setSeedType(seedType.getValue().toString());
                Controller.setSeason(season.getValue().toString());
                isSaved = true;
                if (Controller.getSeedType() == "Sunflower") {
                    sun.setSeedNum(4);
                }
                if (Controller.getSeedType() == "Basil") {
                    ba.setSeedNum(4);
                }
                if (Controller.getSeedType() == "Soy Bean") {
                    soy.setSeedNum(4);
                }
                if (Controller.getSeedType() == "Hemp") {
                    he.setSeedNum(4);
                }
                // unable to switch the scene

            }


        } catch (NullPointerException ee) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid Input");
            a.setContentText("You cannot add an invalid name ,and must select options");
            a.showAndWait();
        }
    }

    public static void reset() {
        inputC.resetData();
        InitialUI2.days = 0;
        Controller.setBuy(0);
        InitialUI2.plotsArray[10].setStatus(-1);
        InitialUI2.plotsArray[11].setStatus(-1);
        Controller.setIrrigation(false);
        Controller.setTractor(false);
        Controller.setMaxHarvest(5);
        Controller.setMaxWaterTimes(5);
        Controller.setPesticidesNum(-Controller.getPesticidesNum());
        Controller.setFerNum(-Controller.getFerNum());
        for (int i = 0; i < 12; i++) {
            InitialUI2.plotsArray[i].setFerLevel(0);
            InitialUI2.plotsArray[i].setWaterLevel(0);
            InitialUI2.conditions[i].setText("Empty");
            InitialUI2.plotsArray[i].setStatus(-1);
            InitialUI2.plotsArray[i].setDead(false);
            InitialUI2.plotsArray[i].setPesticides(false);
        }
    }
    /**
     * @param actionEvent  event
     * */
    public void startGame(ActionEvent actionEvent) {
        try {
            if (nameF.getText().isEmpty() || season.getValue().isEmpty()
                    || seedType.getValue().isEmpty()
                    || difficulty.getValue().isEmpty() || !isSaved) {
                throw new NullPointerException();
            } else if (nameF.getText().trim().isEmpty()) {
                throw new NullPointerException();
            } else {
                Controller.initialSetMoney();
                sceneChange(actionEvent, "UIScene.fxml");
            }

        } catch (NullPointerException ee) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid Input");
            a.setContentText("You have to save Your Info");
            a.showAndWait();
        }
    }
    /**
     * @param actionEvent event
     * @param fxmlName  fxml name
     * */
    public void sceneChange(ActionEvent actionEvent, String fxmlName) {
        try {
            Parent configParent = FXMLLoader.load(getClass().getResource(fxmlName));
            Scene scene = new Scene(configParent);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException var6) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid Input");
            a.setContentText("You have to save Your Info first");
            a.showAndWait();
        }

    }
}








