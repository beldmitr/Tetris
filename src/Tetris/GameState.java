/*
 * Here is a game logic
 */

package Tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Tetris.Figure.FigureType;
import Tetris.Figure.Rotate;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameState {

	private Pane gamePane; // Everything is drawn to this pane
	private Grid grid;
	private Timeline timeline;
	private final int DELAY = 50; // ms

	private int index = 0; // number of frame. It use for dividing frame
							// duration

	private KeyFrame update;
	private Figure actFigure; // Active figure, that was created and falls down
	private Figure nextFigure; // Next figure

	// List of bricks that fell down and they are on the game field
	private List<Brick> bricksOnTable;

	// It is false if it is a game over, and true if game is playing
	private BooleanProperty isPlaying = new SimpleBooleanProperty(false);

	private Score score; // Count score and draws itself on the Pane
	private int sizeFieldPx; // Size of the game field in pixels
	private final int SQUARE_SIZE = 32;

	private int nextFigureX; // Defines where the next figure will be show (not
								// in pixels)
	private int nextFigureY;

	private int sizeField; // Size of the game field
	private boolean paused = false;
	private Speed speed; // Speed of the game. It is divider, divides frames

	public GameState(Pane gamePane, int sizeFieldPx) {

		this.sizeFieldPx = sizeFieldPx;
		this.gamePane = gamePane;

		sizeField = sizeFieldPx / SQUARE_SIZE;

		nextFigureX = sizeField + 1;
		nextFigureY = 5;

		grid = new Grid(sizeFieldPx, SQUARE_SIZE, gamePane);
	}

	public void start() {
		paused = false;
		grid.show(true);
		isPlaying.set(true);
		actFigure = null;
		bricksOnTable = new ArrayList<>();
		score = new Score(gamePane, sizeFieldPx);
		speed = new Speed(gamePane, sizeFieldPx);
		timeline = new Timeline();
		update = new KeyFrame(Duration.millis(DELAY), e -> {
			// Game is updated every speed.getSpeed() frames
			if (index % speed.getSpeed() == 0) {
				checkFullRow();
				if (actFigure == null) {
					// If active figure is not created, it creates
					createFigure();
				} else { // else active figure will fall down
					checkMovingDown();
					// function checkMovingDown(); can make active figure equals
					// null.
					// This means that figure fell down
					// So here is an if condition.
					if (actFigure != null) {
						actFigure.moveDown();
					}
				}
			}
			index += 1;
		});

		timeline.getKeyFrames().add(update);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

	}

	/*
	 * Dispatcher of key events
	 */
	public void dispatcherKeyEvent(KeyEvent e) {

		if (e.getCode() == KeyCode.P) {
			if (paused) { // if the game was paused, continue game
				timeline.play();
				paused = false;
			} else { // else pause game
				timeline.stop();
				paused = true;
			}
		}

		// You can ride figure only if it is an active figure, game is going and
		// game is not paused.
		if (actFigure != null && isPlaying.get() && !paused) {
			switch (e.getCode()) {
			case DOWN:
				checkMovingDown();
				if (actFigure != null) {
					actFigure.moveDown();
				}
				break;
			case LEFT:
				actFigure.moveLeft();
				checkMovingLeft();
				break;
			case RIGHT:
				actFigure.moveRight();
				checkMovingRight();
				break;
			case SPACE:
				actFigure.rotate();
				break;
			default:
				break;
			}
		}
	}

	// Creates an figure
	private void createFigure() {
		// It is for random choosing a type of a new figure and it's rotation
		Random random = new Random();
		int size = FigureType.values().length;
		FigureType[] values = Figure.FigureType.values();

		int sizeRotation = Rotate.values().length;
		Rotate[] valuesRotation = Rotate.values();

		if (nextFigure == null) {

			nextFigure = new Figure(values[random.nextInt(size)], valuesRotation[random.nextInt(sizeRotation)],
					gamePane, nextFigureX, nextFigureY, SQUARE_SIZE, sizeField);

			actFigure = new Figure(values[random.nextInt(size)], valuesRotation[random.nextInt(sizeRotation)], gamePane,
					SQUARE_SIZE, sizeField);

		} else {

			// Removes nextFigure from Pane, so it will not be drawn
			// After will be created new nextFigure and activeFigure
			for (Brick brick : nextFigure.getBricks()) {
				gamePane.getChildren().remove(brick.getRectangle());
			}

			actFigure = new Figure(nextFigure.getType(), nextFigure.getRotation(), gamePane, SQUARE_SIZE, sizeField);

			nextFigure = new Figure(values[random.nextInt(size)], valuesRotation[random.nextInt(sizeRotation)],
					gamePane, nextFigureX, nextFigureY, SQUARE_SIZE, sizeField);

		}

		// Check if there is no place for creation a new figure
		for (Brick brick : actFigure.getBricks()) {
			for (Brick onTable : bricksOnTable) {
				if (brick.getX() == onTable.getX() && brick.getY() == onTable.getY()) {
					gameOver();
				}
			}
		}
	}

	private void gameOver() {
		timeline.stop();
		isPlaying.set(false);
		gamePane.getChildren().clear();
	}

	// Check if a row is full
	private void checkFullRow() {
		for (int i = sizeField; i >= 0; i--) {
			int sum = 0;
			List<Brick> row = new ArrayList<>();
			for (Brick brick : bricksOnTable) {
				if (brick.getY() == i) {
					sum += 1;
					row.add(brick);
				}
			}

			// If row is full
			if (sum == sizeField) {
				deleteRow(row); // delete this full row
				moveRowsDown(i); // and moves all top rows down
				score.increaseScore(); // increase score
				// speed of the game will increase every
				// speed.getSPEED_PER_SCORE() scores
				if (score.getScore() % speed.getSPEED_PER_SCORE() == 0) {
					speed.increaseSpeed();
				}
			}
		}
	}

	// Delete full row
	private void deleteRow(List<Brick> row) {
		for (Brick brick : row) {
			bricksOnTable.remove(brick); // delete bricks
			// and from drawing panel
			gamePane.getChildren().remove(brick.getRectangle());
		}
	}

	private void moveRowsDown(int rowNumber) {
		for (int j = 0; j < bricksOnTable.size(); j++) {
			if (bricksOnTable.get(j).getY() < rowNumber) {
				bricksOnTable.get(j).moveDown();
			}
		}

	}

	// Check collisions on moving left
	private void checkMovingLeft() {
		for (Brick brick : bricksOnTable) {
			for (Brick brickFigure : actFigure.getBricks()) {
				if (brickFigure.getY() == brick.getY() && brickFigure.getX() == brick.getX()) {
					actFigure.moveRight();
				}
			}
		}
	}

	// Check collisions on moving right
	private void checkMovingRight() {
		for (Brick brick : bricksOnTable) {
			for (Brick brickFigure : actFigure.getBricks()) {
				if (brickFigure.getY() == brick.getY() && brickFigure.getX() == brick.getX()) {
					actFigure.moveLeft();
				}
			}
		}
	}

	// Check collisions on moving down
	private void checkMovingDown() {

		if (actFigure.getY() + actFigure.getHeight() > sizeField - 1) {
			/*
			 * if active figure fell down to bottom then add bricks from which
			 * this figure is made to list bricksOnTable and make active figure
			 * equals null
			 */

			for (Brick brick : actFigure.getBricks()) {
				bricksOnTable.add(brick);
			}
			actFigure = null;

		} else {
			/*
			 * if active figure fell down to some other brick then add bricks
			 * from which this figure is made to list bricksOnTable and make
			 * active figure equals null
			 */

			boolean flag = false;
			for (Brick brick : bricksOnTable) {
				for (Brick brickFigure : actFigure.getBricks()) {
					if (brickFigure.getY() == brick.getY() - 1 && brickFigure.getX() == brick.getX()) {
						flag = true;
					}
				}
			}
			if (flag) {
				for (Brick brick : actFigure.getBricks()) {
					bricksOnTable.add(brick);
				}
				actFigure = null;
			}
		}
	}

	// if game is going and it is not game over
	public BooleanProperty isPlaying() {
		return isPlaying;
	}

}
