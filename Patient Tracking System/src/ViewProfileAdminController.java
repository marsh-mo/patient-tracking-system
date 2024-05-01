import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewProfileAdminController {

    @FXML
    private Button btnEdit;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colPatientName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private Label lblCancelAppointment;

    @FXML
    private TableColumn<?, ?> select;

    @FXML
    private TableView<?> tblPatientDetails;

    @FXML
    void onClickEdit(ActionEvent event) {

    }

}
