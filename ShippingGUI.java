/**********************************************************************************
* class ShippingGUI
*  An example of JavaFX basics.
* Author: Corey Lucas
* Last Modified: october 19, 2015
* clucas0044@kctcs.edu
***********************************************************************************/


//import statements to include in every JavaFX GUI class
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import statement specific to only this example
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;

import javafx.geometry.Pos;

import javafx.scene.paint.Color;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.Modality;



//every JavaFX GUI is a subclass of Application
public class ShippingGUI extends Application {
	//@Override //Override the start method in the Application class
	
	private Label firstNameLabel;
	private Label lastNameLabel;
	private Label emailLabel;
	private Label quantityLabel;
	
	private TextField firstNameTextField;
	private TextField lastNameTextField;
	private TextField emailTextField;
	private TextField quantityTextField;
	
	private GridPane inputGrid;
	
	private RadioButton expressRadioButton;
	private RadioButton regularRadioButton;
	private RadioButton overnightRadioButton;
	
	private ToggleGroup shippingGroup;
	
	private VBox radioVBox;
	
	private GridPane topGrid;
	
	private TextArea outputTextArea;
	
	private Button submitButton;
	private Button clearButton;
	private Button exitButton;
	
	private ShippingHandler handler;
	
	private HBox buttonsHBox;
	
	private BorderPane mainPane;
	
	private Stage messageWindow;
	private Label messageLabel;
	private Button messageOKButton;
	private Button messageCancelButton;
	
	private VBox messageBox;
	
	private Scene messageScene;
	
	private String firstName;
	private String lastName;
	private String email;
	private int quantity;
		
	
	//provide the start() method in every JavaFX GUI
	public void start(Stage primaryStage) {
		
		createMessageWindow();
		createInputComponents();
		createOutputComponents();
		createButtons();
		
		createWindow();
		
		
		Scene scene = new Scene(mainPane, 400, 500);
		
		//set windows title
		primaryStage.setTitle("Drone Delivery");
		
		//set the Stage's current scene to be the one we just new built
		primaryStage.setScene(scene);
		
		//show the stage
		primaryStage.show();
	
	} // end of start method
	
	private void createMessageWindow() {
		
		messageLabel = new Label("Are you sure?");
		messageOKButton = new Button("Yes");
		messageCancelButton = new Button("No");
		
		messageBox = new VBox (15);
		
		messageBox.getChildren().add(messageLabel);
		messageBox.getChildren().add(messageOKButton);
		messageBox.getChildren().add(messageCancelButton);
		
		messageScene = new Scene(messageBox, 150, 300);
		
		messageWindow = new Stage();
		
		messageWindow.setScene(messageScene);
		
		messageWindow.initModality(Modality.APPLICATION_MODAL);
		
	}
	
	private void createInputComponents() {
	
		firstNameLabel = new Label("First Name");
		lastNameLabel = new Label("Last Name");
		emailLabel = new Label("Email");
		quantityLabel = new Label("Quantity");
		
		firstNameTextField = new TextField();
		lastNameTextField = new TextField();
		emailTextField = new TextField();
		quantityTextField = new TextField();
		
		inputGrid = new GridPane();
		inputGrid.setHgap(15);
		inputGrid.setVgap(15);
		
		
		inputGrid.add(firstNameLabel, 0, 0);
		inputGrid.add(firstNameTextField, 1, 0);
		inputGrid.add(lastNameLabel, 0, 1);
		inputGrid.add(lastNameTextField, 1, 1);
		inputGrid.add(emailLabel, 0, 2);
		inputGrid.add(emailTextField, 1, 2);
		inputGrid.add(quantityLabel, 0, 3);
		inputGrid.add(quantityTextField, 1, 3);
		
		
		expressRadioButton = new RadioButton("Express");
		regularRadioButton = new RadioButton("Regular");
		overnightRadioButton = new RadioButton("Overnight");
		
		shippingGroup = new ToggleGroup();
		
		expressRadioButton.setToggleGroup(shippingGroup);
		regularRadioButton.setToggleGroup(shippingGroup);
		overnightRadioButton.setToggleGroup(shippingGroup);
		
		expressRadioButton.setSelected(true);
		
		radioVBox = new VBox(15);
		
		radioVBox.getChildren().add(expressRadioButton);
		radioVBox.getChildren().add(regularRadioButton);
		radioVBox.getChildren().add(overnightRadioButton);
		
		topGrid = new GridPane();
		topGrid.setHgap(20);
		
		topGrid.setAlignment(Pos.CENTER);
		
		topGrid.add(inputGrid, 0, 0);
		topGrid.add(radioVBox, 1, 0);
		
		
		
	}// end of createInputComponents
	
	private void createOutputComponents() {
		
		outputTextArea = new TextArea();
		
		outputTextArea.setEditable(false);
	
	}// end of createOutputComponents
	
	private void createButtons() {
		
		submitButton = new Button ("Submit");
		clearButton = new Button ("Clear");
		exitButton = new Button ("Exit");
		
		submitButton.setPrefSize(100, 50);
		clearButton.setPrefSize(100, 50);
		exitButton.setPrefSize(100, 50);
		
		submitButton.setStyle("-fx-background-color: darksalmon;" +
								"-fx-font-weight: bold;" +
								"-fx-font-size: 20;" +
								"-fx-font-style: italic;");
		
		
		submitButton.setTextFill(Color.DARKOLIVEGREEN);
		clearButton.setTextFill(Color.DARKVIOLET);
		exitButton.setTextFill(Color.INDIANRED);
		
		buttonsHBox = new HBox(25);
		
		buttonsHBox.setAlignment(Pos.CENTER);
		
		buttonsHBox.getChildren().add(submitButton);
		buttonsHBox.getChildren().add(clearButton);
		buttonsHBox.getChildren().add(exitButton);
		
		handler = new ShippingHandler();
		
		submitButton.setOnAction(handler);
		clearButton.setOnAction(handler);
		
		//writing an anonymous event handler class
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae){
				messageWindow.showAndWait();	
			}
			
		});
		
		messageOKButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent ae){
				System.exit(0);		
			}	
		});
		
		//using a lambda expression to create and register an event handler
		messageCancelButton.setOnAction(ae ->{
			messageWindow.hide();	
		});
		
	}// end of createButtons
	
	private void createWindow(){
		
		mainPane = new BorderPane();
		
		mainPane.setTop(topGrid);
		mainPane.setCenter(outputTextArea);
		mainPane.setBottom(buttonsHBox);
		
		
	}// end of createWindow
	
	private class ShippingHandler implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent ae) {
			
			if (ae.getSource() == clearButton) {
				
				firstNameTextField.setText("");
				lastNameTextField.setText("");
				emailTextField.setText("");
				quantityTextField.setText("");
				
				outputTextArea.setText("");
				
				expressRadioButton.setSelected(true);
				
				firstNameTextField.requestFocus();
									
			}
			else if (ae.getSource() == submitButton) {
				
				outputTextArea.setText("");
				
				firstName = firstNameTextField.getText().trim();
				lastName = lastNameTextField.getText().trim();
				email = emailTextField.getText().trim();
				quantity = Integer.parseInt(quantityTextField.getText().trim());
				
				outputTextArea.appendText("\nFirst Name: " + firstName);
				outputTextArea.appendText("\nLast Name: " + lastName);
				outputTextArea.appendText("\nEmail: " + email);
												
				outputTextArea.appendText("\nQuantity: " + quantity);
				
				if(expressRadioButton.isSelected()) {
					outputTextArea.appendText("\nShipping method: Express");	
				}
				else if (regularRadioButton.isSelected()) {
					outputTextArea.appendText("\nShipping method: Regular");	
				}
				else {
					outputTextArea.appendText("\nShipping method: Overnight");	
				}
				
			}/*
			else if (ae.getSource() == exitButton) {
				
				messageWindow.showAndWait();
			}
			
			else if (ae.getSource() == messageOKButton) {
				System.exit(0);	
			}
			else if (ae.getSource() == messageCancelButton) {
				messageWindow.hide();	
			}*/
			
			
		}// end of handle() method	
		
		
	}// end of class ShippingHandler
	

} // end of class
