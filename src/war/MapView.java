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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AleGomes
 */
public class MapView {

    private Window window;
    private int indicePressed;
    private boolean pressed;
    private GameImage background;
    private GameImage shadow;

    List<Button> buttons = new ArrayList<Button>(); // Lista de botões

    private Keyboard keyboard;
    private Mouse mouse;

    public MapView(Window window) {
        this.window = window;
        this.shadow = new GameImage("data/gameplay/shadow.png");
        this.keyboard = window.getKeyboard();
        this.mouse = window.getMouse();
        
        try {
            File file = new File("data/pais_button.ini");
            Scanner reader = new Scanner(file);

            int max = reader.nextInt();
            for (int i = 0; i < max; i++) {
            buttons.add(new Button(reader.next(), reader.nextInt(), reader.nextInt(), this.mouse));

            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }

       
        
    }

    public void setBackground(String img) { // Muda o fundo do menu
        background = new GameImage(img);
    }

    public void run() {
        while (true) {
            this.draw();
            
            if(buttonPressed() != -1){
            pressed=true;
            }
            
            if (keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
                this.window.exit();
                
            }
        }
    }

    
    public int buttonPressed(){
    int indice = -1;
        for (int i = 0; i < buttons.size(); i++) {
            if (this.buttons.get(i).isButtonPressed()){
                this.indicePressed = i;
                indice = i;
                
                System.out.println("OLAAAAAAAAAAAAAA");
                return indice;
            }
            
        }
        
     return indice;
            
    }
    
    public void draw() {
        this.background.draw();  
        for( int i = 0; i < buttons.size() ; i++){
          buttons.get(i).draw();
        }
        
        if (this.pressed) {
            this.shadow.draw();
            System.out.println(indicePressed);
        }
       
           
   
        this.window.display();
    }

}
