package poa.exercices.feedPigeons.interfaces;

import poa.exercices.feedPigeons.Bird;
import poa.exercices.feedPigeons.Food;
import poa.exercices.feedPigeons.World;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    private Drawing panel;
    private World w;

    public UserInterface(World world) {
        super();
        this.w = world;
        this.setSize(new Dimension(500, 500));
        this.panel = new Drawing(this);

        this.setContentPane(this.panel);
        this.w.init();
        init();
        run();
    }

    private void init() {
        this.setTitle("Birds birds birds");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(Bird b : this.w.getBirdList()) {
            BirdShape birdShape = new BirdShape(b.getGridPosition());
            b.registerShape(birdShape);
            this.panel.addShape(birdShape);
        }

        for(Food f : this.w.getFoodList()) {
            FoodShape foodShape = new FoodShape(f.getGridPosition());
            f.registerShape(foodShape);
            this.panel.addShape(foodShape);
        }
    }

    public void run() {
        this.panel.initShapes();
        this.panel.repaint();
        this.setSize(501, 501);
        this.setSize(500, 500);
    }
}
