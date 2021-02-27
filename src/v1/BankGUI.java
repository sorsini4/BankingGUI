package v1;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.SeparatorMenuItem;

/**
 * 
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
		setupControls(startPane);
		Scene scene = new Scene(startPane);
		setStage(primaryStage, scene);
	}
	
	/**
	 * 
	 * @param primaryStage
	 * @param scene
	 */
	public void setStage(Stage primaryStage, Scene scene) {
		primaryStage.setWidth(650);
		primaryStage.setHeight(650);
		primaryStage.setTitle("stevensBankApp(boolean isTheBest = true);");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * 
	 * @param startPane
	 */
	public void setupControls(BorderPane startPane) {
		startPane.setStyle("-fx-background-color: LAVENDER");
		
		Label startUp = new Label("Hello! Welcome to my Banking App. Please choose an option.");		
		
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
		
		openAcct.setDisable(true);
		switchAccts.setDisable(true);
		removeAcct.setDisable(true);
		changeUsername.setDisable(true);
		changePass.setDisable(true);
		changePin.setDisable(true);
		
		mainPage.setOnAction( e -> { startPane.getChildren().clear(); 
			setupControls(startPane); } );
		
		loginPage.setOnAction( e -> { startPane.getChildren().clear();
			setLoginScreen(startPane); } );
		
		signupPage.setOnAction( e -> { startPane.getChildren().clear();
			setSignupScreen(startPane); } );
		
		aboutus.setOnAction( e -> { startPane.getChildren().clear();
			aboutusScreen(startPane, new CheckingAcct(new Person(""), new Bank(""), "", "" )); } );
		
		Image myImage = new Image("rylee.jpg");
		ImageView stevesLogo = new ImageView(myImage);
		
		VBox vbox = new VBox(menubar, startUp);
		HBox hbox = new HBox();
				
		stevesLogo.setFitHeight(250);
		stevesLogo.setFitWidth(200);
		stevesLogo.setX(225);
		stevesLogo.setY(200);
		
		vbox.setSpacing(20);
		
		startUp.setFont(new Font("Comic Sans MS", 20));
		startUp.setTextAlignment(TextAlignment.CENTER);
		
		Button loginButton = new Button("Login");
		Button signupButton = new Button("Sign up");
		Button exitButton = new Button("Exit");
		
		loginButton.setStyle("-fx-background-color: #ffe4b5");
		signupButton.setStyle("-fx-background-color: #dda0dd");
		exitButton.setStyle("-fx-background-color: #ff0000");
		
		loginButton.setFont(new Font("Comic Sans MS", 13));
		signupButton.setFont(new Font("Comic Sans MS", 13));
		exitButton.setFont(new Font("Comic Sans MS", 13));
		
		loginButton.setPrefWidth(60);
		signupButton.setPrefWidth(70);
		exitButton.setPrefWidth(60);
		
		hbox.getChildren().addAll(loginButton, exitButton, signupButton);
		hbox.setPadding(new Insets(20));
		hbox.setSpacing(210);
		
		startUp.setPadding(new Insets(35));
		
		startPane.getChildren().add(stevesLogo);
		startPane.setBottom(hbox);
		startPane.setTop(vbox);
		
		BorderPane.setAlignment(hbox, Pos.BOTTOM_LEFT);
		BorderPane.setAlignment(startUp, Pos.TOP_CENTER);
		BorderPane.setAlignment(stevesLogo, Pos.CENTER);
		
		loginButton.setOnAction( e -> { startPane.getChildren().remove(stevesLogo);
			setLoginScreen(startPane); } );
		
		exitButton.setOnAction( e -> System.exit(0) );
		
		signupButton.setOnAction( e -> { startPane.getChildren().remove(stevesLogo);
			setSignupScreen(startPane); } );
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
		Label bankLabel = new Label("Bank");
		Label pinLabel = new Label("PIN #: ");
		Label fnameLabel = new Label("First name: ");
		Label lnameLabel = new Label("Last name: ");
		Label question = new Label("I would like to open a ... (choose one, the other can be opened later)");
		Label checkingLabel = new Label("Checking Account:          ");
		Label savingsLabel = new Label("Savings Account:             ");
		
		prompt.setFont(new Font("Comic Sans MS", 18));
		userLabel.setFont(new Font("Times New Roman", 15));
		passLabel.setFont(new Font("Times New Roman", 15));
		bankLabel.setFont(new Font("Times New Roman", 15));
		pinLabel.setFont(new Font("Times New Roman", 15));
		fnameLabel.setFont(new Font("Times New Roman", 15));
		lnameLabel.setFont(new Font("Times New Roman", 15));
		question.setFont(new Font("Comic Sans MS", 13));
		checkingLabel.setFont(new Font("Times New Roman", 15));
		savingsLabel.setFont(new Font("Times New Roman", 15));
		
		PasswordField password = new PasswordField();
		PasswordField userPIN = new PasswordField();
		
		TextField username = new TextField();
		TextField userFirst = new TextField();
		TextField userLast = new TextField();
		
		ComboBox<String> bankOptions = new ComboBox<String>();
		bankOptions.getItems().addAll("TD Bank", "Chase", "Santander");
		
		username.setPromptText("Enter a username");
		password.setPromptText("Enter a password");
		userPIN.setPromptText("Enter a PIN");
		userFirst.setPromptText("Your first name");
		userLast.setPromptText("Your last name");
		bankOptions.setPromptText("Choose an option");
		
		CheckBox checkingBox = new CheckBox();
		CheckBox savingsBox = new CheckBox();
		
		Button exit = new Button("Exit");
		Button clear = new Button("Clear");
		Button back = new Button("Back");
		Button submit = new Button("Submit");
		
		VBox vbox = new VBox(fnameLabel, lnameLabel, userLabel, passLabel, bankLabel, pinLabel, question);
		VBox vbox1 = new VBox(userFirst, userLast, username, password, bankOptions, userPIN);
		HBox hbox = new HBox(back, clear, submit, exit);		
		HBox hbox1 = new HBox(checkingLabel, checkingBox);
		HBox hbox2 = new HBox(savingsLabel, savingsBox);
		
		vbox.getChildren().add(hbox1);
		vbox.getChildren().add(hbox2);
		
		prompt.setPadding(new Insets(10));
		
		vbox.setPadding(new Insets(15));
		vbox.setSpacing(25);
		
		vbox1.setPadding(new Insets(15));
		vbox1.setSpacing(14);
		
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(147);
		
		startPane.setLeft(vbox);
		startPane.setCenter(vbox1);
		startPane.setTop(prompt);
		startPane.setBottom(hbox);
		
		BorderPane.setAlignment(prompt, Pos.CENTER);
		
		checkingBox.setOnAction( e -> savingsBox.setSelected(false) );
		
		savingsBox.setOnAction( e -> checkingBox.setSelected(false) );
		
		exit.setOnAction( e -> System.exit(0) );
		
		clear.setOnAction( e -> { username.clear(); password.clear(); 
			bankOptions.getSelectionModel().clearSelection(); userPIN.clear(); 
			userFirst.clear(); userLast.clear(); checkingBox.setSelected(false); 
			savingsBox.setSelected(false); } );
		
		back.setOnAction( e -> { setupControls(startPane); vbox.getChildren().clear(); 
			vbox1.getChildren().clear(); hbox.getChildren().clear();
			hbox1.getChildren().clear(); hbox2.getChildren().clear(); } );
		
		submit.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			public void handle(ActionEvent event) {
				
				if(userFirst.getText().isEmpty()) {
					fnameLabel.setTextFill(Color.RED);
					prompt.setText("Please fill out all required fields.");
					return;
				}
				else {
					fnameLabel.setTextFill(Color.BLACK);
				}
				if(userLast.getText().isEmpty()) {
					lnameLabel.setTextFill(Color.RED);
					prompt.setText("Please fill out all required fields.");
					return;
				}
				else {
					lnameLabel.setTextFill(Color.BLACK);
				}
				if(username.getText().isEmpty()) {
					userLabel.setTextFill(Color.RED);					
					prompt.setText("Please fill out all required fields.");
					return;
				}
				else {
					userLabel.setTextFill(Color.BLACK);
				}
			    if(password.getText().isEmpty()) {
					passLabel.setTextFill(Color.RED);
					prompt.setText("Please fill out all required fields.");
					return;
				}
				else {
					passLabel.setTextFill(Color.BLACK);
				}
				if(bankOptions.getSelectionModel().isEmpty()) {
					bankLabel.setTextFill(Color.RED);
					prompt.setText("Please fill out all required fields.");
					return;
				}
				else {
					bankLabel.setTextFill(Color.BLACK);
				}
				if(userPIN.getText().isEmpty()) {
					pinLabel.setTextFill(Color.RED);
					prompt.setText("Please fill out all required fields.");
					return;
				}
				else {
					pinLabel.setTextFill(Color.BLACK);
				}
				if(!checkingBox.isSelected() && !savingsBox.isSelected()) {
					checkingLabel.setTextFill(Color.RED);
					savingsLabel.setTextFill(Color.RED);
					prompt.setText("Please fill out all required fields.");
					return;
				}
				else {
					checkingLabel.setTextFill(Color.BLACK);
					savingsLabel.setTextFill(Color.BLACK);
				}
				
				submitSignupForm(startPane, userFirst, userLast, username, password, bankOptions, userPIN, checkingBox, savingsBox);
				vbox.getChildren().clear(); 
				vbox1.getChildren().clear(); 
				hbox.getChildren().clear(); 
				hbox1.getChildren().clear();
				hbox2.getChildren().clear(); 
				
			} } );
	}
	
	/**
	 * 
	 * @param startPane
	 */
	public void setLoginScreen(BorderPane startPane) {
		 startPane.setStyle("-fx-background-color: PINK"); 
		
		 HBox hbox = new HBox();
		 VBox vbox = new VBox();
		 VBox vbox1 = new VBox();
		 
		 Button exit = new Button("Exit");
		 Button clear = new Button("Clear");
		 Button back = new Button("Back");
		 Button submit = new Button("Submit");
		 
		 Label prompt = new Label("Enter your credentials to sign in.");
		 Label username = new Label("Enter username: ");
		 Label pass = new Label("Enter password: ");
		 Label pin = new Label("Enter PIN #: ");
		 Label bank = new Label("Choose bank: ");
		 
		 TextField userUsername = new TextField();
		 
		 ComboBox<String> bankOptions = new ComboBox<String>();
		 bankOptions.getItems().addAll("TD Bank", "Chase", "Santander");
		 
		 PasswordField userPassword = new PasswordField();
		 PasswordField userPIN = new PasswordField();
		 
		 startPane.setBottom(hbox);
		 startPane.setTop(prompt);
		 startPane.setLeft(vbox);
		 startPane.setCenter(vbox1);
		 
		 hbox.getChildren().addAll(back, clear, submit, exit);
		 hbox.setPadding(new Insets(10));
		 hbox.setSpacing(147);
		 hbox.setAlignment(Pos.BOTTOM_LEFT);
		 
		 vbox.getChildren().addAll(username, pass, pin, bank);
		 username.setFont(new Font("Times New Roman", 17));
		 pass.setFont(new Font("Times New Roman", 17));
		 pin.setFont(new Font("Times New Roman", 17));
		 bank.setFont(new Font("Times New Roman", 17));
		 vbox.setPadding(new Insets(12));
		 vbox.setSpacing(30);
		 
		 vbox1.getChildren().addAll(userUsername, userPassword, userPIN, bankOptions);
		 userUsername.setPromptText("Enter username");
		 userPassword.setPromptText("Enter password");
		 bankOptions.setPromptText("Choose your bank");
		 userPIN.setPromptText("Enter PIN");
		 vbox1.setPadding(new Insets(12));
		 vbox1.setSpacing(23);
		 
		 BorderPane.setAlignment(prompt, Pos.CENTER);
		 prompt.setPadding(new Insets(20));
		 prompt.setFont(new Font("Comic Sans MS", 20));
		 
		 exit.setOnAction( e -> System.exit(0) );
		 
		 clear.setOnAction( e -> { userUsername.clear(); userPassword.clear(); 
		 	userPIN.clear(); } );
		 
		 back.setOnAction( e -> { setupControls(startPane); hbox.getChildren().clear(); 
		 	vbox.getChildren().clear(); vbox1.getChildren().clear(); } );
		 
		 submit.setOnAction( new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent event) {
				 if(userUsername.getText().isEmpty()) {
					 username.setTextFill(Color.RED);
					 prompt.setText("Please fill out all required fields.");
					 return;
				 }
				 else {
					 username.setTextFill(Color.BLACK);
				 }
				 
				 if(userPassword.getText().isEmpty()) {
					 pass.setTextFill(Color.RED);
					 prompt.setText("Please fill out all required fields.");
					 return;
				 }
				 else {
					 pass.setTextFill(Color.BLACK);
				 }
				 
				 if(userPIN.getText().isEmpty()) {
					 pin.setTextFill(Color.RED);
					 prompt.setText("Please fill out all required fields.");
					 return;
				 }
				 else {
					 pin.setTextFill(Color.BLACK);
				 }
				 
				 if(bankOptions.getSelectionModel().isEmpty()) {
					 bank.setTextFill(Color.RED);
					 prompt.setText("Please fill out all required fields.");
					 return;
				 }
				 else {
					 bank.setTextFill(Color.BLACK);
				 }
					
				 submitLoginForm(startPane, userUsername, userPassword, userPIN, banks.getBank(bankOptions.getValue()));  
				 hbox.getChildren().clear(); 
				 vbox.getChildren().clear(); 
				 vbox1.getChildren().clear(); 
			 }
		 });
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
		String usersPIN = userPIN.getText();
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
				setLoginScreen(startPane);
			}	
			else {
				SavingsAcct userAcct = new SavingsAcct(person, bank, userUsername, userPassword);
				userAcct.setUpAccount();
				userAcct.setBank(bank);
				userAcct.setPin(usersPIN);
				bank.addAccount(userAcct);
				userAcct.setOwner(person);
				person.addSavings(userAcct);
				setLoginScreen(startPane);
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
							&& pin.getText().equals(bk.getOwner().getChecking().getPin())) {	
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
							&& pass.getText().equals(bk.getOwner().getSavings().getPassword()) 
							&& pin.getText().equals(bk.getOwner().getSavings().getPin())) {
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
			Alert noAccounts = new Alert(AlertType.ERROR, "Invalid bank. "
					+ "Would you like to exit the program (\"Close\") "
					+ "or try again (\"OK\") ?", ButtonType.CLOSE, 
					ButtonType.OK);

			noAccounts.showAndWait();

			if(noAccounts.getResult() == ButtonType.CLOSE) {
				System.exit(0);
			}
			else {
				setLoginScreen(startPane);
			}
		}
	}
	
	/**
	 * 
	 * @param startPane
	 */
	public void incorrectCredentials(BorderPane startPane) {
		startPane.setStyle("-fx-background-color: LIGHTGREEN");

		Label welcome = new Label();
		HBox hbox = new HBox();
		
		Button exitButton = new Button("Exit");
		Button backToLogin = new Button("Login");
		Button signUp = new Button("Sign up");
		
		welcome.setText("Invalid credentials.");
		welcome.setPadding(new Insets(10));
		welcome.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20)); 
		
		exitButton.setOnAction( e -> System.exit(0) );
		
		backToLogin.setOnAction( e -> { setLoginScreen(startPane); 
			hbox.getChildren().clear(); } );
		
		signUp.setOnAction( e -> { setSignupScreen(startPane); 
			hbox.getChildren().clear(); } );
		
		hbox.getChildren().addAll(backToLogin, signUp, exitButton);

		startPane.setBottom(hbox);
		startPane.setTop(welcome);
		BorderPane.setAlignment(welcome, Pos.CENTER);
		BorderPane.setAlignment(hbox, Pos.BOTTOM_LEFT);

		hbox.setPadding(new Insets(10));
		hbox.setSpacing(240);
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
		
		VBox vbox = new VBox();
		VBox vbox1 = new VBox();
		
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
			setupControls(startPane); } );
		
		loginPage.setOnAction( e -> { startPane.getChildren().clear();
			setLoginScreen(startPane); } );
		
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
						
		Button exitButton = new Button("Exit");
		Button logout = new Button("Logout");
		Button withdraw = new Button("Withdraw");
		Button checkBalance = new Button("Check Balance");
		Button deposit = new Button("Deposit");
		
		exitButton.setPrefWidth(105);
		logout.setPrefWidth(105);
		withdraw.setPrefWidth(105);
		checkBalance.setPrefWidth(105);
		deposit.setPrefWidth(105);		
		
		vbox.getChildren().addAll(withdraw, checkBalance, deposit, exitButton, logout);
		
		vbox.setSpacing(110);
		vbox.setPadding(new Insets(10));
		
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
		
		startPane.setTop(menubar);
		startPane.setLeft(vbox);
		startPane.setCenter(vbox1);
	
		BorderPane.setAlignment(vbox, Pos.CENTER_LEFT);
		vbox1.setAlignment(Pos.CENTER);
		
		deposit.setOnAction( e -> { vbox.getChildren().clear();
			userDepositScreen(startPane, userAcct); } );
		
		checkBalance.setOnAction( e -> { vbox.getChildren().clear();
			userBalanceScreen(startPane, userAcct); } );
		
		withdraw.setOnAction( e ->  { vbox.getChildren().clear(); 
			userWithdrawScreen(startPane, userAcct); } );
		
		exitButton.setOnAction( e -> System.exit(0) );
		
		logout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert goodbye = new Alert(AlertType.CONFIRMATION, "Are you sure you would"
						+ " like to log out?", ButtonType.YES, ButtonType.NO);
				goodbye.setTitle("Logout requested.");
				Optional<ButtonType> result = goodbye.showAndWait();
				if(result.isPresent() && result.get() == ButtonType.YES) {
				    startPane.getChildren().clear();
					setupControls(startPane);
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
		
		hbox.getChildren().addAll(withdrawLabel, withdrawAmt);
		hbox1.getChildren().addAll(exitButton, clearButton, submit, backButton);
		hbox2.getChildren().addAll(vbox);
		vbox.getChildren().addAll(currentBalance, accountNumber, userUsername);
		
		submit.setOnAction( new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					if(userAcct instanceof CheckingAcct) {
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
		
		currentBalance.setFont(new Font("Comic Sans MS", 15));
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
		hbox1.setSpacing(147);
		
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(30);
		hbox.setAlignment(Pos.CENTER);
		
		hbox2.setPadding(new Insets(10));
		hbox2.setSpacing(320);
		
		vbox.setSpacing(20);
		
		startPane.setTop(hbox2);
		startPane.setCenter(hbox);
		startPane.setBottom(hbox1);
		
		BorderPane.setAlignment(hbox2, Pos.TOP_LEFT);
		BorderPane.setAlignment(hbox, Pos.CENTER);
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
		hbox1.getChildren().addAll(exitButton, clearButton, submit, backButton);
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
		hbox1.setSpacing(147);
		
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
		hbox.setSpacing(545);
		
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
		hbox.setSpacing(147);
		
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
			
			hbox.getChildren().addAll(exitButton, clearButton, submitButton, backButton);
			vbox.getChildren().addAll(label, label1, label2);
			vbox1.getChildren().addAll(oldProtected, updatedProt, updatedProtAgain);
			
			startPane.setLeft(vbox);
			startPane.setCenter(vbox1);
			startPane.setBottom(hbox);
			
			submitButton.setOnAction( e -> {
				if(oldProtected.getText().equals(userAcct.getPassword()) && 
						updatedProt.getText().equals(updatedProtAgain.getText())) {
					userAcct.setPassword(updatedProt.getText());
					Alert success = new Alert(AlertType.CONFIRMATION, "Your password has"
							+ " been successfully changed!", ButtonType.OK);
					success.showAndWait();
					loggedIn(startPane, userAcct);
				}
				else {
					Alert problem = new Alert(AlertType.ERROR, "Your new passwords didn't"
							+ " match up, or you entered the wrong password for the current"
							+ " password. Please try again.", ButtonType.OK);
					problem.showAndWait();
					loggedIn(startPane, userAcct);
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

			hbox.getChildren().addAll(exitButton, clearButton, submitButton, backButton);
			vbox.getChildren().addAll(label, label1);
			vbox1.getChildren().addAll(currUsername, updatedInfo);
			
			startPane.setLeft(vbox);
			startPane.setCenter(vbox1);
			startPane.setBottom(hbox);
			
			submitButton.setOnAction( e -> {
				if(userAcct.getUserName().equals(currUsername.getText())) {
					userAcct.setUserName(updatedInfo.getText());
					Alert success = new Alert(AlertType.CONFIRMATION, "Your username has"
							+ " been successfully changed!", ButtonType.OK);
					success.showAndWait();
					loggedIn(startPane, userAcct);
				}
				else {
					Alert problem = new Alert(AlertType.ERROR, "You have entered the "
							+ "incorrect username for this account, try again.", 
							ButtonType.OK);
					problem.showAndWait();
					loggedIn(startPane, userAcct);
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
			
			hbox.getChildren().addAll(exitButton, clearButton, submitButton, backButton);
			vbox.getChildren().addAll(label, label1, label2);
			vbox1.getChildren().addAll(oldProtected, updatedProt, updatedProtAgain);
			
			startPane.setLeft(vbox);
			startPane.setCenter(vbox1);
			startPane.setBottom(hbox);
			
			submitButton.setOnAction( e -> {
				if(oldProtected.getText().equals(userAcct.getPin()) && 
						updatedProt.getText().equals(updatedProtAgain.getText())) {
					userAcct.setPin(updatedProt.getText());
					Alert success = new Alert(AlertType.CONFIRMATION, "Your PIN # has"
							+ " been successfully changed!", ButtonType.OK);
					success.showAndWait();
					loggedIn(startPane, userAcct);
				}
				else {
					Alert problem = new Alert(AlertType.ERROR, "Your new PIN numbers didn't"
							+ " match up, or you entered the wrong PIN # for the current"
							+ " PIN. Please try again.", ButtonType.OK);
					problem.showAndWait();
					loggedIn(startPane, userAcct);
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
			setupControls(startPane);
		}
		
		exitButton.setOnAction( e -> System.exit(0) );
		
		backButton.setOnAction( e -> { startPane.getChildren().clear();
			loggedIn(startPane, userAcct); } );
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
				loggedIn(startPane, userAcct);
			}
			else {
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
				loggedIn(startPane, userAcct);
			}
			else {
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
		
		hbox.setSpacing(196);
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
						setupControls(startPane);
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
						setupControls(startPane);
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
		
		backButton.setOnAction( e -> loggedIn(startPane, userAcct) );
	}
	
	/**
	 * 
	 * @param startPane
	 * @param userAcct
	 */
	public void switchAccounts(BorderPane startPane, BankAccount userAcct) {
		if(userAcct instanceof CheckingAcct) {
			loggedIn(startPane, userAcct.getOwner().getSavings());
		}
		else if(userAcct instanceof SavingsAcct){
			loggedIn(startPane, userAcct.getOwner().getChecking());
		}
		else {
			Alert error = new Alert(AlertType.ERROR, "There was no other account for "
					+ "you to open. Sorry!", ButtonType.OK);
			error.showAndWait();
			if(error.getResult() == ButtonType.OK) {
				loggedIn(startPane, userAcct);	
			}
		}		
	}
	
	public boolean validateCreds(BorderPane startPane, BankAccount userAcct) {		
		
		
		return false;
	}
	
	/**
	 * 
	 * @param startPane
	 * @param bank
	 */
	public void aboutusScreen(BorderPane startPane, BankAccount bank) {
		startPane.setStyle("-fx-background-color: #9370db");
		
		String aboutMe = " So, I'm writing this sitting down in my living room amongst\n"
				+ " the midst of COVID-19. Although, this page is mainly to show you\n"
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
			setupControls(startPane); } );
		
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
			
			back.setOnAction( e1 -> { startPane.getChildren().clear(); 
				aboutusScreen(startPane, bank); } );
		});
	}
}