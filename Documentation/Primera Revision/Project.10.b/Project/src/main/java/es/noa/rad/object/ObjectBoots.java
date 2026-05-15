package es.noa.rad.object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ObjectBoots extends SuperObject {

  public ObjectBoots() {
    super();	  
    super.name = "Boots";	  
    try {
      this.image = ImageIO.read(getClass().getResourceAsStream("/assets/entity/object/boots.png"));
    } catch (IOException e) {
     e.printStackTrace();
    } 
  }

}
