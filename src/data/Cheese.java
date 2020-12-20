package data;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import myInterface.Fryable;

public class Cheese extends Ingredient implements Fryable {

	private Image friedImg;
	private boolean isFried;
	private int timeToFry;
	private int fryCounter;

	public Cheese(Pane root) {
		super();
		this.setIngredientName("Cheese");
		this.setImage(new Image(ClassLoader.getSystemResource("Ingredients/Cheese.png").toString()));
		this.friedImg = new Image(ClassLoader.getSystemResource("Ingredients/FriedCheese.png").toString());
		this.isFried = false;
		this.timeToFry = 14;
		this.fryCounter = 0;
		this.setDragged(false);
		root.getChildren().add(this);

	}
	
	public Cheese fried() {
		this.setImage(getFriedImg());
		this.setFried(true);
		this.setIngredientName("FriedCheese");
		return this;
	}

	@Override
	public void fry() {
		if (!isFried() && getFryCounter() >= getTimeToFry()) {
			this.setImage(friedImg);
			setFried(true);
			this.setIngredientName("FriedCheese");
		} else if (!isFried()) {
			setFryCounter(getFryCounter() + 1);
		}

	}

	@Override
	public void boil() {
		// TODO Auto-generated method stub

	}

	@Override
	public void chop() {
		// TODO Auto-generated method stub

	}

	public Image getFriedImg() {
		return friedImg;
	}

	public void setFriedImg(Image friedImg) {
		this.friedImg = friedImg;
	}

	public boolean isFried() {
		return isFried;
	}

	public void setFried(boolean isFried) {
		this.isFried = isFried;
	}

	public int getTimeToFry() {
		return timeToFry;
	}

	public void setTimeToFry(int timeToFry) {
		this.timeToFry = timeToFry;
	}

	public int getFryCounter() {
		return fryCounter;
	}

	public void setFryCounter(int fryCounter) {
		this.fryCounter = fryCounter;
	}

}
