import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class SignUpPageController implements Initializable {

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnLogin;

  

    @FXML
    private DatePicker dateDOB;

    @FXML
    private Label lblDOB;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblPatient;

    @FXML
    private Label lblPhoneNumber;

    @FXML
    private PasswordField passPassword;

    @FXML
    private ImageView picPatient;

    @FXML
    private TextField txtEmail;

    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
     
        cmbGender.getItems().setAll("Male", "Female");
        cmbGender.getSelectionModel().selectFirst();
        
        btnSignUp.setOnAction((ActionEvent event) -> {
            if (!txtEmail.getText().trim().isEmpty() && !passPassword.getText().trim().isEmpty()) {
                String validatePassword = isValidPassword(passPassword.getText());
                if (!isValidEmail(txtEmail.getText())) {
                    showAlert("Invalid Email!");
                } else if (!validatePassword.equals("valid")) {
                    showAlert(validatePassword);
                } else {
                    Patient patient = new Patient(txtName.getText(), txtEmail.getText(), passPassword.getText(), txtPhoneNumber.getText(),cmbGender.getValue(), dateDOB.getValue().toString());
                    patient.setPhoneNumber(txtPhoneNumber.getText());
                    if (patient.signup()) {
                       
                        showAlert("registered successfully");
                    } else {
                        showAlert("Account already exists!");
                    }
                }
            } else {
                showAlert("Please fill in all information to sign up!");
            }
        });

        btnLogin.setOnAction((ActionEvent event) -> {
            sceneController.changeScene(event, "LoginPage.fxml", "Login");
        }); 
    }

   

        private boolean isValidEmail(String email){
            if(email.contains("@staff")) return false;
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                                "[a-zA-Z0-9_+&*-]+)*@" +
                                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                                "A-Z]{2,7}$";
                            
            Pattern pat = Pattern.compile(emailRegex);
            if (email == null)
                return false;
            if(!isValidEmailHelper(email))
                return false;
            return pat.matcher(email).matches();
        }
    
        private boolean isValidEmailHelper(String email){
            if(email.toLowerCase().contains("@doctor") || email.toLowerCase().contains("@admin") )
                return false;
            return true;
        }   
    
        private String isValidPassword (String password){
        boolean checkValidity = true;
        int passwordLength=8, upChars=0, lowChars=0;
        int special=0, digits=0;
        char ch;
        
        int total = password.length();
        if(total<passwordLength) return "password length must be at least 8 charactrs";
        
        else
        {
            for(int i=0; i<total; i++)
            {
                ch = password.charAt(i);
                if(Character.isUpperCase(ch))
                upChars = 1;
                else if(Character.isLowerCase(ch))
                lowChars = 1;
                else if(Character.isDigit(ch))
                digits = 1;
                else
                special = 1;
            }
        }
        if(upChars!=1) return "passwrd must contain at least 1 uppercase letter";
        else if(lowChars!=1) return "password must contain at least 1 lowercase leeter";
        else if( digits!=1) return "password must contain at least 1 digit";
        else if(special!=1) return "password msut contain at least 1 special character";
        
        return "valid";
        }
    
        private void showAlert(String message) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(message);
            alert.show();
        }

    }


