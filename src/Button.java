/*
Justin Hwang
5/29/2020
Rev: 03
Notes: Added functionality for secondary color when the button is hovered
       Added gray color for a disabled button
 */

import java.awt.*;

public class Button {
    private int x; //x coordinate of the button
    private int y; // y coordinate of the button
    private int width; //width of the button
    private int height; //height of the button
    private Color currentColor; //whichever color the button is currently
    private Color defaultColor; //color the button is by default (not hovered)
    private Color secondaryColor; // color the button is when hoevered
    private boolean isHovered; // if the button is hovered
    private boolean isPressed; //if the button is pressed
    private boolean isEnabled; //if the button is enabled (clickable)

    //default constructor
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

    //draws the button
    public void draw(Graphics g) {
        currentColor = defaultColor;
        if(isHovered == true) {
            currentColor = secondaryColor;
        }
        if(isEnabled == false) {
            currentColor = Color.GRAY;
        }

        g.setColor(currentColor);
        if(isPressed == true && isEnabled == true) {
            g.fillRect(x + 20, y + 20, width - 40, height - 40);
        } else {
            g.fillRect(x, y, width, height);
        }
    }

    //if the button is touched by certain mouse coordinates
    public boolean isTouchedBy(int mouseX, int mouseY) {
        if(mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            return true;
        } else {
            return false;
        }
    }

    //gets if the button is enabled
    public boolean getEnabled() {
        return isEnabled;
    }

    //sets if the button is hovered
    public void setHovered(boolean b) {
        isHovered = b;
    }

    //sets if the button is pressed
    public void setPressed(boolean b) {
        isPressed = b;
    }

    //sets if the button is enabled
    public void setEnabled(boolean b) {
        isEnabled = b;
    }
}
