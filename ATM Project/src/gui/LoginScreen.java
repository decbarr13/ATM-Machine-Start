package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.SignIn;
import logic.SignUp;

public class LoginScreen extends Application {
	
	private static int MAX_FONT_SIZE = 50;

	public void createWindow(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stageOne) throws Exception {
		//Creating window
		Stage window = stageOne;
		window.setTitle("ATM Machine");
		window.setMinHeight(600);
		window.setMinWidth(600);
		
		//Layouts
		VBox layout = new VBox();
		HBox pinLayout = new HBox();
		HBox cardNoLayout = new HBox();
		HBox buttonLayout = new HBox();
		HBox welcomeLayout = new HBox();

		
		//Scene Creation
		Scene scene = new Scene(layout);

		//Items on screen
		Label welcomeLabel = new Label("Welcome to your ATM");
		welcomeLabel.setFont(new Font("Arial", MAX_FONT_SIZE));
		Label cardNo = new Label("Card Number:");
		Label pin = new Label("PIN:");
		TextField userInputCardNo = new TextField();
		TextField userInputPin = new TextField();
		Button signIn = new Button("Sign In");
		Button clear = new Button("Clear");
		Button signUp = new Button("Sign Up");
		
		// Styling items
		welcomeLayout.setAlignment(Pos.CENTER);
		addPadding(welcomeLayout);
		pinLayout.setAlignment(Pos.CENTER);
		addPadding(pinLayout);
		cardNoLayout.setAlignment(Pos.CENTER);
		addPadding(cardNoLayout);
		buttonLayout.setAlignment(Pos.CENTER);
		addPadding(buttonLayout);
		
		
		//Linking items to layouts
		welcomeLayout.getChildren().add(welcomeLabel);
		pinLayout.getChildren().addAll(pin,userInputPin);
		cardNoLayout.getChildren().addAll(cardNo,userInputCardNo);
		buttonLayout.getChildren().addAll(signIn,clear,signUp);
		layout.getChildren().addAll(welcomeLayout,cardNoLayout,pinLayout,buttonLayout);
		window.setScene(scene);
		window.show();
		
		//Action Handlers
		
		signUp.setOnAction(e-> SignUp.creatingAccount(userInputCardNo,userInputPin));
		signIn.setOnAction(e-> SignIn.checkingLoginDetails(userInputCardNo,userInputPin));
		clear.setOnAction(e->{
			userInputCardNo.clear();
			userInputPin.clear();
		});

	}
	
	public static void addPadding(HBox layout) {
		layout.setPadding(new Insets(10, 100, 10, 100));
		layout.setMinHeight(100);
	}

}
