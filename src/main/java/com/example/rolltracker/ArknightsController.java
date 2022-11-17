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

    public void switchToHomeView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void updateRollsLabel(ActionEvent event) throws IOException {
        pullsLabel.setText(orundumTextField.getText());
    }
}