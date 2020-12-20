package data;


import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import myInterface.Fryable;

public class Bacon extends Ingredient implements Fryable {

	private Image friedImg;
	private boolean isFried;
	private int timeToFry;
	private int fryCounter;

	public Bacon(Pane root) {
		super();
		this.setIngredientName("Bacon");
		this.setImage(new Image(ClassLoader.getSystemResource("Ingredients/Bacon.png").toString()));
		this.friedImg = new Image(ClassLoader.getSystemResource("Ingredients/FriedBacon.png").toString());
		this.isFried = false;
		this.timeToFry = 14;
		this.fryCounter = 0;
		this.setDragged(false);
		root.getChildren().add(this);
	}
	public Bacon fried() {
		this.setImage(getFriedImg());
		this.setFried(true);
		this.setIngredientName("FriedBacon");
		return this;
	}

	@Override
	public void fry() {
		if (!isFried() && getFryCounter() >= getTimeToFry()) {
			this.setImage(friedImg);
			setFried(true);
			this.setIngredientName("FriedBacon");
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
