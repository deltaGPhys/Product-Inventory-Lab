package services;

import models.Whiskey;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class WhiskeyServiceTest {

    private WhiskeyService whiskeyService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        WhiskeyService.clear();
    }

    @Test
    public void createTest(){

        // (1)
        String expectedName = "Jack D";
        String expectedBrand = "Primo";
        float expectedVolume = 10.5f;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (2)
        WhiskeyService whiskeyService = new WhiskeyService();
        Whiskey testWhiskey = whiskeyService.create(expectedName, expectedBrand, expectedVolume, expectedQty, expectedPrice);

        // (3)
        int actualId = testWhiskey.getId();
        String actualName = testWhiskey.getName();
        String actualBrand = testWhiskey.getBrand();
        float actualVolume = testWhiskey.getVolume();
        int actualQty = testWhiskey.getQty();
        float actualPrice = testWhiskey.getPrice();

        // (4)
        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedVolume, actualVolume, .01);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedPrice, actualPrice, .01);
    }

    @Test
    public void findWhiskeyTest() {
        WhiskeyService whiskeyService2 = new WhiskeyService();
        whiskeyService2.create();
        whiskeyService2.create();

        whiskeyService2.create();
        whiskeyService2.create();
        whiskeyService2.create();
        whiskeyService2.create();

        Whiskey whiskey3 = whiskeyService2.findWhiskey(3);
        Whiskey whiskey5 = whiskeyService2.findWhiskey(5);

        Assert.assertEquals(whiskey3.getId(),3);
        Assert.assertEquals(whiskey5.getId(),5);
    }

    @Test
    public void findAllWhiskeyTest() {
        WhiskeyService whiskeyService = new WhiskeyService();
        Whiskey whiskey1 = whiskeyService.create();
        Whiskey whiskey2 = whiskeyService.create();
        Whiskey whiskey3 = whiskeyService.create();
        Whiskey whiskey4 = whiskeyService.create();
        Whiskey whiskey5 = whiskeyService.create();
        Whiskey whiskey6 = whiskeyService.create();

        Whiskey[] whiskeys = new Whiskey[] {whiskey1, whiskey2, whiskey3, whiskey4, whiskey5, whiskey6};

        Assert.assertEquals(whiskey3, whiskeyService.findWhiskey(3));
        Assert.assertEquals(whiskey5, whiskeyService.findWhiskey(5));
    }

    @Test
    public void removeWhiskeyTest() {
        WhiskeyService whiskeyService = new WhiskeyService();
        Whiskey whiskey1 = whiskeyService.create();
        Whiskey whiskey2 = whiskeyService.create();
        Whiskey whiskey3 = whiskeyService.create();
        Whiskey whiskey4 = whiskeyService.create();
        Whiskey whiskey5 = whiskeyService.create();
        Whiskey whiskey6 = whiskeyService.create();

        Whiskey[] whiskeys = new Whiskey[] {whiskey1, whiskey2, whiskey3, whiskey4, whiskey5, whiskey6};

        Assert.assertEquals(6, whiskeyService.findAll().length);
        Assert.assertNotNull(whiskeyService.findWhiskey(4));
        whiskeyService.delete(4);
        Assert.assertEquals(5, whiskeyService.findAll().length);
        Assert.assertNull(whiskeyService.findWhiskey(4));



    }
}