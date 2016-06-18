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
public class MapView {

    private Window window;

    private GameImage background;

    List<Button> buttons = new ArrayList<Button>(); // Lista de botões

    private Keyboard keyboard;
    private Mouse mouse;

    public MapView(Window window) {
        this.window = window;

        this.keyboard = window.getKeyboard();
        this.mouse = window.getMouse();
        buttons.add(new Button("data/gameplay/BRASIL2.png",200,400,this.mouse));
        buttons.add(new Button("data/gameplay/PERU.png",130,400,this.mouse));
        buttons.add(new Button("data/gameplay/ARGENTINA.png",130,460,this.mouse));
        buttons.add(new Button("data/gameplay/VENEZUELA.png",135,320,this.mouse));
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
