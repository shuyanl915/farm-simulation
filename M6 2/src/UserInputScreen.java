//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.text.Text;
//
//import java.io.IOException;
//import java.util.NoSuchElementException;
//
//
//public class UserInputScreen {
//    private static final int WIDTH = 1200;
//    private static final int HEIGHT = 800;
//    private Pane root = new Pane();
//    private GridPane gridPane = new GridPane();
//    private String name;
//    private String difficulty;
//    private String season;
//    private String nameInfo;
//    private static String[] playerInfo = new String[4];
//    private ComboBox<String> seasonChoice;
//    private ComboBox<String> difficultyChoice;
//    private ComboBox<String> seedChoice;
//    private Button clear;
//    private Button save;
//    private Button next;
//    private Text nameT;
//    private Text seasonT;
//    private Text difficultyT;
//    private Text seedT;
//    private TextField nameF;
//    protected InitialUI menu = new InitialUI();
//
//
//    /**
//     * This is the method that return initial configuration screen
//     *
////     * @return pane that contain initial configuration screen
//     */
//    public Parent constructInitial() {
//        nameT = new Text(" Player Name :");
//        seasonT = new Text("          Season :");
//        difficultyT = new Text("       Difficulty :");
//        seedT = new Text("     Seed Type :");
//        clear = new Button("Clear");
//        save = new Button("Save");
//        next = new Button("Go To Next Page");
//        seasonChoice = new ComboBox<>();
//        difficultyChoice = new ComboBox<>();
//        seedChoice = new ComboBox<>();
//        nameF = new TextField();
//
//
//        gridPane = new GridPane();
//        gridPane.setMinSize(400, 200);
//        gridPane.setPadding(new Insets(20, 40, 60, 80));
//        gridPane.setVgap(5);
//        gridPane.setHgap(5);
//
//
//        gridPane.add(nameT, 0, 0);
//        gridPane.add(nameF, 1, 0);
//
//        gridPane.add(seasonT, 0, 1);
//        gridPane.add(seasonChoice, 1, 1);
//
//        gridPane.add(difficultyT, 0, 2);
//        gridPane.add(difficultyChoice, 1, 2);
//
//        gridPane.add(seedT, 0, 3);
//        gridPane.add(seedChoice, 1, 3);
//
//        gridPane.add(save, 0, 4);
//        gridPane.add(clear, 1, 4);
//
//        gridPane.add(next, 1, 8);
//        gridPane.setAlignment(Pos.CENTER);
//
//
//
//        // setPromptText for each
//        seasonChoice.setPromptText("Choose Start Season");
//        difficultyChoice.setPromptText("Choose Game Difficulty");
//        nameF.setPromptText("Enter Player Name");
//        seedChoice.setPromptText("Choose Seed Type");
//
//        //button actions
//        save.setOnAction(e -> {
//            try {
//                if (nameF.getText().isEmpty() || seasonChoice.getValue().isEmpty()
//                        || seedChoice.getValue().isEmpty()
//                        || difficultyChoice.getValue().isEmpty()) {
//                    throw new NullPointerException();
//                } else if (nameF.getText().trim().isEmpty()) {
//                    throw new NullPointerException();
//                } else {
//                    playerInfo[0] = nameF.getText();
//                    playerInfo[1] = seedChoice.getValue();
//                    playerInfo[2] = seasonChoice.getValue();
//                    playerInfo[3] = difficultyChoice.getValue();
//                }
//            } catch (NullPointerException ee) {
//                Alert a = new Alert(Alert.AlertType.ERROR);
//                a.setTitle("Error");
//                a.setHeaderText("Invalid Input");
//                a.setContentText("You cannot add an invalid name ,and must select options");
//                a.showAndWait();
//            }
//        });
//
//        clear.setOnAction(e -> {
//            seasonChoice.getSelectionModel().clearSelection();
//            difficultyChoice.getSelectionModel().clearSelection();
//            seedChoice.getSelectionModel().clearSelection();
//            nameF.setText("");
//        });
//
//        next.setOnAction(e -> {
//            try {
//                if (nameF.getText().isEmpty() || seasonChoice.getValue().isEmpty()
//                        || seedChoice.getValue().isEmpty()
//                        || difficultyChoice.getValue().isEmpty()) {
//                    throw new NullPointerException();
//                } else if (nameF.getText().trim().isEmpty()) {
//                    throw new NullPointerException();
//                } else {
//                    nameInfo = nameF.getText();
//                    playerInfo[0] = nameInfo;
//                    playerInfo[1] = seedChoice.getValue();
//                    playerInfo[2] = seasonChoice.getValue();
//                    playerInfo[3] = difficultyChoice.getValue();
//                }
//                Scene scene = null;
//                InitialUI.updateMoney(false, 0, playerInfo[3]);
//                try {
//                    scene = new Scene(menu.uiConstructor(playerInfo, 1));
//                } catch (IOException ioException) {
//                    ioException.printStackTrace();
//                }
//
//                Main.mainPage.setScene(scene);
//
//                //System.out.println(InitialUI.beginMoney);
//            } catch (NullPointerException ee) {
//                Alert a = new Alert(Alert.AlertType.ERROR);
//                a.setTitle("Error");
//                a.setHeaderText("Invalid Input");
//                a.setContentText("You cannot add an invalid name ,and must select options");
//                a.showAndWait();
//            }
//
//        });
//
//        difficultyChoice.getItems().addAll("Easy", "Hard", "Expert");
//        seasonChoice.getItems().addAll("Spring", "Summer", "Fall", "Winter");
//        seedChoice.getItems().addAll("Sunflower", "Basil", "Soy Bean", "Hemp");
//        root.setMinSize(500, 500);
//        root.getChildren().add(gridPane);
//
//
//        return root;
//    }
//
//    /**
//     * The static method returns player info
//     *
//     * @return return the string that contains player info
//     **/
//    public static String[] getPlayerInfo() {
//        if (playerInfo != null) {
//            return playerInfo;
//        } else {
//            throw new NoSuchElementException();
//        }
//    }
//
//    /**
//     * getter method for NameF textFiled
//     *
//     * @return TextField
//     */
//    public TextField getNameF() {
//        return nameF;
//    }
//
//
//}
