package Misc.Items;
import entities.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class HealthKit {
    public Hitbox hitbox;
    private int x;
    private int y;
    private boolean pickedUp;
    //public Image image;

    public HealthKit(int x, int y) {
        this.x = x;
        this.y = y;
        pickedUp = false;

        Hitbox hitbox = new Hitbox(x, y, 25, 25);
    }

    public void pickUp(KeyEvent e, Hitbox box) {

        if (hitbox.isTouching(box)) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_F:
                    pickedUp = true;
                    break;
            }

        }
    }


}
