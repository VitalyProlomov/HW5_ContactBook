package vitalyprolomov.contactbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactBookController implements Initializable {
    public Label cityTextLabel;
    public TableView contactsTableView;
    public Label nameLabel;
    public Label surnameLabel;
    public Label telephoneLabel;
    public Label cityLabel;
    public Label postalCodeLabel;
    public Label nameTextLabel;
    public Label surnameTextLabel;
    public Label telephoneTextLabel;
    public Label postalCodeTextLabel;
    public Label personDetailsLabel;
    public Label birthdayTextLabel;
    public Label birthdayLabel;
    public TableColumn<Person, String> nameColumn;
    public TableColumn<Person, String> surnameColumn;
    public Button editContactButton;
    public Button addContactButton;
    public Button exitButton;

    static ObservableList<Person> allPersons = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTable();
        setButtons();
    }

    public void addPerson(Person person) throws Exception {
        if (ValidatorUtils.isPersonValid(person)) {
            allPersons.add(person);
        } else {
            throw new IllegalArgumentException("Invalid person, could not be added.");
        }
    }

    public void addAction(MouseEvent mouseEvent, AddContactViewController.Mode mode) {
        Stage addContactStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(BookApplication.class.getResource("add-contact-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 300, 440);
        } catch (IOException e) {
            System.out.println("Could not open window " + e.getMessage());
        }

        addContactStage.initModality(Modality.APPLICATION_MODAL);

        AddContactViewController.mode = mode;

        addContactStage.setTitle("Edit User");
        addContactStage.setScene(scene);
        addContactStage.show();
    }

    public void setButtons() {
        addContactButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addAction(mouseEvent, AddContactViewController.Mode.ADD);
            }
        });

        editContactButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                addAction(mouseEvent, AddContactViewController.Mode.EDIT);
            }
        });
    }

    public void setTable() {
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("name"));
        surnameColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("surname"));

        allPersons.add(new Person("Example Name", "Example Surname",
                "Yekaterinburg", "620026",
                "20.05.2001", "+79124503288"));

        contactsTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Person clickedPerson = (Person) contactsTableView.getSelectionModel().getSelectedItem();
                if (clickedPerson != null) {
                    nameTextLabel.setText(clickedPerson.getName());
                    surnameTextLabel.setText(clickedPerson.getSurname());
                    telephoneTextLabel.setText(clickedPerson.getTelephoneNumber());
                    cityTextLabel.setText(clickedPerson.getCity());
                    postalCodeTextLabel.setText(clickedPerson.getPostalCode());
                    birthdayTextLabel.setText(clickedPerson.getBirthdayData());
                }
            }
        });

        contactsTableView.setItems((ObservableList) allPersons);


    }

}
