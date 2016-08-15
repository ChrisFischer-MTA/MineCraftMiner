package javaapplication12;
//-10004943

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Scanner;

// Christopher Fischer
public class JavaApplication12 {

    static Robot sonny;
    static Scanner stdin = new Scanner(System.in);
    /*
    Stone - 131
    Iron  - 250
     */
    static int dur;
    int tempDur;
    static int crossx;
    static int crossy;
    final static int array[] = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58};
    static Rectangle screenRect;

    public static void createRobot() {
        try {
            sonny = new Robot();
            screenRect = new Rectangle(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        createRobot();
        System.out.println("1. Miner (death, dumb, and blind)");
        System.out.println("2. Wood Cutter (Spruce)");
        int c = stdin.nextInt();

        switch (c) {
            case 1:
                miner();
                break;
            case 2:
                woodFinder();
                break;
            default:

            // Jump
            // Place
            // Mine
            // Woodcutter job as we know it
        }
    }

    public static int[] woodFinder() {
        BufferedImage Screen = getScreen();
        int x = 0;
        int y = 0;
        for (int i = 0; i < Screen.getWidth(); i++) {
            for (int j = 0; j < Screen.getHeight(); j++) {
                if (Screen.getRGB(i, j) == -10004943) {
                    //We have a hittable area.
                    x = i;
                    y = j;
                    System.out.println(x + "_" + y);
                    break;
                }
            }
            if (x != 0 && y != 0) {
                break;
            }
        }
        if (x == 0 && y == 0) {
            return null;
        }
        int[] array = {x, y};

        return array;
    }

    public static void woodCutter() {
        // Woodfinder returns the X&Y of wood;
        // I now need to add in logic to move the mouse cruise in the direction of said wood;
        // Then mine;
        // Then find again;
        // Until it cant.
    }

    public static BufferedImage getScreen() {
        return sonny.createScreenCapture(screenRect);
    }

    public static void miner() {
        System.out.println("How many picks do you have?");
        int d = stdin.nextInt();
        System.out.println("What is highest durability of any pick in your hotbar?");
        dur = stdin.nextInt();
        System.out.println("Whats your current dur?");
        int tempdur = stdin.nextInt();
        if (d > 9) {
            d = 9;
        }
        for (int i = 1; i <= d; i++) {
            try {
                Thread.sleep(1000);
                sonny.keyPress(array[i]);
                sonny.keyRelease(array[i]);
            } catch (Exception e) {
                //
            }
            if (i == 1) {
                for (int j = 0; j < tempdur; j++) {
                    mineBlock();
                }
            } else {
                for (int j = 0; j < dur; j++) {
                    mineBlock();
                }
            }
        }
    }

    public static void mineBlock() {
        try {
            Thread.sleep(1000);
            sonny.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(1500);
            sonny.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
