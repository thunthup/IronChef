package data;

import javafx.scene.image.ImageView;


public abstract class Ingredient extends ImageView  {
	
	private String ingredientName;
	private boolean isDragged;
	
	public Ingredient() {
		this.ingredientName = "";
		this.setDragged(false);
		this.setX(Math.random() * 416 + 345);
		this.setY(Math.random() * 200 + 220);
		this.setOnMouseDragged(e-> {
			this.setX(e.getX()-this.getBoundsInLocal().getWidth()/2);
			this.setY(e.getY()-this.getBoundsInLocal().getHeight()/2);
			this.setDragged(true);
		});
		this.setOnMouseReleased(e->{
			this.setDragged(false);
		});
		
	}

	public abstract void fry();
	
	public abstract void boil();
	
	public abstract void chop();
	
	

	public String getIngredientName() {
		return ingredientName;
	}

	public Ingredient setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
		return this;
	}

	public boolean isDragged() {
		return isDragged;
	}

	public void setDragged(boolean isDragged) {
		this.isDragged = isDragged;
	}



}
