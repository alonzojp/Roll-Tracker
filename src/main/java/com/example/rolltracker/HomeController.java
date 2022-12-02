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

import java.io.IOException;

public class HomeController {

    private Stage stage;
    private Scene scene;
    private Parent root;

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