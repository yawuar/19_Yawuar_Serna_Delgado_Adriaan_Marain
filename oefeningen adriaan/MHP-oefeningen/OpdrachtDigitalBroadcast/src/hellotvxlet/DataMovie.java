/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.havi.ui.HGraphicButton;
import org.havi.ui.HScene;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author student
 */
public class DataMovie {

    public HScene sceneMovie;
    public String title, director, year, rating, genre, url;
    public HGraphicButton imgBtn;
    
    public void GetMovieInfo(int id) throws FileNotFoundException, org.json.simple.parser.ParseException, IOException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = (JSONArray) parser.parse(new FileReader("movies.json"));
        String newId = Integer.toString(id);
        
        for(int i = 0;i < jsonArr.size();i++ ) {
            JSONObject object = (JSONObject)jsonArr.get(i);
            
            String ides = (String) object.get("Id");
            //String title = (String) object.get("Title");
            
            if (newId.equals(ides)) {  
                //System.out.println(title);
                title = (String) object.get("Title");
                director = (String) object.get("Director");
                year = (String) object.get("Year");
                rating = (String) object.get("Rating");
                genre = (String) object.get("Genre");
                url = (String) object.get("Imageurl");
                
                System.out.println(title + director + year + rating + genre + url);
            }
        }
    }
}
