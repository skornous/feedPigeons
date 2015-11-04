package poa.tests.feedPigeons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import poa.exercices.feedPigeons.Bird;
import poa.exercices.feedPigeons.Food;
import poa.exercices.feedPigeons.World;
import poa.exercices.feedPigeons.utils.Case;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BirdSpecs {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() { // set stream catchers
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() { // clean streams
        System.setOut(null);
    }

    @Test
    public void birdIsAlive() {
        World w = new World();
        Bird b = new Bird(new Case(0, 0), w);

        b.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            b.kill();
            Assert.assertNotEquals(null, this.outContent);
        }
    }

    @Test
    public void birdCanEat() {
        World w = new World();
        Bird b = new Bird(new Case(0, 0), w);

        b.start();
        b.feed(new Food(new Case(0, 0)));
        b.kill();

        Assert.assertEquals(b.getHunger(), -1);
    }
}