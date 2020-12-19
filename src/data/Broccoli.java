package data;

import app.GameControl;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import myInterface.Fryable;

public class Broccoli extends Ingredient implements Fryable {
	private Image friedImg;
	private boolean isFried;
	private int timeToFry;
	private int fryCounter;

	public Broccoli(Pane root) {
		super();
		this.setIngredientName("Broccoli");
		this.setImage(new Image(ClassLoader.getSystemResource("Ingredients/Broccoli.png").toString()));
		this.friedImg = new Image(ClassLoader.getSystemResource("Ingredients/FriedBroccoli.png").toString());
		this.isFried = false;
		this.timeToFry = 14;
		this.fryCounter = 0;
		this.setDragged(false);
		root.getChildren().add(this);

	}

	public Broccoli fried() {
		this.setImage(getFriedImg());
		this.setFried(true);
		this.setIngredientName("FriedBroccoli");
		return this;
	}

	@Override
	public void fry() {
		if (!isFried() && getFryCounter() >= getTimeToFried()) {
			this.setImage(friedImg);
			setFried(true);
			this.setIngredientName("FriedBroccoli");
		} else if (!isFried()) {
			setFryCounter(getFryCounter() + 1);
		}

	}

	@Override
	public void boil() {

	}

	@Override
	public void chop() {

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

	public int getTimeToFried() {
		return timeToFry;
	}

	public void setTimeToFried(int timeToFried) {
		this.timeToFry = timeToFried;
	}

	public int getFryCounter() {
		return fryCounter;
	}

	public void setFryCounter(int fryCounter) {
		this.fryCounter = fryCounter;
	}
}
