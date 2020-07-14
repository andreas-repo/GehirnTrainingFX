package org.training.graphicalInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.training.logic.CalculatorGame;

public class GraphicalUserInterface extends Application {
    private final CalculatorGame calculatorGame = new CalculatorGame();
    private int points = 0;

    @Override
    public void start(Stage stage) throws Exception {
        TabPane tabPane = new TabPane();
        /**
         * tab1
         */
        GridPane tab1GridPane = new GridPane();
        tab1GridPane.setPadding(new Insets(20, 20, 20, 20));
        tab1GridPane.setHgap(10);
        tab1GridPane.setVgap(10);
        tab1GridPane.setAlignment(Pos.CENTER);

        GridPane toggleGridPane = new GridPane();
        toggleGridPane.setPadding(new Insets(20, 20, 20, 20));
        toggleGridPane.setHgap(10);
        toggleGridPane.setVgap(10);
        toggleGridPane.setAlignment(Pos.CENTER);
        toggleGridPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));



        Tab tab1 = new Tab("Calculus Training", tab1GridPane);

        ToggleButton toggleButtonAddition = new ToggleButton("Addition");
        ToggleButton toggleButtonSubtraction = new ToggleButton("Subtraction");
        ToggleButton toggleButtonMultiplication = new ToggleButton("Multiplication");
        ToggleButton toggleButtonDivision = new ToggleButton("Division");

        ToggleGroup toggleGroup = new ToggleGroup();

        toggleButtonAddition.setToggleGroup(toggleGroup);
        toggleButtonSubtraction.setToggleGroup(toggleGroup);
        toggleButtonMultiplication.setToggleGroup(toggleGroup);
        toggleButtonDivision.setToggleGroup(toggleGroup);

        HBox hBoxToggleGroup = new HBox(toggleButtonAddition, toggleButtonSubtraction, toggleButtonMultiplication, toggleButtonDivision);
        hBoxToggleGroup.setAlignment(Pos.CENTER);
        toggleGridPane.add(hBoxToggleGroup, 1, 0);

        ToggleButton toggleButtonDifficultyEasy = new ToggleButton("Easy");
        ToggleButton toggleButtonDifficultyMedium = new ToggleButton("Medium");
        ToggleButton toggleButtonDifficultyHard = new ToggleButton("Hard");

        ToggleGroup toggleGroupDifficulty = new ToggleGroup();

        toggleButtonDifficultyEasy.setToggleGroup(toggleGroupDifficulty);
        toggleButtonDifficultyMedium.setToggleGroup(toggleGroupDifficulty);
        toggleButtonDifficultyHard.setToggleGroup(toggleGroupDifficulty);

        HBox hBoxToggleGroupDifficulty = new HBox(toggleButtonDifficultyEasy, toggleButtonDifficultyMedium, toggleButtonDifficultyHard);
        hBoxToggleGroupDifficulty.setAlignment(Pos.CENTER);
        toggleGridPane.add(hBoxToggleGroupDifficulty, 1, 1);

        tab1GridPane.add(toggleGridPane, 0, 0);

        GridPane gameGridPane = new GridPane();
        gameGridPane.setPadding(new Insets(20, 20, 20, 20));
        gameGridPane.setHgap(10);
        gameGridPane.setVgap(10);
        gameGridPane.setAlignment(Pos.CENTER);
        gameGridPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        tab1GridPane.add(gameGridPane, 0, 1);

        Label gameLabel = new Label();
        gameLabel.setId("gameLabel");
        HBox hbGameLabel = new HBox(10);
        hbGameLabel.setAlignment(Pos.CENTER);
        hbGameLabel.getChildren().add(gameLabel);
        gameGridPane.add(hbGameLabel, 0, 0);

        TextField gameInputText = new TextField();
        gameInputText.setVisible(false);
        gameInputText.setId("gameInputText");
        gameInputText.setEditable(true);
        gameInputText.setMaxWidth(40);
        gameInputText.setMinWidth(40);
        gameInputText.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                gameInputText.setText("");
            }
        });
        HBox hbGameInputText = new HBox(10);
        hbGameInputText.setAlignment(Pos.CENTER);
        hbGameInputText.getChildren().add(gameInputText);
        gameGridPane.add(hbGameInputText, 1, 0);

        Button gameInput = new Button("Submit");
        gameInput.setId("gameInput");
        HBox hbGameInput = new HBox(10);
        hbGameInput.setAlignment(Pos.CENTER);
        hbGameInput.getChildren().add(gameInput);
        gameGridPane.add(hbGameInput, 1, 1, 2, 1);

        /**
         * Points GridPane
         */
        GridPane pointsGridPane = new GridPane();
        pointsGridPane.setPadding(new Insets(20, 20, 20, 20));
        pointsGridPane.setHgap(10);
        pointsGridPane.setVgap(10);
        pointsGridPane.setAlignment(Pos.CENTER);
        pointsGridPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        tab1GridPane.add(pointsGridPane, 0, 2);

        Label pointsLabel = new Label(points +" Points");
        pointsLabel.setId("pointsLabel");
        HBox hbPointsLabel = new HBox(10);
        hbPointsLabel.setAlignment(Pos.CENTER_RIGHT);
        hbPointsLabel.getChildren().add(pointsLabel);
        pointsGridPane.add(hbPointsLabel, 0, 0);


        toggleButtonDifficultyEasy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleButtonAddition.isSelected()) {
                    gameLabel.setText(calculatorGame.randomAddition(10));
                } else if (toggleButtonSubtraction.isSelected()) {
                    gameLabel.setText(calculatorGame.randomSubtractionInteger(10));
                } else if (toggleButtonMultiplication.isSelected()) {
                    gameLabel.setText(calculatorGame.randomMultiplicationInteger(10));
                } else if (toggleButtonDivision.isSelected()) {
                    gameLabel.setText(calculatorGame.randomDivisionDouble(10));
                }
                gameInputText.setVisible(true);
                gameInput.setVisible(true);
                gameInputText.setText("?");
            }
        });

        toggleButtonDifficultyMedium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleButtonAddition.isSelected()) {
                    gameLabel.setText(calculatorGame.randomAddition(100));
                } else if (toggleButtonSubtraction.isSelected()) {
                    gameLabel.setText(calculatorGame.randomSubtractionInteger(100));
                } else if (toggleButtonMultiplication.isSelected()) {
                    gameLabel.setText(calculatorGame.randomMultiplicationInteger(100));
                } else if (toggleButtonDivision.isSelected()) {
                    gameLabel.setText(calculatorGame.randomDivisionDouble(100));
                }

                gameInputText.setVisible(true);
                gameInput.setVisible(true);
                gameInputText.setText("?");
            }
        });

        toggleButtonDifficultyHard.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (toggleButtonAddition.isSelected()) {
                    gameLabel.setText(calculatorGame.randomAddition(1000));
                } else if (toggleButtonSubtraction.isSelected()) {
                    gameLabel.setText(calculatorGame.randomSubtractionInteger(1000));
                } else if (toggleButtonMultiplication.isSelected()) {
                    gameLabel.setText(calculatorGame.randomMultiplicationInteger(1000));
                } else if (toggleButtonDivision.isSelected()) {
                    gameLabel.setText(calculatorGame.randomDivisionDouble(1000));
                }

                gameInputText.setVisible(true);
                gameInput.setVisible(true);
                gameInputText.setText("?");
            }
        });

        gameInput.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean result = false;
                if (toggleButtonAddition.isSelected()) {
                    try {
                        String input = gameInputText.getText();
                        int parsedInput = Integer.parseInt(input);
                        result = calculatorGame.getRandomAdditionResult() == parsedInput;
                        if (result) {
                            GraphicalUserInterface.this.points++;
                            pointsLabel.setText(GraphicalUserInterface.this.points +" Points");
                            if (toggleButtonDifficultyEasy.isSelected()) {
                                gameLabel.setText(calculatorGame.randomAddition(10));
                                gameInputText.setText("?");
                            } else if (toggleButtonDifficultyMedium.isSelected()) {
                                gameLabel.setText(calculatorGame.randomAddition(100));
                                gameInputText.setText("?");
                            } else if (toggleButtonDifficultyHard.isSelected()) {
                                gameLabel.setText(calculatorGame.randomAddition(1000));
                                gameInputText.setText("?");
                            }
                        } else {
                            gameInputText.setText("WRONG");
                        }
                    } catch (NumberFormatException e) {

                    }

                } else if (toggleButtonSubtraction.isSelected()) {
                    try {
                        String input = gameInputText.getText();
                        int parsedInput = Integer.parseInt(input);
                        result = calculatorGame.getRandomSubtractionIntegerResult() == parsedInput;
                        if (result) {
                            GraphicalUserInterface.this.points++;
                            pointsLabel.setText(GraphicalUserInterface.this.points +" Points");
                            if (toggleButtonDifficultyEasy.isSelected()) {
                                gameLabel.setText(calculatorGame.randomSubtractionInteger(10));
                                gameInputText.setText("?");
                            } else if (toggleButtonDifficultyMedium.isSelected()) {
                                gameLabel.setText(calculatorGame.randomSubtractionInteger(100));
                                gameInputText.setText("?");
                            } else if (toggleButtonDifficultyHard.isSelected()) {
                                gameLabel.setText(calculatorGame.randomSubtractionInteger(1000));
                                gameInputText.setText("?");
                            }
                        } else {
                            gameInputText.setText("WRONG");
                        }
                    } catch (NumberFormatException e) {

                    }

                } else if (toggleButtonMultiplication.isSelected()) {
                    try {
                        String input = gameInputText.getText();
                        int parsedInput = Integer.parseInt(input);
                        result = calculatorGame.getRandomMultiplicationIntegerResult() == parsedInput;
                        if (result) {
                            GraphicalUserInterface.this.points++;
                            pointsLabel.setText(GraphicalUserInterface.this.points +" Points");
                            if (toggleButtonDifficultyEasy.isSelected()) {
                                gameLabel.setText(calculatorGame.randomMultiplicationInteger(10));
                                gameInputText.setText("?");
                            } else if (toggleButtonDifficultyMedium.isSelected()) {
                                gameLabel.setText(calculatorGame.randomMultiplicationInteger(100));
                                gameInputText.setText("?");
                            } else if (toggleButtonDifficultyHard.isSelected()) {
                                gameLabel.setText(calculatorGame.randomMultiplicationInteger(1000));
                                gameInputText.setText("?");
                            }
                        } else {
                            gameInputText.setText("WRONG");
                        }
                    } catch (NumberFormatException e) {

                    }

                } else if (toggleButtonDivision.isSelected()) {
                    try {
                        String input = gameInputText.getText();
                        double parsedInput = Double.parseDouble(input);
                        result = calculatorGame.getRandomDivisionDoubleResult() == parsedInput;
                        if (result) {
                            GraphicalUserInterface.this.points++;
                            pointsLabel.setText(GraphicalUserInterface.this.points +" Points");
                            if (toggleButtonDifficultyEasy.isSelected()) {
                                gameLabel.setText(calculatorGame.randomDivisionDouble(10));
                                gameInputText.setText("?");
                            } else if (toggleButtonDifficultyMedium.isSelected()) {
                                gameLabel.setText(calculatorGame.randomDivisionDouble(100));
                                gameInputText.setText("?");
                            } else if (toggleButtonDifficultyHard.isSelected()) {
                                gameLabel.setText(calculatorGame.randomDivisionDouble(1000));
                                gameInputText.setText("?");
                            }
                        } else {
                            gameInputText.setText("WRONG");
                        }
                    } catch (NumberFormatException e) {

                    }
                }
            }
        });



        /**
         * tab2
         */
        Tab tab2 = new Tab("Tab2", new Label("Tab2 Label"));

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);

        VBox vBox = new VBox(tabPane);

        //tab1GridPane.setGridLinesVisible(true);

        Scene scene = new Scene(vBox, 400, 400);
        stage.setScene(scene);
        stage.setTitle("GehirntrainingFX");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
