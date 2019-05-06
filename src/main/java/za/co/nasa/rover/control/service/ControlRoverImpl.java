package za.co.nasa.rover.control.service;

import za.co.nasa.rover.control.model.Rover;
import java.util.*;

public class ControlRoverImpl {

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(" ");

        LaunchRovers(scanner);
        scanner.close();
    }

    public String LaunchRovers(Scanner scanner){

        List<Rover> rovers = new ArrayList<Rover>();
        StringBuilder out = new StringBuilder();

        int xMax = scanner.nextInt();
        int yMax = scanner.nextInt();

        while(scanner.hasNext()){
            int roverX = scanner.nextInt();
            int roverY = scanner.nextInt();
            String roverFacing = scanner.next();
            String roverInstructions = scanner.next();

            Rover rover = new Rover(roverX, roverY, roverFacing);
            rover.setMaxX(xMax);
            rover.setMaxY(yMax);
            rover.instruct(roverInstructions);
            rovers.add(rover);
            out.append(rover.getCoordinates()).append(" ").append(rover.getDirection()).append(" ");

        }

        return out.toString();
    }
}
