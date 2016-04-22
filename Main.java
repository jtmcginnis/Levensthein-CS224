package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Main extends Application {

    private GridPane grid;
    private Button calculate;
    private Label distanceLabel;
    private TextField inputOne;
    private TextField inputTwo;
    private final LDCalculator ldCalculator = new LDCalculator();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Levensthein Distance");
        primaryStage.setScene(getGridPaneScene());
        initTextFields();
        initDistanceLabel();
        initButton();
        primaryStage.show();

    }

    private Scene getGridPaneScene(){
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        return new Scene(grid, 300, 275);
    }

    private void initButton(){
        calculate = new Button("Calculate");
        grid.add(calculate, 0, 3);
        calculate.setOnAction(event -> {
            calculateDistance(inputOne.getText(), inputTwo.getText());
        });
    }

    private void initDistanceLabel(){
        distanceLabel = new Label("Distance: 0");
        grid.add(distanceLabel, 0, 0);
    }

    private void initTextFields(){
        inputOne = new TextField();
        grid.add(inputOne, 0, 1);
        inputTwo = new TextField();
        grid.add(inputTwo, 0, 2);
    }

    private void calculateDistance(String one, String two){
        one.trim();
        two.trim();
        one.toLowerCase();
        two.toLowerCase();
        distanceLabel.setText("Distance: " + ldCalculator.calculate(one, two));
    }



}
