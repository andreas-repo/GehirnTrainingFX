package org.training.logic;

import java.util.Random;

public class CalculatorGame {

    private Random random = new Random();

    private int randomAdditionResult;
    private int randomAdditionNumber1;
    private int randomAdditionNumber2;

    private int randomSubtractionIntegerResult;
    private int randomSubtractionIntegerNumber1;
    private int randomSubtractionIntegerNumber2;

    private int randomMultiplicationIntegerResult;
    private int randomMultiplicationIntegerNumber1;
    private int randomMultiplicationIntegerNumber2;

    private double randomDivisionDoubleResult;
    private double randomDivisionDoubleNumber1;
    private double randomDivisionDoubleNumber2;

    public String randomAddition(int border) {
        this.randomAdditionNumber1 = random.nextInt(border);
        this.randomAdditionNumber2 = random.nextInt(border);
        this.randomAdditionResult = randomAdditionNumber1 + randomAdditionNumber2;
        //System.out.println("Number 1: " +this.randomAdditionNumber1);
        //System.out.println("Number 2: " +this.randomAdditionNumber2);
        //System.out.println("Result: " +this.randomAdditionResult);
        return new String(this.randomAdditionNumber1 +" + " +this.randomAdditionNumber2 +" = ");
    }

    public int getRandomAdditionResult() {
        return this.randomAdditionResult;
    }

    public void setRandomAdditionResult(int randomAdditionResult) {
        this.randomAdditionResult = randomAdditionResult;
    }

    public int getRandomAdditionNumber1() {
        return this.randomAdditionNumber1;
    }

    public void setRandomAdditionNumber1(int randomAdditionNumber1) {
        this.randomAdditionNumber1 = randomAdditionNumber1;
    }

    public int getRandomAdditionNumber2() {
        return this.randomAdditionNumber2;
    }

    public void setRandomAdditionNumber2(int randomAdditionNumber2) {
        this.randomAdditionNumber2 = randomAdditionNumber2;
    }

    public String randomSubtractionInteger(int border) {
        this.randomSubtractionIntegerNumber1 = random.nextInt(border);
        this.randomSubtractionIntegerNumber2 = random.nextInt(border);
        this.randomSubtractionIntegerResult = this.randomSubtractionIntegerNumber1 - this.randomSubtractionIntegerNumber2;
        //System.out.println("Number 1: " +this.randomSubtractionIntegerNumber1);
        //System.out.println("Number 2: " +this.randomSubtractionIntegerNumber2);
        //System.out.println("Result: " +this.randomSubtractionIntegerResult);
        return new String(this.randomSubtractionIntegerNumber1 +" - " +this.randomSubtractionIntegerNumber2  +" = ");
    }

    public int getRandomSubtractionIntegerResult() {
        return randomSubtractionIntegerResult;
    }

    public void setRandomSubtractionIntegerResult(int randomSubtractionIntegerResult) {
        this.randomSubtractionIntegerResult = randomSubtractionIntegerResult;
    }

    public int getRandomSubtractionIntegerNumber1() {
        return randomSubtractionIntegerNumber1;
    }

    public void setRandomSubtractionIntegerNumber1(int randomSubtractionIntegerNumber1) {
        this.randomSubtractionIntegerNumber1 = randomSubtractionIntegerNumber1;
    }

    public int getRandomSubtractionIntegerNumber2() {
        return randomSubtractionIntegerNumber2;
    }

    public void setRandomSubtractionIntegerNumber2(int randomSubtractionIntegerNumber2) {
        this.randomSubtractionIntegerNumber2 = randomSubtractionIntegerNumber2;
    }

    public String randomMultiplicationInteger(int border) {
        this.randomMultiplicationIntegerNumber1 = this.random.nextInt(border);
        this.randomMultiplicationIntegerNumber2 = this.random.nextInt(border);
        this.randomMultiplicationIntegerResult = this.randomMultiplicationIntegerNumber1 * this.randomMultiplicationIntegerNumber2;
        //System.out.println("Number 1: " +this.randomMultiplicationIntegerNumber1);
        //System.out.println("Number 2: " +this.randomMultiplicationIntegerNumber2);
        //System.out.println("Result: " +this.randomMultiplicationIntegerResult);
        return new String(this.randomMultiplicationIntegerNumber1 +" * " +this.randomMultiplicationIntegerNumber2 +" = ");
    }

    public int getRandomMultiplicationIntegerResult() {
        return randomMultiplicationIntegerResult;
    }

    public void setRandomMultiplicationIntegerResult(int randomMultiplicationIntegerResult) {
        this.randomMultiplicationIntegerResult = randomMultiplicationIntegerResult;
    }

    public int getRandomMultiplicationIntegerNumber1() {
        return randomMultiplicationIntegerNumber1;
    }

    public void setRandomMultiplicationIntegerNumber1(int randomMultiplicationIntegerNumber1) {
        this.randomMultiplicationIntegerNumber1 = randomMultiplicationIntegerNumber1;
    }

    public int getRandomMultiplicationIntegerNumber2() {
        return randomMultiplicationIntegerNumber2;
    }

    public void setRandomMultiplicationIntegerNumber2(int randomMultiplicationIntegerNumber2) {
        this.randomMultiplicationIntegerNumber2 = randomMultiplicationIntegerNumber2;
    }

    public String randomDivisionDouble(int border) {
        this.randomDivisionDoubleNumber1 = this.random.nextInt(border);
        this.randomDivisionDoubleNumber2 = this.random.nextInt(border);
        this.randomDivisionDoubleResult = this.randomDivisionDoubleNumber1 / this.randomDivisionDoubleNumber2;
        //System.out.println("Number 1: " +this.randomDivisionDoubleNumber1);
        //System.out.println("Number 2: " +this.randomDivisionDoubleNumber2);
        //System.out.println("Result: " +this.randomDivisionDoubleResult);
        return new String(this.randomDivisionDoubleNumber1 +" / " +this.randomDivisionDoubleNumber2 +" = ");
    }

    public double getRandomDivisionDoubleResult() {
        return randomDivisionDoubleResult;
    }

    public void setRandomDivisionDoubleResult(double randomDivisionDoubleResult) {
        this.randomDivisionDoubleResult = randomDivisionDoubleResult;
    }

    public double getRandomDivisionDoubleNumber1() {
        return randomDivisionDoubleNumber1;
    }

    public void setRandomDivisionDoubleNumber1(double randomDivisionDoubleNumber1) {
        this.randomDivisionDoubleNumber1 = randomDivisionDoubleNumber1;
    }

    public double getRandomDivisionDoubleNumber2() {
        return randomDivisionDoubleNumber2;
    }

    public void setRandomDivisionDoubleNumber2(double randomDivisionDoubleNumber2) {
        this.randomDivisionDoubleNumber2 = randomDivisionDoubleNumber2;
    }

    public boolean resultCheckerAdditionInteger(int result) {
        boolean endResult = false;
        if(result == this.randomAdditionResult) {
            endResult = true;
        }

        return endResult;
    }

    public boolean resultCheckerSubtractionInteger(int result) {
        boolean endResult = false;
        if(result == this.randomSubtractionIntegerResult) {
            endResult = true;
        }

        return endResult;
    }

    public boolean resultCheckerMultiplicationInteger(int result) {
        boolean endResult = false;
        if(result == this.randomMultiplicationIntegerResult) {
            endResult = true;
        }

        return endResult;
    }

    public boolean resultCheckerDivisionInteger(double result) {
        boolean endResult = false;
        if(result == this.randomDivisionDoubleResult) {
            endResult = true;
        }

        return endResult;
    }


}
