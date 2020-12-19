package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Utensil extends ImageView {
	public Utensil(String utensilName) {
		super();
		switch (utensilName) {
		case "Trash": {
			this.setImage(new Image(ClassLoader.getSystemResource("utensil/Trash.png").toString()));
			this.setX(409);
			this.setY(490);
			break;
		}
		case "Pan":{
			this.setImage(new Image(ClassLoader.getSystemResource("utensil/Pan.png").toString()));
			this.setX(619);
			this.setY(449);
			this.setRotate(-20);
			break;
		}
		case "CuttingBoard":{
			this.setImage(new Image(ClassLoader.getSystemResource("utensil/CuttingBoard.png").toString()));
			this.setX(818);
			this.setY(288);
			
			break;
		}
		case "Pot":{
			this.setImage(new Image(ClassLoader.getSystemResource("utensil/Pot.png").toString()));
			this.setX(818);
			this.setY(0);
			
			break;
		}
		case "Plate":{
			this.setImage(new Image(ClassLoader.getSystemResource("utensil/Plate.png").toString()));
			this.setX(398);
			this.setY(-227);
			
			break;
		}

		}
	}
}
