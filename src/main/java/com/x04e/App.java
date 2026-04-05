package com.x04e;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
		WebView web = new WebView();

		System.out.println("Java Version: "+ System.getProperty("java.version"));
		System.out.println("JavaFX Version: "+ System.getProperty("javafx.version"));
		System.out.println("WebView Version: "+ web.getEngine().getUserAgent());

		web.getEngine().load("https://google.com");
		//web.getEngine().loadContent("<!DOCTYPE html><head><style>*{box-sizing: border-box;} html,body{box-sizing:border-box;height:100%;width:100%;background-color:red;}</style></head><html><body>Hello World!</body></html>", "text/html");

		web.getEngine().getLoadWorker().exceptionProperty().addListener(new ChangeListener<Throwable>(){
			@Override
			public void changed(ObservableValue<? extends Throwable> observable, Throwable oldValue, Throwable newValue) {
				System.out.print("LoadWorkerError: ");
				newValue.printStackTrace();
			}
		});

        stage.setScene(new Scene(new StackPane(web), 800, 600));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}