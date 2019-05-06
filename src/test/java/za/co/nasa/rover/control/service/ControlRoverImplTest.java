package za.co.nasa.rover.control.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Scanner;

@RunWith(MockitoJUnitRunner.class)
public class ControlRoverImplTest {

    @InjectMocks
    private ControlRoverImpl controlRover;

    @Test
    public void LaunchRovers() {
        String testIn = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
        String testOut = "1 3 N 5 1 E ";
        Scanner scanner = new Scanner(testIn);
        String out = controlRover.LaunchRovers(scanner);
        Assert.assertEquals(testOut,out);
    }


    @Test
    public void LaunchRovers_LeftMove() {
        String testIn = "5 5 3 2 W LM";
        String testOut = "3 1 S ";
        Scanner scanner = new Scanner(testIn);
        String out = controlRover.LaunchRovers(scanner);
        Assert.assertEquals(testOut,out);
    }

    @Test
    public void LaunchRovers_RightMove() {
        String testIn = "5 5 3 2 W RM";
        String testOut = "3 3 N ";
        Scanner scanner = new Scanner(testIn);
        String out = controlRover.LaunchRovers(scanner);
        Assert.assertEquals(testOut,out);
    }

    @Test
    public void LaunchRovers_MinX() {
        String testIn = "5 5 3 2 W MMMMM";
        String testOut = "0 2 W ";
        Scanner scanner = new Scanner(testIn);
        String out = controlRover.LaunchRovers(scanner);
        Assert.assertEquals(testOut,out);
    }

    @Test
    public void LaunchRovers_MinY() {
        String testIn = "5 5 1 2 S MMMMM";
        String testOut = "1 0 S ";
        Scanner scanner = new Scanner(testIn);
        String out = controlRover.LaunchRovers(scanner);
        Assert.assertEquals(testOut,out);
    }


    @Test
    public void LaunchRovers_MaxX() {
        String testIn = "5 5 3 2 E MMMMM";
        String testOut = "5 2 E ";
        Scanner scanner = new Scanner(testIn);
        String out = controlRover.LaunchRovers(scanner);
        Assert.assertEquals(testOut,out);
    }

    @Test
    public void LaunchRovers_MaxY() {
        String testIn = "5 5 1 2 N MMMMM";
        String testOut = "1 5 N ";
        Scanner scanner = new Scanner(testIn);
        String out = controlRover.LaunchRovers(scanner);
        Assert.assertEquals(testOut,out);
    }

}