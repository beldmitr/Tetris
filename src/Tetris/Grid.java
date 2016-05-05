package Tetris;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Grid {

	private List<Line> lines = new ArrayList<>();
	
	/* 
	 * Lines width.
	 * If widthLine is less then 2, then JavaFX draws lines the same width as 2.0, but with less opacity.
	 */
	private final double widthLine = 2.0;
	
	private Pane gamePane;	// Grid is drawn to this pane

	public Grid(int size, int square, Pane gamePane) {
		super();

		this.gamePane = gamePane;

		for (int i = 0; i < (int) (size / square) + 1; i++) {
			Line vertical = new Line(i * square, 0 , i * square,
					size);
			vertical.setStrokeWidth(widthLine);

			Line horizontal = new Line(0, i * square, size,
					i * square);
			horizontal.setStrokeWidth(widthLine);

			lines.add(vertical);
			lines.add(horizontal);
		}
	}

	public void show(boolean isShow) {
		if (isShow) {
			for (Line line : lines) {
				gamePane.getChildren().add(line);
			}
		} else {
			for (Line line : lines) {
				gamePane.getChildren().remove(line);
			}
		}
	}

}
