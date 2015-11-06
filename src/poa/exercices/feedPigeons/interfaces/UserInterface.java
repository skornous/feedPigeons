package poa.exercices.feedPigeons.interfaces;

import poa.exercices.feedPigeons.Bird;
import poa.exercices.feedPigeons.Food;
import poa.exercices.feedPigeons.World;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserInterface extends JFrame {

    private JPanel panel;
    private World w;
    private java.util.List<EntityShape> shapes;

    public UserInterface(World world) {
        super();
        this.panel = new JPanel();
        this.w = world;
        this.shapes = new ArrayList<>();

//        this.panel.setBackground(Color.WHITE);
        this.setContentPane(this.panel);
        this.w.init();
        init();
        run();
    }

    private void init() {
        this.setTitle("Birds birds birds");
        this.setVisible(true);
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(Bird b : this.w.getBirdList()) {
            BirdShape birdShape = new BirdShape(new Point(b.getPosition().getX(), b.getPosition().getY()));
            b.registerShape(birdShape);
            this.shapes.add(birdShape);
        }

        for(Food f : this.w.getFoodList()) {
            FoodShape foodShape = new FoodShape(new Point(f.getPosition().getX(), f.getPosition().getY()));
            f.registerShape(foodShape);
            this.shapes.add(foodShape);
        }
    }

    public void run() {
        for (EntityShape es : this.shapes) {
            System.out.println("Entity created");
            System.out.println(es);
            es.repaint();
        }
        this.setSize(501, 501);
        this.setSize(500, 500);
    }
}
