package hellotvxlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HConfigurationException;
import org.havi.ui.HGraphicButton;
import org.havi.ui.HPermissionDeniedException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;
import org.json.simple.parser.ParseException;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener, HActionListener {

    HScene scene;
    HStillImageBackgroundConfiguration hsbic;
    DataMovie dm = new DataMovie();
    HBackgroundImage image1, image2, image3, image4;
    int imageteller = 0;
    int cursor;
    int imgAmount = 10;
    HGraphicButton[] btn = new HGraphicButton[imgAmount];
    HGraphicButton imgBtn;
    String[] imgArray = {"theshawshankredemption.jpg", "godfather1.jpg", "godfather2.jpg", "thedarkknight.jpg", "schindlerslist.jpg", "twelveangrymen.jpg", "pulpfiction.jpg", "lotrreturnoftheking.jpg", "ilbuonoilbrutto.jpg", "fightclub.jpg"};
    
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        setScene();
        addButtons();
    }
    
    public void setScene() {
        HScreen screen = HScreen.getDefaultHScreen();
        HBackgroundDevice hbackgroundev = screen.getDefaultHBackgroundDevice();
        hbackgroundev.reserveDevice(this);
        //configuratie:
        HBackgroundConfigTemplate hbct = new HBackgroundConfigTemplate();
        hbct.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        hsbic = (HStillImageBackgroundConfiguration) hbackgroundev.getBestConfiguration(hbct);
        
        // Image inladen
        image1 = new HBackgroundImage("backgroundPotatoes.m2v");
        image1.load(this);
        
        scene=HSceneFactory.getInstance().getDefaultHScene();
    }
   
    public void addButtons() {
        int counter = 0;
        for(int i = 0, ilen = imgArray.length; i < ilen; i++) {
            if (i == 5) counter = 0;
            if (i < 5) {
                btn[i] = new HGraphicButton(Toolkit.getDefaultToolkit().createImage(imgArray[i]), 50 + 120 * counter, 80, 105, 155);
                counter++;
            } else {
                btn[i] = new HGraphicButton(Toolkit.getDefaultToolkit().createImage(imgArray[i]), 50 + 120 * counter, 250, 105, 155);
                counter++;
            }
            btn[i].setVisible(true);
            btn[i].setResizeMode(2);
            btn[i].addHActionListener(this);
            btn[i].setActionCommand("num" + i);
            scene.add(btn[i]);
        }
        scene.validate(); scene.setVisible(true);
        
        btn[0].setFocusTraversal(btn[5], btn[5], btn[9], btn[1]);
        btn[9].setFocusTraversal(btn[4], btn[4], btn[8], btn[0]);
        btn[0].requestFocus();
        
        counter = 0;
        for(int i = 1; i < imgArray.length - 1; i++) {
            if (i == 5) counter = 0;
            if (i < 5) {
                btn[i].setFocusTraversal(btn[i+5], btn[i+5], btn[i-1], btn[i+1]);
                counter++;
            } else {
                btn[i].setFocusTraversal(btn[i-5], btn[i-5], btn[i-1], btn[i+1]);
                counter++;
            }
        }
    }
    
    public void loadMovieData(int movieIndex) throws FileNotFoundException, ParseException, IOException {
        HStaticText lblTitle, lblDirector, lblYear, lblRating, lblGenre, lblBack;
        dm.GetMovieInfo(movieIndex);
        
        lblBack = new HStaticText("Press Enter to go back to the overview", 50, 380, 400, 50);
        lblBack.setBackground(Color.WHITE);
        lblBack.setForeground(Color.BLACK);
        lblBack.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblBack.setHorizontalAlignment(HVisible.HALIGN_LEFT);
        Font fntBack = new Font("Arial", 0, 13);
        lblBack.setFont(fntBack);
        
        lblTitle = new HStaticText(dm.title, 280, 80, 400, 50);
        lblTitle.setBackground(Color.WHITE);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblTitle.setHorizontalAlignment(HVisible.HALIGN_LEFT);
        Font fntTitle = new Font("Arial", 0, 35);
        lblTitle.setFont(fntTitle);
        
        lblDirector = new HStaticText("Director: " + dm.director, 280, 130, 400, 50);
        lblDirector.setBackground(Color.WHITE);
        lblDirector.setForeground(Color.BLACK);
        lblDirector.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblDirector.setHorizontalAlignment(HVisible.HALIGN_LEFT);
        
        lblYear = new HStaticText("Year: " + dm.year, 280, 180, 400, 50);
        lblYear.setBackground(Color.WHITE);
        lblYear.setForeground(Color.BLACK);
        lblYear.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblYear.setHorizontalAlignment(HVisible.HALIGN_LEFT);
        
        lblRating = new HStaticText("Rating: " + dm.rating + "/10", 280, 230, 400, 50);
        lblRating.setBackground(Color.WHITE);
        lblRating.setForeground(Color.BLACK);
        lblRating.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblRating.setHorizontalAlignment(HVisible.HALIGN_LEFT);
        
        lblGenre = new HStaticText("Genre: " + dm.genre, 280, 280, 400, 50);
        lblGenre.setBackground(Color.WHITE);
        lblGenre.setForeground(Color.BLACK);
        lblGenre.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblGenre.setHorizontalAlignment(HVisible.HALIGN_LEFT);
        
        imgBtn = new HGraphicButton(Toolkit.getDefaultToolkit().createImage(dm.url), 50, 80, 210, 310);
        scene.add(imgBtn);
        scene.add(lblBack);
        scene.add(lblTitle);
        scene.add(lblDirector);
        scene.add(lblYear);
        scene.add(lblRating);
        scene.add(lblGenre);
        
        imgBtn.setActionCommand("imgButton");
        imgBtn.setResizeMode(2);
        imgBtn.requestFocus();
        imgBtn.addHActionListener(this);
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
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
    }

    public void actionPerformed(ActionEvent event) {
        scene.removeAll(); scene.validate(); scene.repaint();
        
        if(event.getActionCommand().equals("imgButton")) {
                addButtons();
            } else for(int i = 0, ilen = imgArray.length; i < ilen; i++) { 
            if(event.getActionCommand().equals("num" + i)) {
                try {
                    loadMovieData(i);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
