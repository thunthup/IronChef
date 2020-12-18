package data;

import app.GameControl;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import myInterface.Boilable;
import myInterface.Chopable;

public class Fish extends Ingredient implements Boilable, Chopable {

	private Image boiledImg;
	private Image choppedImg;
	private boolean isBoiled;
	private boolean isChopped;
	private int timeToBoil;
	private int timeToChop;
	private int boilCounter;
	private int chopCounter;

	public Fish(Pane root) {
		super();
		this.setImage(new Image(ClassLoader.getSystemResource("Ingredients/Fish.png").toString()));
		this.boiledImg = new Image(ClassLoader.getSystemResource("Ingredients/BoiledFish.png").toString());
		this.choppedImg = new Image(ClassLoader.getSystemResource("Ingredients/BoiledFish.png").toString());
		this.isBoiled = false;
		this.isChopped = false;
		this.timeToBoil = 100;
		this.timeToChop = 100;
		this.boilCounter = 0;
		this.chopCounter = 0;
		this.setIngredientName("Fish");
		this.setDragged(false);
		root.getChildren().add(this);
		GameControl.IngredientsOnTable.add(this);

	}

	@Override
	public void fry() {
	

	}

	@Override
	public void boil() {
		
		if (!isBoiled() && getBoilCounter() >= getTimeToBoil()) {
			this.setImage(boiledImg);
			setBoiled(true);
			this.setIngredientName("BoiledFish");
		} else
			setBoilCounter(getBoilCounter() + 1);

	}

	@Override
	public void chop() {
		if (!isChopped() && getChopCounter() >= getTimeToChop()) {
			this.setImage(choppedImg);
			setChopped(true);
			this.setIngredientName("ChoppedFish");
		} else
			setChopCounter(getChopCounter() + 1);

	}

	public Image getBoiledImg() {
		return boiledImg;
	}

	public void setBoiledImg(Image boiledImg) {
		this.boiledImg = boiledImg;
	}

	public Image getChoppedImg() {
		return choppedImg;
	}

	public void setChoppedImg(Image choppedImg) {
		this.choppedImg = choppedImg;
	}

	public boolean isBoiled() {
		return isBoiled;
	}

	public void setBoiled(boolean isBoiled) {
		this.isBoiled = isBoiled;
	}

	public boolean isChopped() {
		return isChopped;
	}

	public void setChopped(boolean isChopped) {
		this.isChopped = isChopped;
	}

	public int getTimeToBoil() {
		return timeToBoil;
	}

	public void setTimeToBoil(int timeToBoil) {
		this.timeToBoil = timeToBoil;
	}

	public int getTimeToChop() {
		return timeToChop;
	}

	public void setTimeToChop(int timeToChop) {
		this.timeToChop = timeToChop;
	}

	public int getBoilCounter() {
		return boilCounter;
	}

	public void setBoilCounter(int boilCounter) {
		this.boilCounter = boilCounter;
	}

	public int getChopCounter() {
		return chopCounter;
	}

	public void setChopCounter(int chopCounter) {
		this.chopCounter = chopCounter;
	}

}
