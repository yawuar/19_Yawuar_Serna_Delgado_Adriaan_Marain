/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
package hellotvxlet;
 
import java.awt.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;
 
/**
 *
 * @author student
 */
public class MijnComponent extends HComponent {
 
    Image spaceship, sterren;
    int schipx = 360, stery = 0;
    
    public MijnComponent(int x, int y, int w, int h)
    {
        this.setBounds(x,y,w,h); // afmetingen van de component
        spaceship=this.getToolkit().getImage("spaceship.png");
        sterren=this.getToolkit().getImage("sterren.png");
        
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(spaceship, 1);
        mt.addImage(sterren, 2);
       
        try {
            mt.waitForAll();
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
    public void setSchipPos(int x) {
        schipx = x;
        this.repaint();
    }
   
    public void paint(Graphics g)
    {
        g.drawImage(sterren, 0, stery, this);
        g.drawImage(spaceship, schipx, 500, this);
        
//        g.drawLine(0,0,100,100); // x1,y1, x2,y2
//        g.drawLine(100,0,0,100);
//        g.setColor(new DVBColor(0,0,179,179));
//        g.fillRoundRect(10,10,200,100,15,15);
//        g.setColor(new DVBColor(0,0,255,179));
//        g.fillRoundRect(0,0,200,100,15,15);
//        g.setColor(Color.YELLOW);
//        g.drawString("Tekst", 40, 40);
    }
}