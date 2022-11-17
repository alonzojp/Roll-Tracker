package com.example.rolltracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ArknightsController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label pullsLabel;
    @FXML
    TextField orundumTextField;
    @FXML
    TextField originitePrimeTextField;
    @FXML
    TextField yellowCertificatesTextField;
    @FXML
    TextField headhuntingPermitsTextField;


    public void switchToHomeView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void updateRollsLabel(ActionEvent event) throws IOException {
        String orundumCount = orundumTextField.getText();
        String originitePrimeCount = originitePrimeTextField.getText();
        String yellowCertificatesCount = yellowCertificatesTextField.getText();
        String headhuntingPermitsCount = headhuntingPermitsTextField.getText();

        int totalPulls = 0;
        try {
            totalPulls += Math.round(Integer.parseInt(orundumCount)/600);
            totalPulls += Math.round((Integer.parseInt(originitePrimeCount) * 180)/600);
            totalPulls += Math.round(Integer.parseInt(yellowCertificatesCount)/6.789);
            totalPulls += Math.round(Integer.parseInt(headhuntingPermitsCount));

            pullsLabel.setText("Pulls: " + totalPulls);
        }
        catch (NumberFormatException e) {
            pullsLabel.setText("Are you sure about that?");
        }

    }
}