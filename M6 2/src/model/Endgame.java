package model;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Endgame {
    public void restartGame(ActionEvent actionEvent) {

        // reset everything
        inputC.resetData();
        inputC.reset();
        Controller.setDate(1);
        // jump to ueserinput
        sceneChange(actionEvent, "userInput.fxml");

    }

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
