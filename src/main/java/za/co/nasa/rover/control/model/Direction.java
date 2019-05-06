package za.co.nasa.rover.control.model;

public enum Direction {
    N("NORTH",0), //take north as 0 degrees
    E("EAST",90),
    S("SOUTH", 180),
    W("WEST", 270);

    private final String value;
    private final Integer degrees;

    Direction(String value, Integer degrees){
        this.degrees = degrees;
        this.value = value;
    }

    public Integer getDegree(){
        return degrees;
    }

    public String  getValue(){
        return value;
    }

}
