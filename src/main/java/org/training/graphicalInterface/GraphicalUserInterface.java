package org.training.graphicalInterface;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.training.logic.CalculatorGame;

import java.util.Random;

public class GraphicalUserInterface extends Application {
    private final CalculatorGame calculatorGame = new CalculatorGame();
    private int points = 0;

    private static final int KEYBOARD_MOVEMENT_DELTA = 5;
    private static final Duration TRANSLATE_DURATION = Duration.seconds(0.25);

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

        Label pointsLabel = new Label(points + " Points");
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
                            pointsLabel.setText(GraphicalUserInterface.this.points + " Points");
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
                            pointsLabel.setText(GraphicalUserInterface.this.points + " Points");
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
                            pointsLabel.setText(GraphicalUserInterface.this.points + " Points");
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
                            pointsLabel.setText(GraphicalUserInterface.this.points + " Points");
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
        GridPane tab2GridPane = new GridPane();
        tab2GridPane.setPadding(new Insets(20, 20, 20, 20));
        tab2GridPane.setHgap(10);
        tab2GridPane.setVgap(10);
        tab2GridPane.setAlignment(Pos.CENTER);

        Tab tab2 = new Tab("Memory Training", tab2GridPane);


        /**
         * Toggle GridPane
         */
        GridPane toggleGridPaneTab2 = new GridPane();
        toggleGridPaneTab2.setPadding(new Insets(20, 20, 20, 20));
        toggleGridPaneTab2.setHgap(10);
        toggleGridPaneTab2.setVgap(10);
        toggleGridPaneTab2.setAlignment(Pos.CENTER);

        /**
         * GridPane for the Circles
         */
        GridPane rotateGridPane = new GridPane();
        rotateGridPane.setPadding(new Insets(20, 20, 20, 20));
        rotateGridPane.setHgap(10);
        rotateGridPane.setVgap(10);
        rotateGridPane.setAlignment(Pos.CENTER);

        //Creating a hexagon
        Polygon hexagon = new Polygon();

        //Adding coordinates to the hexagon
        hexagon.getPoints().addAll(200.0, 50.0,
                400.0, 50.0,
                450.0, 150.0,
                400.0, 250.0,
                200.0, 250.0,
                150.0, 150.0);
        //Setting the fill color for the hexagon
        hexagon.setFill(Color.BLUE);

        //Creating a rotate transition
        RotateTransition rotateTransition = new RotateTransition();

        //Setting the duration for the transition
        rotateTransition.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        rotateTransition.setNode(hexagon);

        //Setting the angle of the rotation
        rotateTransition.setByAngle(360);

        //Setting the cycle count for the transition
        rotateTransition.setCycleCount(50);

        //Setting auto reverse value to false
        rotateTransition.setAutoReverse(false);

        //Playing the animation
        rotateTransition.play();

        //Creating a Group object
        Group root = new Group(hexagon);

        rotateGridPane.add(root, 0, 0);


        tab2GridPane.add(rotateGridPane, 0, 0);

        /**
         * add the tabs
         */
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);

        VBox vBox = new VBox(tabPane);

        //tab1GridPane.setGridLinesVisible(true);
        //set the scene
        Scene scene = new Scene(vBox, 400, 400);
        stage.setScene(scene);
        stage.setTitle("GehirntrainingFX");
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    //create a circle method
    private Circle createCircle() {
        final Circle circle = new Circle(200, 150, 50, Color.BLUEVIOLET);
        circle.setOpacity(0.7);
        return circle;
    }


    private Label createInstructions() {
        Label instructions = new Label(
                "Use the arrow keys to move the circle in small increments\n" +
                        "Click the mouse to move the circle to a given location\n" +
                        "Ctrl + Click the mouse to slowly translate the circle to a given location"
        );
        instructions.setTextFill(Color.FORESTGREEN);
        return instructions;
    }

    //create TranslateTransition method
    private TranslateTransition createTranslateTransition(final Circle circle) {
        final TranslateTransition transition = new TranslateTransition(TRANSLATE_DURATION, circle);
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                circle.setCenterX(circle.getTranslateX() + circle.getCenterX());
                circle.setCenterY(circle.getTranslateY() + circle.getCenterY());
                circle.setTranslateX(0);
                circle.setTranslateY(0);
            }
        });
        return transition;
    }

    //move circle on key press method
    private void moveCircleOnKeyPress(Scene scene, final Circle circle) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP:
                        circle.setCenterY(circle.getCenterY() - KEYBOARD_MOVEMENT_DELTA);
                        break;
                    case RIGHT:
                        circle.setCenterX(circle.getCenterX() + KEYBOARD_MOVEMENT_DELTA);
                        break;
                    case DOWN:
                        circle.setCenterY(circle.getCenterY() + KEYBOARD_MOVEMENT_DELTA);
                        break;
                    case LEFT:
                        circle.setCenterX(circle.getCenterX() - KEYBOARD_MOVEMENT_DELTA);
                        break;
                }
            }
        });
    }

    //move circle on mouse press method
    private void moveCircleOnMousePress(Scene scene, final Circle circle, final TranslateTransition transition) {
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!mouseEvent.isControlDown()) {
                    circle.setCenterX(mouseEvent.getSceneX());
                    circle.setCenterY(mouseEvent.getSceneY());
                } else {
                    transition.setToX(mouseEvent.getSceneX() - circle.getCenterX());
                    transition.setToY(mouseEvent.getSceneY() - circle.getCenterY());
                    transition.playFromStart();
                }
            }
        });

    }

    //move circle automatical
    private void autoMove(Scene scene, final Circle circle, final TranslateTransition transition) {
        int counter = 10000;
        while (counter <= 10000) {
            Random random = new Random();
            transition.setToX(circle.getCenterX() - random.nextInt(10));
            transition.setToY(circle.getCenterX() - random.nextInt(10));
            transition.playFromStart();
            counter++;
        }
    }
}
