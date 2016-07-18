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
    private GameImage Objetivo;
    private GameImage fundoPrasCartas;
    private GameImage[] cartas;
    //private Hud_Dialog menu_lateral = new Hud_Dialog();
    private GameImage shadow;
    private Sprite[] soldier;
    private boolean mostraObjetivo;
    private boolean mostraCartas;

    List<Button> buttons = new ArrayList<Button>(); // Lista de botões
    private Button objectiveButton;
    private Button cartasButton;
    private Button xButton;

    private Keyboard keyboard;
    private Mouse mouse;
    private boolean backgroundDrawn;
    private Sprite imagemDoJogador;

    public MapView(Window window) {
        this.window = window;
        controller = Controller.getInstance();
        this.shadow = new GameImage("data/gameplay/shadow.png");
        this.keyboard = window.getKeyboard();
        this.mouse = window.getMouse();
        backgroundDrawn = false;
        soldier = new Sprite[42];
        cartas = new GameImage[5];
        Objetivo=null;
        mostraObjetivo=false;
        mostraCartas=false;
        imagemDoJogador = new Sprite("data/gameplay/sprite soldados 100x100.png", 6);
        fundoPrasCartas = new GameImage("data/gameplay/fundo pras cartas.png");
        fundoPrasCartas.setPosition(800/2-fundoPrasCartas.width/2, 600/2-fundoPrasCartas.height/2);
        xButton = new Button("data/gameplay/Botao x.png", 800/2+fundoPrasCartas.width/2-40, 600/2-fundoPrasCartas.height/2, mouse);
        objectiveButton = new Button("data/gameplay/Botao Objetivo.png", 810, 540, this.mouse);
        cartasButton = new Button("data/gameplay/Botao Cartas.png", 910, 540, this.mouse);
        for(int i = 0; i<5; i++){
            cartas[i]=null;
        }
        
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
            objectiveButtonPressed();
            cardsButtonPressed();
            
            callHudDraw();
            
            objectiveButton.draw();
            cartasButton.draw();
            
            if(xButton.isButtonPressed()){
                mostraCartas=false;
                backgroundDrawn=false;
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
    public void objectiveButtonPressed(){
        if(objectiveButton.isButtonPressed()&&controller.getGameStarted()){
            objectiveButtonsActions();
        }
    }
    
    public void cardsButtonPressed(){
        if(cartasButton.isButtonPressed()&&controller.getGameStarted()){
            cartasButtonsActions();
        }
    }
    
    public void objectiveButtonsActions(){
        if(Objetivo==null){
            switch(controller.getPlayerById(0).getObjective().getMSG()){
                case "Conquistar na totalidade a ASIA e a ÁFRICA.":
                    Objetivo= new GameImage("data/gameplay/objectives0;4;3.png");
                    break;
                case "Conquistar na totalidade a ASIA e a AMÉRICA DO SUL.":
                    Objetivo= new GameImage("data/gameplay/objectives0;4;1.png");
                    break;
                case "Conquistar na totalidade a AMÉRICA DO NORTE e a ÁFRICA.":
                    Objetivo= new GameImage("data/gameplay/objectives0;0;3.png");
                    break;
                case "Conquistar na totalidade a AMÉRICA DO NORTE e a AUSTRÁLIA.":
                    Objetivo= new GameImage("data/gameplay/objectives0;0;5.png");
                    break;
                case "Conquistar na totalidade a EUROPA, a AMÉRICA DO SUL e mais um terceiro.":
                    Objetivo= new GameImage("data/gameplay/objectives1;2;1.png");
                    break;
                case "Conquistar na totalidade a EUROPA, a AUSTRÁLIA e mais um terceiro.":
                    Objetivo= new GameImage("data/gameplay/objectives1;2;5.png");
                    break;
                case "Conquistar 18 TERRITÓRIOS e ocupar cada um deles com pelo menos dois exércitos.":
                    Objetivo= new GameImage("data/gameplay/objectives2;18.png");
                    break;
                case "Conquistar 24 TERRITÓRIOS à sua escolha.":
                    Objetivo= new GameImage("data/gameplay/objectives2;24.png");
                    break;
                case "Destruir totalmente OS EXÉRCITOS AZUIS ou conquistar 18 territórios caso ele não esteja em jogo.":
                    Objetivo= new GameImage("data/gameplay/objectives03;AZUL.png");
                    break;
                case "Destruir totalmente OS EXÉRCITOS AMARELOS ou conquistar 18 territórios caso ele não esteja em jogo.":
                    Objetivo= new GameImage("data/gameplay/objectives3;AMARELO.png");
                    break;
                case "Destruir totalmente OS EXÉRCITOS VERMELHOS ou conquistar 18 territórios caso ele não esteja em jogo.":
                    Objetivo= new GameImage("data/gameplay/objectives3;VERMELHO.png");
                    break;
                case "Destruir totalmente OS EXÉRCITOS PRETOS ou conquistar 18 territórios caso ele não esteja em jogo.":
                    Objetivo= new GameImage("data/gameplay/objectives3;PRETO.png");
                    break;
                case "Destruir totalmente OS EXÉRCITOS ROXOS ou conquistar 18 territórios caso ele não esteja em jogo.":
                    Objetivo= new GameImage("data/gameplay/objectives3;ROXO.png");
                    break;
                case "Destruir totalmente OS EXÉRCITOS VERDES ou conquistar 18 territórios caso ele não esteja em jogo.":
                    Objetivo= new GameImage("data/gameplay/objectives3;VERDE.png");
                    break;
                default:
                    System.out.println("ERRO NA IMAGEM DA CARTA OBJETIVO: mensagem do objetivo nao existe no switch/case");     
            }
            Objetivo.setPosition(window.getWidth()/2-Objetivo.width/2, window.getHeight()/2-Objetivo.height/2);
        }
        mostraObjetivo=true;
    }
    
    
    public void callRound(){
        
        if (controller.getTerritory(indicePressed).getOwner().getId() == 0){
            if (controller.getState()==0){
                Distribuir_Dialog frame = new Distribuir_Dialog(this);            
                // Pais_Dialog frame = new Pais_Dialog(this);
                frame.setVisible(true);
                }


            else if (controller.getState()==1){
                    Atacar_Dialog frame = new Atacar_Dialog(this);            
                    // Pais_Dialog frame = new Pais_Dialog(this);
                    frame.setVisible(true);
                    }

            else if (controller.getState()==2){
                Mover_Dialog frame = new Mover_Dialog(this);            
                // Pais_Dialog frame = new Pais_Dialog(this);
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
        
        if(mouse.isLeftButtonPressed()&&mostraObjetivo){
            this.background.draw();
            mostraObjetivo=false;
        }
        if(mostraObjetivo)
            Objetivo.draw();
        desenhaSimboloDoJogador();
        
        
        if(mouse.isLeftButtonPressed()&&mostraCartas){
            mostraCartas=false;
            this.background.draw();
        }
        if(mostraCartas){
            fundoPrasCartas.draw();
            xButton.draw();
            //há implementar Cartas.draw();
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
            hud.draw();
            stageImage = new GameImage("data/gameplay/distribuição.png");
            stageImage.setPosition(900 - stageImage.width/2 , 20);
            stageImage.draw();
            window.drawText("Clique nos seus países", 830, 60, Color.black,Font.getFont("Verdana"));
            window.drawText("para distribuir tropas", 840, 80, Color.black,Font.getFont("Verdana"));

        }

        else { 
        
        } 
        
        if(controller.getState()==1){
            hud.draw();
            stageImage = new GameImage("data/gameplay/ataque.png");
            stageImage.setPosition(900 - stageImage.width/2 , 20);
            stageImage.draw();
            window.drawText("Clique nos seus países", 830, 60, Color.black,Font.getFont("Verdana"));
            window.drawText("para escolher seus alvos de ataque", 802, 80, Color.black,Font.getFont("Verdana"));
           
        }
        
        
        if(controller.getState()==2){
            hud.draw();
            stageImage = new GameImage("data/gameplay/Movimentação.png");
            stageImage.setPosition(900 - stageImage.width/2 , 20);
            stageImage.draw();
            window.drawText("Clique nos seus países", 830, 60, Color.black,Font.getFont("Verdana"));
            window.drawText("para movimentar suas tropas ", 815, 80, Color.black,Font.getFont("Verdana"));
            window.drawText("entre os territórios", 845, 100, Color.black,Font.getFont("Verdana"));
           
        }
 
                
                
    }
    
    private void desenhaSimboloDoJogador(){
        if(controller.getGameStarted()){
            //era pra ser getPlayerById(0)???
            switch(controller.getPlayerById(5).getColor()){
                    case "Amarelo":
                        imagemDoJogador.setCurrFrame(5);
                        break;
                    case "Azul":
                        imagemDoJogador.setCurrFrame(1);
                        break;
                    case "Roxo":
                        imagemDoJogador.setCurrFrame(3);
                        break;
                    case "Preto":
                        imagemDoJogador.setCurrFrame(0);
                        break;
                    case "Verde":
                        imagemDoJogador.setCurrFrame(2);
                        break;
                    case "Vermelho":
                        imagemDoJogador.setCurrFrame(4);
                        break;
                    default:
                }
            imagemDoJogador.setPosition(900-imagemDoJogador.width/2,300-imagemDoJogador.height/2);
            imagemDoJogador.draw();
        }
    }    

    private void cartasButtonsActions() {
        mostraCartas=true;
        //desenhaCartas();
    }
    
    private void desenhaCartas(){
        //fixme
        for (int i = 0; i < controller.getPlayerById(5).getCards().size(); i++) {
            String aux=null; 
            if(controller.getPlayerById(5).getCards().get(i)!=null)
                aux = controller.getPlayerById(5).getCards().get(i).getTerritory().getName();
            if(aux==null)
                cartas[i]=null;
            cartas[i]=new GameImage("/data/gameplay/"+aux+" Card.png");
        }
        for (int i = 0; i < 5; i++){
            if(cartas[i]!=null){
                cartas[i].setDimension(55, 90);
                cartas[i].setPosition(fundoPrasCartas.x+5*(i+1), fundoPrasCartas.y+5);
            }
        }
    }
}