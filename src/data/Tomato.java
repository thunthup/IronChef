package data;


import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import myInterface.Boilable;
import myInterface.Chopable;

public class Tomato extends Ingredient  implements Boilable, Chopable {
	private Image boiledImg;
	private Image choppedImg;
	private boolean isBoiled;
	private boolean isChopped;
	private int timeToBoil;
	private int timeToChop;
	private int boilCounter;
	private int chopCounter;

	public Tomato(Pane root) {
		super();
		this.setImage(new Image(ClassLoader.getSystemResource("Ingredients/Tomato.png").toString()));
		this.boiledImg = new Image(ClassLoader.getSystemResource("Ingredients/BoiledTomato.png").toString());
		this.choppedImg = new Image(ClassLoader.getSystemResource("Ingredients/ChoppedTomato.png").toString());
		this.isBoiled = false;
		this.isChopped = false;
		this.timeToBoil = 14;
		this.timeToChop = 14;
		this.boilCounter = 0;
		this.chopCounter = 0;
		this.setIngredientName("Tomato");
		this.setDragged(false);
		root.getChildren().add(this);
		

	}
	public Tomato boiled() {
		this.setImage(getBoiledImg());
		this.setBoiled(true);
		this.setIngredientName("BoiledTomato");
		return this;
	}

	public Tomato chopped() {
		this.setImage(getChoppedImg());
		this.setBoiled(true);
		this.setIngredientName("ChoppedTomato");
		return this;
	}
	
	@Override
	public void chop() {
		if (!isChopped() && !isBoiled() && getChopCounter() >= getTimeToChop()) {
			this.setImage(choppedImg);
			setChopped(true);
			this.setIngredientName("ChoppedTomato");
		} else
			setChopCounter(getChopCounter() + 1);

	}

	@Override
	public void boil() {

		if (!isBoiled() && !isChopped() && getBoilCounter() >= getTimeToBoil()) {
			this.setImage(boiledImg);
			setBoiled(true);
			this.setIngredientName("BoiledTomato");
		} else
			setBoilCounter(getBoilCounter() + 1);

	}
	@Override
	public void fry() {
		// TODO Auto-generated method stub
		
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
