/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Daniel
 */
public class Background extends JPanel {

    // The Image to store the background image in.
    private Image img;
    private String imageName;

    public Background(String imageName) {
        // Loads the background image and stores in img object.
        setImageName(imageName);
        this.setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, getSize().width, getSize().height, this);
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
        String path = System.getProperty("user.dir");
        img = Toolkit.getDefaultToolkit().createImage(path + "\\images\\" + imageName);
        painComponent(img);
    }
    
}
