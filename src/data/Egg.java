package data;


import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import myInterface.Fryable;

public class Egg extends Ingredient implements Fryable {

	private Image friedImg;
	private boolean isFried;
	private int timeToFry;
	private int fryCounter;

	public Egg(Pane root) {
		super();
		this.setIngredientName("Egg");
		this.setImage(new Image(ClassLoader.getSystemResource("Ingredients/Egg.png").toString()));
		this.friedImg = new Image(ClassLoader.getSystemResource("Ingredients/FriedEgg.png").toString());
		this.isFried = false;
		this.timeToFry = 14;
		this.fryCounter = 0;
		this.setDragged(false);
		root.getChildren().add(this);

	}

	public Egg fried() {
		this.setImage(getFriedImg());
		this.setFried(true);
		this.setIngredientName("FriedEgg");
		return this;
	}

	@Override
	public void fry() {
		if (!isFried() && getFryCounter() >= getTimeToFry()) {
			this.setImage(friedImg);
			setFried(true);
			this.setIngredientName("FriedEgg");
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

	public int getTimeToFry() {
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
