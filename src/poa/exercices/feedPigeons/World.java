package poa.exercices.feedPigeons;

import poa.exercices.feedPigeons.utils.Case;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Bird> birdList;
    private List<Food> foodList;
    // size 10/10

    public World() {
        this.birdList = new ArrayList<Bird>();
        this.foodList = new ArrayList<Food>();
    }

    public void init() {
        System.out.println("Init game");
        this.addBird(new Bird(new Case(0, 0), this));
        this.addBird(new Bird(new Case(0, 2), this));
        this.addBird(new Bird(new Case(2, 0), this));
        this.addBird(new Bird(new Case(2, 3), this));
        this.addBird(new Bird(new Case(3, 5), this));
        this.addBird(new Bird(new Case(5, 3), this));
        this.addFood(new Food(new Case(9, 9)));
        this.addFood(new Food(new Case(4, 6)));
        this.addFood(new Food(new Case(9, 3)));
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
