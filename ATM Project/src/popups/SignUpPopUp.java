package popups;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.SignUp;

public class SignUpPopUp {

	public static void addingName() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Checkout Percentage");
		window.setMinWidth(250);
		System.out.println();
		
		Label firstNameLabel = new Label("First Name");
		Label surnameLabel = new Label("Surname");
		Label cardNoLabel = new Label("Card Number");
		Label pinLabel = new Label("Pin");
		
		TextField firstName = new TextField();
		TextField surname = new TextField();
		TextField cardNo = new TextField();
		TextField pin = new TextField();
				
		Button submit = new Button("Submit");
		
		HBox hBox1 = new HBox();
		HBox hBox2 = new HBox();
		HBox hBox3 = new HBox();
		HBox hBox4 = new HBox();
		VBox layout = new VBox();

		hBox1.getChildren().addAll(firstNameLabel, firstName);
		hBox2.getChildren().addAll(surnameLabel, surname);
		hBox3.getChildren().addAll(cardNoLabel,cardNo);
		hBox4.getChildren().addAll(pinLabel,pin);
		layout.getChildren().addAll(hBox1, hBox2, hBox3, hBox4,submit);
		layout.setAlignment(Pos.CENTER);
		
		submit.setOnAction(e->{
			String fullName = firstName.getText() + " " + surname.getText();
			boolean accountCreated = SignUp.creatingAccount(cardNo,pin, fullName);
			if(accountCreated)
				window.close();
		});
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		// Used alongside initmodality above
		window.showAndWait();
	}
}
