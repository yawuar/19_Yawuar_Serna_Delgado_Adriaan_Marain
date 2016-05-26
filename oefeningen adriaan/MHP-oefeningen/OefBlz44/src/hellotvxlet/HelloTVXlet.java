package hellotvxlet;

import java.awt.event.KeyEvent;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.*;

public class HelloTVXlet implements Xlet, UserEventListener {
 
    MijnComponent mc = new MijnComponent(0,0,720,540);
    int sx = 350;
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }
 
    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
       
        
        //MijnComponent mc2 = new MijnComponent(250,400,100,100);
       
        scene.add(mc);
        //scene.add(mc2);
       
        scene.validate();
        scene.setVisible(true);
    }
 
    public void pauseXlet() {
    }
 
    public void startXlet() throws XletStateChangeException {
        UserEventRepository mijnRep = new UserEventRepository("naam");
        mijnRep.addAllArrowKeys();
        EventManager mijnMan = EventManager.getInstance();
        mijnMan.addUserEventListener(this, mijnRep); //implements eventlistener
        
        
    }

    public void userEventReceived(UserEvent e) {
        System.out.println(e.toString());
        if(e.getType()==KeyEvent.KEY_PRESSED)
        {
            if(e.getCode()==HRcEvent.VK_LEFT)
            {
                sx--; //bovenaant int sx=350;
                mc.setSchipPos(sx); //van mc een globale var 
            }
            if(e.getCode()==HRcEvent.VK_RIGHT)
            {
                sx++; //bovenaant int sx=350;
                mc.setSchipPos(sx); //van mc een globale var 
            }
        
        }
    }
   
   
}