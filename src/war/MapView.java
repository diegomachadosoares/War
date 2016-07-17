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
import java.awt.Font;
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
    private Controller controller;
    private int indicePressed;
    private boolean pressed;
    private GameImage background;
    private GameImage hud;
    private GameImage stageImage;
    //private Hud_Dialog menu_lateral = new Hud_Dialog();
    private GameImage shadow;
    private Sprite[] soldier;

    List<Button> buttons = new ArrayList<Button>(); // Lista de botões

    private Keyboard keyboard;
    private Mouse mouse;
    private boolean backgroundDrawn;

    public MapView(Window window) {
        this.window = window;
        controller = Controller.getInstance();
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
            
            if( buttonPressed() != -1  ){           
                pressed=true;           
                callRound();
            }
            
            callHudDraw();

            
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
    
    
    public void callRound(){
    if (controller.getTerritory(indicePressed).getOwner().getId() == 0){
        if (controller.getState()==0){
            Distribuir_Dialog frame = new Distribuir_Dialog(this);            
            // Pais_Dialog frame = new Pais_Dialog(this);
            frame.setVisible(true);
            }
        
        if (controller.getState()==1){
            Atacar_Dialog frame = new Atacar_Dialog(this);            
            frame.setVisible(true);
            }
    }
    }
    
    public void draw() {
        if(!backgroundDrawn){
            this.background.draw();
            backgroundDrawn=true;
            this.hud.draw();
        }

        for( int i = 0; i < buttons.size() ; i++){
          buttons.get(i).draw();
        }
        
        if (this.pressed) {
            //this.shadow.draw();


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
                //soldier[i].setPosition(posX-soldier[i].width, posY-buttons.get(i).getSprite().height*0.5);
                soldier[i].setPosition(posX-soldier[i].width/4, posY-buttons.get(i).getSprite().height*0.5);
                
                switch(player.getColor()){
                    case "Amarelo":
                        soldier[i].setCurrFrame(5);
                        soldier[i].draw();
                        window.drawText(quantidade, posX, posY+soldier[i].height/3, Color.BLACK);
                        break;
                    case "Azul":
                        soldier[i].setCurrFrame(1);
                        soldier[i].draw();
                        window.drawText(quantidade, posX, posY+soldier[i].height/3, Color.BLACK);
                        break;
                    case "Roxo":
                        soldier[i].setCurrFrame(3);
                        soldier[i].draw();
                        window.drawText(quantidade, posX, posY+soldier[i].height/3, Color.BLACK);
                        break;
                    case "Preto":
                        soldier[i].setCurrFrame(0);
                        soldier[i].draw();
                        window.drawText(quantidade, posX, posY+soldier[i].height/3, Color.BLACK);
                        break;
                    case "Verde":
                        soldier[i].setCurrFrame(2);
                        soldier[i].draw();
                        window.drawText(quantidade, posX, posY+soldier[i].height/3, Color.BLACK);
                        break;
                    case "Vermelho":
                        soldier[i].setCurrFrame(4);
                        soldier[i].draw();
                        window.drawText(quantidade, posX, posY+soldier[i].height/3, Color.BLACK);
                        break;
                    default:
                }
                

            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }

    private void callHudDraw() {
        if(controller.getState()==0){
            stageImage = new GameImage("data/gameplay/distribuição.png");
            stageImage.setPosition(900 - stageImage.width/2 , 20);
            stageImage.draw();
            window.drawText("Clique nos seus países", 830, 60, Color.black,Font.getFont("Verdana"));
            window.drawText("para distribuir tropas", 840, 80, Color.black,Font.getFont("Verdana"));

        }

        else { hud.draw();
        
        } 
        
        if(controller.getState()==1){
            stageImage = new GameImage("data/gameplay/ataque.png");
            stageImage.setPosition(900 - stageImage.width/2 , 20);
            stageImage.draw();
            window.drawText("NÃO IMPLEMENTADO AINDA", 830, 60, Color.black,Font.getFont("Verdana"));
            
        }
    }
        
}