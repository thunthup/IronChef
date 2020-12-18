package gui;

import app.GameControl;
import data.Egg;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class IngredientButton extends ImageView {

	public IngredientButton(String IngredientName, Pane root) {
		super();
		switch (IngredientName) {
		case "Egg": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/ButtonBase.png").toString()));
			this.setX(54);
			this.setY(211);

			this.setOnMouseClicked(e -> {
				if (GameControl.IngredientsOnTable.size() <= 6) {
					new Egg(root);
				}
			});
			break;

		}
		case "Broccoli": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/ButtonBase.png").toString()));
			this.setX(0);
			this.setY(0);
			this.setOnMouseClicked(e -> {
				new Egg(root);
			});
			break;

		}
		}
		root.getChildren().add(this);
	}
}
