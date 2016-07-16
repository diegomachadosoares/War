/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import JPlay.GameImage;
import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Sprite;
import JPlay.Window;
import java.awt.Color;
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
    private GameImage hud;
    //private Hud_Dialog menu_lateral = new Hud_Dialog();
    private GameImage shadow;
    private Sprite[] soldier;

    List<Button> buttons = new ArrayList<Button>(); // Lista de botões

    private Keyboard keyboard;
    private Mouse mouse;
    private boolean backgroundDrawn;

    public MapView(Window window) {
        this.window = window;
        this.shadow = new GameImage("data/gameplay/shadow.png");
        this.keyboard = window.getKeyboard();
        this.mouse = window.getMouse();
        backgroundDrawn = false;
        soldier = new Sprite[42];
        
        try {
            File file = new File("data/pais_button.ini");
            Scanner reader = new Scanner(file);

            int max = reader.nextInt();
            for (int i = 0; i < max; i++) {
                buttons.add(new Button(reader.next(), reader.nextInt(), reader.nextInt(), this.mouse));
                soldier[i] = new Sprite("data/gameplay/sprite soldados 20x20.png", 6);
                soldier[i].setPosition(1000,1000);  //para os soldados nao serem printados 
                                                    //na tela antes do jogo começar
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }

        //menu_lateral.setVisible(true);
        
    }

    public void setBackground(String img) { // Muda o fundo do menu
        background = new GameImage(img);
    }
    
        public void setHud(String img, int x, int y) { // Muda o fundo do hud
        hud = new GameImage(img);
        hud.setPosition(x, y);
    }

    public void run() {
        while (true) {
            this.draw();
            if(Controller.getInstance().getGameStarted())
                escreveNumeros();
            
            if(buttonPressed() != -1){
            
            pressed=true;
            Pais_Dialog frame = new Pais_Dialog(this);
            frame.setVisible(true);
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
                
                return indice;
            }
            
        }
        
     return indice;
            
    }
    
    public void draw() {
        if(!backgroundDrawn){
            this.background.draw();
            backgroundDrawn=true;
        }
        this.hud.draw();
        for( int i = 0; i < buttons.size() ; i++){
          buttons.get(i).draw();
        }
        
        if (this.pressed) {
            //this.shadow.draw();


        }
        
        for(int i=0; i<42; i++){
            soldier[i].draw();
        }
       
           
   
        this.window.display();
    }
    
    public void setPressed(boolean x){
    this.pressed=x;
    }

    public int getIndice(){
    return indicePressed;
    }
    
    public void escreveNumeros(){
        Controller controller = Controller.getInstance();
        try {
            File file = new File("data/pais_button.ini");
            Scanner reader = new Scanner(file);

            int max = reader.nextInt();
            for (int i = 0; i < max; i++) {
                reader.next();
                Territory territory = controller.getTerritory(i);
                Player player = territory.getOwner();
                String quantidade = Integer.toString(territory.getTroops());
                int posX = reader.nextInt()+buttons.get(i).getSprite().width/2; 
                int posY = (int)(reader.nextInt()+buttons.get(i).getSprite().height*1.5);
                soldier[i].setPosition(posX-soldier[i].width, posY-buttons.get(i).getSprite().height*0.5);
                
                switch(player.getColor()){
                    case "Amarelo":
                        window.drawText(quantidade, posX, posY, Color.BLACK);
                        soldier[i].setCurrFrame(5);
                        break;
                    case "Azul":
                        window.drawText(quantidade, posX, posY, Color.BLACK);
                        soldier[i].setCurrFrame(1);
                        break;
                    case "Roxo":
                        window.drawText(quantidade, posX, posY, Color.BLACK);
                        soldier[i].setCurrFrame(3);
                        break;
                    case "Preto":
                        window.drawText(quantidade, posX, posY, Color.BLACK);
                        soldier[i].setCurrFrame(0);
                        break;
                    case "Verde":
                        window.drawText(quantidade, posX, posY, Color.BLACK);
                        soldier[i].setCurrFrame(2);
                        break;
                    case "Vermelho":
                        window.drawText(quantidade, posX, posY, Color.BLACK);
                        soldier[i].setCurrFrame(4);
                        break;
                    default:
                }
                

            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
}