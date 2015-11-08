package poa.exercices.feedPigeons;

import poa.exercices.feedPigeons.interfaces.UserInterface;
import poa.exercices.feedPigeons.utils.Case;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Bird> birdList;
    private List<Food> foodList;
    private UserInterface ui;
    // size 10/10

    public World(UserInterface ui) {
        this.birdList = new ArrayList<>();
        this.foodList = new ArrayList<>();
        this.ui = ui;

        this.init();
        this.ui.init(this);
        this.ui.run();
        this.run();
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
        System.out.println("---Start---");
        System.out.println(this.toString());
        System.out.println("---Initial State---");
        for (Bird b : birdList) {
            b.start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--- All birds are alive ---");
        //// TODO: 08/11/2015 make a variable from the while true
        while (true) {
            try {
                this.ui.reDraw();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        for (Bird b : birdList) {
//            b.kill();
//        }
//        System.out.println("---Final State---");
//        System.out.println(this.toString());
//        System.out.println("---Stop---");
    }

    public void removeFood(Food f) {
        this.ui.eatFood(f.getShape());
        this.foodList.remove(f);
    }

    @Override
    public String toString(){
        return "World{\n\tFoods: " + this.listF(this.foodList) + ",\n\tBirds: " + this.listB(this.birdList) + "\n}";
    }

    private String listB(List<Bird> objects) {
        String str = "[";
        for (Object o : objects) {
            str += o + ", ";
        }
        str += "]";
        return str;
    }

    private String listF(List<Food> objects) {
        String str = "[";
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
