package v2;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * !!!!!!!!CONNECT THIS TO MONGO!!!!!!!!!!
 * @author Steven Orsini
 * @version 06/10/2020
 */
public class BankGUI extends Application {
	
	BankList banks = new BankList(new Bank("TD Bank"), new Bank("Chase"),
			new Bank("Santander"));
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		BorderPane startPane = new BorderPane();
		mainPage(startPane);
		Scene scene = new Scene(startPane);
		setStage(primaryStage, scene);
	}
	
	/**
	 * 
	 * @param primaryStage
	 * @param scene
	 */
	public void setStage(Stage primaryStage, Scene scene) {
		primaryStage.setWidth(750);
		primaryStage.setHeight(750);
		primaryStage.setMinWidth(750);
		primaryStage.setMinHeight(750);
		primaryStage.setMaxWidth(750);
		primaryStage.setMaxHeight(750);
		
		primaryStage.setTitle("stevensBankApp(boolean isTheBest = true);");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * 
	 * @param startPane
	 */
	public void mainPage(BorderPane startPane) {
		startPane.setStyle("-fx-background-color: LAVENDER");
		
		Label noAccount = new Label("Don't have an account with us?");
		Label startUp = new Label("Enter your credentials to sign in.");
		Label username = new Label("Enter username: ");
		Label pass = new Label("Enter password: ");
		Label pin = new Label("Enter PIN #: ");
		Label bank = new Label("Choose bank: ");
		 
		MenuBar menubar = new MenuBar();
		
		Menu accounts = new Menu("Accounts");
		Menu mySettings = new Menu("My Settings");
		Menu links = new Menu("Page Links");
		Menu aboutUs = new Menu("About Us");
		
		MenuItem openAcct = new MenuItem("Open new account");
		MenuItem switchAccts = new MenuItem("Switch accounts");
		MenuItem removeAcct = new MenuItem("Remove an account");
		MenuItem changeUsername = new MenuItem("Change username");
		MenuItem changePass = new MenuItem("Change password");
		MenuItem changePin = new MenuItem("Change PIN");
		MenuItem mainPage = new MenuItem("Home Page");
		MenuItem loginPage = new MenuItem("Log in");
		MenuItem signupPage = new MenuItem("Sign up");
		MenuItem aboutus = new MenuItem("About Us");
				
		Button signupButton = new Button("Sign up by clicking here!");
		Button exitButton = new Button("Exit");
		Button submitButton = new Button("Submit");
		Button clearButton = new Button("Clear");
		Button showPassword = new Button();

		TextField userUsername = new TextField();

		ComboBox<String> bankOptions = new ComboBox<String>();
		bankOptions.getItems().addAll("TD Bank", "Chase", "Santander");

		PasswordField userPassword = new PasswordField();
		PasswordField userPIN = new PasswordField();
		
		HBox hbox = new HBox();
		HBox hbox1 = new HBox();
		HBox passwordHbox = new HBox(userPassword, showPassword);
		
		VBox menuBar = new VBox(menubar, startUp);
		VBox signupBut = new VBox(noAccount, signupButton);		
		VBox labelVbox = new VBox(username, pass, pin, bank);
		VBox answerVbox = new VBox(userUsername, passwordHbox, userPIN, bankOptions);
		VBox vbox4 = new VBox();
		
		HBox hbox2 = new HBox(signupBut);

		vbox4.getChildren().addAll(hbox2, hbox);
		hbox2.setAlignment(Pos.CENTER);
		vbox4.setSpacing(150);
		
		username.setFont(new Font("Times New Roman", 17));
		pass.setFont(new Font("Times New Roman", 17));
		pin.setFont(new Font("Times New Roman", 17));
		bank.setFont(new Font("Times New Roman", 17));

		userUsername.setPromptText("Enter username");
		userUsername.setMaxWidth(170);
		
		userPassword.setPromptText("Enter password");
		userPassword.setMaxWidth(170);
		
		bankOptions.setPromptText("Choose your bank");
		bankOptions.setMaxWidth(170);
		
		userPIN.setPromptText("Enter PIN");
		userPIN.setMaxWidth(170);
		 
		labelVbox.setPadding(new Insets(12));
		labelVbox.setSpacing(30);

		answerVbox.setPadding(new Insets(12));
		answerVbox.setSpacing(23);
		
		passwordHbox.setSpacing(40);
		 
		menubar.getMenus().addAll(accounts, mySettings, links, aboutUs);
		
		accounts.getItems().addAll(openAcct, new SeparatorMenuItem(), switchAccts, new SeparatorMenuItem(), removeAcct);
		mySettings.getItems().addAll(changeUsername, new SeparatorMenuItem(), changePass, new SeparatorMenuItem(), changePin);
		links.getItems().addAll(mainPage, new SeparatorMenuItem(), loginPage, new SeparatorMenuItem(), signupPage);
		aboutUs.getItems().add(aboutus);
		
		openAcct.setDisable(true);
		switchAccts.setDisable(true);
		removeAcct.setDisable(true);
		changeUsername.setDisable(true);
		changePass.setDisable(true);
		changePin.setDisable(true);
		
		final double CIRCLE_RADIUS = 15.0;
		
		showPassword.setShape(new Circle(CIRCLE_RADIUS));
		showPassword.setMinSize(2.0 * CIRCLE_RADIUS, 2.0 * CIRCLE_RADIUS);
		Image imageDeposit = new Image(getClass().getResourceAsStream("show-password.png"));
		ImageView imageViewDeposit = new ImageView(imageDeposit);
		imageViewDeposit.setFitWidth(30);
		imageViewDeposit.setFitHeight(25);
		showPassword.setGraphic(imageViewDeposit);
		showPassword.setStyle("-fx-background-color: transparent");
		
		mainPage.setOnAction( e -> { startPane.getChildren().clear(); 
			mainPage(startPane); } );
		
		loginPage.setOnAction( e -> { startPane.getChildren().clear();
			mainPage(startPane); } );
		
		signupPage.setOnAction( e -> { startPane.getChildren().clear();
			setSignupScreen(startPane); } );
		
		aboutus.setOnAction( e -> { startPane.getChildren().clear();
			aboutusScreen(startPane, new CheckingAcct(new Person(""), new Bank(""), "", "" )); } );
						
		startUp.setFont(new Font("Comic Sans MS", 20));
		startUp.setTextAlignment(TextAlignment.CENTER);
		
		noAccount.setFont(Font.font("Comic Sans MS", 17));
		
		signupButton.setStyle("-fx-background-color: transparent");
		
		signupButton.setFont(new Font("Comic Sans MS", 13));
		signupButton.setTextFill(Color.BLUE);
		signupButton.setUnderline(true);
		
		exitButton.setFont(new Font("Comic Sans MS", 13));
		submitButton.setFont(new Font("Comic Sans MS", 13));
		clearButton.setFont(new Font("Comic Sans MS", 13));
		
		signupButton.setPrefWidth(70);
		signupButton.setMaxSize(350, 500);

		menuBar.setSpacing(20);

		hbox.getChildren().addAll(exitButton, submitButton, clearButton);
		hbox.setPadding(new Insets(20));
		hbox.setSpacing(275);
		
		hbox1.getChildren().addAll(labelVbox, answerVbox);
				
		startUp.setPadding(new Insets(35));
		
		startPane.setBottom(vbox4);
		startPane.setTop(menuBar);
		startPane.setCenter(hbox1);
		
		menuBar.setAlignment(Pos.CENTER);
		hbox1.setAlignment(Pos.CENTER);
		
		BorderPane.setAlignment(hbox1, Pos.CENTER);
		BorderPane.setAlignment(vbox4, Pos.BOTTOM_LEFT);
		
		clearButton.setOnAction( e -> { userUsername.clear(); userPassword.clear(); 
	 	userPIN.clear(); bankOptions.getSelectionModel().clearSelection(); } );
		
		exitButton.setOnAction( e -> System.exit(0) );
		
		signupButton.setOnAction( e -> { setSignupScreen(startPane); } );
		
		signupButton.setOnMouseEntered( e -> startPane.setCursor(Cursor.HAND) );
		
		signupButton.setOnMouseExited( e -> startPane.setCursor(Cursor.DEFAULT) );
		
		bankOptions.setOnMouseEntered( e -> startPane.setCursor(Cursor.HAND) );
		
		bankOptions.setOnMouseExited( e -> startPane.setCursor(Cursor.DEFAULT) );
		 
		submitButton.setOnAction( new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				
				startPane.setCursor(Cursor.WAIT);
				
				if(userUsername.getText().isEmpty()) {
					username.setTextFill(Color.RED);
					startUp.setText("Please fill out all required fields.");
					return;
				}
				else {
					username.setTextFill(Color.BLACK);
				}

				if(userPassword.getText().isEmpty()) {
					pass.setTextFill(Color.RED);
					startUp.setText("Please fill out all required fields.");
					return;
				}
				else {
					pass.setTextFill(Color.BLACK);
				}

				if(userPIN.getText().isEmpty()) {
					startUp.setText("Please fill out all required fields.");
					pin.setTextFill(Color.RED);
					return;
				}
				else {
					pin.setTextFill(Color.BLACK);
				}

				if(!isValidPin(userPIN.getText())) {
					startUp.setText("You have entered an illegal PIN number. Try again.");
					pin.setTextFill(Color.RED);
					return;
				}
				else {
					pin.setTextFill(Color.BLACK);
				}	
				
				if(bankOptions.getSelectionModel().isEmpty()) {
					bank.setTextFill(Color.RED);
					startUp.setText("Please fill out all required fields.");
					return;
				}
				else {
					bank.setTextFill(Color.BLACK);
				}

				submitLoginForm(startPane, userUsername, userPassword, userPIN, banks.getBank(bankOptions.getValue()));  
				hbox.getChildren().clear(); 
				menuBar.getChildren().clear(); 
				signupBut.getChildren().clear(); 
			}
		});
	 
	}
	
	/**
	 * 
	 * @param startPane
	 */
	public void setSignupScreen(BorderPane startPane) {
		startPane.setStyle("-fx-background-color: AQUAMARINE");
		
		Label prompt = new Label("Please fill out the form.");
		Label userLabel = new Label("Username: ");
		Label passLabel = new Label("Password: ");
		Label passLabelAgain = new Label("Password again: ");
		Label bankLabel = new Label("Bank");
		Label pinLabel = new Label("PIN #: ");
		Label fnameLabel = new Label("First name: ");
		Label lnameLabel = new Label("Last name: ");
		Label question = new Label("I would like to open a ... (choose one, the other can be opened later)");
		Label checkingLabel = new Label("Checking Account:          ");
		Label savingsLabel = new Label("Savings Account:             ");
		
		PasswordField password = new PasswordField();
		PasswordField passwordAgain = new PasswordField();
		PasswordField userPIN = new PasswordField();
		
		TextField username = new TextField();
		TextField userFirst = new TextField();
		TextField userLast = new TextField();
		
		ComboBox<String> bankOptions = new ComboBox<String>();
		bankOptions.getItems().addAll("TD Bank", "Chase", "Santander");
		
		CheckBox checkingBox = new CheckBox();
		CheckBox savingsBox = new CheckBox();
		
		Button exit = new Button("Exit");
		Button clear = new Button("Clear");
		Button back = new Button("Back");
		Button submit = new Button("Submit");
		Button passwordHelp = new Button();
		Button passwordHelp2 = new Button();
		
		HBox buttonHbox = new HBox(exit, submit, back, clear);		
		HBox hbox1 = new HBox(checkingLabel, checkingBox);
		HBox hbox2 = new HBox(savingsLabel, savingsBox);
		HBox hbox3 = new HBox();
		HBox hbox4 = new HBox();
		VBox labelVbox = new VBox(fnameLabel, lnameLabel, userLabel, passLabel, passLabelAgain, bankLabel, pinLabel, question);
		VBox userResponseVbox = new VBox(userFirst, userLast, username, hbox3, hbox4, bankOptions, userPIN);
		
		prompt.setFont(new Font("Comic Sans MS", 18));
		userLabel.setFont(new Font("Times New Roman", 15));
		passLabel.setFont(new Font("Times New Roman", 15));
		passLabelAgain.setFont(new Font("Times New Roman", 15));
		bankLabel.setFont(new Font("Times New Roman", 15));
		pinLabel.setFont(new Font("Times New Roman", 15));
		fnameLabel.setFont(new Font("Times New Roman", 15));
		lnameLabel.setFont(new Font("Times New Roman", 15));
		question.setFont(new Font("Comic Sans MS", 13));
		checkingLabel.setFont(new Font("Times New Roman", 15));
		savingsLabel.setFont(new Font("Times New Roman", 15));
		
		username.setPromptText("Enter a username");
		password.setPromptText("Enter a password");
		passwordAgain.setPromptText("Enter password");
		userPIN.setPromptText("Enter a PIN");
		userFirst.setPromptText("Your first name");
		userLast.setPromptText("Your last name");
		bankOptions.setPromptText("Choose an option");
		
		username.setMaxWidth(190);
		password.setMaxWidth(190);
		passwordAgain.setMaxWidth(190);
		userPIN.setMaxWidth(190);
		userFirst.setMaxWidth(190);
		userLast.setMaxWidth(190);
		bankOptions.setMaxWidth(190);
		
		exit.setFont(new Font("Comic Sans MS", 13));
		clear.setFont(new Font("Comic Sans MS", 13));
		back.setFont(new Font("Comic Sans MS", 13));
		submit.setFont(new Font("Comic Sans MS", 13));
		
		passwordHelp.setShape(new Circle(20.0));
		passwordHelp.setStyle("-fx-background-color: transparent");
		passwordHelp2.setShape(new Circle(20.0));
		passwordHelp2.setStyle("-fx-background-color: transparent");
		
		Image questionImage = new Image(getClass().getResourceAsStream("information.png"));
		ImageView questionImageView = new ImageView(questionImage);
		passwordHelp.setGraphic(questionImageView);
		questionImageView.setFitWidth(15);
		questionImageView.setFitHeight(15);

		Image questionImage2 = new Image(getClass().getResourceAsStream("information.png"));
		ImageView questionImageView2 = new ImageView(questionImage2);
		passwordHelp2.setGraphic(questionImageView2);
		questionImageView2.setFitWidth(15);
		questionImageView2.setFitHeight(15);
		
		hbox3.getChildren().addAll(password, passwordHelp);
		hbox4.getChildren().addAll(passwordAgain, passwordHelp2);
		
		labelVbox.getChildren().add(hbox1);
		labelVbox.getChildren().add(hbox2);
		
		prompt.setPadding(new Insets(20));
		
		labelVbox.setPadding(new Insets(15));
		labelVbox.setSpacing(35);
		
		userResponseVbox.setPadding(new Insets(15));
		userResponseVbox.setSpacing(24);
		
		buttonHbox.setPadding(new Insets(20));
		buttonHbox.setSpacing(168);
		
		startPane.setLeft(labelVbox);
		startPane.setCenter(userResponseVbox);
		startPane.setTop(prompt);
		startPane.setBottom(buttonHbox);
		
		BorderPane.setAlignment(prompt, Pos.CENTER);
		
		bankOptions.setOnMouseEntered( e -> startPane.setCursor(Cursor.HAND) );
		
		bankOptions.setOnMouseExited( e -> startPane.setCursor(Cursor.DEFAULT) );
		
		checkingBox.setOnAction( e -> savingsBox.setSelected(false) );
		
		savingsBox.setOnAction( e -> checkingBox.setSelected(false) );
		
		exit.setOnAction( e -> System.exit(0) );
		
		passwordHelp.setOnMouseEntered( e -> startPane.setCursor(Cursor.HAND) );
		
		passwordHelp.setOnMouseExited( e -> startPane.setCursor(Cursor.DEFAULT) );
		
		passwordHelp2.setOnMouseEntered( e -> startPane.setCursor(Cursor.HAND) );
		
		passwordHelp2.setOnMouseExited( e -> startPane.setCursor(Cursor.DEFAULT) );
		
		passwordHelp.setOnAction( e -> passwordHelper( new BorderPane() ) );
		
		passwordHelp2.setOnAction( e -> passwordHelper( new BorderPane() ) );
		
		clear.setOnAction( e -> { 
			username.clear(); password.clear(); 
			bankOptions.getSelectionModel().clearSelection(); userPIN.clear(); 
			userFirst.clear(); userLast.clear(); checkingBox.setSelected(false); 
			savingsBox.setSelected(false); 
		} );
		
		back.setOnAction( e -> { 
			mainPage(startPane); labelVbox.getChildren().clear(); 
			userResponseVbox.getChildren().clear(); buttonHbox.getChildren().clear();
			hbox1.getChildren().clear(); hbox2.getChildren().clear(); 
		} );
		
		submit.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			public void handle(ActionEvent event) {
				
				if(userFirst.getText().isEmpty()) {
					fnameLabel.setTextFill(Color.RED);
					prompt.setText("Please enter a first name.");
					return;
				}
				else {
					fnameLabel.setTextFill(Color.BLACK);
				}
				if(userLast.getText().isEmpty()) {
					lnameLabel.setTextFill(Color.RED);
					prompt.setText("Please enter a last name.");
					return;
				}
				else {
					lnameLabel.setTextFill(Color.BLACK);
				}
				if(username.getText().isEmpty()) {
					userLabel.setTextFill(Color.RED);					
					prompt.setText("Please enter a username.");
					return;
				}
				else {
					userLabel.setTextFill(Color.BLACK);
				}
			    if(password.getText().isEmpty() || passwordAgain.getText().isEmpty()) {
					passLabel.setTextFill(Color.RED);
					passLabelAgain.setTextFill(Color.RED);
					prompt.setText("Please enter a password.");
					return;
				}
				else {
					passLabel.setTextFill(Color.BLACK);
				}
			    if(!isValidPassword(password.getText())) {
			    	passLabel.setTextFill(Color.RED);
			    	prompt.setText("Your password does not meet security requirements.\n     "
			    			+ "Click the question mark to see requirements.");
			    	return;
			    }
			    else {
			    	passLabel.setTextFill(Color.BLACK);
			    }
			    if(!password.getText().equals(passwordAgain.getText())) {
					passLabel.setTextFill(Color.RED);
					passLabelAgain.setTextFill(Color.RED);
			    	prompt.setText("Your passwords do not match.");
			    	return;
			    }
			    else {
			    	passLabel.setTextFill(Color.BLACK);
			    	passLabelAgain.setTextFill(Color.BLACK);
			    }
				if(bankOptions.getSelectionModel().isEmpty()) {
					bankLabel.setTextFill(Color.RED);
					prompt.setText("Please choose a bank.");
					return;
				}
				else {
					bankLabel.setTextFill(Color.BLACK);
				}
				if(userPIN.getText().isEmpty()) {
					pinLabel.setTextFill(Color.RED);
					prompt.setText("Please enter a Personal Identification Number (PIN).");
					return;
				}
				else {
					pinLabel.setTextFill(Color.BLACK);
				}
				if(!isValidPin(userPIN.getText())) {
					prompt.setText("You have entered an illegal PIN number. Try again.");
					pinLabel.setTextFill(Color.RED);
					return;
				}
				else {
					pinLabel.setTextFill(Color.BLACK);
				}			
				if(!checkingBox.isSelected() && !savingsBox.isSelected()) {
					checkingLabel.setTextFill(Color.RED);
					savingsLabel.setTextFill(Color.RED);
					prompt.setText("Please choose between the two account types.");
					return;
				}
				else {
					checkingLabel.setTextFill(Color.BLACK);
					savingsLabel.setTextFill(Color.BLACK);
				}
				
				submitSignupForm(startPane, userFirst, userLast, username, password, bankOptions, userPIN, checkingBox, savingsBox);
				labelVbox.getChildren().clear(); 
				userResponseVbox.getChildren().clear(); 
				buttonHbox.getChildren().clear(); 
				hbox1.getChildren().clear();
				hbox2.getChildren().clear();
				
			} } );
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userFirst
	 * @param userLast
	 * @param username
	 * @param password
	 * @param bankOptions
	 * @param userPIN
	 * @param savingsBox
	 * @param checkingBox
	 */
	public void submitSignupForm(BorderPane startPane, TextField userFirst, 
			TextField userLast, TextField username, PasswordField password, 
			ComboBox<String> bankOptions, PasswordField userPIN, CheckBox savingsBox, 
			CheckBox checkingBox) {
		
		boolean takenName = false;
		
		Bank bank;
		
		String name = userFirst.getText() + " " + userLast.getText();
		String userUsername = username.getText();
		String userPassword = password.getText();
		
		int usersPIN = Integer.parseInt(userPIN.getText());
		
		Person person = new Person(name);
				
		if(banks.isBankThere(bankOptions)) {
			bank = banks.getBank(bankOptions.getValue().toString());
		}
		else {
			bank = new Bank(bankOptions.getValue());
			banks.addBank(bank);
		}
	
		for(BankAccount act: bank.accounts) {
			if(act.getUserName().equals(userUsername)) {
				takenName = true;
				break;
			}
			else {
				takenName = false;
			}
		}

		if(!takenName) {
			if(!checkingBox.isSelected()) {
				CheckingAcct userAcct = new CheckingAcct(person, bank, userUsername, userPassword);
				
				userAcct.setUpAccount();
				userAcct.setBank(bank);
				userAcct.setPin(usersPIN);
				bank.addAccount(userAcct);
				userAcct.setOwner(person);
				person.addChecking(userAcct);
				
				Alert accountMade = new Alert(AlertType.CONFIRMATION, "You have successfully "
						+ "created an account! Please login with the credentials you used for "
						+ "your account.", ButtonType.OK);
				accountMade.showAndWait();
				
				startPane.getChildren().clear();
				mainPage(startPane);
			}	
			else {
				SavingsAcct userAcct = new SavingsAcct(person, bank, userUsername, userPassword);
				
				userAcct.setUpAccount();
				userAcct.setBank(bank);
				userAcct.setPin(usersPIN);
				bank.addAccount(userAcct);
				userAcct.setOwner(person);
				person.addSavings(userAcct);
				
				Alert accountMade = new Alert(AlertType.CONFIRMATION, "You have successfully "
						+ "created an account! Please login with the credentials you used for "
						+ "your account.", ButtonType.OK);
				accountMade.showAndWait();
				
				startPane.getChildren().clear();
				mainPage(startPane);
			}
		}
		else {
			Alert usernameError = new Alert(AlertType.ERROR, "This username is already in"
					+ " use. Please choose another one. \nUsername in use: " + username.getText(),
					ButtonType.OK);
			usernameError.showAndWait();
			
			if(usernameError.getResult() == ButtonType.OK) {
				startPane.getChildren().clear();
				setSignupScreen(startPane);
			}
			else {
				startPane.getChildren().clear();
				setSignupScreen(startPane);
			}
		}
	}
	
	/**
	 * 
	 * @param startPane
	 * @param username
	 * @param pass
	 * @param pin
	 * @param bank
	 * @param prompt
	 */
	public void submitLoginForm(BorderPane startPane, TextField username, 
			PasswordField pass, PasswordField pin, Bank bank) {

		if(!bank.accounts.isEmpty()) {
			for(BankAccount bk: bank.accounts) {
				if(bk.getOwner().hasChecking()) {
					if(username.getText().equals(bk.getOwner().getChecking().getUserName()) 
							&& pass.getText().equals(bk.getOwner().getChecking().getPassword()) 
							&& Integer.parseInt(pin.getText()) == bk.getOwner().getChecking().getPin()) {	
						startPane.getChildren().clear();
						loggedIn(startPane, bk);
					}
					else {
						startPane.getChildren().clear();
						incorrectCredentials(startPane);
					}
				}
				if(bk.getOwner().hasSavings()) {
					if(username.getText().equals(bk.getOwner().getSavings().getUserName()) 
							&& pass.getText().equals(bk.getOwner().getSavings().getPassword())) { 
						startPane.getChildren().clear();
						loggedIn(startPane, bk);
					}
					else {
						startPane.getChildren().clear();
						incorrectCredentials(startPane);
					}
				}
			}
		}
		else {
			Alert noAccounts = new Alert(AlertType.ERROR, "This bank currently has no accounts."
					+ "Therefore, it is an invalid choice.\n"
					+ "Would you like to exit the program (\"Close\") "
					+ "or try again (\"OK\")?", ButtonType.CLOSE, 
					ButtonType.OK);

			noAccounts.showAndWait();

			if(noAccounts.getResult() == ButtonType.CLOSE) {
				System.exit(0);
			}
			else {
				mainPage(startPane);
			}
		}
	}
	
	/**
	 * 
	 * @param startPane
	 */
	public void incorrectCredentials(BorderPane startPane) {
		Alert incorrectCreds = new Alert(AlertType.ERROR, "You have entered an incorrect"
				+ " username, or password. Please try again.", ButtonType.OK);
		
		Optional<ButtonType> result = incorrectCreds.showAndWait();
		
		if(result.get() == ButtonType.OK) {
			mainPage(startPane);
		}
	}
	
	/**
	 * 
	 * @param startPane
	 */
	public void passwordHelper(BorderPane newPane) {
		
		Stage newWindow = new Stage();
		Scene newScene = new Scene(newPane);
		Button exitButton = new Button("Exit");
		HBox buttonBox = new HBox(exitButton);
		Label passwordHelp = new Label("In order for your password to be secure, we must"
				+ " ensure that you have met the following requirements:\n\n"
				+ "- At least one uppercase letter\n- At least one numeric value"
				+ "\n- Password is at least seven characters long");
		
		newPane.setStyle("-fx-background-color: LAVENDER");
		
		newWindow.setTitle("Password Helper");
		newWindow.setScene(newScene);
		newWindow.setHeight(390);
		newWindow.setWidth(390);
		newWindow.setMaxWidth(390);
		newWindow.setMaxHeight(390);
		newWindow.initModality(Modality.APPLICATION_MODAL);
		newWindow.show();
		
		passwordHelp.setLineSpacing(1.5);
		passwordHelp.setPadding(new Insets(10));
		passwordHelp.setFont(new Font("Comic Sans MS", 15));
		passwordHelp.setTextAlignment(TextAlignment.CENTER);
		passwordHelp.setWrapText(true);

		buttonBox.setPadding(new Insets(10));
		exitButton.setFont(new Font("Comic Sans MS", 13));
		exitButton.setOnAction( e -> newWindow.close() );

		buttonBox.setAlignment(Pos.BOTTOM_CENTER);
		
		newPane.setCenter(passwordHelp);
		newPane.setBottom(buttonBox);
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 */
	public void loggedIn(BorderPane startPane, BankAccount userAcct) {
		startPane.setStyle("-fx-background-color: #fff0f5");
								
		String usersName = userAcct.getOwner().getName();
				
		String[] splitName = usersName.split(" ");
		
		Label greeting = new Label(" Good day, " + splitName[0] + ". Hope all is well!\n"
				+ "What would you like to do today? ");
		Label account = new Label();
		Label accountNum = new Label("Account number: " + userAcct.getAccountNumber());
		
		if(userAcct instanceof CheckingAcct) {
			account.setText(userAcct.getOwner().getName() + "'s Checking Account");
		}
		else {
			account.setText(userAcct.getOwner().getName() + "'s Savings Account");
		}
		
		VBox topVbox = new VBox();
		VBox vbox1 = new VBox();
	
		HBox hbox = new HBox();
		HBox hbox1 = new HBox();
		
		MenuBar menubar = new MenuBar();
		
		Menu accounts = new Menu("Accounts");
		Menu mySettings = new Menu("My Settings");
		Menu links = new Menu("Page Links");
		Menu aboutUs = new Menu("About Us");
		
		MenuItem openAcct = new MenuItem("Open new account");
		MenuItem switchAccts = new MenuItem("Switch accounts");
		MenuItem removeAcct = new MenuItem("Remove an account");
		MenuItem changeUsername = new MenuItem("Change username");
		MenuItem changePass = new MenuItem("Change password");
		MenuItem changePin = new MenuItem("Change PIN");
		MenuItem mainPage = new MenuItem("Home Page");
		MenuItem loginPage = new MenuItem("Log in");
		MenuItem signupPage = new MenuItem("Sign up");
		MenuItem aboutus = new MenuItem("About Us");
				
		menubar.getMenus().addAll(accounts, mySettings, links, aboutUs);
		
		accounts.getItems().addAll(openAcct, new SeparatorMenuItem(), switchAccts, new SeparatorMenuItem(), removeAcct);
		mySettings.getItems().addAll(changeUsername, new SeparatorMenuItem(), changePass, new SeparatorMenuItem(), changePin);
		links.getItems().addAll(mainPage, new SeparatorMenuItem(), loginPage, new SeparatorMenuItem(), signupPage);
		aboutUs.getItems().add(aboutus);
		
		changeUsername.setOnAction( e -> { String username = "user";
			changeUserCreds(startPane, userAcct, username); } );
		
		changePass.setOnAction( e -> { String pass = "pass";
			changeUserCreds(startPane, userAcct, pass); } );
		
		changePin.setOnAction( e -> { String pin = "pin";
			changeUserCreds(startPane, userAcct, pin); } );
		
		mainPage.setOnAction( e -> { startPane.getChildren().clear(); 
			mainPage(startPane); } );
		
		loginPage.setOnAction( e -> { startPane.getChildren().clear();
			mainPage(startPane); } );
		
		signupPage.setOnAction( e -> { startPane.getChildren().clear();
			setSignupScreen(startPane); } );
		
		aboutus.setOnAction( e -> { startPane.getChildren().clear();
			aboutusScreen(startPane, userAcct); } );
		
		switchAccts.setOnAction( e -> { 
			try {
				switchAccounts(startPane, userAcct); 
			}
			catch(NullPointerException e1) {
				Alert error = new Alert(AlertType.ERROR, "You do not have a second account to"
						+ " switch to. Please create an account via the \"My Accounts\" tab in the"
						+ " top left to use this feature. Thanks for banking with us!", ButtonType.OK);
				error.setTitle("Invalid action.");
				error.showAndWait();
				if(error.getResult() == ButtonType.OK) {
					startPane.getChildren().clear();
					loggedIn(startPane, userAcct);
				}
			} } );
		
		openAcct.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(userAcct.getOwner().amtOfAccounts() >= 2) {
					Alert alert = new Alert(AlertType.CONFIRMATION, "You already have two"
							+ " accounts with " + userAcct.getBank().getName() + ".", 
							ButtonType.OK);
					alert.showAndWait();
				}
				else {
					if(userAcct instanceof CheckingAcct) {
						Alert alert = new Alert(AlertType.CONFIRMATION, "Would you like to create a"
								+ " new savings account with " + userAcct.getBank().getName() + "?", 
								ButtonType.YES, ButtonType.NO);
						alert.showAndWait();
						if(alert.getResult() == ButtonType.NO) {
							loggedIn(startPane, userAcct);
						}
						else {
							createNewAccount(startPane, userAcct);
						}
					}
					else {
						Alert alert = new Alert(AlertType.CONFIRMATION, "Would you like to create a"
								+ " new checking account with " + userAcct.getBank().getName() + "?", 
								ButtonType.YES, ButtonType.NO);
						alert.showAndWait();
						if(alert.getResult() == ButtonType.NO) {
							loggedIn(startPane, userAcct);
						}
						else {
							createNewAccount(startPane, userAcct);
						}
					}
				}
			}
		});
		
		removeAcct.setOnAction( e -> {
			startPane.getChildren().clear();
			removeAccount(startPane, userAcct);
		});
			
		final double CIRCLE_RADIUS = 25.0;
		Circle c = new Circle(CIRCLE_RADIUS);
		
		Text exitLabel = new Text("Exit");
		Text logoutLabel = new Text("Logout");
		Text withdrawLabel = new Text("Withdraw");
		Text checkBalanceLabel = new Text("Check Balance");
		Text depositLabel = new Text("Deposit");
		Text transferLabel = new Text("Transfer");
		
		Button exitButton = new Button();
		Button logoutButton = new Button();
		Button withdraw = new Button();
		Button checkBalance = new Button();
		Button deposit = new Button();
		Button transfer = new Button();
		
		VBox exitVbox = new VBox();
		VBox logoutVbox = new VBox();
		VBox withdrawVbox = new VBox();
		VBox balanceVbox = new VBox();
		VBox depositVbox = new VBox();
		VBox transferVbox = new VBox();
		
		hbox.getChildren().addAll(transferVbox, withdrawVbox, depositVbox, balanceVbox, logoutVbox, exitVbox);
				
		exitButton.setShape(c);
		exitButton.setMinSize(2.0 * CIRCLE_RADIUS, 2.0 * CIRCLE_RADIUS);
		Image imageExit = new Image(getClass().getResourceAsStream("exit1.png"));
		ImageView imageViewExit = new ImageView(imageExit);
		imageViewExit.setFitWidth(30);
		imageViewExit.setFitHeight(25);
		exitButton.setGraphic(imageViewExit);
		
		logoutButton.setShape(c);
		logoutButton.setMinSize(2.0 * CIRCLE_RADIUS, 2.0 * CIRCLE_RADIUS);
		Image imageLogout = new Image(getClass().getResourceAsStream("logout.png"));
		ImageView imageViewLogout = new ImageView(imageLogout);
		imageViewLogout.setFitWidth(30);
		imageViewLogout.setFitHeight(25);
		logoutButton.setGraphic(imageViewLogout);
		
		withdraw.setShape(c);
		withdraw.setMinSize(2.0 * CIRCLE_RADIUS, 2.0 * CIRCLE_RADIUS);
		Image imageWithdraw = new Image(getClass().getResourceAsStream("withdraw.png"));
		ImageView imageViewWithdraw = new ImageView(imageWithdraw);
		imageViewWithdraw.setFitWidth(30);
		imageViewWithdraw.setFitHeight(25);
		withdraw.setGraphic(imageViewWithdraw);
		
		checkBalance.setShape(c);
		checkBalance.setMinSize(2.0 * CIRCLE_RADIUS, 2.0 * CIRCLE_RADIUS);
		Image imageBalance = new Image(getClass().getResourceAsStream("dollar.png"));
		ImageView imageViewBalance = new ImageView(imageBalance);
		imageViewBalance.setFitWidth(30);
		imageViewBalance.setFitHeight(25);
		checkBalance.setGraphic(imageViewBalance);
		
		deposit.setShape(c);
		deposit.setMinSize(2.0 * CIRCLE_RADIUS, 2.0 * CIRCLE_RADIUS);
		Image imageDeposit = new Image(getClass().getResourceAsStream("safe.png"));
		ImageView imageViewDeposit = new ImageView(imageDeposit);
		imageViewDeposit.setFitWidth(30);
		imageViewDeposit.setFitHeight(25);
		deposit.setGraphic(imageViewDeposit);
		
		transfer.setShape(c);
		transfer.setMinSize(2.0 * CIRCLE_RADIUS, 2.0 * CIRCLE_RADIUS);
		Image imageTransfer = new Image(getClass().getResourceAsStream("transfer.png"));
		ImageView imageViewTransfer = new ImageView(imageTransfer);
		imageViewTransfer.setFitWidth(30);
		imageViewTransfer.setFitHeight(25);
		transfer.setGraphic(imageViewTransfer);
		
		transferVbox.getChildren().addAll(transfer, transferLabel);
		withdrawVbox.getChildren().addAll(withdraw, withdrawLabel);
		balanceVbox.getChildren().addAll(checkBalance, checkBalanceLabel);
		depositVbox.getChildren().addAll(deposit, depositLabel);
		logoutVbox.getChildren().addAll(logoutButton, logoutLabel);
		exitVbox.getChildren().addAll(exitButton, exitLabel);
		
		transferVbox.setSpacing(5);
		withdrawVbox.setSpacing(5);
		balanceVbox.setSpacing(5);
		depositVbox.setSpacing(5);
		logoutVbox.setSpacing(5);
		exitVbox.setSpacing(5);
		
		transferVbox.setAlignment(Pos.CENTER);
		withdrawVbox.setAlignment(Pos.CENTER);
		balanceVbox.setAlignment(Pos.CENTER);
		depositVbox.setAlignment(Pos.CENTER);
		logoutVbox.setAlignment(Pos.CENTER);
		exitVbox.setAlignment(Pos.CENTER);
		
		topVbox.getChildren().addAll(menubar, hbox, hbox1);
		
		hbox.setAlignment(Pos.TOP_LEFT);
		hbox.setSpacing(80);
		hbox.setPadding(new Insets(10));
		hbox1.setSpacing(95);
		hbox1.setPadding(new Insets(10));
		topVbox.setSpacing(10);
		
		vbox1.getChildren().addAll(account, accountNum, greeting);

		vbox1.setSpacing(25);
		
		greeting.setFont(new Font("Avenir Next", 19));
		greeting.setPadding(new Insets(10));
		greeting.setTextAlignment(TextAlignment.CENTER);
		
		account.setFont(new Font("Avenir Next", 16));
		account.setPadding(new Insets(10));
		account.setTextAlignment(TextAlignment.CENTER);
		
		accountNum.setFont(new Font("Avenir Next", 16));
		accountNum.setPadding(new Insets(10));
		accountNum.setTextAlignment(TextAlignment.CENTER);
		
		startPane.setTop(topVbox);
		startPane.setCenter(vbox1);
	
		BorderPane.setAlignment(topVbox, Pos.CENTER_LEFT);
		vbox1.setAlignment(Pos.CENTER);
		
		transfer.setOnAction( e -> { 
			startPane.getChildren().clear(); 
			canUserTransfer(startPane, userAcct);
		});
		
		deposit.setOnAction( e -> { 
			topVbox.getChildren().clear();
			userDepositScreen(startPane, userAcct); 
		});
		
		checkBalance.setOnAction( e -> { 
			topVbox.getChildren().clear();
			userBalanceScreen(startPane, userAcct); 
		});
		
		withdraw.setOnAction( e ->  { 
			topVbox.getChildren().clear(); 
			userWithdrawScreen(startPane, userAcct);
		});
		
		exitButton.setOnAction( e -> System.exit(0) );
		
		logoutButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert goodbye = new Alert(AlertType.CONFIRMATION, "Are you sure you would"
						+ " like to log out?", ButtonType.YES, ButtonType.NO);
				goodbye.setTitle("Logout requested.");
				Optional<ButtonType> result = goodbye.showAndWait();
				if(result.isPresent() && result.get() == ButtonType.YES) {
				    startPane.getChildren().clear();
					mainPage(startPane);
				}
				else {
					loggedIn(startPane, userAcct);
				}
			}	
		} );		
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 */
	public void userWithdrawScreen(BorderPane startPane, BankAccount userAcct) {
		startPane.setStyle("-fx-background-color: #e0ffff");
		String ownerName = userAcct.getOwner().getName();
		String username = userAcct.getUserName();
		int accountNum = userAcct.getAccountNumber();

		HBox hbox = new HBox();
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		VBox vbox = new VBox();
		VBox vbox1 = new VBox();
		
		Label userUsername = new Label();
		Label accountNumber = new Label();
		Label currentBalance = new Label();
		Label withdrawLabel = new Label("How much would you like to withdraw, " 
				+ ownerName + "?");
		
		TextField withdrawAmt = new TextField();
		
		Button submit = new Button("Submit");
		Button exitButton = new Button("Exit");
		Button backButton = new Button("Back");
		Button clearButton = new Button("Clear");
		
		accountNumber.setText("Account number: " + accountNum);
		userUsername.setText("Username: " + username);
		currentBalance.setText("Current balance: $" + String.format("%,.2f", userAcct.getBalance()));
		withdrawAmt.setPromptText("Withdrawal amount");
				
		vbox1.getChildren().addAll(currentBalance, hbox);
		hbox.getChildren().addAll(withdrawLabel, withdrawAmt);
		hbox1.getChildren().addAll(exitButton, submit, backButton, clearButton);
		hbox2.getChildren().addAll(vbox);
		vbox.getChildren().addAll(accountNumber, userUsername);
		
		submit.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					if(userAcct instanceof CheckingAcct && userAcct.getOwner().getChecking().getBalance()
							> Double.parseDouble(withdrawAmt.getText())) {
						userAcct.withdraw(Double.parseDouble(withdrawAmt.getText()));
						currentBalance.setText("");
						accountNumber.setText("");
						hbox.getChildren().clear();
						hbox1.getChildren().clear();
						hbox2.getChildren().clear();
						
						Alert actionNotification = new Alert(AlertType.INFORMATION, 
								"You have withdrew $" + withdrawAmt.getText() + " from your "
								+ "account. If you did not mean for this, press \"Cancel\". "
								+ "Otherwise, press \"OK\" to continue.", ButtonType.CANCEL,
								ButtonType.OK);
						actionNotification.showAndWait();
						if(actionNotification.getResult() == ButtonType.CANCEL) {
							userAcct.deposit(Double.parseDouble(withdrawAmt.getText()));
							loggedIn(startPane, userAcct);
						}
						else {
							loggedIn(startPane, userAcct);
						}
					}
					else if(userAcct instanceof SavingsAcct && userAcct.getBalance() >= 999) {
						userAcct.withdraw(Double.parseDouble(withdrawAmt.getText()));
						currentBalance.setText("");
						accountNumber.setText("");
						hbox.getChildren().clear();
						hbox1.getChildren().clear();
						hbox2.getChildren().clear();
						
						Alert actionNotification = new Alert(AlertType.INFORMATION, 
								"You have withdrew $" + withdrawAmt.getText() + " from your "
								+ "account. If you did not mean for this, press \"Cancel\". "
								+ "Otherwise, press \"OK\" to continue.", ButtonType.CANCEL,
								ButtonType.OK);
						actionNotification.showAndWait();
						if(actionNotification.getResult() == ButtonType.CANCEL) {
							userAcct.deposit(Double.parseDouble(withdrawAmt.getText()));
							loggedIn(startPane, userAcct);
						}
						else {
							loggedIn(startPane, userAcct);
						}
					}
					else {
						if(userAcct instanceof SavingsAcct) {
							Alert notEnoughFunds = new Alert(AlertType.ERROR, "You have tried to"
									+ " withdraw " + withdrawAmt.getText() + " from your savings"
									+ " account, when it does not reach the minimum amount of current"
									+ " funds. You must have $1,000.00 in order to withdraw from"
									+ " a savings account.", ButtonType.OK);
							notEnoughFunds.showAndWait();
							if(notEnoughFunds.getResult() == ButtonType.OK) {
								startPane.getChildren().clear();
								loggedIn(startPane, userAcct);
							}
							else {
								startPane.getChildren().clear();
								loggedIn(startPane, userAcct);
							}
						}
						else {
							Alert notEnoughFunds = new Alert(AlertType.ERROR, "You have tried to"
									+ " withdraw " + withdrawAmt.getText() + " from your checking"
									+ " account, when it does not have enough funds available.", 
									ButtonType.OK);
							notEnoughFunds.showAndWait();
							if(notEnoughFunds.getResult() == ButtonType.OK) {
								startPane.getChildren().clear();
								loggedIn(startPane, userAcct);
							}
							else {
								startPane.getChildren().clear();
								loggedIn(startPane, userAcct);
							}
						}
					}
				}
				catch(NumberFormatException e) {
					Alert invalidResponse = new Alert(AlertType.ERROR, "Invalid response."
							+ "You did not enter a correctly formatted number. Please press"
							+ " \"OK\" to try again, otherwise close to go back.", 
							ButtonType.CLOSE, ButtonType.OK);
					
					invalidResponse.setTitle("Invalid entrant.");
					
					invalidResponse.showAndWait();
					
					if(invalidResponse.getResult() == ButtonType.OK) {
						userWithdrawScreen(startPane, userAcct);
					}
					else {
						currentBalance.setText("");
						accountNumber.setText("");
						hbox.getChildren().clear();
						hbox1.getChildren().clear();
						hbox2.getChildren().clear();
						loggedIn(startPane, userAcct);
					}
				}
			}
		
		} );
		
		withdrawLabel.setFont(new Font("Comic Sans MS", 14));
		
		currentBalance.setFont(new Font("Comic Sans MS", 18));
		currentBalance.setTextAlignment(TextAlignment.JUSTIFY);		
		
		accountNumber.setFont(new Font("Comic Sans MS", 15));
		accountNumber.setTextAlignment(TextAlignment.JUSTIFY);
		
		userUsername.setFont(new Font("Comic Sans MS", 15));
		userUsername.setTextAlignment(TextAlignment.JUSTIFY);

		exitButton.setOnAction( e -> System.exit(0) );
		
		backButton.setOnAction( e -> { currentBalance.setText(""); 
			accountNumber.setText(""); loggedIn(startPane, userAcct); 
			hbox.getChildren().clear(); hbox1.getChildren().clear(); 
			hbox2.getChildren().clear(); } ); 
		
		clearButton.setOnAction( e -> withdrawAmt.clear() );
		
		hbox1.setPadding(new Insets(10));
		hbox1.setSpacing(180);
		
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(30);
		hbox.setAlignment(Pos.CENTER);
		
		hbox2.setPadding(new Insets(10));
		hbox2.setSpacing(320);
		
		vbox.setSpacing(20);
		
		vbox1.setSpacing(30);
		
		startPane.setTop(hbox2);
		startPane.setCenter(vbox1);
		startPane.setBottom(hbox1);
	
		vbox1.setAlignment(Pos.CENTER);
		
		BorderPane.setAlignment(hbox2, Pos.TOP_LEFT);
		BorderPane.setAlignment(vbox1, Pos.CENTER);
		BorderPane.setAlignment(hbox1, Pos.BOTTOM_LEFT);
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 */
	public void userDepositScreen(BorderPane startPane, BankAccount userAcct) {
		startPane.setStyle("-fx-background-color: #e0ffff");
		
		String ownerName = userAcct.getOwner().getName();
		String username = userAcct.getUserName();
		int accountNum = userAcct.getAccountNumber();

		HBox hbox = new HBox();
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		VBox vbox = new VBox();
		
		Label userUsername = new Label();
		Label accountNumber = new Label();
		Label currentBalance = new Label();
		Label depositLabel = new Label("How much would you like to deposit, " 
				+ ownerName + "?");
		
		TextField depositAmt = new TextField();
		
		Button submit = new Button("Submit");
		Button exitButton = new Button("Exit");
		Button backButton = new Button("Back");
		Button clearButton = new Button("Clear");
		
		userUsername.setText("Username: " + username);
		accountNumber.setText("Account number: " + accountNum);
		currentBalance.setText("Current balance: $" + String.format("%,.2f", userAcct.getBalance()));
		depositAmt.setPromptText("Deposit amount");
		
		hbox.getChildren().addAll(depositLabel, depositAmt);
		hbox1.getChildren().addAll(exitButton, submit, backButton, clearButton);
		hbox2.getChildren().addAll(vbox);
		vbox.getChildren().addAll(currentBalance, accountNumber, userUsername);
		
		submit.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					userAcct.deposit(Double.parseDouble(depositAmt.getText()));
					currentBalance.setText("");
					accountNumber.setText("");
					hbox.getChildren().clear();
					hbox1.getChildren().clear();
					hbox2.getChildren().clear();
					loggedIn(startPane, userAcct);
				}
				catch(NumberFormatException e) {
					Alert invalidResponse = new Alert(AlertType.ERROR, "Invalid response."
							+ "You did not enter a correctly formatted number. Please press"
							+ " \"OK\" to try again, otherwise close to go back.", 
							ButtonType.CLOSE, ButtonType.OK);
					
					invalidResponse.showAndWait();
					
					if(invalidResponse.getResult() == ButtonType.OK) {
						userDepositScreen(startPane, userAcct);
					}
					else {
						currentBalance.setText("");
						accountNumber.setText("");
						hbox.getChildren().clear();
						hbox1.getChildren().clear();
						hbox2.getChildren().clear();
						loggedIn(startPane, userAcct);
					}
				}
			}
		
		} );
		
		depositLabel.setFont(new Font("Comic Sans MS", 14));
		
		currentBalance.setFont(new Font("Comic Sans MS", 15));
		currentBalance.setTextAlignment(TextAlignment.JUSTIFY);
		
		userUsername.setFont(new Font("Comic Sans MS", 15));
		userUsername.setTextAlignment(TextAlignment.JUSTIFY);
		
		accountNumber.setFont(new Font("Comic Sans MS", 15));
		accountNumber.setTextAlignment(TextAlignment.JUSTIFY);
		
		exitButton.setOnAction( e -> System.exit(0) );
		
		backButton.setOnAction( e -> { currentBalance.setText(""); 
			accountNumber.setText(""); loggedIn(startPane, userAcct); 
			hbox.getChildren().clear(); hbox1.getChildren().clear(); 
			hbox2.getChildren().clear(); } ); 
		
		clearButton.setOnAction( e -> depositAmt.clear() );
		
		hbox1.setPadding(new Insets(10));
		hbox1.setSpacing(180);
		
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(30);
		
		hbox2.setPadding(new Insets(10));
		hbox2.setSpacing(320);
		
		vbox.setSpacing(20);
		
		startPane.setTop(hbox2);
		startPane.setBottom(hbox1);
		startPane.setCenter(hbox);

		hbox.setAlignment(Pos.CENTER);
		
		BorderPane.setAlignment(hbox2, Pos.TOP_LEFT);
		BorderPane.setAlignment(hbox, Pos.CENTER);
		BorderPane.setAlignment(hbox1, Pos.BOTTOM_LEFT);
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 */
	public void userBalanceScreen(BorderPane startPane, BankAccount userAcct) {
		startPane.setStyle("-fx-background-color: #ee82ee");
		
		String currentBalance = String.format("%,.2f", userAcct.getBalance());
		
		Label userBalance = new Label();
		Button exitButton = new Button("Exit");
		Button backButton = new Button("Back");
		
		HBox hbox = new HBox();
		
		userBalance.setText("Your current balance is: $" + currentBalance);
		
		userBalance.setFont(new Font("Comic Sans MS", 18));
		
		hbox.getChildren().addAll(exitButton, backButton);
		
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(650);
		
		startPane.setCenter(userBalance);
		startPane.setBottom(hbox);
		
		BorderPane.setAlignment(userBalance, Pos.CENTER);
		hbox.setAlignment(Pos.BOTTOM_LEFT);
		
		exitButton.setOnAction( e -> System.exit(0) );
		
		backButton.setOnAction( e -> { loggedIn(startPane, userAcct);
			hbox.getChildren().clear(); } );
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 */
	public void canUserTransfer(BorderPane startPane, BankAccount userAcct) {
		
		if(userAcct.getOwner().amtOfAccounts() <= 1) {
			loggedIn(startPane, userAcct);
			Alert oneAccount = new Alert(AlertType.ERROR, "You only have one account with "
					+ userAcct.getBank().getName() + ". Please open a second account to perform"
					+ " this action.", ButtonType.OK);
			oneAccount.showAndWait();
		}
		else {
			userTransferScreen(startPane, userAcct);
		}
		
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 */
	public void userTransferScreen(BorderPane startPane, BankAccount userAcct) {
		startPane.setStyle("-fx-background-color: LAVENDER");
		
		ComboBox<String> transferFrom = new ComboBox<String>();
		ComboBox<String> transferTo = new ComboBox<String>();
		
		TextField transferAmt = new TextField();
		
		HBox hbox = new HBox();
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		
		VBox vbox = new VBox();
		
		Button backButton = new Button("Back");
		Button submitButton = new Button("Submit");
		
		backButton.setFont(new Font("Comic Sans MS", 13));
		submitButton.setFont(new Font("Comic Sans MS", 13));
		
		transferFrom.setStyle("-fx-font: 17px \"Comic Sans MS\";");
		transferTo.setStyle("-fx-font: 17px \"Comic Sans MS\";");
		
		transferAmt.setPromptText("Amount to be transferred");
		
		transferFrom.setPromptText("Transfer from");
		transferTo.setPromptText("Transfer to");
		
		transferFrom.getItems().addAll(userAcct.getOwner().getName() + "'s Checking Account", 
				userAcct.getOwner().getName() + "'s Savings Account");
		transferTo.getItems().addAll(userAcct.getOwner().getName() + "'s Checking Account", 
				userAcct.getOwner().getName() + "'s Savings Account");
	
		transferFrom.setOnMouseEntered( e -> startPane.setCursor(Cursor.HAND) );
		
		transferFrom.setOnMouseExited( e -> startPane.setCursor(Cursor.DEFAULT) );
		
		transferTo.setOnMouseEntered( e -> startPane.setCursor(Cursor.HAND) );
		
		transferTo.setOnMouseExited( e -> startPane.setCursor(Cursor.DEFAULT) );
		
		backButton.setOnAction( e -> {
			startPane.getChildren().clear();
			loggedIn(startPane, userAcct);
		});
		
		submitButton.setOnAction( e -> {
			
			if(transferFrom.getValue().equals(userAcct.getOwner().getName() + "'s Checking Account") 
					&& transferTo.getValue().equals(userAcct.getOwner().getName() + "'s Savings Account")) {
				
				try {
					userAcct.getOwner().getChecking().withdraw(Double.parseDouble(transferAmt.getText()));
					userAcct.getOwner().getSavings().deposit(Double.parseDouble(transferAmt.getText()));
					
					Alert success = new Alert(AlertType.CONFIRMATION, "You have successfully "
							+ "transfered " + String.format("%,.2f", transferAmt.getText())
							+ "from your Checking to your Savings. Thanks for banking "
							+ "with us!", ButtonType.OK);
					success.showAndWait();
					
					startPane.getChildren().clear();
					loggedIn(startPane, userAcct);
				}
				catch(NumberFormatException e1) {
					Alert invalidAmt = new Alert(AlertType.ERROR, "You have entered an invalid "
							+ "number. Try again.", ButtonType.OK);
					invalidAmt.showAndWait();
					
					transferFrom.getItems().clear();
					transferTo.getItems().clear();
					transferAmt.clear();
				}
			}
			else if(transferFrom.getValue().equals(userAcct.getOwner().getName() + "'s Savings Account") 
					&& transferTo.getValue().equals(userAcct.getOwner().getName() + "'s Checking Account")) {
				
				try {
					userAcct.getOwner().getSavings().withdraw(Double.parseDouble(transferAmt.getText()));
					userAcct.getOwner().getChecking().deposit(Double.parseDouble(transferAmt.getText()));
					
					Alert success = new Alert(AlertType.CONFIRMATION, "You have successfully "
							+ "transfered " + String.format("%,.2f", transferAmt.getText())
							+ "from your Savings to your Checking. Thanks for banking "
							+ "with us!", ButtonType.OK);
					success.showAndWait();
					
					startPane.getChildren().clear();
					loggedIn(startPane, userAcct);
				}
				catch(NumberFormatException e1) {
					Alert invalidAmt = new Alert(AlertType.ERROR, "You have entered an invalid "
							+ "number. Try again.", ButtonType.OK);
					invalidAmt.showAndWait();
					
					transferFrom.getItems().clear();
					transferTo.getItems().clear();
					transferAmt.clear();
				}
				
			}
			else {
				Alert sameAcct = new Alert(AlertType.ERROR, "You are attempting to transfer"
						+ " money from the same account you are transfering into. Please choose"
						+ " two different accounts to perform this action.", ButtonType.OK);
				sameAcct.showAndWait();
				transferFrom.getItems().clear();
				transferTo.getItems().clear();
				transferAmt.clear();
			}
		});
		
		hbox.getChildren().add(transferFrom);
		hbox1.getChildren().add(transferTo);
		hbox2.getChildren().addAll(submitButton, backButton);
		
		vbox.getChildren().addAll(hbox, hbox1, transferAmt);
		
		vbox.setSpacing(20);
		
		startPane.setCenter(vbox);
		startPane.setBottom(hbox2);
		
		vbox.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(hbox2, Pos.BOTTOM_CENTER);
		
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 * @param change
	 */
	public void changeUserCreds(BorderPane startPane, BankAccount userAcct, String change) {
		startPane.setStyle("-fx-background-color: #f5deb3");
		
		VBox vbox = new VBox();
		VBox vbox1 = new VBox();
		HBox hbox = new HBox();
		
		Label label = new Label();
		Label label1 = new Label();
		Label label2 = new Label();
		
		TextField currUsername = new TextField();
		TextField updatedInfo = new TextField();
		
		PasswordField oldProtected = new PasswordField();
		PasswordField updatedProt = new PasswordField();
		PasswordField updatedProtAgain = new PasswordField();
		
		Button submitButton = new Button("Submit");
		Button exitButton = new Button("Exit");
		Button clearButton = new Button("Clear");
		Button backButton = new Button("Back");
		
		vbox.setPadding(new Insets (20));
		vbox.setSpacing(36);
		
		vbox1.setPadding(new Insets(20));
		vbox1.setSpacing(30);
		
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(180);
		
		if(change.equals("pass")) {
			startPane.getChildren().clear();
			
			label.setText("Please enter your old password: ");
			label1.setText("Please enter the new password you would like: ");
			label2.setText("Please enter the new password again: ");
			
			label.setFont(new Font("Comic Sans MS", 16));
			label1.setFont(new Font("Comic Sans MS", 16));
			label2.setFont(new Font("Comic Sans MS", 16));
			
			oldProtected.setPromptText("Current Password");
			updatedProt.setPromptText("New Password");
			updatedProtAgain.setPromptText("New Password Again");
			
			hbox.getChildren().addAll(exitButton, submitButton, backButton, clearButton);
			vbox.getChildren().addAll(label, label1, label2);
			vbox1.getChildren().addAll(oldProtected, updatedProt, updatedProtAgain);
			
			startPane.setLeft(vbox);
			startPane.setCenter(vbox1);
			startPane.setBottom(hbox);
			
			submitButton.setOnAction( e -> {
				if(oldProtected.getText().equals(userAcct.getPassword()) && 
						updatedProt.getText().equals(updatedProtAgain.getText()) &&
						isValidPassword(updatedProt.getText()) && 
						isValidPassword(updatedProtAgain.getText())) {
					
					userAcct.setPassword(updatedProt.getText());
					Alert success = new Alert(AlertType.CONFIRMATION, "Your password has"
							+ " been successfully changed!", ButtonType.OK);
					success.showAndWait();
					startPane.getChildren().clear();
					loggedIn(startPane, userAcct);
				}
				else {
					Alert problem = new Alert(AlertType.ERROR, "Your new passwords didn't"
							+ " match up, or you entered the wrong password for the current"
							+ " password. Please try again.\nRemember, your"
							+ " password must contain a number, uppercase letter,"
							+ " and be at least seven characters long.", ButtonType.OK);
					problem.showAndWait();
					startPane.getChildren().clear();
					changeUserCreds(startPane, userAcct, "pass");
				} 
			} );
			
			clearButton.setOnAction( e -> { oldProtected.clear(); updatedProt.clear();
				updatedProtAgain.clear(); } );
		}
		else if(change.equals("user")) {
			startPane.getChildren().clear();
			
			label.setText("Please enter your current username: ");
			label1.setText("Please enter your new username you would like: ");
			
			label.setFont(new Font("Comic Sans MS", 16));
			label1.setFont(new Font("Comic Sans MS", 16));
			
			currUsername.setPromptText("Current Username");
			updatedInfo.setPromptText("New Username");

			hbox.getChildren().addAll(exitButton, submitButton, backButton, clearButton);
			vbox.getChildren().addAll(label, label1);
			vbox1.getChildren().addAll(currUsername, updatedInfo);
			
			startPane.setLeft(vbox);
			startPane.setCenter(vbox1);
			startPane.setBottom(hbox);
			
			submitButton.setOnAction( e -> {
				if(userAcct.getUserName().equals(currUsername.getText()) && 
						!userAcct.getUserName().equals(updatedInfo.getText())) {
					
					userAcct.setUserName(updatedInfo.getText());
					Alert success = new Alert(AlertType.CONFIRMATION, "Your username has"
							+ " been successfully changed!", ButtonType.OK);
					success.showAndWait();
					startPane.getChildren().clear();
					loggedIn(startPane, userAcct);
				}
				else {
					Alert problem = new Alert(AlertType.ERROR, "You have entered the "
							+ "incorrect username for this account, or used the same "
							+ "username to change to. Please try again.", 
							ButtonType.OK);
					problem.showAndWait();
					startPane.getChildren().clear();
					changeUserCreds(startPane, userAcct, "user");
				}
			});
			
			clearButton.setOnAction( e -> { currUsername.clear(); 
				updatedInfo.clear(); } ); 
		}
		else if(change.equals("pin")) {
			startPane.getChildren().clear();
			
			label.setText("Please enter your old PIN #: ");
			label1.setText("Please enter the new PIN # you would like: ");
			label2.setText("Please enter the new PIN # again: ");
			
			label.setFont(new Font("Comic Sans MS", 16));
			label1.setFont(new Font("Comic Sans MS", 16));
			label2.setFont(new Font("Comic Sans MS", 16));
			
			oldProtected.setPromptText("Current PIN #");
			updatedProt.setPromptText("New PIN #");
			updatedProtAgain.setPromptText("New PIN # Again");
			
			hbox.getChildren().addAll(exitButton, submitButton, backButton, clearButton);
			vbox.getChildren().addAll(label, label1, label2);
			vbox1.getChildren().addAll(oldProtected, updatedProt, updatedProtAgain);
			
			startPane.setLeft(vbox);
			startPane.setCenter(vbox1);
			startPane.setBottom(hbox);
			
			submitButton.setOnAction( e -> {
				if(Integer.parseInt(oldProtected.getText()) == userAcct.getPin() && 
						isValidPin(updatedProt.getText()) && isValidPin(updatedProtAgain.getText()) &&
						updatedProt.getText().equals(updatedProtAgain.getText())) {
					
					Alert success = new Alert(AlertType.CONFIRMATION, "Your PIN # has"
							+ " been successfully changed!", ButtonType.OK);
					
					success.showAndWait();
					
					startPane.getChildren().clear();
					
					loggedIn(startPane, userAcct);
					
				}
				else {
					Alert problem = new Alert(AlertType.ERROR, "Your new PIN numbers didn't"
							+ " match up, or you entered the wrong PIN # for the current"
							+ " PIN. Please try again.", ButtonType.OK);
					problem.showAndWait();
					startPane.getChildren().clear();
					changeUserCreds(startPane, userAcct, "pin");
				} 
			} );
			
			clearButton.setOnAction( e -> { oldProtected.clear(); updatedProt.clear();
				updatedProtAgain.clear(); } );
		}
		else {
			Alert problem = new Alert(AlertType.ERROR, "Well...This is embarassing."
					+ " It seems there is a software error, please try again. Sorry"
					+ " for any inconvience.", ButtonType.OK);
			problem.showAndWait();
			mainPage(startPane);
		}
		
		exitButton.setOnAction( e -> System.exit(0) );
		
		backButton.setOnAction( e -> { startPane.getChildren().clear();
			loggedIn(startPane, userAcct); } );
	}
	
	/**
	 * 
	 * @param userPassword
	 * @return
	 */
	public boolean isValidPassword(String userPassword) {

		boolean hasDigit = false;
		boolean hasUppercase = false;
		boolean longEnough = false;

		for(int i = 0; i < userPassword.length(); i++) {
			char currentLetter = userPassword.charAt(i);

			if(Character.isDigit(currentLetter)) {
				hasDigit = true;
			}
			if(Character.isUpperCase(currentLetter)) {
				hasUppercase = true;
			}
			if(userPassword.length() >= 7) {
				longEnough = true;
			}
		}
		
		if(hasDigit && hasUppercase && longEnough) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param userPIN
	 * @return
	 */
	public boolean isValidPin(String userPIN) {
		try {
			int userPin = Integer.parseInt(userPIN);
			
			if(userPin >= 10000 || userPin <= 999) {
				return false;
			}
			else {
				return true;
			}
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 */
	public void createNewAccount(BorderPane startPane, BankAccount userAcct) {
		Bank bank = userAcct.getBank();
		
		if(userAcct.getOwner().hasChecking() && userAcct.getOwner().hasSavings()) {
			Alert alert = new Alert(AlertType.ERROR, "You can only have one checking and "
					+ "savings per account. Sorry!", ButtonType.OK);
			alert.showAndWait();
			loggedIn(startPane, userAcct);
		}
		else if(userAcct instanceof CheckingAcct) {
			SavingsAcct userAcct1 = new SavingsAcct(userAcct.getOwner(), userAcct.getBank(), userAcct.getUserName(), userAcct.getPassword());
			userAcct.getOwner().addSavings(userAcct1);
			userAcct1.setUpAccount();
			bank.addAccount(userAcct1);
			userAcct1.setOwner(userAcct.getOwner());
			Alert alert = new Alert(AlertType.CONFIRMATION, "You have successfully"
					+ " made a new savings account! Thank you for banking with us."
					+ " You will now be able to swap accounts via \"My Accounts\" tab!", ButtonType.OK);
			alert.showAndWait();
			if(alert.getResult() == ButtonType.OK) {
				startPane.getChildren().clear();
				loggedIn(startPane, userAcct);
			}
			else {
				startPane.getChildren().clear();
				loggedIn(startPane, userAcct);
			}
		}
		else {
			CheckingAcct userAcct1 = new CheckingAcct(userAcct.getOwner(), userAcct.getBank(), userAcct.getUserName(), userAcct.getPassword());
			userAcct.getOwner().addChecking(userAcct1);
			userAcct1.setUpAccount();
			bank.addAccount(userAcct1);	
			userAcct1.setOwner(userAcct.getOwner());
			Alert alert = new Alert(AlertType.CONFIRMATION, "You have successfully"
					+ " made a new checking account! Thank you for banking with us."
					+ " You will now be able to swap accounts via \"My Accounts\" tab!",
					ButtonType.OK);
			alert.showAndWait();
			if(alert.getResult() == ButtonType.OK) {
				startPane.getChildren().clear();
				loggedIn(startPane, userAcct);
			}
			else {
				startPane.getChildren().clear();
				loggedIn(startPane, userAcct);
			}
		}
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 */
	public void removeAccount(BorderPane startPane, BankAccount userAcct) {
		startPane.setStyle("-fx-background-color: WHITE");
		
		Label whichAcct = new Label("Which account would you like to remove?");
		
		Button checking = new Button("Checking Acct");
		Button savings = new Button("Savings Acct");
		Button backButton = new Button("Back");
		
		HBox hbox = new HBox(checking, savings, backButton);
		
		startPane.setCenter(whichAcct);
		startPane.setBottom(hbox);
		
		BorderPane.setAlignment(hbox, Pos.BOTTOM_LEFT);
		
		hbox.setSpacing(240);
		hbox.setPadding(new Insets(10));

		whichAcct.setFont(new Font("Comic Sans MS", 16));
		
		checking.setOnAction( e -> {
			if(userAcct.getOwner().hasChecking()) {
				Alert remove = new Alert(AlertType.CONFIRMATION, "You are about to remove"
						+ " the checking account associated with " + userAcct.getOwner().toString() +
						". This action is irreversible. Would you like to proceed?", ButtonType.NO,
						ButtonType.YES);
				remove.showAndWait();
				if(remove.getResult() == ButtonType.YES) {
					userAcct.getOwner().removeChecking();
					Alert removed = new Alert(AlertType.INFORMATION, "You have successfully"
							+ " removed the checking account associated.", ButtonType.OK);
					removed.showAndWait();
					startPane.getChildren().clear();
					try {
						loggedIn(startPane, userAcct.getOwner().getSavings());
					}
					catch(NullPointerException e1) {
						Alert noAccounts = new Alert(AlertType.ERROR, "You do not have any"
								+ " active accounts with " + userAcct.getBank().getName() +
								". Please open an account via the sign up page to get started.", 
								ButtonType.OK);
						noAccounts.showAndWait();
						mainPage(startPane);
					}
				}
				else {
					startPane.getChildren().clear();
					loggedIn(startPane, userAcct);
				}
			}
			else {
				Alert noAcct = new Alert(AlertType.ERROR, "You do not have a checking account"
						+ " with " + userAcct.getBank().getName() + ".", ButtonType.OK);
				noAcct.showAndWait();
				startPane.getChildren().clear();
				loggedIn(startPane, userAcct);
			}
		});
		
		savings.setOnAction( e -> {
			if(userAcct.getOwner().hasSavings()) {
				Alert remove = new Alert(AlertType.CONFIRMATION, "You are about to remove"
						+ " the savings account associated with " + userAcct.getOwner().toString() +
						". This action is irreversible. Would you like to proceed?", ButtonType.NO,
						ButtonType.YES);
				remove.showAndWait();
				if(remove.getResult() == ButtonType.YES) {
					userAcct.getOwner().removeSavings();
					Alert removed = new Alert(AlertType.INFORMATION, "You have successfully"
							+ " removed the savings account associated.", ButtonType.OK);
					removed.showAndWait();
					startPane.getChildren().clear();
					try {
						loggedIn(startPane, userAcct.getOwner().getChecking());
					}
					catch(NullPointerException e1) {
						Alert noAccounts = new Alert(AlertType.ERROR, "You do not have any"
								+ " active accounts with " + userAcct.getBank().getName() +
								". Please open an account via the sign up page to get started.", 
								ButtonType.OK);
						noAccounts.showAndWait();
						mainPage(startPane);
					}
				}
				else {
					startPane.getChildren().clear();
					loggedIn(startPane, userAcct);
				}
			}
			else {
				Alert noAcct = new Alert(AlertType.ERROR, "You do not have a savings account"
						+ " with " + userAcct.getBank().getName() + ".", ButtonType.OK);
				noAcct.showAndWait();
				startPane.getChildren().clear();
				loggedIn(startPane, userAcct);
			}
		});
		
		backButton.setOnAction( e -> { startPane.getChildren().clear();
			loggedIn(startPane, userAcct); } );
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 */
	public void switchAccounts(BorderPane startPane, BankAccount userAcct) {
		if(userAcct instanceof CheckingAcct) {
			startPane.getChildren().clear();
			loggedIn(startPane, userAcct.getOwner().getSavings());
		}
		else if(userAcct instanceof SavingsAcct){
			startPane.getChildren().clear();
			loggedIn(startPane, userAcct.getOwner().getChecking());
		}
		else {
			Alert error = new Alert(AlertType.ERROR, "There was no other account for "
					+ "you to switch too. Sorry!", ButtonType.OK);
			error.showAndWait();
			
			if(error.getResult() == ButtonType.OK) {
				startPane.getChildren().clear();
				loggedIn(startPane, userAcct);	
			}
		}		
	}
	
	/**
	 * 
	 * @param startPane
	 * @param bank
	 */
	public void aboutusScreen(BorderPane startPane, BankAccount bank) {
		startPane.setStyle("-fx-background-color: #9370db");
		
		String aboutMe = " So, I'm writing this sitting down in my living room amongst\n"
				+ " the midst of COVID-19. This page is mainly to show you\n"
				+ " a little bit about myself, while showcasing my Java programming\n"
				+ " skills! Lets start clicking some buttons and learning a little\n"
				+ " bit about me! Start in the top left, then go counter clockwise!";
		Label aboutme = new Label(aboutMe);
		
		HBox hbox = new HBox();
		HBox hbox1 = new HBox();
		
		Button school = new Button("School");
		Button priorWork = new Button("Work History");
		Button aboutMyself = new Button("About Me");
		Button back = new Button("Back");
		
		school.setPrefWidth(170);
		priorWork.setPrefWidth(170);
		aboutMyself.setPrefWidth(170);
		back.setPrefWidth(170);
		
		aboutme.setTextAlignment(TextAlignment.CENTER);
		aboutme.setFont(new Font("Comic Sans MS", 20));
		
		hbox.getChildren().addAll(school, priorWork);
		hbox1.getChildren().addAll(back, aboutMyself);
		
		hbox.setPadding(new Insets(15));
		hbox.setSpacing(400);
		
		hbox1.setPadding(new Insets(15));
		hbox1.setSpacing(400);
				
		back.setOnAction( e -> { startPane.getChildren().clear();
			mainPage(startPane); } );
		
		BorderPane.setAlignment(hbox, Pos.TOP_LEFT);
		BorderPane.setAlignment(hbox1, Pos.BOTTOM_LEFT);
		
		startPane.setTop(hbox);
		startPane.setCenter(aboutme);
		startPane.setBottom(hbox1);
		
		school.setOnAction( e -> { startPane.getChildren().clear();
			Label section = new Label("School");
			Label schoolStuff = new Label("I graduated from Howell High School in 2016."
					+ " From there, I went to Brookdale Community College, and then I"
					+ " enrolled in the College of Science and Mathematics at Rowan University."
					+ " I am currently as of May 11th, 2020 (when this personal project was started)"
					+ " pursuing a BA Degree in Computing and Informatics, with a minor"
					+ " in Computer Science, and a concetration in Cyber Security. As well,"
					+ " I have a Certificate of Undergraduate Studies in Management Information Systems."
					+ " To make this a little more structured:\n\n\nRowan University\n"
					+ "Major: Computing and Informatics\nMinor: Computer Science\nConcentration: Cyber Security"
					+ "\nCUGS in MIS");
			
			schoolStuff.setWrapText(true);
			schoolStuff.setFont(new Font("Comic Sans MS", 18));
			schoolStuff.setPadding(new Insets(10));
			
			section.setPadding(new Insets(10));
			section.setFont(new Font("Comic Sans MS", 20));
			
			hbox.getChildren().clear();
			hbox.getChildren().add(back);
			hbox.setPadding(new Insets(10));
			
			BorderPane.setAlignment(section, Pos.TOP_CENTER);
			BorderPane.setAlignment(hbox, Pos.BOTTOM_LEFT);
			
			startPane.setTop(section);
			startPane.setCenter(schoolStuff);
			startPane.setBottom(hbox);
			
			back.setOnAction( e1 -> { 
				startPane.getChildren().clear(); 
				aboutusScreen(startPane, bank); 
			} );
		});
	}
}