package war;

import JPlay.GameImage;
import JPlay.Keyboard;
import JPlay.Mouse;
import JPlay.Window;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private Window window;

    private GameImage background;
    private GameImage hud;
    List<Button> buttons = new ArrayList<Button>(); // Lista de botões

    private Keyboard keyboard;
    private Mouse mouse;

    private int opc; // Representa a opção escolhida

    public Menu(Window window) {
        this.window = window;

        this.keyboard = window.getKeyboard();
        this.mouse = window.getMouse();
    }

    public int run() { // Inicia o menu
        opc = -1;

        loop();

        return opc;
    }

    public boolean addButton(String img, int x, int y) { // Adiciona um botão ao menu
        return buttons.add(new Button(img, x, y, mouse));
    }

    public void setBackground(String img) { // Muda o fundo do menu
        background = new GameImage(img);
        
    }

    
    private void loop() { // Loop lógico do menu
        while (opc < 0) {
            if (mouse.isLeftButtonPressed()) { // Verifica se o botão esquerdo do mouse foi pressionado
                for (int i = 0; i < buttons.size(); i++) // Verifica se o mouse estava sobre algum botão
                {
                    if (buttons.get(i).isMouseOn()) {
                        opc = i;
                    }
                }
            }

            if (keyboard.keyDown(Keyboard.ESCAPE_KEY)) {
                opc = buttons.size() - 1;
            }

            draw();
        }
    }

    private void draw() { // Desenha o menu
        this.background.draw();


        for (Button button : buttons) {
            // Desenha cada botão da lista
            button.draw();
        }

        this.window.display();
    }
}
