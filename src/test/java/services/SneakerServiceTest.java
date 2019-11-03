package services;

import models.Sneaker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class SneakerServiceTest {

    private SneakerService sneakerService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        SneakerService.clear();
    }

    @Test
    public void createTest(){

        // (1)
        String expectedName = "Stan Smith";
        String expectedBrand = "Adidas";
        String expectedSport = "Tennis";
        float expectedSize = 10.5f;
        int expectedQty = 10;
        float expectedPrice = 80.00f;

        // (2)
        SneakerService sneakerService = new SneakerService();
        Sneaker testSneaker = sneakerService.create(expectedName, expectedBrand,
                expectedSport, expectedSize, expectedQty, expectedPrice);

        // (3)
        int actualId = testSneaker.getId();
        String actualName = testSneaker.getName();
        String actualBrand = testSneaker.getBrand();
        String actualSport = testSneaker.getSport();
        float actualSize = testSneaker.getSize();
        int actualQty = testSneaker.getQty();
        float actualPrice = testSneaker.getPrice();

        // (4)
        Assert.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedBrand, actualBrand);
        Assert.assertEquals(expectedSport, actualSport);
        Assert.assertEquals(expectedSize, actualSize, .01);
        Assert.assertEquals(expectedQty, actualQty);
        Assert.assertEquals(expectedPrice, actualPrice, .01);
    }

    @Test
    public void findSneakerTest() {
        SneakerService sneakerService2 = new SneakerService();
        sneakerService2.create();
        sneakerService2.create();

        sneakerService2.create();
        sneakerService2.create();
        sneakerService2.create();
        sneakerService2.create();

        Sneaker sneaker3 = sneakerService2.findSneaker(3);
        Sneaker sneaker5 = sneakerService2.findSneaker(5);

        Assert.assertEquals(sneaker3.getId(),3);
        Assert.assertEquals(sneaker5.getId(),5);
    }

    @Test
    public void findAllSneakerTest() {
        SneakerService sneakerService = new SneakerService();
        Sneaker sneaker1 = sneakerService.create();
        Sneaker sneaker2 = sneakerService.create();
        Sneaker sneaker3 = sneakerService.create();
        Sneaker sneaker4 = sneakerService.create();
        Sneaker sneaker5 = sneakerService.create();
        Sneaker sneaker6 = sneakerService.create();

        Sneaker[] sneakers = new Sneaker[] {sneaker1, sneaker2, sneaker3, sneaker4, sneaker5, sneaker6};

        Assert.assertEquals(sneaker3, sneakerService.findSneaker(3));
        Assert.assertEquals(sneaker5, sneakerService.findSneaker(5));
    }

    @Test
    public void removeSneakerTest() {
        SneakerService sneakerService = new SneakerService();
        Sneaker sneaker1 = sneakerService.create();
        Sneaker sneaker2 = sneakerService.create();
        Sneaker sneaker3 = sneakerService.create();
        Sneaker sneaker4 = sneakerService.create();
        Sneaker sneaker5 = sneakerService.create();
        Sneaker sneaker6 = sneakerService.create();

        Sneaker[] sneakers = new Sneaker[] {sneaker1, sneaker2, sneaker3, sneaker4, sneaker5, sneaker6};

        Assert.assertEquals(6, sneakerService.findAll().length);
        Assert.assertNotNull(sneakerService.findSneaker(4));
        sneakerService.delete(4);
        Assert.assertEquals(5, sneakerService.findAll().length);
        Assert.assertNull(sneakerService.findSneaker(4));



    }
}