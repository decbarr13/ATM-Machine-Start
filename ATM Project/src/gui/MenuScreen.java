package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.Accounts;

public class MenuScreen {

	public static void start(Accounts account) {
		Stage window = new Stage();
		window.setTitle("ATM Machine");
		window.setMinHeight(600);
		window.setMinWidth(600);
		
		BorderPane layout = new BorderPane();
		HBox topLayer = new HBox();
		GridPane centreLayer= new GridPane();
		
		Label welcome = new Label("Welcome " + account.getName());
		topLayer.getChildren().add(welcome);
		
		Button add = new Button("Deposit Money");
		centreLayer.add(add, 0, 0);
		Button withdraw = new Button("Withdraw Money");
		centreLayer.add(withdraw, 1,0);
		Button transfer = new Button("Transfer money");
		centreLayer.add(transfer, 0, 1);
		Button history = new Button("Account History");
		centreLayer.add(history, 1, 1);
		Button quit = new Button("Quit");
		centreLayer.add(quit, 2, 0);
		
		layout.setTop(topLayer);
		layout.setCenter(centreLayer);
		
		add.setOnAction(e-> account.addMoney());
		withdraw.setOnAction(e-> account.withdrawMoney());
		transfer.setOnAction(e-> account.transferToNewAccount());
		history.setOnAction(e-> account.getTransactionHistory());
		quit.setOnAction(e-> window.close());
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
		
	}

}
