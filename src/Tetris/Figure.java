package Tetris;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Figure {

	// Types of figures
	enum FigureType {
		I, J, L, O, S, T, Z
	};

	// Rotations
	enum Rotate {
		Angle0, Angle90, Angle180, Angle270
	};

	// Bricks from which figure consist
	private List<Brick> bricks = new ArrayList<>();
	private Rotate rotation;
	private FigureType type;
	private Pane gamePane;
	private int x = 6; // Start coordinates of a figure
	private int y = 0;

	/*
	 * Width and Height of a figure For example, width of an I figure in
	 * vertical position is 1 and height is 4 "I" figure in horizontal position
	 * has width that equals 4 and height equals 1
	 */
	private int width = 0;
	private int height = 0;

	private int sizeField; // Game field in pixels
	private int squareSize; // Size of one square

	public Figure(FigureType type, Rotate rotation, Pane gamePane, int squareSize, int sizeField) {
		super();

		this.rotation = rotation;
		this.type = type;
		this.gamePane = gamePane;
		this.squareSize = squareSize;
		this.sizeField = sizeField;

		createFigure();

	}

	public Figure(FigureType type, Rotate rotation, Pane gamePane, int x, int y, int squareSize, int sizeField) {
		super();

		this.rotation = rotation;
		this.type = type;
		this.gamePane = gamePane;
		this.squareSize = squareSize;
		this.sizeField = sizeField;

		this.x = x;
		this.y = y;

		createFigure();

	}

	private void createFigure() {
		Color color;
		switch (type) {
		case I:
			color = Color.RED;
			makeI(gamePane, color);
			break;
		case J:
			color = Color.YELLOW;
			makeJ(gamePane, color);
			break;
		case L:
			color = Color.MAGENTA;
			makeL(gamePane, color);
			break;
		case O:
			color = Color.BLUE;
			makeO(gamePane, color);
			break;
		case S:
			color = Color.CYAN;
			makeS(gamePane, color);
			break;
		case T:
			color = Color.LIME;
			makeT(gamePane, color);
			break;
		case Z:
			color = Color.ORANGE;
			makeZ(gamePane, color);
			break;
		}
	}

	// Make I

	private void makeI(Pane gamePane, Color color) {
		switch (rotation) {
		case Angle0:
			makeIRot0(gamePane, color);
			width = 4;
			height = 1;
			break;
		case Angle90:
			makeIRot90(gamePane, color);
			width = 1;
			height = 4;
			break;
		case Angle180:
			makeIRot180(gamePane, color);
			width = 4;
			height = 1;
			break;
		case Angle270:
			makeIRot270(gamePane, color);
			width = 1;
			height = 4;
			break;
		}
	}

	private void makeIRot0(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(3 + x, 0 + y, squareSize, gamePane, color));
	}

	private void makeIRot90(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 2 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 3 + y, squareSize, gamePane, color));
	}

	private void makeIRot180(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(3 + x, 0 + y, squareSize, gamePane, color));
	}

	private void makeIRot270(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 2 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 3 + y, squareSize, gamePane, color));
	}

	// Make J

	private void makeJ(Pane gamePane, Color color) {
		switch (rotation) {
		case Angle0:
			makeJRot0(gamePane, color);
			width = 3;
			height = 2;
			break;
		case Angle90:
			makeJRot90(gamePane, color);
			width = 2;
			height = 3;
			break;
		case Angle180:
			makeJRot180(gamePane, color);
			width = 3;
			height = 2;
			break;
		case Angle270:
			makeJRot270(gamePane, color);
			width = 2;
			height = 3;
			break;
		}
	}

	private void makeJRot0(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeJRot90(Pane gamePane, Color color) {
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 2 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 2 + y, squareSize, gamePane, color));
	}

	private void makeJRot180(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeJRot270(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 2 + y, squareSize, gamePane, color));
	}

	// Make L

	private void makeL(Pane gamePane, Color color) {
		switch (rotation) {
		case Angle0:
			makeLRot0(gamePane, color);
			width = 3;
			height = 2;
			break;
		case Angle90:
			makeLRot90(gamePane, color);
			width = 2;
			height = 3;
			break;
		case Angle180:
			makeLRot180(gamePane, color);
			width = 3;
			height = 2;
			break;
		case Angle270:
			makeLRot270(gamePane, color);
			width = 2;
			height = 3;
			break;
		}
	}

	private void makeLRot0(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeLRot90(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 2 + y, squareSize, gamePane, color));
	}

	private void makeLRot180(Pane gamePane, Color color) {
		bricks.add(new Brick(2 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeLRot270(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 2 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 2 + y, squareSize, gamePane, color));
	}

	// Make O

	private void makeO(Pane gamePane, Color color) {
		switch (rotation) {
		case Angle0:
			makeORot0(gamePane, color);
			width = 2;
			height = 2;
			break;
		case Angle90:
			makeORot90(gamePane, color);
			width = 2;
			height = 2;
			break;
		case Angle180:
			makeORot180(gamePane, color);
			width = 2;
			height = 2;
			break;
		case Angle270:
			makeORot270(gamePane, color);
			width = 2;
			height = 2;
			break;
		}
	}

	private void makeORot0(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeORot90(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeORot180(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeORot270(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
	}

	// Make S

	private void makeS(Pane gamePane, Color color) {
		switch (rotation) {
		case Angle0:
			makeSRot0(gamePane, color);
			width = 3;
			height = 2;
			break;
		case Angle90:
			makeSRot90(gamePane, color);
			width = 2;
			height = 3;
			break;
		case Angle180:
			makeSRot180(gamePane, color);
			width = 3;
			height = 2;
			break;
		case Angle270:
			makeSRot270(gamePane, color);
			width = 2;
			height = 3;
			break;
		}
	}

	private void makeSRot0(Pane gamePane, Color color) {
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeSRot90(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 2 + y, squareSize, gamePane, color));
	}

	private void makeSRot180(Pane gamePane, Color color) {
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeSRot270(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 2 + y, squareSize, gamePane, color));
	}

	// Make T

	private void makeT(Pane gamePane, Color color) {
		switch (rotation) {
		case Angle0:
			makeTRot0(gamePane, color);
			width = 3;
			height = 2;
			break;
		case Angle90:
			makeTRot90(gamePane, color);
			width = 2;
			height = 3;
			break;
		case Angle180:
			makeTRot180(gamePane, color);
			width = 3;
			height = 2;
			break;
		case Angle270:
			makeTRot270(gamePane, color);
			width = 2;
			height = 3;
			break;
		}
	}

	private void makeTRot0(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeTRot90(Pane gamePane, Color color) {
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 2 + y, squareSize, gamePane, color));
	}

	private void makeTRot180(Pane gamePane, Color color) {
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeTRot270(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 2 + y, squareSize, gamePane, color));
	}

	// Make Z

	private void makeZ(Pane gamePane, Color color) {
		switch (rotation) {
		case Angle0:
			makeZRot0(gamePane, color);
			width = 3;
			height = 2;
			break;
		case Angle90:
			makeZRot90(gamePane, color);
			width = 2;
			height = 3;
			break;
		case Angle180:
			makeZRot180(gamePane, color);
			width = 3;
			height = 2;
			break;
		case Angle270:
			makeZRot270(gamePane, color);
			width = 2;
			height = 3;
			break;
		}
	}

	private void makeZRot0(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeZRot90(Pane gamePane, Color color) {
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 2 + y, squareSize, gamePane, color));
	}

	private void makeZRot180(Pane gamePane, Color color) {
		bricks.add(new Brick(0 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(2 + x, 1 + y, squareSize, gamePane, color));
	}

	private void makeZRot270(Pane gamePane, Color color) {
		bricks.add(new Brick(1 + x, 0 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(1 + x, 1 + y, squareSize, gamePane, color));
		bricks.add(new Brick(0 + x, 2 + y, squareSize, gamePane, color));
	}

	// Moves

	public void moveUp() {
		y -= 1;
		for (Brick brick : bricks) {
			brick.moveUp();
		}
	}

	public void moveDown() {
		y += 1;
		for (Brick brick : bricks) {
			brick.moveDown();
		}
	}

	public void moveLeft() {
		x -= 1;
		if (x < 0) {
			x += 1;
		} else {
			for (Brick brick : bricks) {
				brick.moveLeft();
			}
		}
	}

	public void moveRight() {
		x += 1;
		if (x + width > sizeField) {
			x -= 1;
		} else {
			for (Brick brick : bricks) {
				brick.moveRight();
			}
		}
	}

	// Rotation

	public void rotate() {
		// Change rotation if it is possible. It is not possible if a figure
		// after rotation will beyond
		// If it is not possible, function will end with "return;" command
		switch (rotation) {
		case Angle0:
			if (x + height > sizeField || y + width > sizeField) {
				return;
			}
			rotation = Rotate.Angle90;
			break;
		case Angle90:
			if (x + height > sizeField || y + width > sizeField) {
				return;
			}
			rotation = Rotate.Angle180;
			break;
		case Angle180:
			if (x + height > sizeField || y + width > sizeField) {
				return;
			}
			rotation = Rotate.Angle270;
			break;
		case Angle270:
			if (x + height > sizeField || y + width > sizeField) {
				return;
			}
			rotation = Rotate.Angle0;
			break;
		}

		// Delete bricks from Pane and from list
		for (Brick brick : bricks) {
			gamePane.getChildren().remove(brick.getRectangle());
		}

		bricks.clear();

		// Create new figure in chosen position
		Color color;
		switch (type) {
		case I:
			color = Color.RED;
			makeI(gamePane, color);
			break;
		case J:
			color = Color.YELLOW;
			makeJ(gamePane, color);
			break;
		case L:
			color = Color.MAGENTA;
			makeL(gamePane, color);
			break;
		case O:
			color = Color.BLUE;
			makeO(gamePane, color);
			break;
		case S:
			color = Color.CYAN;
			makeS(gamePane, color);
			break;
		case T:
			color = Color.LIME;
			makeT(gamePane, color);
			break;
		case Z:
			color = Color.ORANGE;
			makeZ(gamePane, color);
			break;
		}

	}

	// Getters and setters

	public List<Brick> getBricks() {
		return bricks;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rotate getRotation() {
		return rotation;
	}

	public FigureType getType() {
		return type;
	}

}
