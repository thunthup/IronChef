package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import gui.Trash;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import logic.Ingredient;

public class GameControl {
	public static ArrayList<Rectangle> IngredientsOnTable = new ArrayList<Rectangle>();
	public static ObservableList<Ingredient> IngredientsOnPan;
	public static ObservableList<Ingredient> IngredientsOnPot;
	public static ObservableList<Ingredient> IngredientsOnCut;
	public static ObservableList<Ingredient> IngredientsOnTrash;
	public static Trash trash = new Trash();
	

	public static void updateIngredients(Pane root) {
		for (Rectangle ingredient : IngredientsOnTable) {
			if (trash.getBoundsInLocal().intersects(ingredient.getBoundsInLocal())) {
				root.getChildren().remove(ingredient);
			}
		}
	}



}
