import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CancelAppointmentAdminController {

    @FXML
    private Button btnCancel;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDoctorName;

    @FXML
    private TableColumn<?, ?> colPatientName;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private Label lblCancelAppointment;

    @FXML
    private TableColumn<?, ?> select;

    @FXML
    private TableView<?> tblCancelAppointment;

    @FXML
    void onClickCancel(ActionEvent event) {

    }

}
