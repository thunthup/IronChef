package data;

import app.GameControl;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import myInterface.Fryable;

public class Bread extends Ingredient implements Fryable {
	private Image friedImg;
	private boolean isFried;
	private int timeToFry;
	private int fryCounter;

	public Bread(Pane root) {
		super();
		this.setIngredientName("Bread");
		this.setImage(new Image(ClassLoader.getSystemResource("Ingredients/Bread.png").toString()));
		this.friedImg = new Image(ClassLoader.getSystemResource("Ingredients/FriedBread.png").toString());
		this.isFried = false;
		this.timeToFry = 14;
		this.fryCounter = 0;
		this.setDragged(false);
		root.getChildren().add(this);

	}

	public Bread fried() {
		this.setImage(getFriedImg());
		this.setFried(true);
		this.setIngredientName("FriedBread");
		return this;
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

	@Override
	public void fry() {
		if (!isFried() && getFryCounter() >= getTimeToFry()) {
			this.setImage(friedImg);
			setFried(true);
			this.setIngredientName("FriedBread");
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

}
