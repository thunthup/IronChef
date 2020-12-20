package app;

import java.util.ArrayList;

import java.util.stream.Collectors;

import data.Ingredient;
import data.Menu;
import gui.QuestBar;
import gui.Utensil;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.application.Platform;

import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import myException.NotCookableException;
import myInterface.Boilable;
import myInterface.Chopable;
import myInterface.Fryable;

public class GameControl {
	public static boolean gamePlaying;
	public static Timeline timeline;
	public static ArrayList<Ingredient> ingredientsOnTable = new ArrayList<Ingredient>();
	public static ArrayList<Ingredient> ingredientsOnServe = new ArrayList<Ingredient>();
	public static ArrayList<String> ingredientsOnServeName = new ArrayList<String>();
	public static ArrayList<Ingredient> ingredientsOnPan = new ArrayList<Ingredient>();
	public static ArrayList<Ingredient> ingredientsOnPot = new ArrayList<Ingredient>();
	public static ArrayList<Ingredient> ingredientsOnCuttingBoard = new ArrayList<Ingredient>();
	public static Menu currentMenu;
	public static QuestBar questBar;

	public static int score;
	public static double timeLeft;
	public static Utensil trash = new Utensil("Trash");
	public static Utensil pan = new Utensil("Pan");
	public static Utensil pot = new Utensil("Pot");
	public static Utensil cuttingBoard = new Utensil("CuttingBoard");
	public static Utensil plate = new Utensil("Plate");
	public static MediaPlayer frySound = new MediaPlayer(
			new Media(ClassLoader.getSystemResource("sound/Frying.mp3").toString()));
	public static MediaPlayer boilSound = new MediaPlayer(
			new Media(ClassLoader.getSystemResource("sound/Boiling.mp3").toString()));
	public static MediaPlayer chopSound = new MediaPlayer(
			new Media(ClassLoader.getSystemResource("sound/Chopping.wav").toString()));
	public static AudioClip trashSound = new AudioClip(ClassLoader.getSystemResource("sound/sweep.wav").toString());

	public static void updateIngredients(Pane root) {
		for (Ingredient ingredient : ingredientsOnTable) {
			if (!ingredient.isDragged()) {
				if (ingredient.getX() < 346) {
					ingredient.setX(348);
				}
				if (ingredient.getY() <= 1) {
					ingredient.setY(15);
				}
				if (ingredient.getY() >= 630) {
					ingredient.setY(620);
				}
				if (ingredient.getX() > 930) {
					ingredient.setX(930);
				}

				if (!root.getChildren().contains(ingredient)) {
					Platform.runLater(new Runnable() {

						@Override
						public void run() {
							ingredientsOnTable.remove(ingredient);
							ingredientsOnCuttingBoard.remove(ingredient);
							ingredientsOnPan.remove(ingredient);
							ingredientsOnPot.remove(ingredient);
							ingredientsOnServe.remove(ingredient);

						}
					});
				}

				////////////////////////////////////////////////////////////////////////////////////// Trash
				////////////////////////////////////////////////////////////////////////////////////// Functionality

				if (trash.getBoundsInParent().contains(ingredient.getBoundsInParent())) {

					trashSound.play();
					GameControl.score -= 500;
					root.getChildren().remove(ingredient);

				}
				///////////////////////////////////////////////////////////////////////////////////////// Pan
				///////////////////////////////////////////////////////////////////////////////////////// Functionality

				if (pan.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					if (!ingredientsOnPan.contains(ingredient)) {
						ingredientsOnPan.add(ingredient);
					}
					try {
						frySound.setCycleCount(Animation.INDEFINITE);
						frySound.play();
						if (ingredient instanceof Fryable) {
							ingredient.fry();

						} else {
							throw new NotCookableException();
						}

					} catch (NotCookableException e) {
						score -= 7;
					}
				}
				if (!pan.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					if (ingredientsOnPan.contains(ingredient)) {
						ingredientsOnPan.remove(ingredient);
					}
				}
				if (ingredientsOnPan.size() == 0) {
					frySound.stop();
				}
				///////////////////////////////////////////////////////////////////////////////////// Pot
				///////////////////////////////////////////////////////////////////////////////////// Functionality

				if (pot.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					if (!ingredientsOnPot.contains(ingredient)) {
						ingredientsOnPot.add(ingredient);
					}
					try {
						boilSound.setCycleCount(Animation.INDEFINITE);
						boilSound.play();
						if (ingredient instanceof Boilable) {
							ingredient.boil();

						} else {
							throw new NotCookableException();
						}

					} catch (NotCookableException e) {
						score -= 7;
					}
				}
				if (!pot.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					if (ingredientsOnPot.contains(ingredient)) {
						ingredientsOnPot.remove(ingredient);
					}
				}
				if (ingredientsOnPot.size() == 0) {
					boilSound.stop();
				}
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////// CuttingBoard
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////// Functionality
				if (cuttingBoard.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					if (!ingredientsOnCuttingBoard.contains(ingredient)) {
						ingredientsOnCuttingBoard.add(ingredient);
					}
					try {
						chopSound.setCycleCount(Animation.INDEFINITE);
						chopSound.play();
						if (ingredient instanceof Chopable) {
							ingredient.chop();

						} else {
							throw new NotCookableException();
						}

					} catch (NotCookableException e) {
						score -= 7;
					}
				}
				if (!cuttingBoard.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					if (ingredientsOnCuttingBoard.contains(ingredient)) {
						ingredientsOnCuttingBoard.remove(ingredient);
					}
				}
				if (ingredientsOnCuttingBoard.size() == 0) {
					chopSound.stop();
				}
				///////////////////////////////////////////////////////////////////////////// Serving
				///////////////////////////////////////////////////////////////////////////// Plate
				///////////////////////////////////////////////////////////////////////////// Functionality
				ingredientsOnServeName.clear();
				if (plate.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					if (!ingredientsOnServe.contains(ingredient)) {
						ingredientsOnServe.add(ingredient);
					}
				}
				if (!plate.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					if (ingredientsOnServe.contains(ingredient)) {
						ingredientsOnServe.remove(ingredient);
					}
				}

				for (Ingredient ingredientOnServe : ingredientsOnServe) {
					ingredientsOnServeName.add(ingredientOnServe.getIngredientName());

				}

				boolean menuCheck = ingredientsOnServeName.stream().sorted().collect(Collectors.toList())
						.equals(GameControl.currentMenu.getNameList().stream().sorted().collect(Collectors.toList()));

				if (menuCheck) {
					root.getChildren().removeAll(ingredientsOnServe);
					root.getChildren().removeIf(x -> x instanceof QuestBar);
					ingredientsOnServe.clear();
					GameControl.score += currentMenu.getScore();
					menuCheck = false;
					Menu nextMenu = new Menu();
					ingredientsOnServeName.clear();
					GameControl.questBar = new QuestBar(nextMenu);
					GameControl.currentMenu = nextMenu;
					try {
						root.getChildren().add(questBar);
					} catch (Exception e) {

					}

				}

			}
		}

	}

}
