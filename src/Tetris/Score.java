package Tetris;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score {

	private int score = 0;
	private Text text;

	private int MARGIN_LEFT = 10; // Text position
	private int MARGIN_TOP = 30;

	public Score(Pane gamePane, int size) {
		super();

		text = new Text(size + MARGIN_LEFT, MARGIN_TOP, "Score : " + Integer.toString(score));
		text.setFont(Font.font(28));
		gamePane.getChildren().add(text);
	}

	public void increaseScore() {
		score++;
		text.setText("Score : " + Integer.toString(score));
	}

	public void resetScore() {
		score = 0;
		text.setText("Score : " + Integer.toString(score));
	}

	public int getScore() {
		return score;
	}

}
