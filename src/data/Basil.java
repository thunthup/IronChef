package data;


import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Basil extends Ingredient {
	
	public Basil(Pane root) {
		super();
		this.setIngredientName("Basil");
		this.setImage(new Image(ClassLoader.getSystemResource("Ingredients/Basil.png").toString()));
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
