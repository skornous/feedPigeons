package poa.exercices.feedPigeons;

import poa.exercices.feedPigeons.utils.Case;

public class Bird extends Entity {

    protected int stomachSize;
    protected int hunger;
    private boolean alive;
    private World world;

    public Bird(Case position, World w) {
        super(position);
        this.stomachSize = 10; // base stomach is 10
        this.hunger = 0; // basic hunger is none existent
        this.alive = true; // basic hunger is none existent
        this.world = w;
    }

    public void feed(Food f) {
        this.hunger -= f.getSize();
    }

    public void kill() {
        this.alive = false;
    }

    @Override
    public void run() {
        while(!this.isDead()) {
            System.out.println(this);
            this.doSomethingWithYourLife();

            try {
                this.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doSomethingWithYourLife() {
        //TODO look for nearby food
        Food nearestFood = this.seekForFood();
        if (nearestFood != null) {
            //TODO Move toward that food
            System.out.println("food nearby !");
            this.moveToward(nearestFood);
            if (nearestFood.getPosition().distanceTo(this.position) == 0) { // eat food if on it
                this.feed(nearestFood);
                System.out.println("===\nBird:"+this+" eat food "+nearestFood+"\n===");
                this.world.removeFood(nearestFood);
            }
        } else {
            //TODO No food ? Go to sleep
            try {
                this.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void moveToward(Food f) {
        this.position.moveTo(f.getPosition());
    }

    private Food seekForFood() {
        return this.world.nearestFood(this);
    }

    public boolean isDead() {
        return !this.alive;
    }

    @Override
    public String toString() {
        return "Bird{ID: " + this.getIdentifier() +  ",Case:" + this.getPosition() + "}";
    }

    public int getHunger() {
        return this.hunger;
    }
}
