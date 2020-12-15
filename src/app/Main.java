package app;

import org.graalvm.compiler.nodes.InliningLog.UpdateScope;

import gui.GameButton;
import gui.ToggleButton;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	final static int HEIGHT = 700;
	final static int WIDGTH = 1000;

	private void gameScreenStart(Stage stage) {
		Pane root = new Pane();
		root.setPrefSize(WIDGTH, HEIGHT);
		root.setMinSize(WIDGTH, HEIGHT);
		Scene gamescene = new Scene(root);
		ImageView gameScreenBackground = new ImageView(
				new Image(ClassLoader.getSystemResource("GameScreenBG.png").toString()));
		root.getChildren().add(gameScreenBackground);
		stage.setScene(gamescene);
		stage.show();
		
//		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),e->{
//			updateIngredients();
//		}));
	}

	private void menuStart(Stage stage) {
		
		AnchorPane root = new AnchorPane();
		root.setPrefSize(1000, 700);
		root.setMinSize(1000, 700);

		Image bg = new Image(ClassLoader.getSystemResource("menubg.png").toString());
		ImageView bgi = new ImageView(bg);
		root.getChildren().add(bgi);
		Scene menuScene = new Scene(root, 1000, 700);
	
		
		GameButton play = new GameButton("playbutton.png", "playbuttonhighlight.png", root, 362, 400);
		play.setOnMouseClicked(e -> gameScreenStart(stage));

		GameButton exit = new GameButton("exitButton.png", "exitButtonhighlight.png", root, 362, 520);
		exit.setOnMouseClicked(e -> stage.close());

		AudioClip bgMusic = new AudioClip(ClassLoader.getSystemResource("sound/bgMusic.mp3").toString());
		bgMusic.setCycleCount(AudioClip.INDEFINITE);
		bgMusic.setVolume(0.035D);
		bgMusic.play();

		ToggleButton bgMusicButton = new ToggleButton("bgMusicButton.png", "bgMusicButtonhighlight.png",
				"bgMusicOffButton.png", "bgMusicOffButtonhighlight.png", root, 866, 578);

		bgMusicButton.setOnMouseClicked(e -> {
			bgMusicButton.setToggleState((!bgMusicButton.getToggleState()));
			if (bgMusicButton.getToggleState()) {
				bgMusic.play();
			} else {
				bgMusic.stop();
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
