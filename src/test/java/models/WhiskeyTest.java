package models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParameters;

@RunWith(JUnit4.class)
public class WhiskeyTest {


    @Test
    public void setNameTest() {
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setName(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getName());
    }

    @Test
    public void setIdTest() {
        // given (1)
        int expected = 3;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setId(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getId());
    }

    @Test
    public void setBrandTest() {
        // given (1)
        String expected = "Neke";

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setBrand(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getBrand());
    }

    @Test
    public void setQtyTest() {
        // given (1)
        int expected = 7;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setQty(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getQty());
    }

    @Test
    public void setVolumeTest() {
        // given (1)
        float expected = 4.5f;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setVolume(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getVolume(), .01);
    }

    @Test
    public void setPriceTest() {
        // given (1)
        float expected = 56.99f;

        // when (2)
        Whiskey testWhiskey = new Whiskey();
        testWhiskey.setPrice(expected);

        // then (3)
        Assert.assertEquals(expected, testWhiskey.getPrice(), .01);
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
        Assert.assertEquals(expectedId, testWhiskey.getId());
        Assert.assertEquals(expectedName, testWhiskey.getName());
        Assert.assertEquals(expectedBrand, testWhiskey.getBrand());
        Assert.assertEquals(expectedVolume, testWhiskey.getVolume(), .01);
        Assert.assertEquals(expectedQty, testWhiskey.getQty());
        Assert.assertEquals(expectedPrice, testWhiskey.getPrice(), .01);
    }

}