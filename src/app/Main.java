package app;

import data.Ingredient;
import gui.GameButton;
import gui.IngredientButton;
import gui.QuestBar;
import gui.ToggleButton;
import javafx.animation.Animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	final static int HEIGHT = 700;
	final static int WIDGTH = 1000;

	private void scoreScreen(Stage stage) {
		
		GameControl.boilSound.stop();
		GameControl.chopSound.stop();
		GameControl.frySound.stop();
		GameControl.timeLeft = 180;

		Pane root = new Pane();
		root.setPrefSize(WIDGTH, HEIGHT);
		ImageView backgroundImg = new ImageView(new Image(ClassLoader.getSystemResource("menubg.png").toString()));
		root.getChildren().add(backgroundImg);
		Scene scoreScene = new Scene(root);
		stage.setScene(scoreScene);
		stage.show();

	}

	private void gameScreenStart(Stage stage) {

		Pane root = new Pane();
		root.setPrefSize(WIDGTH, HEIGHT);
		root.setMinSize(WIDGTH, HEIGHT);

		Scene gamescene = new Scene(root);
		ImageView gameScreenBackgroundleft = new ImageView(
				new Image(ClassLoader.getSystemResource("gameScreenbgleft.png").toString()));
		ImageView gameScreenBackgroundright = new ImageView(
				new Image(ClassLoader.getSystemResource("gameScreenbgright.png").toString()));
		gameScreenBackgroundleft.setX(0);
		gameScreenBackgroundleft.setY(0);
		gameScreenBackgroundright.setX(350);
		gameScreenBackgroundright.setY(0);
		root.getChildren().addAll(gameScreenBackgroundleft, gameScreenBackgroundright);
		IngredientButton eggButton = new IngredientButton("Egg", root);
		IngredientButton FishButton = new IngredientButton("Fish", root);
		IngredientButton broccoliButton = new IngredientButton("Broccoli", root);
		IngredientButton baconButton = new IngredientButton("Bacon", root);
		IngredientButton basilButton = new IngredientButton("Basil", root);
		IngredientButton breadButton = new IngredientButton("Bread", root);
		IngredientButton TomatoButton = new IngredientButton("Tomato", root);
		IngredientButton CarrotButton = new IngredientButton("Carrot", root);
		IngredientButton CheeseButton = new IngredientButton("Cheese", root);
		root.getChildren().addAll(GameControl.trash, GameControl.pan, GameControl.pot, GameControl.plate,
				GameControl.cuttingBoard);
		root.getChildren().add(GameControl.questBar);
		GameControl.timeLeft = 5;
		Font font = new Font(Font.getFamilies().get(0), 40);
		Label scoreLabel = new Label("Score: " + GameControl.score);
		scoreLabel.setFont(font);
		scoreLabel.setTranslateX(70);
		scoreLabel.setTranslateY(629);
		Label timeLabel = new Label("Time: " + GameControl.timeLeft);
		
		timeLabel.setFont(font);
		timeLabel.setTranslateX(60);
		timeLabel.setTranslateY(20);
		root.getChildren().addAll(timeLabel, scoreLabel);
		stage.setScene(gamescene);
		stage.show();

		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(150), e -> {
			GameControl.updateIngredients(root);
			GameControl.timeLeft -= 0.15D;
			timeLabel.setText("Time: " + (int) GameControl.timeLeft);
			if (GameControl.timeLeft <= 0) {
				for(Ingredient ingredient : GameControl.ingredientsOnTable) {
					root.getChildren().remove(ingredient);
				}
				GameControl.updateIngredients(root);
				scoreScreen(stage);
				
			}
			scoreLabel.setText("Score: " + GameControl.score);
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

	}

	private void menuStart(Stage stage) {

		Pane root = new Pane();
		root.setPrefSize(1000, 700);
		root.setMinSize(1000, 700);
		GameControl.score = 0;
		Image bg = new Image(ClassLoader.getSystemResource("menubg.png").toString());
		ImageView bgi = new ImageView(bg);
		root.getChildren().add(bgi);
		Scene menuScene = new Scene(root, 1000, 700);

		GameButton play = new GameButton("playbutton.png", "playbuttonhighlight.png", root, 362, 400);
		play.setOnMouseClicked(e -> gameScreenStart(stage));

		GameButton exit = new GameButton("exitButton.png", "exitButtonhighlight.png", root, 362, 520);
		exit.setOnMouseClicked(e -> stage.close());
		MediaPlayer bgm = new MediaPlayer(new Media(ClassLoader.getSystemResource("sound/bgMusic.mp3").toString()));
		AudioClip bgMusic = new AudioClip(ClassLoader.getSystemResource("sound/bgMusic.mp3").toString());
		bgm.setCycleCount(AudioClip.INDEFINITE);
		bgm.setVolume(0.05D);
		bgm.play();

		ToggleButton bgMusicButton = new ToggleButton("bgMusicButton.png", "bgMusicButtonhighlight.png",
				"bgMusicOffButton.png", "bgMusicOffButtonhighlight.png", root, 866, 578);

		bgMusicButton.setOnMouseClicked(e -> {
			bgMusicButton.setToggleState((!bgMusicButton.getToggleState()));
			if (bgMusicButton.getToggleState()) {
				bgm.play();
			} else {
				bgm.pause();
			}
			bgMusicButton.update();
		});

		stage.setScene(menuScene);
		stage.show();
	}

	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setTitle("IRON CHEF");
		stage.setResizable(false);

		menuStart(stage);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
