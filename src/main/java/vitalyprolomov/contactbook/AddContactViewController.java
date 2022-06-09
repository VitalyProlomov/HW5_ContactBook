package vitalyprolomov.contactbook;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddContactViewController implements Initializable {
    public Label surnameLabel;
    public Label nameLabel;
    public Label telephoneLabel;
    public Label cityLabel;
    public Label postalCodeLabel;
    public Label birthdayLabel;
    public TextField nameTextField;
    public TextField surnameTextField;
    public TextField telephoneTextField;
    public TextField cityTextField;
    public TextField postalTextField;
    public TextField birthdayTextField;
    public Button saveButton;

    public enum Mode {
        EDIT,
        ADD
    }
    public static Mode mode;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        saveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                saveChanges(mode);
                Stage curStage = (Stage) saveButton.getScene().getWindow();
                curStage.close();
            }
        });
    }
    public void saveChanges(Mode mode) {
        if (mode == Mode.ADD) {
            ContactBookController.allPersons.add(new Person(
                    nameTextField.getText(), surnameTextField.getText(),
                    telephoneTextField.getText(), cityTextField.getText(),
                    postalTextField.getText(), birthdayTextField.getText()
            ));
        }
    }


}
