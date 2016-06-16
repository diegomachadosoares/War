package war;

import JPlay.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Game {

    private Window window; // Janela do jogo
    private Menu menu;

    public Game(int winWidth, int winHeight) {
        this.window = new Window(winWidth, winHeight);
        this.window.getKeyboard().setBehavior(Keyboard.SPACE_KEY, Keyboard.DETECT_EVERY_PRESS);

        constructMenu(this.window);
    }

    public void run() throws FileNotFoundException, IOException { // Quando chamado inicia o jogo
        loop();

        window.exit();
    }

    public void loop() throws FileNotFoundException, IOException { // Loop primário do jogo, gerencia escolhas de menu
        int index = -1;

        while (index != 0) {
            index = menu.run();
            if (index == 0){
                runGameplay();
            }else{
                if(index == 1){
                    window.exit();
                }
            }
        }
    }

    private void runGameplay() throws FileNotFoundException, IOException {
        
        //Mostrar mapa
        Map tabuleiro = new Map(window);
        tabuleiro.setBackground("data/gameplay/mapa-mundi.png");
        tabuleiro.run();
    }

    private void constructMenu(Window window) { // Configura o menu
        try {
            menu = new Menu(window);

            File file = new File("data/menu/config.ini");
            Scanner reader = new Scanner(file);

            menu.setBackground(reader.next());

            int max = reader.nextInt();
            for (int i = 0; i < max; i++) {
                menu.addButton(reader.next(), reader.nextInt(), reader.nextInt());
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
}
