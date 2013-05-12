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
    private JLabel image = new JLabel();
    private String path = System.getProperty("user.dir");

    public Background(String imageName) {
        // Loads the background image and stores in img object.
        setImageName(imageName);
    }



    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
        image.setIcon(new ImageIcon(path + "\\images\\" + imageName));
        this.add(image);
        validate();
    }
    
}
