package com.example.rolltracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class HomeController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Label arknightsLabel;
    @FXML
    Label arknightsLabel2;
    @FXML
    Label blueArchiveLabel;
    @FXML
    Label blueArchiveLabel2;

    String arknightsArray[];
    String blueArchiveArray[];
    public void initialize() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("arknightsTracker.txt"));
        String lastLine = "";
        String currentLine = "";

        while ((currentLine = input.readLine()) != null) {
            lastLine = currentLine;
        }

        arknightsArray = lastLine.split(",", 0);

        arknightsLabel.setText(arknightsArray[5]);
        arknightsLabel2.setText("Pulls:" + arknightsArray[4]);

        BufferedReader input2 = new BufferedReader(new FileReader("blueArchiveTracker.txt"));

        while ((currentLine = input2.readLine()) != null) {
            lastLine = currentLine;
        }

        blueArchiveArray = lastLine.split(",", 0);

        blueArchiveLabel.setText(blueArchiveArray[2]);
        blueArchiveLabel2.setText("Pulls:" + blueArchiveArray[1]);
    }

    public void switchToArknightsView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ArknightsView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBlueArchiveView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BlueArchiveView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToProjectSekaiView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProjectSekaiView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}