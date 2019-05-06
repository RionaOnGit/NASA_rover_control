package za.co.nasa.rover.control.model;

import java.io.Serializable;

public class Rover implements Serializable {

    private final int ONE_STEP = 1; //set default steps
    private final int NINETY_DEGREE_ROTATION = 90; //each right/left turn can be considered +/-90 degree rotation

    private Direction direction;
    private int maxX;
    private int maxY;
    private int x_position;
    private int y_position;

    public Rover(int x_position, int y_position, String direction) {
        //Create new Rover with position (x,y) facing direction (N, E, W, S)
        this.x_position = x_position;
        this.y_position = y_position;
        this.direction = Direction.valueOf(direction);
        System.out.println("ROVER LAUNCHED " + getX_position() + getY_position() + getDirection().getValue());
    }

    public void instruct(String instructions){
        //Use list of instructions to trigger each action
        String[] actions = instructions.split("");

        for(String action : actions){
            System.out.println("Action : "+ action);
            action(Instruction.valueOf(action));
        }
    }

    private void action(Instruction instruction){
        switch (instruction) {
            case L:
                rotateLeft();
                break;
            case R:
                rotateRight();
                break;
            case M:
                moveForward(ONE_STEP);
                break;
        }
    }

    private void rotateLeft() {
        setDirection(direction.getDegree() - NINETY_DEGREE_ROTATION);
        System.out.println("Rover Rotated Left, now facing " + getDirection());
    }

    private void rotateRight() {
        setDirection(direction.getDegree() + NINETY_DEGREE_ROTATION);
        System.out.println("Rover Rotated Right, now facing " + getDirection());
    }

    private void setDirection(Integer value){
        switch (value){
            case 0 : case 360: //if rovers calculated angle is 0 or 360 degrees -> facing north
                setDirection(Direction.N);
            break;
             case 90: //if rovers calculated angle is 90 degrees -> facing east
                 setDirection(Direction.E);
            break;
             case 180: //if rovers calculated angle is 180 degrees -> facing south
                 setDirection(Direction.S);
            break;
             case 270 : case -90: //if rovers calculated angle is 270 or -90 degrees -> facing west
                setDirection(Direction.W);
            break;
        }

    }

    private void moveForward(int numSteps) {
        switch (getDirection()) { // move rover numSteps steps forward based on the direction it is facing
            case N:
                setCoordinates(getX_position(), getY_position() + numSteps);
                break;
            case E:
                setCoordinates(getX_position() + numSteps, getY_position());
                break;
            case S:
                setCoordinates(getX_position(), getY_position() - numSteps);
                break;
            case W:
                setCoordinates(getX_position() - numSteps, getY_position());
                break;
        }
    }

    public String getCoordinates() {
        return x_position+" "+y_position;
    }

    private void setCoordinates(int x, int y) {

        //if new proposed x co ordinate is not with range (0;maxX) set it to max/min respectively
        if(x<=0){
            x_position = 0;
        }else if (x >= maxX){
            x_position = maxX;
        }else {
            x_position = x;
        }

        //if new proposed y co ordinate is not with range (0;maxY) set it to max/min respectively
        if(y<=0){
            y_position = 0;
        }else if (y >= maxY){
            y_position = maxY;
        }else {
            y_position = y;
        }
        System.out.println("Rover Moved " + getX_position() + getY_position());

    }

    public Direction getDirection() {
        return direction;
    }

    private void setDirection(Direction direction) {
        this.direction = direction;
    }

    private int getX_position() {
        return x_position;
    }

    private int getY_position() {
        return y_position;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

}