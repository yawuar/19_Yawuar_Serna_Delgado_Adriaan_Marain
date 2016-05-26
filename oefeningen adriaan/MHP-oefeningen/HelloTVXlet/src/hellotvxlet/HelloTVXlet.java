package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.*;
import org.havi.ui.event.HActionListener;

public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
    HTextButton button3 = new HTextButton("Ronald Reagan", 50, 510, 300, 50);
    HTextButton button2 = new HTextButton("Bill Clinton", 50, 440, 300, 50);
    HTextButton button1 = new HTextButton("George Washington", 50, 370, 300, 50);
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
        System.out.println("initXlet");
        scene = HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() {
                                                            // X,  Y ,  W ,  H
        HStaticText label1 = new HStaticText("Wie was de eerste President van de vs?", 50, 300, 620, 50);
        label1.setBackground(Color.BLACK);
        label1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        button1.setBackground(new DVBColor(255, 0, 0, 127));
        button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button1.setActionCommand("Button1click");
        button1.addHActionListener(this);
        
        button2.setBackground(new DVBColor(255, 0, 0, 127));
        button2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button2.setActionCommand("Button2click");
        button2.addHActionListener(this);
        
        button3.setBackground(new DVBColor(255, 0, 0, 127));
        button3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        button3.setActionCommand("Button3click");
        button3.addHActionListener(this);
        
        HTextButton btnHelp = new HTextButton("Hulplijn", 370, 200, 300, 50);
        btnHelp.setBackground(new DVBColor(0, 0, 255, 127));
        btnHelp.setBackgroundMode(HVisible.BACKGROUND_FILL);
        btnHelp.setActionCommand("btnHelpKlik");
        btnHelp.addHActionListener(this);
        
                                // UP ,  DOWN  , LEFT, RIGHT
        button1.setFocusTraversal(button3, button2, null, btnHelp);
        button2.setFocusTraversal(button1, button3, null, btnHelp);
        button3.setFocusTraversal(button2, button1, null, btnHelp);
        btnHelp.setFocusTraversal(button3, button1, button1, null);
        
        scene.add(button1);
        scene.add(button2);
        scene.add(button3);
        scene.add(btnHelp);
        scene.add(label1);
        scene.validate();
        scene.setVisible(true);
        button1.requestFocus();
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        if(event.getActionCommand().equals("btnHelpKlik")) {
            scene.remove(button2);
            scene.remove(button3);
            scene.repaint();
            return;
        }
        if (event.getActionCommand().equals("Button1click")) {
            HStaticText result = new HStaticText("goed!", 720/2-100, 100, 200, 100);
            result.setBackground(Color.GREEN);
            result.setBackgroundMode(HVisible.BACKGROUND_FILL);
            scene.add(result);
            scene.repaint();
        } else {
            HStaticText result = new HStaticText("fout!", 720/2-100, 100, 200, 100);
            result.setBackground(Color.RED);
            result.setBackgroundMode(HVisible.BACKGROUND_FILL);
            scene.add(result);
            scene.popToFront(result);
            scene.repaint();
        }
    }
}
