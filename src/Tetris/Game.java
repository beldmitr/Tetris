package Tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {

	private final int WIDTH = 640;
	private final int HEIGHT = 480;

	private StackPane root; // main pane
	private Scene scene; // scene
	private Pane gamePane; // all graphics is drawn to this pane

	private GameState gameState; // Game logic
	private Button btnStart; // Button that start game

	@Override
	public void start(Stage primaryStage) {
		root = new StackPane();
		gamePane = new Pane();

		btnStart = new Button("Start");

		gameState = new GameState(gamePane, HEIGHT);
		// if game is over, show Start button
		btnStart.visibleProperty().bind(gameState.isPlaying().not());
		btnStart.setScaleX(2);
		btnStart.setScaleY(2);

		btnStart.setOnAction(e -> {
			gameState.start(); // on click starts the game
		});
		root.getChildren().add(gamePane);
		root.getChildren().add(btnStart);

		scene = new Scene(root, WIDTH, HEIGHT);
		// Listen key pressing
		scene.setOnKeyPressed(gameState::dispatcherKeyEvent);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Tetris");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
