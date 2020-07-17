package org.training.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BlueCircle {
    private Circle blueCircle = new Circle();
    private double centerX;
    private  double centerY;

    public BlueCircle(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
        blueCircle.setCenterX(centerX);
        blueCircle.setCenterY(centerY);
        blueCircle.setRadius(25.0f);
        blueCircle.setFill(Color.BLUE);
        blueCircle.setStrokeWidth(20);
    }

    public Circle getBlueCircle() {
        return blueCircle;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
        this.blueCircle.setCenterX(this.centerX);
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
        this.blueCircle.setCenterY(this.centerY);
    }
}
