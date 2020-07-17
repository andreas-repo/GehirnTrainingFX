package org.training.model;

import javafx.animation.SequentialTransition;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class ShapeAnimations {
    private SequentialTransition sequentialTransitionOne;
    private SequentialTransition sequentialTransitionTwo;


    public Group animationOne() {
        Circle c1Yellow = new Circle();
        c1Yellow.setCenterX(200.0f);
        c1Yellow.setCenterY(200.0f);
        c1Yellow.setRadius(30.0f);
        c1Yellow.setFill(Color.YELLOW);
        c1Yellow.setStrokeWidth(20.0f);

        Circle c2Yellow = new Circle();
        c2Yellow.setCenterX(100.0f);
        c2Yellow.setCenterY(100.0f);
        c2Yellow.setRadius(30.0f);
        c2Yellow.setFill(Color.YELLOW);
        c2Yellow.setStrokeWidth(20.0f);

        Circle c3Yellow = new Circle();
        c3Yellow.setCenterX(200.0f);
        c3Yellow.setCenterY(200.0f);
        c3Yellow.setRadius(30.0f);
        c3Yellow.setFill(Color.YELLOW);
        c3Yellow.setStrokeWidth(20.0f);

        Circle c4Yellow = new Circle();
        c4Yellow.setCenterX(200.0f);
        c4Yellow.setCenterY(200.0f);
        c4Yellow.setRadius(30.0f);
        c4Yellow.setFill(Color.YELLOW);
        c4Yellow.setStrokeWidth(20.0f);

        Circle c1Blue = new Circle();
        c1Blue.setCenterX(200.0f);
        c1Blue.setCenterY(200.0f);
        c1Blue.setRadius(30.0f);
        c1Blue.setFill(Color.YELLOW);
        c1Blue.setStrokeWidth(20.0f);

        TranslateTransition t1Yellow = new TranslateTransition();
        TranslateTransition t2Yellow = new TranslateTransition();
        TranslateTransition t3Yellow = new TranslateTransition();
        TranslateTransition t4Yellow = new TranslateTransition();

        TranslateTransition t1Blue = new TranslateTransition();

        /**
         * circle one yellow
         */
        t1Yellow.setDuration(Duration.millis(1000.0f));
        t1Yellow.setNode(c1Yellow);
        t1Yellow.toXProperty().setValue(100.0f);
        t1Yellow.toYProperty().setValue(100.0f);
        t1Yellow.setCycleCount(5);
        t1Yellow.setAutoReverse(false);
        /**
         * circle two yellow
         */
        t2Yellow.setDuration(Duration.millis(1000.0f));
        t2Yellow.setNode(c1Yellow);
        t2Yellow.toXProperty().setValue(100.0f);
        t2Yellow.toYProperty().setValue(100.0f);
        t2Yellow.setCycleCount(5);
        t2Yellow.setAutoReverse(false);

        this.sequentialTransitionOne = new SequentialTransition(c1Yellow, t1Yellow);
        this.sequentialTransitionTwo = new SequentialTransition(c2Yellow, t2Yellow);

        this.sequentialTransitionOne.play();
        this.sequentialTransitionTwo.play();

        return new Group(c1Yellow, c2Yellow);
    }

    public void playAnimationOne() {

    }
}
