package poa.exercices.feedPigeons.interfaces;

import poa.exercices.feedPigeons.Bird;
import poa.exercices.feedPigeons.Food;
import poa.exercices.feedPigeons.World;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    private Drawing panel;

    public UserInterface() {
        super();
        this.setSize(new Dimension(500, 500));
    }

    public void init(World w) {
        this.setTitle("Birds birds birds");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new Drawing(this, w);
        this.setContentPane(this.panel);

        for (Bird b : w.getBirdList()) {
            BirdShape birdShape = new BirdShape(b.getGridPosition());
            b.registerShape(birdShape);
            this.panel.addShape(birdShape);
        }

        for (Food f : w.getFoodList()) {
            FoodShape foodShape = new FoodShape(f.getGridPosition());
            f.registerShape(foodShape);
            this.panel.addShape(foodShape);
        }
    }

    public void run() {
        this.panel.initShapes();
        this.panel.repaint();
    }

    public void reDraw() {
        this.panel.repaint();
    }

    public void eatFood(EntityShape food) {
        this.panel.removeShape(food);
    }
}
