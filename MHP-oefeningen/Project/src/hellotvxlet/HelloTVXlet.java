package hellotvxlet;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.json.simple.*;

public class HelloTVXlet implements Xlet {

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        JSONObject obj = new JSONObject();
        obj.put("name", "Koen");
        System.out.print(obj);
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
    }
}
