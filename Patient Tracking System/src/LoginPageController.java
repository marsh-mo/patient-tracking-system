import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ResourceBundle;


public class LoginPageController implements Initializable {

    sceneController sceneCont = new sceneController();
    Modle model = new Modle();
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSignUp;

    @FXML
    private Label lblInformation;

    @FXML
    private Label lblPatient;

    @FXML
    private PasswordField passPassword;

    @FXML
    private TextField txtEmail;
    
    @FXML
    private ImageView photo;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
       

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                boolean loggedIn;
                

                if (txtEmail.getText().contains("@doctor.com")) {
                    Doctor doctor = new Doctor();
                    doctor.setEmail(txtEmail.getText());
                    doctor.setPassword(passPassword.getText());
                    loggedIn = doctor.login();
                    if(loggedIn){

                        model.setDoctor(doctor);
                        
                        sceneController.changeScene(event, "MainPageDoctor.fxml", "Home page" );

                    } 
                } else if(txtEmail.getText().contains("@admin.com")){
                    Admin admin = new Admin();
                    admin.setEmail(txtEmail.getText());
                    admin.setPassword(passPassword.getText());
                    loggedIn = admin.login();

                    if(loggedIn){
                        model.setAdmin(admin);
                        
                        sceneController.changeScene(event, "MainPageAdmin.fxml", "Home page" );
                    }
                }
                    else {
                        Patient patient = new Patient();
                        patient.setEmail(txtEmail.getText());
                        patient.setPassword(passPassword.getText());
                        loggedIn = patient.login();
                        if(loggedIn){
    
                            model.setPatient(patient);
                            
                            sceneController.changeScene(event, "MainPagePatient.fxml", "Home page" );
                        }

                    }

                    if (!loggedIn) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Wrong email or username.");
                        alert.show();
                    }
                
                    }  
            });

        
    


         btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 sceneCont.changeScene(event, "SignUpPage.fxml", "Sign Up");
            }
        });


    

       
    }
    


}








