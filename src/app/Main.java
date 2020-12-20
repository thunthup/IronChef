package app;

import java.util.ArrayList;

import data.Ingredient;
import data.Menu;
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
	public static double now;
	final static int HEIGHT = 700;
	final static int WIDGTH = 1000;

	private void scoreScreen(Stage stage) {
		GameControl.timeline.pause();
		GameControl.boilSound.stop();
		GameControl.chopSound.stop();
		GameControl.frySound.stop();
		GameControl.timeLeft = 120;

		Pane root = new Pane();
		root.setPrefSize(WIDGTH, HEIGHT);
		ImageView backgroundImg = new ImageView(new Image(ClassLoader.getSystemResource("menubg.png").toString()));
		root.getChildren().add(backgroundImg);
		Scene scoreScene = new Scene(root);
		Font font = new Font(Font.getFamilies().get(0), 40);
		Label scoreLabel = new Label("Score: " + GameControl.score);
		scoreLabel.setFont(font);
		scoreLabel.setTranslateX(70);
		scoreLabel.setTranslateY(629);
		root.getChildren().add(scoreLabel);
		ImageView gameOver = new ImageView(new Image(ClassLoader.getSystemResource("gameover.png").toString()));
		gameOver.setX(278);
		gameOver.setY(64);
		
		root.getChildren().add(gameOver);
		GameButton playAgainButton = new GameButton("PlayAgain.png", "PlayAgainhighlight.png", root, 322, 380);
		playAgainButton.setOnMouseClicked(e -> gameScreenStart(stage));
		GameButton backToMenuButon = new GameButton("BacktoMenuButton.png", "BackToMenuButtonhighlight.png", root, 459, 380);
		backToMenuButon.setOnMouseClicked(e -> {
			menuStart(stage);
		});
		GameButton exit = new GameButton("CircleExit.png", "CircleExithighlight.png", root, 596, 380);
		exit.setOnMouseClicked(e -> {
			stage.close();
		});

		stage.setScene(scoreScene);
		stage.show();

	}

	private void gameScreenStart(Stage stage) {
		GameControl.timeLeft = 7;
		GameControl.score = 0;
		Pane root = new Pane();
		root.setPrefSize(WIDGTH, HEIGHT);
		root.setMinSize(WIDGTH, HEIGHT);

		Scene gamescene = new Scene(root);
		ImageView gameScreenBackground = new ImageView(
				new Image(ClassLoader.getSystemResource("gameScreenbgleft.png").toString()));

		root.getChildren().addAll(gameScreenBackground);
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
		GameControl.currentMenu = new Menu();
		GameControl.questBar = new QuestBar(GameControl.currentMenu);
		root.getChildren().add(GameControl.questBar);

		Font font = new Font(Font.getFamilies().get(0), 40);
		Label scoreLabel = new Label("Score: " + GameControl.score);
		scoreLabel.setFont(font);
		scoreLabel.setTranslateX(70);
		scoreLabel.setTranslateY(629);
		Label timeLabel = new Label("Time: " + (int)GameControl.timeLeft);

		timeLabel.setFont(font);
		timeLabel.setTranslateX(60);
		timeLabel.setTranslateY(20);
		root.getChildren().addAll(timeLabel, scoreLabel);
		stage.setScene(gamescene);
		stage.show();

		GameControl.timeline = new Timeline(new KeyFrame(Duration.millis(150), e -> {

			GameControl.updateIngredients(root);
			GameControl.timeLeft -= 0.15D;
			timeLabel.setText("Time: " + (int) GameControl.timeLeft);
			if (GameControl.timeLeft <= 0) {
				for (Ingredient ingredient : GameControl.ingredientsOnTable) {
					root.getChildren().remove(ingredient);
				}
				GameControl.updateIngredients(root);
				scoreScreen(stage);

			}
			scoreLabel.setText("Score: " + GameControl.score);
		
		}));
		GameControl.timeline.setCycleCount(Animation.INDEFINITE);
		GameControl.timeline.play();

	}
	
	private void howToPlay(Stage stage) {
		
		Pane root = new Pane();
		root.setPrefSize(WIDGTH, HEIGHT);
		Image bg = new Image(ClassLoader.getSystemResource("menubg.png").toString());
		ImageView bgi = new ImageView(bg);
		
		ImageView howToPlay1 = new ImageView(new Image(ClassLoader.getSystemResource("HowToPlay1.png").toString()));
		ImageView howToPlay2 = new ImageView(new Image(ClassLoader.getSystemResource("HowToPlay2.png").toString()));
		ImageView howToPlay3 = new ImageView(new Image(ClassLoader.getSystemResource("HowToPlay3.png").toString()));
		ImageView howToPlay4 = new ImageView(new Image(ClassLoader.getSystemResource("HowToPlay4.png").toString()));
		ImageView howToPlay5 = new ImageView(new Image(ClassLoader.getSystemResource("HowToPlay5.png").toString()));
		howToPlay1.setX(171);
		howToPlay1.setY(17);
		howToPlay2.setX(171);
		howToPlay2.setY(17);
		howToPlay3.setX(171);
		howToPlay3.setY(17);
		howToPlay4.setX(171);
		howToPlay4.setY(17);
		howToPlay5.setX(171);
		howToPlay5.setY(17);
		ImageView nextButton1 = new ImageView(new Image(ClassLoader.getSystemResource("NextButton.png").toString()));
		ImageView nextButton2 = new ImageView(new Image(ClassLoader.getSystemResource("NextButton.png").toString()));
		ImageView nextButton3 = new ImageView(new Image(ClassLoader.getSystemResource("NextButton.png").toString()));
		ImageView nextButton4 = new ImageView(new Image(ClassLoader.getSystemResource("NextButton.png").toString()));
		ImageView nextButton5 = new ImageView(new Image(ClassLoader.getSystemResource("NextButton.png").toString()));
		nextButton1.setX(628);
		nextButton1.setY(545);
		nextButton2.setX(628);
		nextButton2.setY(545);
		nextButton3.setX(641);
		nextButton3.setY(320);
		nextButton4.setX(641);
		nextButton4.setY(320);
		nextButton5.setX(641);
		nextButton5.setY(320);
		nextButton1.setOnMouseClicked(e->{
			root.getChildren().removeAll(howToPlay1,nextButton1);
			root.getChildren().addAll(howToPlay2,nextButton2);
		});
		nextButton2.setOnMouseClicked(e->{
			root.getChildren().removeAll(howToPlay2,nextButton2);
			root.getChildren().addAll(howToPlay3,nextButton3);
		});
		nextButton3.setOnMouseClicked(e->{
			root.getChildren().removeAll(howToPlay3,nextButton3);
			root.getChildren().addAll(howToPlay4,nextButton4);
		});
		nextButton4.setOnMouseClicked(e->{
			root.getChildren().removeAll(howToPlay4,nextButton4);
			root.getChildren().addAll(howToPlay5,nextButton5);
		});
		nextButton5.setOnMouseClicked(e->{
			gameScreenStart(stage);
		});
		root.getChildren().addAll(bgi,howToPlay1,nextButton1);
		
		
		Scene howToPlayScene = new Scene(root);
		stage.setScene(howToPlayScene);
		stage.show();
	}

	private void menuStart(Stage stage) {

		Pane root = new Pane();
		root.setPrefSize(1000, 700);
		root.setMinSize(1000, 700);
		GameControl.score = 0;
		Image bg = new Image(ClassLoader.getSystemResource("menubg.png").toString());
		ImageView bgi = new ImageView(bg);
		root.getChildren().add(bgi);
		ImageView logo = new ImageView(new Image(ClassLoader.getSystemResource("GameLogo.png").toString()));
		logo.setFitWidth(460);
		logo.setFitHeight(418);
		logo.setX(WIDGTH / 4 + 20);
		root.getChildren().add(logo);
		Scene menuScene = new Scene(root, 1000, 700);

		GameButton play = new GameButton("playbutton.png", "playbuttonhighlight.png", root, 362, 420);
		play.setOnMouseClicked(e -> howToPlay(stage));

		GameButton exit = new GameButton("exitButton.png", "exitButtonhighlight.png", root, 362, 540);
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
