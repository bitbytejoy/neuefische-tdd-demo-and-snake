package com.hextrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void christmasTree_whenMinus1_thenStump() {
        int height = -1;
        String actual = Main.christmasTree(height);
        Assertions.assertEquals("I", actual);
    }

    @Test
    void christmasTree_when0_thenStump() {
        int height = 0;
        String actual = Main.christmasTree(height);
        Assertions.assertEquals("I", actual);
    }

    @Test
    void christmasTree_when1_thenHeight1() {
        int height = 1;
        String actual = Main.christmasTree(height);
        Assertions.assertEquals("X\nI", actual);
    }

    @Test
    void christmasTree_when2_thenHeight2() {
        int height = 2;
        String actual = Main.christmasTree(height);
        Assertions.assertEquals(" X\nXXX\n I", actual);
    }

    @Test
    void christmasTree_when3_thenHeight3() {
        int height = 3;
        String actual = Main.christmasTree(height);
        Assertions.assertEquals("  X\n XXX\nXXXXX\n  I", actual);
    }

    @Test
    void christmasTree_when4_thenHeight4() {
        int height = 4;
        String actual = Main.christmasTree(height);
        Assertions.assertEquals("   X\n  XXX\n XXXXX\nXXXXXXX\n   I", actual);
    }

    @Test
    void christmasTree_when5_thenHeight5() {
        int height = 5;
        String actual = Main.christmasTree(height);
        Assertions.assertEquals("    X\n   XXX\n  XXXXX\n XXXXXXX\nXXXXXXXXX\n    I", actual);
    }
}