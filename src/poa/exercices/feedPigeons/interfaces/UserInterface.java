package poa.exercices.feedPigeons.interfaces;

import poa.exercices.feedPigeons.Bird;
import poa.exercices.feedPigeons.Food;
import poa.exercices.feedPigeons.World;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {

    private JPanel panel;
    private World w;

    public UserInterface(World world) {
        super();
        this.panel = new JPanel();
        this.w = world;

        this.add(this.panel);

        panel.setBackground(Color.WHITE);
        init();
    }

    private void init() {
        this.setTitle("Birds birds birds");
        this.setVisible(true);
        this.setSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(Bird b : this.w.getBirdList()) {
            b.registerShape(new BirdShape(new Point(b.getPosition().getX(), b.getPosition().getY())));
        }

        for(Food f : this.w.getFoodList()) {
            f.registerShape(new FoodShape(new Point(f.getPosition().getX(), f.getPosition().getY())));
        }
    }

    public void run() {
        this.w.run();
    }
}
