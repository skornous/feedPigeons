package poa.exercices.feedPigeons;

import poa.exercices.feedPigeons.interfaces.UserInterface;
import poa.exercices.feedPigeons.utils.Case;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Bird> birdList;
    private List<Food> foodList;
    private UserInterface ui;
    private boolean running;
    // size 10/10

    public World(UserInterface ui) {
        this.birdList = new ArrayList<>();
        this.foodList = new ArrayList<>();
        this.ui = ui;
        this.running = true;

        this.init();
        this.ui.init(this);
        this.ui.run();
        this.run();
    }

    public void init() {
        System.out.println("Init game");
        this.addBird(new Bird(new Case(150, 0), this));
        this.addBird(new Bird(new Case(0, 200), this));
        this.addBird(new Bird(new Case(490, 0), this));
        this.addBird(new Bird(new Case(250, 350), this));
        this.addBird(new Bird(new Case(360, 500), this));
        this.addBird(new Bird(new Case(490, 300), this));
        this.addFood(new Food(new Case(450, 450)));
        this.addFood(new Food(new Case(400, 650)));
        this.addFood(new Food(new Case(410, 3)));
    }

    public void run() {
        //start a world of pain and agony
        System.out.println("---Start---");
        System.out.println(this.toString());
        System.out.println("---Initial State---");
        for (Bird b : birdList) {
            b.start();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--- All birds are alive ---");
        while (this.running) {
            try {
                this.ui.reDraw();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        birdList.forEach(bird -> bird.kill()); // kill all bird to clean up memory
        System.out.println("---Final State---");
        System.out.println(this.toString());
        System.out.println("---Stop---");

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
