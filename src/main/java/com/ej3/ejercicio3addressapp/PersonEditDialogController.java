package com.ej3.ejercicio3addressapp;

import com.ej3.ejercicio3addressapp.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField birthdayField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initialing the controller class
     */

    @FXML
    private void initialize() {
    }

    /**
     * Setting the stage of this dialog
     */

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog window
     */

    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        streetField.setText(person.getStreet());
        postalCodeField.setText(Integer.toString(person.getPostalCode()));
        cityField.setText(person.getCity());
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
    }

    /**
     * checks if the user clicked ok and returns true
     */

    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Used when the user clicks ok.
     */

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setStreet(streetField.getText());
            person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
            person.setCity(cityField.getText());
            person.setBirthday(DateUtil.parse(birthdayField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Checking if the user input is valid.
     */

    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "First name is not valid!";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "Last name is not valid!";
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "Street is not valid!";
        }
        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "Postal code is not valid!";
        } else {
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Postal code must be a number!";
            }
        }
        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "City is not valid!";
        }
        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "Birthday is not valid!";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "Birthday must be in the format dd.mm.yyyy!";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            //error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Fields are not valid");
            alert.setHeaderText("Please check the invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    /**
     * Used when the user clicks cancel.
     */

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
