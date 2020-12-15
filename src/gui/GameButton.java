package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;

public class GameButton extends ImageView {

	public GameButton(String img,String imghighlight,Pane root,double x,double y) {
		super();
		this.setImage(new Image(ClassLoader.getSystemResource(img).toString()));
		this.setCache(true);
		this.setOnMouseEntered(e -> {
			this.setImage(new Image(ClassLoader.getSystemResource(imghighlight).toString()));
			new AudioClip(ClassLoader.getSystemResource("sound/uisound.wav").toString()).play();
		});
		this.setOnMouseExited(e -> 	this.setImage(new Image(ClassLoader.getSystemResource(img).toString())));

		this.setX(x);
		this.setY(y);
		this.setPreserveRatio(true);
		root.getChildren().add(this);
	}
}
