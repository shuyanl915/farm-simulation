package model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;

public class Inventory2 {
    @FXML
    private Button backToFarm;
    @FXML
    private Text sunSeed;
    @FXML
    private Text sunflower;
    @FXML
    private Text basilSeed;
    @FXML
    private Text basil;
    @FXML
    private Text soySeed;
    @FXML
    private Text soyBean;
    @FXML
    private Text hempSeed;
    @FXML
    private Text hemp;
    @FXML
    private Text pesticides;

    @FXML
    private Text sunflower1;

    @FXML
    private Text basil1;

    @FXML
    private Text soyBean1;

    @FXML
    private Text hemp1;

    @FXML
    private Text fertilizers;

    /**
     * constructor for inventory2
     */
    public Inventory2() {
    }

    /**
     * initialize method
     */
    public void initialize() {
        sunSeed.setText(sunSeed.getText() + inputC.sun.getSeedNum());
        basilSeed.setText(basilSeed.getText() + inputC.ba.getSeedNum());
        soySeed.setText(soySeed.getText() + inputC.soy.getSeedNum());
        hempSeed.setText(hempSeed.getText() + inputC.he.getSeedNum());
        sunflower.setText(sunflower.getText() + inputC.sun.getCrop());
        basil.setText(basil.getText() + inputC.ba.getCrop());
        soyBean.setText(soyBean.getText() + inputC.soy.getCrop());
        hemp.setText(hemp.getText() + inputC.he.getCrop());
        fertilizers.setText("Fertilizers : " + Controller.getFerNum());


        sunflower1.setText("Sun flower with Pesticides : "
                + inputC.sun.getPest());
        basil1.setText("Basil with Pesticides : " + inputC.ba.getPest());
        soyBean1.setText("Soy bean with Pesticides : " + inputC.soy.getPest());
        hemp1.setText("Hemp with Pesticides : " + inputC.he.getPest());
        System.out.println("inv..." + Controller.getPesticidesNum());
        pesticides.setText("Pesticides : " + Controller.getPesticidesNum());
    }

    /**
     * method back to farm
     *
     * @param actionEvent event
     */
    public void backToFarm(ActionEvent actionEvent) {
        sceneChange(actionEvent, "UIScene.fxml");

    }

    /**
     * method change scene
     *
     * @param actionEvent event
     * @param fxmlName    file name
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
