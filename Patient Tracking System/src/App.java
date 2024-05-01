import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    Stage primaryStage = new Stage(); // Login
    Stage stageSignUp = new Stage();
    Stage stageMainAdmin = new Stage();
    Stage stageMainPatient = new Stage();
    Stage stageMainDoctor = new Stage();
    Stage stageBookAppPatient = new Stage();
    Stage stageCancelAppAdmin = new Stage();
    Stage stageRemovePatientAdmin = new Stage();
    Stage stageViewAppPatient = new Stage();
    Stage stageViewPrescriptionPatient = new Stage();
    Stage stageViewProfileAdmin = new Stage();
    Stage stageViewProfilePatient = new Stage();
    Stage stageWritePrescriptionDoctor = new Stage();

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
            Parent root = (Parent) fxmlloader.load();
            Scene scene = new Scene(root);
            primaryStage.setTitle("Login");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setWidth(770.0);
            primaryStage.setHeight(443.0);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {//هذه مسؤله عن تشغيل البرنامج كله
        launch(args);
    }
}