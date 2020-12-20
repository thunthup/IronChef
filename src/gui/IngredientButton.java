package gui;

import app.GameControl;
import data.*;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class IngredientButton extends ImageView {

	public static int itemLimit = 4;
	private Tooltip tooltip;
	public IngredientButton(String IngredientName, Pane root) {
		super();
		
		switch (IngredientName) {
		case "Egg": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/EggButton.png").toString()));
			this.setX(54);
			this.setY(211);

			this.setOnMouseClicked(e -> {
				if (GameControl.ingredientsOnTable.size() < itemLimit) {
					GameControl.ingredientsOnTable.add(new Egg(root));
				}
			});
			break;

		}
		case "Broccoli": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/BroccoliButton.png").toString()));
			this.setX(159);
			this.setY(211);

			this.setOnMouseClicked(e -> {
				if (GameControl.ingredientsOnTable.size() < itemLimit) {
					GameControl.ingredientsOnTable.add(new Broccoli(root));
				}
			});
			break;
		}
		case "Fish": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/FishButton.png").toString()));
			this.setX(264);
			this.setY(211);

			this.setOnMouseClicked(e -> {
				if (GameControl.ingredientsOnTable.size() < itemLimit) {
					GameControl.ingredientsOnTable.add(new Fish(root));
				}
			});
			break;
		}
		case "Bacon": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/BaconButton.png").toString()));
			this.setX(54);
			this.setY(305);

			this.setOnMouseClicked(e -> {
				if (GameControl.ingredientsOnTable.size() < itemLimit) {
					GameControl.ingredientsOnTable.add(new Bacon(root));
				}
			});
			break;
		}
		case "Basil": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/BasilButton.png").toString()));
			this.setX(159);
			this.setY(305);

			this.setOnMouseClicked(e -> {
				if (GameControl.ingredientsOnTable.size() < itemLimit) {
					GameControl.ingredientsOnTable.add(new Basil(root));
				}
			});
			break;
		}
		case "Bread": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/BreadButton.png").toString()));
			this.setX(264);
			this.setY(305);

			this.setOnMouseClicked(e -> {
				if (GameControl.ingredientsOnTable.size() < itemLimit) {
					GameControl.ingredientsOnTable.add(new Bread(root));
				}
			});
			break;
		}
		case "Tomato": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/TomatoButton.png").toString()));
			this.setX(54);
			this.setY(399);

			this.setOnMouseClicked(e -> {
				if (GameControl.ingredientsOnTable.size() < itemLimit) {
					GameControl.ingredientsOnTable.add(new Tomato(root));
				}
			});
			break;
		}
		case "Carrot": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/CarrotButton.png").toString()));
			this.setX(159);
			this.setY(399);

			this.setOnMouseClicked(e -> {
				if (GameControl.ingredientsOnTable.size() < itemLimit) {
					GameControl.ingredientsOnTable.add(new Carrot(root));
				}
			});
			break;
		}
		case "Cheese": {
			this.setImage(new Image(ClassLoader.getSystemResource("IngredientButton/CheeseButton.png").toString()));
			this.setX(264);
			this.setY(399);

			this.setOnMouseClicked(e -> {
				if (GameControl.ingredientsOnTable.size() < itemLimit) {
					GameControl.ingredientsOnTable.add(new Cheese(root));
				}
			});
			break;
		}
		
		}
		tooltip = new Tooltip(IngredientName);
		Tooltip.install(this, tooltip);
		this.setOnMouseEntered(e->{
			tooltip.show(root, e.getScreenX(), e.getScreenY());
		});
		this.setOnMouseExited(e->{
			tooltip.hide();
		});
		root.getChildren().add(this);
}}
