//import javafx.fxml.FXML;
//import javafx.geometry.Pos;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.layout.BorderPane;
//
//import java.io.IOException;
//
//public class Inventory {
//    private BorderPane root = new BorderPane();
//    //private final int max_capacity = 200;
//    private Label sunFlowerSeed;
//    private Label basilSeed;
//    private Label soyBeanSeed;
//    private Label hempSeed;
//    private Label sunFlower;
//    @FXML
//    private Label basil;
//    private Label soyBean;
//    private Label hemp;
//    private Button back;
//    private VBox inventoryList;
//    private GridPane centerPart;
//    private HBox topMenu;
//    private int seed1Num;
//    private int seed2Num;
//    private int seed3Num;
//    private int seed4Num;
//    private int total;
//    //index: 0:sunflower seed, 1:basil seed, 2:soy bean seed, 3:hemp seed,
//    //       4:sunflower,      5:basil,      6:soy bean,      7:hemp
//    protected static int[] inventorySituation = new int[9];
//
//
//    /**
//     * return inventory screen
//     *
//     * @param topMenu a
//     * @return screen
//     */
//    public Parent constructInv(HBox topMenu) {
//        sunFlowerSeed = new Label("SunFlower Seed: " + inventorySituation[0]);
//        basilSeed = new Label("Basil Seed: " + inventorySituation[1]);
//        soyBeanSeed = new Label("Soy Bean Seed: " + inventorySituation[2]);
//        hempSeed = new Label("Hemp seed: " + inventorySituation[3]);
//        sunFlower = new Label("SunFlower: " + inventorySituation[4]);
//        basil = new Label("Basil: " + inventorySituation[5]);
//        soyBean = new Label("Soy Bean: " + inventorySituation[6]);
//        hemp = new Label("Hemp: " + inventorySituation[7]);
//        back = new Button("Go Back to Plots");
//
//        HBox oldTopMenu = topMenu;
//
//
//        back.setOnAction(e -> {
//            UserInputScreen user = new UserInputScreen();
//            InitialUI uI = new InitialUI();
//            GridPane plots = uI.getPlotGrid();
//            int day = uI.getDays();
//            String[] info = user.getPlayerInfo();
//            try {
//                Scene scene = new Scene(uI.uiConstructor(info, day));
//                Main.mainPage.setScene(scene);
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//
//
//        });
//
//
//        centerPart = new GridPane();
//        centerPart.addColumn(3, sunFlowerSeed, basilSeed, soyBeanSeed, hempSeed);
//        centerPart.addColumn(7, sunFlower, basil, soyBean, hemp);
//        centerPart.setAlignment(Pos.CENTER);
//
//
//        topMenu = new HBox();
//        topMenu.getChildren().addAll(back);
//        topMenu.setAlignment(Pos.CENTER_RIGHT);
//
//        root.setMinSize(500, 500);
//
//        root.setCenter(centerPart);
//        root.setTop(topMenu);
//
//
//        return root;
//    }
//
//    /**
//     * @param seedType   a
//     * @param buy        a
//     * @param harvestNum a
//     */
//    public void updateInv(String seedType, int harvestNum, boolean buy) {
//        if (harvestNum > 12) {
//            throw new IllegalArgumentException("num harvest can't be over 12");
//        }
//
//        if (seedType.equals("Sunflower")) {
//            if (buy) {
//                inventorySituation[0] += harvestNum;
//            } else {
//                inventorySituation[4] += harvestNum;
//            }
//
//
//        } else if (seedType.equals("Basil")) {
//            if (buy) {
//                inventorySituation[1] += harvestNum;
//            } else {
//                inventorySituation[5] += harvestNum;
//            }
//
//
//        } else if (seedType.equals("Soy Bean")) {
//            if (buy) {
//                inventorySituation[2] += harvestNum;
//            } else {
//                inventorySituation[6] += harvestNum;
//            }
//
//        } else if (seedType.equals("Hemp")) {
//            if (buy) {
//                inventorySituation[3] += harvestNum;
//            } else {
//                inventorySituation[7] += harvestNum;
//            }
//
//        }
//        total = inventorySituation[0] + inventorySituation[1]
//                + inventorySituation[2] + inventorySituation[3];
//    }
//
//    /**
//     * @return a
//     */
//    public int[] getInventorySituation() {
//        //System.out.println(inventorySituation[0]);
//        return inventorySituation;
//    }
//
//    /**
//     * return total
//     *
//     * @return total
//     */
//    public int getTotal() {
//        return total;
//    }
//}
