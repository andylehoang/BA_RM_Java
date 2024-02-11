package application;

import java.text.ParseException;
import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Hello World");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Lebensmittel a = new Lebensmittel("Mineralwasser", 0.4, 0.89, "13-01-2024");
		System.out.println(a.getId());
		Sonstige b = new Sonstige("DVD",1.2 ,3.4, 18);
		System.out.println(b.getId());
		launch(args);
	}
}
