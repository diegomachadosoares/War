/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import JPlay.GameImage;
import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Window;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AleGomes
 */
public class Tabuleiro {

    private Window window;

    private GameImage background;

    List<Button> buttons = new ArrayList<Button>(); // Lista de botões

    private Keyboard keyboard;
    private Mouse mouse;

    public Tabuleiro(Window window) {
        this.window = window;

        this.keyboard = window.getKeyboard();
        this.mouse = window.getMouse();
    }

    public void setBackground(String img) { // Muda o fundo do menu
        background = new GameImage(img);
    }

    public void run() {
        while (true) {
            this.draw();
            
            if (keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
                this.window.exit();
            }
        }
    }

    public void draw() {
        this.background.draw();

        this.window.display();
    }

}
