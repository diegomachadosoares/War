package war;

import JPlay.Sprite;
import JPlay.Mouse;

public class Button {
    private Sprite image;
    private Mouse mouse;

    public Button(String img, int x, int y, Mouse mouse) {
        //O sprit tem dois frames: um quando o sprite estiver selecionado
        //e outro quando não estiver selecionado.
        
        image = new Sprite(img, 2);

        image.setPosition(x, y);

        this.mouse = mouse;
    }

    public void draw() {
        if(!mouse.isOverObject(image))
            image.setCurrFrame(0);
        else
            image.setCurrFrame(1);

        image.draw();
    }

    public boolean isMouseOn() {
        return mouse.isOverObject(image);
    }

    public Sprite getSprite() {
        return image;
    }
}
