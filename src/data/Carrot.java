package data;

import app.GameControl;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Carrot extends Ingredient {
	public Carrot(Pane root) {
		super();
		this.setIngredientName("Carrot");
		this.setImage(new Image(ClassLoader.getSystemResource("Ingredients/Carrot.png").toString()));
		this.setDragged(false);
		root.getChildren().add(this);
		

	}
	@Override
	public void fry() {
		// TODO Auto-generated method stub

	}

	@Override
	public void boil() {
		// TODO Auto-generated method stub

	}

	@Override
	public void chop() {
		// TODO Auto-generated method stub

	}

}
