package es.noa.rad.object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ObjectDoor extends SuperObject {

  public ObjectDoor() {
	super();
    super.name = "Door";
    this.collision = true;
    try {
      this.image = ImageIO.read(getClass().getResourceAsStream("/assets/entity/object/door.png"));
    } catch (IOException e) {
     e.printStackTrace();
    } 
  }

}
