package com.hextrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RomanToNumberTest {
    @ParameterizedTest
    @CsvSource({
        "I,1",
        "II,2",
        "III,3",
        "IV,4",
        "V,5",
        "VI,6",
        "VII,7",
        "VIII,8",
        "IX,9",
        "X,10",
        "XI,11",
        "XII,12",
        "XIII,13",
        "XIV,14",
        "XV,15",
        "XVI,16",
        "XVII,17",
        "XVIII,18",
        "XIX,19",
        "XX,20",
        "XXI,21",
        "XXX,30",
        "XXXV,35",
        "XXXIX,39",
    })
    void romanToNumber(String roman, int expected) {
        Assertions.assertEquals(expected, Main.romanToNumber(roman));
    }
}