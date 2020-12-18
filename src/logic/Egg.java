package logic;

import app.GameControl;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import myInterface.Fryable;

public class Egg extends Ingredient implements Fryable {

	private Image friedImg;
	private boolean isFried;
	private int timeToFried;
	private int fryCounter;

	public Egg(Pane root) {
		super();
		this.setImage(new Image(ClassLoader.getSystemResource("Ingredients/Egg.png").toString()));
		this.friedImg = new Image(ClassLoader.getSystemResource("Ingredients/FriedEgg.png").toString());
		this.isFried = false;
		this.timeToFried = 100;
		this.fryCounter = 0;
		this.setIngredientName("Egg");
		this.setDragged(false);
		this.setX(Math.random() * 416 + 377);
		this.setY(Math.random() * 200 + 220);
		;
		root.getChildren().add(this);
		GameControl.IngredientsOnTable.add(this);
	

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
		return timeToFried;
	}

	public void setTimeToFried(int timeToFried) {
		this.timeToFried = timeToFried;
	}

	public int getFryCounter() {
		return fryCounter;
	}

	public void setFryCounter(int fryCounter) {
		this.fryCounter = fryCounter;
	}

	@Override
	public void fry() {
		if (!isFried() && getFryCounter() >= getTimeToFried()) {
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
	public void cut() {

	}

}
