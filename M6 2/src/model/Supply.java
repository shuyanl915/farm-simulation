package model;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Supply implements Initializable {

    @FXML
    private TextField quantityP;

    @FXML
    private TextField quantityF;


    @FXML
    private Label displayM;

    @FXML
    private Label ferText;

    @FXML
    private Label pestText;


    private static int pesticide = 5;
    private static int fertilize = 7;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayM.setText(displayM.getText() + Controller.getMoney());
        pestText.setText("Pesticides: " + Controller.getPesticidesNum());
        ferText.setText("Fertilizer: " + Controller.getFerNum());


    }

    /**
     * method for buy
     * @param event mouse event
     */
    @FXML
    void buyF(ActionEvent event) {
        int num;
        try {
            if (quantityF.getText().isEmpty()) {
                throw new IllegalArgumentException();
            }

            num = Integer.parseInt(quantityF.getText());
            Market1.difficultyMult();
            int money = num * fertilize * Market1.buyingMult;
            if (money > Controller.getMoney()) {
                throw new NoSuchFieldException();
            } else {
                int c = Controller.getMoney();
                Controller.setMoney(c - money);
                displayM.setText("Money：" + Controller.getMoney());
            }
            Controller.setFerNum(num);
            ferText.setText("Fertilizer : " + Controller.getFerNum());

        } catch (Exception ee) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid Action");
            if (ee instanceof IllegalArgumentException) {
                a.setContentText("You must enter number");
            } else if (ee instanceof NoSuchFieldException) {
                a.setContentText("You dont have enough money to buy");
            }
            a.showAndWait();
        }


    }

    /**
     * method for but again
     * @param event mouse event
     */
    @FXML
    void buyP(ActionEvent event) {
        int num;
        try {
            if (quantityP.getText().isEmpty()) {
                throw new IllegalArgumentException();
            }

            num = Integer.parseInt(quantityP.getText());
            Market1.difficultyMult();
            int money = num * pesticide * Market1.buyingMult; //$5 for each
            if (money > Controller.getMoney()) {
                throw new NoSuchFieldException();
            } else {
                int c = Controller.getMoney();
                Controller.setMoney(c - money);
                displayM.setText("Money：" + Controller.getMoney());
            }
            Controller.setPesticidesNum(num);
            System.out.println(Controller.getPesticidesNum());
            pestText.setText("Pesticides : " + Controller.getPesticidesNum());

        } catch (Exception ee) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Invalid Action");
            if (ee instanceof IllegalArgumentException) {
                a.setContentText("You must enter number");
            } else if (ee instanceof NoSuchFieldException) {
                a.setContentText("You dont have enough money to buy");
            }
            a.showAndWait();
        }

    }

    /**
     * method to go back
     * @param event mouse event
     */
    @FXML
    void back(ActionEvent event) {
        sceneChange(event, "market.fxml");

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

}


