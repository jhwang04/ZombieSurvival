/*
Justin Hwang
5/29/2020
Rev: 03
Notes: Added functionality for secondary color when the button is hovered
       Added gray color for a disabled button
 */

package zombiesurvivalgame;

import java.awt.*;

public class Button {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color currentColor;
    private Color defaultColor;
    private Color secondaryColor;
    private boolean isHovered;
    private boolean isPressed;
    private boolean isEnabled;

    public Button(int x, int y, int w, int h, Color defaultColor, Color secondaryColor) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.defaultColor = defaultColor;
        this.secondaryColor = secondaryColor;
        this.currentColor = defaultColor;
        this.isHovered = false;
        this.isPressed = false;
        this.isEnabled = true;
    }

    public void draw(Graphics g) {
        currentColor = defaultColor;
        if(isHovered == true) {
            currentColor = secondaryColor;
        }
        if(isEnabled == false) {
            currentColor = Color.GRAY;
        }

        g.setColor(currentColor);
        if(isPressed == true) {
            g.fillRect(x + 20, y + 20, width - 40, height - 40);
        } else {
            g.fillRect(x, y, width, height);
        }
    }

    public boolean isTouchedBy(int mouseX, int mouseY) {
        if(mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getEnabled() {
        return isEnabled;
    }

    public void setHovered(boolean b) {
        isHovered = b;
    }

    public void setPressed(boolean b) {
        isPressed = b;
    }

    public void setEnabled(boolean b) {
        isEnabled = b;
    }
}
