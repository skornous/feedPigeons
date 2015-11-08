import poa.exercices.feedPigeons.World;
import poa.exercices.feedPigeons.interfaces.UserInterface;

public class Main {
    public static void main(String[] args) {
        //TODO launch it
        World w = new World(new UserInterface());

        w.run();
//        UserInterface ui = new UserInterface(w);
    }
}
