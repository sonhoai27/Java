/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arlert;

/**
 *
 * @author Rơm
 */
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
public class SpriteMapManipulator {
    //input thư mục chứa những sprite ban đầu, output là nơi chứa spritemap
    public static void join(String inputPath,String outputPath) throws IOException{
        //Mở thư mục, tham chiếu directory dữ thư mục
        File directory= new File(inputPath);
        //
        File[] files=directory.listFiles();
        //đọc thư mục đầu tiên
        BufferedImage sprite= ImageIO.read(files[0]);
        int with=sprite.getWidth()*files.length;
        int height=sprite.getHeight();
        //xây dựng spritemap(1 map gồm nhiều sprite) bằng buffered (mỗi tấm ảnh là 1 sprite)
        BufferedImage spritemap=new BufferedImage(with, height,BufferedImage.TYPE_INT_ARGB);
       Graphics2D g2d=spritemap.createGraphics();
       int x=0;//vị trí bắt đầu của sprite tiếp theo
       for(File file:files){
           //tải sprite lên
           sprite=ImageIO.read(file);
           //vẽ sprite lên spritemap
           g2d.drawImage(sprite, null, x,0);
           x+=sprite.getWidth();
       }
       //ghi spritemap ra ổ cứng
       ImageIO.write(sprite, "png", new File(outputPath));
    }
    public static void main(String[] args) {
        try{
            SpriteMapManipulator.join(args[0], args[1]);
        }catch(IOException ex){
            System.err.println(ex);}
        
    }
    
    
}
