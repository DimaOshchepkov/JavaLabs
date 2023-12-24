package com.example.aaaa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    
    @FXML
    public AnchorPane rightPane;
    @FXML
    public AnchorPane leftPane;
    @FXML
    public SplitPane pane;
    @FXML
    public Button btn1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    public void onMouseClicked(MouseEvent mouseEvent) {
        btn1.setText("ffsgldsfg");
    }
}