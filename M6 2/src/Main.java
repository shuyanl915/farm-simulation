
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


public class Main extends Application {
    protected static Stage mainPage;
    private final int width = 500;
    private final int height = 500;
    MediaPlayer mediaPlayer ;

    /**
     * The main method that invokes application
     *
     * @param args string from user console
     */
    public static void main(String[] args) {

        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root2 = FXMLLoader.load(getClass().getResource("model/sample.fxml"));
        mainPage = primaryStage;
        mainPage.setScene(new Scene(root2, width, height));
        mainPage.setTitle("The Farm game");

        mainPage.show();
        //playMusic();

    }

    /*public void playMusic(){
        String s = "music.mp3";
        Media h = new Media(Paths.get(s).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }*/
    /**
     * @param actionEvent event
     * */
    public void inventory(ActionEvent actionEvent) {
        sceneChange(actionEvent, "InventoryScene.fxml");
    }
    /**
     * @param fxmlName fxml
     * @param actionEvent  event
     * */
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
