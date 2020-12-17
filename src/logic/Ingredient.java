package logic;

import javafx.scene.image.ImageView;
import myException.NotCookableException;

public abstract class Ingredient extends ImageView  {
	
	private String ingredientName;
	private boolean isDragged;
	
	public Ingredient() {
		this.ingredientName = "";
		this.setDragged(false);
		this.setOnMouseDragged(e-> {
			this.setX(e.getX()-this.getBoundsInLocal().getWidth()/2);
			this.setY(e.getY()-this.getBoundsInLocal().getHeight()/2);
			this.setDragged(true);
		});
		this.setOnMouseDragReleased(e->{
			this.setDragged(false);
		});
		
	}

	public abstract void fry() throws NotCookableException;
	
	public abstract void boil() throws NotCookableException;
	
	public abstract void cut() throws NotCookableException;
	
	

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public boolean isDragged() {
		return isDragged;
	}

	public void setDragged(boolean isDragged) {
		this.isDragged = isDragged;
	}
}
