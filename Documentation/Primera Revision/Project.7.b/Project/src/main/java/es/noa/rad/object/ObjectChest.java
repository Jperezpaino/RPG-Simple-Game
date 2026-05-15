package es.noa.rad.object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ObjectChest extends SuperObject {

  public ObjectChest() {
    super.name = "Chest";	  
    try {
      this.image = ImageIO.read(getClass().getResourceAsStream("/assets/entity/object/chest.png"));
    } catch (IOException e) {
     e.printStackTrace();
    } 
  }

}
