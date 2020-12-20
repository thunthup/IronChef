package gui;

import data.Ingredient;
import data.Menu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class QuestBar extends HBox {
	public QuestBar(Menu menu) {
		this.setPadding(new Insets(2));
		this.setBackground(new Background(new BackgroundFill(Color.IVORY, new CornerRadii(5), new Insets(1))));
		this.setAlignment(Pos.CENTER);
		this.setTranslateX(50);
		this.setTranslateY(80);
		this.setMaxHeight(80);
		for (Ingredient ingredient : menu.getIngredientList()) {

			this.getChildren().add(ingredient);

		}
	}
}
