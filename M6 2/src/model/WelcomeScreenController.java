package model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeScreenController {


    /**
     * start game
     * @param actionEvent event
     */
    public void startGame(ActionEvent actionEvent) {
        sceneChange(actionEvent, "userInput.fxml");
    }

    /**
     * change to next scene
     * @param actionEvent event
     * @param fxmlName file name
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
