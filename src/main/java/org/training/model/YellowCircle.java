package org.training.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class YellowCircle {

    private Circle yellowCircle = new Circle();
    private double centerX;
    private double centerY;

    public YellowCircle(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
        yellowCircle.setCenterX(centerX);
        yellowCircle.setCenterY(centerY);

        yellowCircle.setRadius(25.0f);
        yellowCircle.setFill(Color.BLUE);
        yellowCircle.setStrokeWidth(20);
    }


    public Circle getYellowCircle() {
        return yellowCircle;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
        this.yellowCircle.setCenterX(this.centerX);
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
        this.yellowCircle.setCenterY(this.centerY);
    }
}
