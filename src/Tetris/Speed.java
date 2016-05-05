package Tetris;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Speed {
	// Every SPEED_PER_SCORE scores speed will increase
	private final int SPEED_PER_SCORE = 50;
	private final int START_SPEED = 10;

	/*
	 * Variable speed is a frame DIVIDER, so the real speed of game as bigger,
	 * as variable speed is less; MIN_SPEED bounds speed, so speed can be
	 * between START_SPEED and MAX_SPEED
	 * 
	 */
	private final int MAX_SPEED = 5;

	private int speed = START_SPEED; // At the begin speed is START_SPEED
	private Text text;

	private int MARGIN_LEFT = 10; // Text position
	private int MARGIN_TOP = 60;

	public Speed(Pane gamePane, int size) {
		super();

		text = new Text(size + MARGIN_LEFT, MARGIN_TOP, "Speed : " + Integer.toString(START_SPEED - speed));
		text.setFont(Font.font(28));
		gamePane.getChildren().add(text);
	}

	public void increaseSpeed() {
		speed--; // Game is as faster, as variable speed is less
		if (speed < MAX_SPEED) {
			speed = MAX_SPEED;
		}
		text.setText("Speed : " + Integer.toString(START_SPEED - speed));
	}

	public void resetSpeed() {
		speed = START_SPEED;
		text.setText("Speed : " + Integer.toString(START_SPEED - speed));
	}

	public int getSpeed() {
		return speed;
	}

	// Every SPEED_PER_SCORE score game will become faster
	public int getSPEED_PER_SCORE() {
		return SPEED_PER_SCORE;
	}

}
