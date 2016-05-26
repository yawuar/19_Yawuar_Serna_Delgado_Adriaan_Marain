package hellotvxlet;

import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.bluray.ui.event.HRcEvent;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HConfigurationException;
import org.havi.ui.HPermissionDeniedException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;


public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {

    HStillImageBackgroundConfiguration hsbic;
    HBackgroundImage image1, image2, image3, image4;
    int imageteller = 0;
    int cursor;
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScreen screen = HScreen.getDefaultHScreen();
        HBackgroundDevice hbackgroundev = screen.getDefaultHBackgroundDevice();
        boolean gereserveerd = hbackgroundev.reserveDevice(this);
        if(gereserveerd) {
            System.out.println("backgrounddev gereserveerd");
        }
        
        //configuratie:
        HBackgroundConfigTemplate hbct = new HBackgroundConfigTemplate();
        hbct.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        hsbic = (HStillImageBackgroundConfiguration) hbackgroundev.getBestConfiguration(hbct);
        
        // Image inladen
        image1 = new HBackgroundImage("pizza1.m2v");
        image2 = new HBackgroundImage("pizza2.m2v");
        image3 = new HBackgroundImage("pizza3.m2v");
        image4 = new HBackgroundImage("pizza4.m2v");
        image1.load(this);
        image2.load(this);
        image3.load(this);
        image4.load(this);
        
        // Maak een UserEvent
        UserEventRepository rep = new UserEventRepository("naam");
        // voeg daar allArrowKeys aan toe
        rep.addKey(HRcEvent.VK_UP);
        rep.addKey(HRcEvent.VK_DOWN);
        rep.addKey(HRcEvent.VK_RIGHT);
        rep.addKey(HRcEvent.VK_LEFT);
        // vraag een link naar EventManager op met .getInstance()
        EventManager man = EventManager.getInstance();
        // registreer de UserEventRepository op de EventManager met
        // addUserEventListener
        man.addUserEventListener(this, rep);
        // Implementeer de interface UserEventlistener op deze Xlet
        // Vang de events op in UserEventReceived
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
        String lijst = "orderlijst:\n";
        HScene scene = HSceneFactory.getInstance().getDefaultHScene();
        HStaticText hst = new HStaticText(lijst, 400, 50, 300, 300);
        hst.setVerticalAlignment(hst.VALIGN_TOP);
        hst.setHorizontalAlignment(hst.HALIGN_LEFT);
        // om tekst toe te voegen (in UserEventReceiced)
        hst.setTextContent(lijst + "regel11\n", hst.NORMAL_STATE);
        
        scene.add(hst);
        scene.validate();
        scene.setVisible(true);
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        imageteller++;
        if(imageteller == 4) System.out.println("image geladen");
        try {
            hsbic.displayImage(image1);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (HPermissionDeniedException ex) {
            ex.printStackTrace();
        } catch (HConfigurationException ex) {
            ex.printStackTrace();
        }
        
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED) {
            System.out.println("Pushed Button");
            switch( e.getCode() ) {
                case HRcEvent.VK_UP:
                    System.out.println("VK_UP is PRESSED");
                break;
                
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN is PRESSED");
                break;
                
                case HRcEvent.VK_LEFT:
                    cursor--;
                    if(cursor < 1) cursor = 4;
                    System.out.println("VK_LEFT is PRESSED");
                break;
                
                case HRcEvent.VK_RIGHT:
                    cursor++;
                    if(cursor > 4) cursor = 1;
                    System.out.println("VK_RIGHT is PRESSED");
                break;
            }
            
            try {
                if(imageteller == 4) {
                    if(cursor == 1) hsbic.displayImage(image1);
                    if(cursor == 2) hsbic.displayImage(image2);
                    if(cursor == 3) hsbic.displayImage(image3);
                    if(cursor == 4) hsbic.displayImage(image4);
                }
            } catch (HPermissionDeniedException ex) {
                ex.printStackTrace();
            } catch (HConfigurationException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
