package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhiskeyTest {


    @Test
    public void setNameTest() {
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setName(expected);

        // then (3)
        Assertions.assertEquals(expected, testWhiskey.getName());
    }

    @Test
    public void setIdTest() {
        // given (1)
        int expected = 3;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setId(expected);

        // then (3)
        Assertions.assertEquals(expected, testWhiskey.getId());
    }

    @Test
    public void setBrandTest() {
        // given (1)
        String expected = "Neke";

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setBrand(expected);

        // then (3)
        Assertions.assertEquals(expected, testWhiskey.getBrand());
    }

    @Test
    public void setQtyTest() {
        // given (1)
        int expected = 7;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setQty(expected);

        // then (3)
        Assertions.assertEquals(expected, testWhiskey.getQty());
    }

    @Test
    public void setVolumeTest() {
        // given (1)
        float expected = 4.5f;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setVolume(expected);

        // then (3)
        Assertions.assertEquals(expected, testWhiskey.getVolume());
    }

    @Test
    public void setPriceTest() {
        // given (1)
        float expected = 56.99f;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setPrice(expected);

        // then (3)
        Assertions.assertEquals(expected, testWhiskey.getPrice());
    }

    @Test // (1)
    public void constructorTest(){

        // (2)
        int expectedId = 6;
        String expectedName = "Black Label";
        String expectedBrand = "Johnny Walker";
        float expectedVolume = 11.5f;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (3)
        Whiskey testWhiskey = new Whiskey(expectedId, expectedName, expectedBrand,
                 expectedVolume, expectedQty,expectedPrice);

        // (4)
        Assertions.assertEquals(expectedId, testWhiskey.getId());
        Assertions.assertEquals(expectedName, testWhiskey.getName());
        Assertions.assertEquals(expectedBrand, testWhiskey.getBrand());
        Assertions.assertEquals(expectedVolume, testWhiskey.getVolume());
        Assertions.assertEquals(expectedQty, testWhiskey.getQty());
        Assertions.assertEquals(expectedPrice, testWhiskey.getPrice());
    }

}