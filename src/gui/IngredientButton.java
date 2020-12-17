package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import logic.Egg;

public class IngredientButton extends ImageView {

	
	public IngredientButton(int IngredientNum, Pane root) {
		super();
		switch (IngredientNum) {
		case 0: {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/ButtonBase.png").toString()));
			this.setOnMouseClicked(e -> {
				new Egg(root);
			});
			root.getChildren().add(this);
		}
		default:
			
		}
	}
}
