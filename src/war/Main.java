package war;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
            int width = 800;
            int height = 600;

            Game game = new Game(width, height);
            
        try {
            game.run();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
