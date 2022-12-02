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

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

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
    TextField distinctionCertificateTextField;
    @FXML
    TextField headhuntingPermitTextField;

    String resultLine = "";

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

    public void updateRollsLabel(ActionEvent event) throws IOException {
        resultLine = "";

        String orundumCount = orundumTextField.getText();
        String originitePrimeCount = originitePrimeTextField.getText();
        String headhuntingPermitsCount = headhuntingPermitTextField.getText();
        String yellowCertificatesCount = distinctionCertificateTextField.getText();

        Date date = new Date();
        SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd");
        String dateNow = currentDate.format(date);
        String timeNow = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

        double totalPulls = 0;
        int totalPullsInt = 0;
        try {
            Integer.parseInt(orundumCount);
            Integer.parseInt(originitePrimeCount);
            Integer.parseInt(headhuntingPermitsCount);
            Integer.parseInt(yellowCertificatesCount);

            totalPulls = ((Double.parseDouble(orundumCount))/600.0) +
                         ((Double.parseDouble(originitePrimeCount) * 180)/600.0) +
                         ((Double.parseDouble(headhuntingPermitsCount))) +
                         ((Double.parseDouble(yellowCertificatesCount))/(258.0/38.0));

            totalPulls = Math.floor(totalPulls);
            totalPullsInt = (int) totalPulls;

            resultLine = orundumCount + ", " +
                    originitePrimeCount + ", " +
                    headhuntingPermitsCount  + ", " +
                    yellowCertificatesCount  + ", " +
                    totalPullsInt  + ", " +
                    dateNow + ", " +
                    timeNow;

            BufferedWriter output = new BufferedWriter(new FileWriter("arknightsTracker.txt", true));
            output.newLine();
            output.append(resultLine);
            output.close();

            pullsLabel.setText("Calculated Pulls: " + totalPullsInt);
        }
        catch (NumberFormatException e) {
            pullsLabel.setText("Invalid Input.");
        }
    } // end updateRollsLabel
}