package com.example.rolltracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class BlueArchiveController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Label pullsLabel;
    @FXML
    TextField pyroxeneTextField;
    String resultLine = "";

    public void updateRollsLabel(ActionEvent event) throws IOException {
        resultLine = "";

        String pyroxeneCount = pyroxeneTextField.getText();

        Date date = new Date();
        SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd");
        String dateNow = currentDate.format(date);
        String timeNow = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

        double totalPulls = 0;
        int totalPullsInt = 0;
        try {
            Integer.parseInt(pyroxeneCount);

            totalPulls = ((Double.parseDouble(pyroxeneCount))/120.0);

            totalPulls = Math.floor(totalPulls);
            totalPullsInt = (int) totalPulls;

            resultLine = pyroxeneCount + ", " +
                    totalPullsInt  + ", " +
                    dateNow + ", " +
                    timeNow;

            BufferedWriter output = new BufferedWriter(new FileWriter("blueArchiveTracker.txt", true));
            output.newLine();
            output.append(resultLine);
            output.close();

            pullsLabel.setText("Calculated Pulls: " + totalPullsInt);
        }
        catch (NumberFormatException e) {
            pullsLabel.setText("Invalid Input.");
        }
    } // end updateRollsLabel

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
