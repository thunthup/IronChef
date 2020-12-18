package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import data.Ingredient;
import gui.Utensil;
import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import myException.NotCookableException;
import myInterface.Fryable;

public class GameControl {
	public static int N = 0;
	public static ArrayList<Ingredient> IngredientsOnTable = new ArrayList<Ingredient>();
	public static ArrayList<Ingredient> IngredientsOnServe = new ArrayList<Ingredient>();
	public static ArrayList<Ingredient> IngredientsOnPan = new ArrayList<Ingredient>();
	public static ArrayList<Ingredient> IngredientsOnPot = new ArrayList<Ingredient>();
	public static int score = 2000;
	public static Utensil trash = new Utensil("Trash");
	public static Utensil pan = new Utensil("Pan");
	public static MediaPlayer frySound = new MediaPlayer(new Media(ClassLoader.getSystemResource("sound/Frying.mp3").toString()));
	public static AudioClip trashSound = new AudioClip(ClassLoader.getSystemResource("sound/sweep.wav").toString());
	
	public static void updateIngredients(Pane root) {
		for (Ingredient ingredient : IngredientsOnTable) {
			if(!ingredient.isDragged()){
				if (trash.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					
				
					trashSound.play();
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							IngredientsOnTable.remove(ingredient);
							
						}
					});
					
					root.getChildren().remove(ingredient);
					
				}
				if(ingredient.getX() < 346) {
					ingredient.setX(348);
				}
				if(ingredient.getY() <= 1) {
					ingredient.setY(ingredient.getY()+12);
				}
				if(ingredient.getY() >= 630) {
					ingredient.setY(ingredient.getY()-12);
				}
				if(ingredient.getX() > 930) {
					ingredient.setX(ingredient.getX()-12);
				}
				if (pan.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					if(!IngredientsOnPan.contains(ingredient)) {
						IngredientsOnPan.add(ingredient);
					}
					try {
						if(ingredient instanceof Fryable) {
							ingredient.fry();
							frySound.setCycleCount(Animation.INDEFINITE);
							frySound.play();
								
						}else {
							throw new NotCookableException();
						}
						
					} catch (NotCookableException e) {
						score -= 20;
					}
				}
				if(!pan.getBoundsInParent().contains(ingredient.getBoundsInParent())) {
					if(IngredientsOnPan.contains(ingredient)){
						IngredientsOnPan.remove(ingredient);
					}
				}
				if(IngredientsOnPan.size() == 0) {
					frySound.stop();
				}
			}
				
			}
			
		}
}
