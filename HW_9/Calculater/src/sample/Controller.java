package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label textField;
    private boolean clickMul = false;
    private boolean clickAdd = false;
    private boolean clickSub = false;
    private boolean clickDiv = false;
    private boolean clickDot = false;
    private String s = "0";
    private int flag = 0;
    private double first = 1;
    private double second = 1;
    private String symbol ;

    @FXML
    private Button buttonAC;
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button buttonDot;

    /**
     * Show the button that is pressed in the calculator
     * @param event
     */
    @FXML
    public void onClick(ActionEvent event){
        if (event.getSource().equals(button0)){
            if (!s.equals("0")){
                s+="0";
            }
            else {
                s = "0";
                return;
            }
        }
        else {
            if (s.equals("0")){
                s = "";
            }
              if (event.getSource().equals(button1)) {
                s += "1";
            } else if (event.getSource().equals(button2)) {
                s += "2";
            } else if (event.getSource().equals(button3)) {
                s += "3";
            } else if (event.getSource().equals(button4)) {
                s += "4";
            } else if (event.getSource().equals(button5)) {
                s += "5";
            } else if (event.getSource().equals(button6)) {
                s += "6";
            } else if (event.getSource().equals(button7)) {
                s += "7";
            } else if (event.getSource().equals(button8)) {
                s += "8";
            } else if (event.getSource().equals(button9)) {
                s += "9";
            }
        }
            if (event.getSource().equals(buttonDot)) {
                if (!clickDot) {
                    clickDot = true;
                    s += ".";
            }
        }
        textField.setText(s);
        clickMul = false;
        clickAdd = false;
        clickDiv = false;
        clickSub = false;
    }

    /**
     * AC button handling
     * @param event
     */
    @FXML
    public void onClickAC(ActionEvent event){
        s = "0";
        flag = 0;
        clickMul = false;
        clickAdd = false;
        clickDiv = false;
        clickSub = false;
        clickDot = false;
        textField.setText(s);
    }

    /**
     * Multiplier button handling
     * @param event
     */
    @FXML
    public void onClickMul(ActionEvent event) {
        if (clickMul){
            return;
        }
        clickDot = false;
        clickMul = true;
        symbol = "*";
        if (flag == 0) {
            flag = 1;
            first = Double.parseDouble(s);
            s = "";
        }
        else if (flag == 1){
            first = first * Double.parseDouble(s);
            s = "";
            textField.setText("" + first);
        }

    }

    /**
     * Plus button handling
     * @param event
     */
    @FXML
    public void onClickAdd(ActionEvent event) {
        if (clickAdd){
            return;
        }
        clickDot = false;
        clickAdd = true;
        symbol = "+";
        if (flag == 0) {
            flag = 1;
            first = Double.parseDouble(s);
            s = "";
        }
        else if (flag == 1){
            first = first + Double.parseDouble(s);
            s = "";
            textField.setText("" + first);
        }

    }

    /**
     * Subtraction
     * @param event
     */
    @FXML
    public void onClickSub(ActionEvent event) {
        if (clickSub){
            return;
        }
        clickDot = false;
        clickSub = true;
        symbol = "-";
        if (flag == 0) {
            flag = 1;
            first = Double.parseDouble(s);
            s = "";
        }
        else if (flag == 1){
            first = first - Double.parseDouble(s);
            s = "";
            textField.setText("" + first);
        }

    }

    /**
     * Division button handling
     * @param event
     */
    @FXML
    public void onClickDiv(ActionEvent event) {
        if (clickDiv){
            return;
        }
        clickDot = false;
        clickDiv = true;
        symbol = "/";
        if (flag == 0) {
            flag = 1;
            first = Double.parseDouble(s);
            s = "";
        }
        else if (flag == 1){
            first =  first / Double.parseDouble(s);
            s = "";
            textField.setText("" + first);
        }

    }

    /**
     * Equal button handling
     * @param event
     */
    @FXML
    public void  onClickEq(ActionEvent event){
        if (flag == 1 && !clickMul && !clickSub && !clickDiv && !clickAdd){
            flag = 0;
            second = Double.parseDouble(s);
            if (symbol.equals("*")){
                s = Double.toString(first * second);
            }
            else if (symbol.equals("+")){
                s = Double.toString(first + second);
            }
            else if (symbol.equals("/")){
                s = Double.toString(first / second);
            }
            else if (symbol.equals("-")){
                s = Double.toString(first - second);
            }
            clickSub = false;
            clickAdd = false;
            clickDiv = false;
            clickMul = false;
            clickDot = false;
            textField.setText(s);

        }
    }
}
