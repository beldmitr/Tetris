/*
 * Figures are made from bricks 
 */

package Tetris;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick {

	private Rectangle rect;
	private int size; // size of brick

	private int x = 0;
	private int y = 0;

	public Brick(int x, int y, int size, Pane gamePane, Color color) {
		super();

		this.x = x;
		this.y = y;
		this.size = size;

		rect = new Rectangle(size - 2, size - 2);
		rect.setX(x * size + 1);
		rect.setY(y * size + 1);
		rect.setFill(color);

		gamePane.getChildren().add(rect);
	}

	// Moves.
	// It moves not by pixels, but by steps

	public void moveUp() {
		y -= 1;
		rect.setY(y * size + 1);
	}

	public void moveDown() {
		y += 1;
		rect.setY(y * size + 1);
	}

	public void moveLeft() {
		x -= 1;
		rect.setX(x * size + 1);
	}

	public void moveRight() {
		x += 1;
		rect.setX(x * size + 1);
	}

	// Getters and Setters

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Rectangle getRectangle() {
		return rect;
	}
}
