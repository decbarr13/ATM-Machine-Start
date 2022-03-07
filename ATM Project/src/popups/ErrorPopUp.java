package popups;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorPopUp {

	

	public static void showError(String errorLabel) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Checkout Percentage");
		window.setMinWidth(250);
		
		Label error = new Label(errorLabel);
		HBox layout = new HBox();
		layout.getChildren().add(error);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		// Used alongside initmodality above
		window.showAndWait();
	}
	
}
