package poa.exercices.feedPigeons;

import poa.exercices.feedPigeons.utils.Case;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Bird> birdList;
    private List<Food> foodList;
    // size 10/10

    public World() {
        this.birdList = new ArrayList<>();
        this.foodList = new ArrayList<>();
    }

    public void run() {
        //TODO start a world of pain and agony
        this.testWhat();
    }

    public void addBird(Bird b) {
        this.birdList.add(b);
    }

    public void addFood(Food f) {
        this.foodList.add(f);
    }

    public Food nearestFood(Entity e) {
        Food nearest = null;
        int minDist = Integer.MAX_VALUE;
        Case p = e.getPosition();

        for (Food f : foodList) {
            int distance = p.distanceTo(f.getPosition());
            if (distance < minDist) {
                nearest = f;
            }
        }

        return nearest;
    }

    public void testWhat() {
        Case initBirds = new Case(0, 0);
        this.addBird(new Bird(initBirds, this));
        this.addBird(new Bird(initBirds, this));
        this.addBird(new Bird(initBirds, this));
        this.addBird(new Bird(initBirds, this));
        this.addBird(new Bird(initBirds, this));
        this.addBird(new Bird(initBirds, this));
        this.addBird(new Bird(initBirds, this));
        this.addBird(new Bird(initBirds, this));
        this.addFood(new Food(new Case(2, 2)));
        this.addFood(new Food(new Case(1, 2)));
        this.addFood(new Food(new Case(1, 1)));
        this.addFood(new Food(new Case(2, 1)));
        try {
            System.out.println("---Start---");
            System.out.println(this.toString());
            System.out.println("---Initial State---");
            for (Bird b : birdList) {
                b.start();
            }
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            for (Bird b : birdList) {
                b.kill();
            }
            System.out.println("---Final State---");
            System.out.println(this.toString());
            System.out.println("---Stop---");
        }
    }

    public void removeFood(Food f) {
        this.foodList.remove(f);
    }

    @Override
    public String toString(){
        return "World{\n\tFoods: " + this.listF(this.foodList) + ",\n\tBirds: " + this.listB(this.birdList) + "\n}";
    }

    private String listB(List<Bird> objects) {
        String str = new String("[");
        for (Object o : objects) {
            str += o + ", ";
        }
        str += "]";
        return str;
    }

    private String listF(List<Food> objects) {
        String str = new String("[");
        for (Object o : objects) {
            str += o + ", ";
        }
        str += "]";
        return str;
    }

    public List<Bird> getBirdList() {
        return birdList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
