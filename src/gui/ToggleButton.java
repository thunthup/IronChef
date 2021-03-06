package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;

public class ToggleButton extends ImageView {
	private boolean toggleState;
	private String onhighlightURL;
	private String offhighlightURL;

	public ToggleButton(String onURL, String onhighlightURL, String offURL, String offhighlightURL, Pane root, double x,
			double y) {
		super();
		this.toggleState = true;
		this.onhighlightURL = onhighlightURL;
		this.offhighlightURL = offhighlightURL;
		this.setImage(new Image(ClassLoader.getSystemResource(onURL).toString()));
		this.setOnMouseEntered(e -> {
			if (toggleState) {
				this.setImage(new Image(ClassLoader.getSystemResource(onhighlightURL).toString()));
			} else {
				this.setImage(new Image(ClassLoader.getSystemResource(offhighlightURL).toString()));
			}
			new AudioClip(ClassLoader.getSystemResource("sound/uisound.wav").toString()).play();
		});
		this.setOnMouseExited(e -> {
			if (toggleState) {
				this.setImage(new Image(ClassLoader.getSystemResource(onURL).toString()));
			} else {
				this.setImage(new Image(ClassLoader.getSystemResource(offURL).toString()));
			}
		});
		this.setX(x);
		this.setY(y);
		root.getChildren().add(this);

	}

	public void update() {
		if (toggleState) {
			this.setImage(new Image(ClassLoader.getSystemResource(onhighlightURL).toString()));
		} else {
			this.setImage(new Image(ClassLoader.getSystemResource(offhighlightURL).toString()));
		}
		new AudioClip(ClassLoader.getSystemResource("sound/uisound.wav").toString()).play();

	}

	public boolean getToggleState() {
		return toggleState;
	}

	public void setToggleState(boolean toggleState) {
		this.toggleState = toggleState;
	}
}
