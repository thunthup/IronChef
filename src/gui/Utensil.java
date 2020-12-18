package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Utensil extends ImageView {
	public Utensil(String utensilName) {
		super();
		switch (utensilName) {
		case "Trash": {
			this.setImage(new Image(ClassLoader.getSystemResource("utensil/Trash.png").toString()));
			this.setX(417);
			this.setY(499);
			break;
		}
		case "Pan":{
			this.setImage(new Image(ClassLoader.getSystemResource("utensil/Pan.png").toString()));
			this.setX(619);
			this.setY(449);
			this.setRotate(-20);
			break;
		}

		}
	}
}
