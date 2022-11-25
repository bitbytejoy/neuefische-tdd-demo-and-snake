package com.hextrix;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int snakeX = 0;
    public static int snakeY = 0;

    public static int dirX = 1;
    public static int dirY = 0;

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',},
                new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',}
        };

        Thread newThread = new Thread(() -> {
            while (true) {
                for (char[] chars : grid) {
                    Arrays.fill(chars, ' ');
                }

                grid[snakeY][snakeX] = '*';

                snakeX += dirX;
                snakeX %= 29;
                snakeX = snakeX < 0 ? 29 : snakeX;

                snakeY += dirY;
                snakeY %= 19;
                snakeY = snakeY < 0 ? 19 : snakeY;

                System.out.println("dirX: " + dirX);
                System.out.println("dirY: " + dirY);
                System.out.println("To change direction type one of W A S D and press ENTER");
                System.out.println(render(grid));

                try {
                    Runtime.getRuntime().exec("clear");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                try {
                    Thread.sleep(1000/10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        newThread.start();

        while (true) {
            String ch = System.console() != null
                ? System.console().readLine()
                : "";

            if (ch.startsWith("w")) {
                dirX = 0;
                dirY = -1;
            } else if (ch.startsWith("a")) {
                dirX = -1;
                dirY = 0;
            } else if (ch.startsWith("s")) {
                dirX = 0;
                dirY = 1;
            } else if (ch.startsWith("d")) {
                dirX = 1;
                dirY = 0;
            }
        }
    }

    public static String render (char[][] grid) {
        StringBuilder frame = new StringBuilder();

        for (char[] row : grid) {
            for (char cell : row) {
                frame.append(cell);
            }

            frame.append("\n");
        }

        return frame.toString();
    }

    public static String christmasTree (int height) {
        StringBuilder tree = new StringBuilder();

        for (int i = 0; i < height; i++) {
            tree.append(" ".repeat(height - (i + 1)));
            tree.append("X".repeat(2 * i + 1));
            tree.append("\n");
        }

        if (height > 0) {
            tree.append(" ".repeat(height - 1));
        }

        tree.append("I");

        return tree.toString();
    }

    public static int romanToNumber (String roman) {
        if (roman.equals("IV")) {
            return 4;
        }

        if (roman.startsWith("V")) {
            return 5 + roman.substring(1).length();
        }

        if (roman.equals("IX")) {
            return 9;
        }

        if (roman.startsWith("X")) {
            int result = 10;

            String rest = roman.substring(1);
            if (!rest.isEmpty()) {
                result = result + romanToNumber(rest);
            }

            return result;
        }

        return roman.length();
    }
}