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
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void doSomethingWithYourLife() {
        //look for nearby food
        Food nearestFood = this.seekForFood();
        if (nearestFood != null) {
            //Move toward that food
            System.out.println("food nearby !");
            this.moveToward(nearestFood);
            if (nearestFood.getPosition().distanceTo(this.position) == 0) { // eat food if on it
                this.feed(nearestFood);
                System.out.println("===\nBird:"+this+" eat food "+nearestFood+"\n===");
                this.world.removeFood(nearestFood);
            }
        } else {
            //No food ? Go to sleep
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void moveToward(Food f) {
        this.position.moveTo(f.getPosition());
        this.shape.move(this.getGridPosition());
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

    public void flee() {
        int x = (int) (Math.random() * (worldSize - 50)),
                y = (int) (Math.random() * (worldSize - 50));
        this.setPosition(new Case(x, y));
        this.shape.move(this.getGridPosition());
    }
}
