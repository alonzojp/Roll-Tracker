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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    String[] resultArray;
    public void switchToHomeView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void updateRollsLabel(ActionEvent event) throws IOException {
        resultLine = "";

        String orundumCount = orundumTextField.getText();
        String originitePrimeCount = originitePrimeTextField.getText();
        String yellowCertificatesCount = distinctionCertificateTextField.getText();
        String headhuntingPermitsCount = headhuntingPermitTextField.getText();

        Date date = new Date();
        SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd");
        String dateNow = currentDate.format(date);
        String timeNow = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

        System.out.println(Arrays.toString(resultLine.split(",", 0)));

        int totalPulls = 0;
        try {
            totalPulls += Math.round(Integer.parseInt(orundumCount)/600);
            totalPulls += Math.round((Integer.parseInt(originitePrimeCount) * 180)/600);
            totalPulls += Math.round(Integer.parseInt(yellowCertificatesCount)/(258/38));
            totalPulls += Math.round(Integer.parseInt(headhuntingPermitsCount));

            resultLine = orundumCount + ", " +
                    originitePrimeCount + ", " +
                    yellowCertificatesCount  + ", " +
                    headhuntingPermitsCount  + ", " +
                    totalPulls  + ", " +
                    dateNow + ", " +
                    timeNow;

            // resultArray = resultLine.split(",", 0);

            try(PrintWriter output = new PrintWriter(new FileWriter("arknightsTracker.txt",true)))
            {
                output.printf("%s\r\n", resultLine);
            }
            catch (Exception e) {}

            pullsLabel.setText("Calculated Pulls: " + totalPulls);
        }
        catch (NumberFormatException e) {
            pullsLabel.setText("Are you sure about that?");
        }

    }
}