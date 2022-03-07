package popups;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AccountExistsPopUp {
	public static void showError() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Checkout Percentage");
		window.setMinWidth(250);
		System.out.println();
		
		Label error = new Label("Account Already Exists");
		HBox layout = new HBox();
		layout.getChildren().add(error);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		// Used alongside initmodality above
		window.showAndWait();
	}
	
}
