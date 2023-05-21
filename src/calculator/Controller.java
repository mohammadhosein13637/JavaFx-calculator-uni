package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.math.BigInteger;

public class Controller {
    BigInteger number1 = BigInteger.ZERO;
    @FXML
    private Label expression;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button zero;
    @FXML
    private Button clear;
    @FXML
    private Button equals;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button multiply;
    @FXML
    private Button divide;
    @FXML
    private Button delete;
    private String operator = "";

    public void initialize() {
        one.setDisable(true);
        two.setDisable(true);
        three.setDisable(true);
        four.setDisable(true);
        five.setDisable(true);
        six.setDisable(true);
        seven.setDisable(true);
        eight.setDisable(true);
        nine.setDisable(true);
        zero.setDisable(true);
        clear.setDisable(true);
        equals.setDisable(true);
        plus.setDisable(true);
        minus.setDisable(true);
        multiply.setDisable(true);
        divide.setDisable(true);
        delete.setDisable(true);
    }


    public void onCalculator() {
        one.setDisable(false);
        two.setDisable(false);
        three.setDisable(false);
        four.setDisable(false);
        five.setDisable(false);
        six.setDisable(false);
        seven.setDisable(false);
        eight.setDisable(false);
        nine.setDisable(false);
        zero.setDisable(false);
        clear.setDisable(false);
        equals.setDisable(false);
        plus.setDisable(false);
        minus.setDisable(false);
        multiply.setDisable(false);
        divide.setDisable(false);
        delete.setDisable(false);
    }

    public void processNumbers(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        expression.setText(expression.getText() + value);
    }

    public void processOperator(ActionEvent event) {
        String operator1 = ((Button) event.getSource()).getText();
        if (operator.isEmpty() && !operator1.equals("=")) {
            operator = operator1;
            number1 = new BigInteger(expression.getText());
            expression.setText(expression.getText() + operator1);
        } else {
            String[] numbers = expression.getText().split("[+-/*/]");
            for (int i = 1; i < numbers.length; i++) {
                BigInteger number = new BigInteger(numbers[i]);
                calculate(number1, number, operator);
            }
        }
    }

    public void clearText() {
        expression.setText("");
        operator = "";
        number1 = BigInteger.ZERO;
    }

    public void calculate(BigInteger number, BigInteger number1, String operand) {
        switch (operand) {
            case "+":
                expression.setText(number.add(number1).toString());
                operator = "";
                break;

            case "-":
                expression.setText(number.subtract(number1).toString());
                operator = "";
                break;

            case "*":
                expression.setText(number.multiply(number1).toString());
                operator = "";
                break;

            case "/":
                if (number1.equals(BigInteger.ZERO)) {
                    expression.setText("Error: Division by zero");
                } else {
                    expression.setText(number.divide(number1).toString());
                }
                operator = "";
                break;
        }
    }
}
