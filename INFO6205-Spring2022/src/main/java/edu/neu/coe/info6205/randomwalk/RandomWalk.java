/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.randomwalk;

import java.lang.reflect.Array;
import java.util.Random;
import java.lang.Math;

public class RandomWalk {

    private int x = 0;
    private int y = 0;

    private final Random random = new Random();

    /**
     * Private method to move the current position, that's to say the drunkard moves
     *
     * @param dx the distance he moves in the x direction
     * @param dy the distance he moves in the y direction
     */
    private void move(int dx, int dy) {
        // FIXME do move by replacing the following code
    	 x = x + dx;
    	 y = y + dy;


//         throw new RuntimeException("Not implemented");
        // END 
    }

    /**
     * Perform a random walk of m steps
     *
     * @param m the number of steps the drunkard takes
     */
    private void randomWalk(int m) {
        // FIXME
    	for(int i=0; i<m; i++) {
    		randomMove();
    	}
        // END 
    }

    /**
     * Private method to generate a random move according to the rules of the situation.
     * That's to say, moves can be (+-1, 0) or (0, +-1).
     */
    private void randomMove() {
        boolean ns = random.nextBoolean();
        int step = random.nextBoolean() ? 1 : -1;
        move(ns ? step : 0, ns ? 0 : step);
    }

    /**
     * Method to compute the distance from the origin (the lamp-post where the drunkard starts) to his current position.
     *
     * @return the (Euclidean) distance from the origin to the current position.
     */
    public double distance() {
        // FIXME
    	double d = 0;
        double x2 = 0;
        double y2 = 0;
        x2 = Math.pow(x, 2);
        y2 = Math.pow(y, 2);
        d = Math.sqrt(x2+y2);
        // END
        return d;
    }

    /**
     * Perform multiple random walk experiments, returning the mean distance.
     *
     * @param m the number of steps for each experiment
     * @param n the number of experiments to run
     * @return the mean distance
     */
    public static double randomWalkMulti(int m, int n) {
        double totalDistance = 0;
        for (int i = 0; i < n; i++) {
            RandomWalk walk = new RandomWalk();
            walk.randomWalk(m);
            totalDistance = totalDistance + walk.distance();
        }
        return totalDistance / n;
    }

    public static void main(String[] args) {
//        if (args.length == 0)
//            throw new RuntimeException("Syntax: RandomWalk steps [experiments]");
//        int m = Integer.parseInt(args[0]);
//        int n = 30;

        int[] arrM = {35, 45, 62, 75, 83, 96, 124, 200, 225, 254};
        int[] arrN = {40, 50, 150, 200, 250, 300};

        int num = 0;

        for(int i=0; i<6; i++){
            int n = (int) Array.get(arrN, i);
            for(int j=0; j<10; j++){
                int m = (int) Array.get(arrM, j);
                double meanDistance = randomWalkMulti(m, n);
                num += 1;
                System.out.println("No." + num + ". " + m + " steps: " + meanDistance + " over " + n + " experiments");
            }
        }
    }

//        if (args.length > 1) n = Integer.parseInt(args[1]);

//    }

}
