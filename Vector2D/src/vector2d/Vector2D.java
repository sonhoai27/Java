/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector2d;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;

/**
 *
 * @author sonho
 */
public class Vector2D extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    public Vector2D() {
        setTitle("Graphic");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        GeneralPath generalPath = new GeneralPath();
        
        generalPath.moveTo(50, 50);
        generalPath.lineTo(50, 100);
        generalPath.lineTo(200, 130);
        g2D.draw(generalPath);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Vector2D graphic = new Vector2D();
    }
    
}
