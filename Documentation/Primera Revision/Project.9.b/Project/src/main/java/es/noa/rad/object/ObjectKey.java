package es.noa.rad.object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ObjectKey extends SuperObject {

  public ObjectKey() {
	super();	
    super.name = "Key";
    try {
      this.image = ImageIO.read(getClass().getResourceAsStream("/assets/entity/object/key.png"));
    } catch (IOException e) {
     e.printStackTrace();
    } 
  }

}
