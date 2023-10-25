/**
 * <h1>
 *      Paket & Importe
 * </h1>
 * <h3>
 * Das Paket de.mgonzales.gui gibt den Ort an, an dem sich diese Klasse im Projekt befindet.
 * Es gibt mehrere Importe, die benötigt werden, um die GUI und ihre Funktionalität zu erstellen.
 * </h3>
 */
package de.mgonzales.gui;

import de.mgonzales.settings.AppCommands;
import de.mgonzales.settings.AppTexts;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

/**
 * <h1>
 *     Klasse GuiController
 * </h1>
 * <h3>
 * Die Klasse GuiController wird definiert. Sie ist verantwortlich für die Erstellung und Steuerung der grafischen Benutzeroberfläche (GUI).
 * </h3>
 */
public class GuiController {
    /**
     * <h1>
     *     Konstanten, Attribute und Konstruktoren
     * </h1>
     * <h3>
     * Es gibt Platzhalter für Konstanten, Attribute und Konstruktoren, aber sie sind aktuell leer.
     * </h3>
     */
    //region Konstanten
    //endregion Konstanten

    //region Attribute
    //endregion Attribute

    //region Konstruktoren
    public GuiController() {
    }
    //endregion Konstruktoren

    //region Methoden

    /**
     * <h1>
     *     Methode startGui
     * </h1>
     * <h3>
     * Diese Methode wird aufgerufen, um die GUI zu starten und zu initialisieren.
     * </h3>
     */
    public static void start() {
        /**
         * <h3>
         * Ein neues JFrame-Objekt namens frame wird erstellt. Dies ist das Hauptfenster der Anwendung.
         * Der Titel des Fensters wird auf den Wert von AppData.APP_NAME gesetzt.
         * Wenn das Fenster geschlossen wird, wird die Anwendung beendet (JFrame.EXIT_ON_CLOSE).
         * Die Größe des Fensters wird auf 300x200 Pixel gesetzt.
         * Das Layout des Fensters wird auf ein GridLayout mit 4 Zeilen und 1 Spalte gesetzt.
         * </h3>
         */
        JFrame frame = new JFrame(AppTexts.TXT_APP_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 1));

        /**
         * <h3>
         * Ein neues JPanel-Objekt namens inputPanel wird erstellt. Dies ist ein Container für andere GUI-Komponenten.
         * Zwei JTextField-Objekte werden erstellt, um die beiden Zahlen für die Berechnung einzugeben.
         *  Diese Textfelder werden zum inputPanel hinzugefügt.
         * </h3>
         */
        JPanel inputPanel = new JPanel();
        JTextField firstNumberInput = new JTextField(10);
        JTextField secondNumberInput = new JTextField(10);
        inputPanel.add(firstNumberInput);
        inputPanel.add(secondNumberInput);
        
        /**
         * Das Hauptfenster frame wird sichtbar gemacht.
         */
        frame.setVisible(true);

        /**
         * <h3>
         * Ein weiteres JPanel namens operatorsPanel wird erstellt.
         * Vier JButton-Objekte werden erstellt, die die vier Grundrechenarten repräsentieren.
         * Diese Buttons werden zum operatorsPanel hinzugefügt.
         * </h3>
         */
        JPanel operatorsPanel = new JPanel();
        JButton addButton = new JButton(AppCommands.SIGN_ADDITION);
        JButton subtractButton = new JButton(AppCommands.SIGN_SUBSTRACT);
        JButton multiplyButton = new JButton(AppCommands.SIGN_MULTIPLY);
        JButton divideButton = new JButton(AppCommands.SIGN_DIVIDE);

        operatorsPanel.add(addButton);
        operatorsPanel.add(subtractButton);
        operatorsPanel.add(multiplyButton);
        operatorsPanel.add(divideButton);

        /**
         * <h3>
         * Ein JLabel-Objekt namens resultLabel wird erstellt, um das Ergebnis der Berechnung anzuzeigen.
         * </h3>
         */
        JLabel resultLabel = new JLabel(AppTexts.TXT_RESULT);
        resultLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        /**
         * <h3>
         * Das inputPanel, operatorsPanel und resultLabel werden zum Hauptfenster frame hinzugefügt.
         * </h3>
         */
        frame.add(inputPanel);
        frame.add(operatorsPanel);
        frame.add(resultLabel);

        /**
         * <h3>
         * Für jeden Button wird ein ActionListener hinzugefügt. Wenn ein Button gedrückt wird,
         * wird die Methode performOperation aufgerufen, um die entsprechende Rechenoperation durchzuführen.
         * </h3>
         */
        addButton.addActionListener(e -> performOperation(firstNumberInput, secondNumberInput, resultLabel, AppCommands.SIGN_ADDITION));
        subtractButton.addActionListener(e -> performOperation(firstNumberInput, secondNumberInput, resultLabel, AppCommands.SIGN_SUBSTRACT));
        multiplyButton.addActionListener(e -> performOperation(firstNumberInput, secondNumberInput, resultLabel, AppCommands.SIGN_MULTIPLY));
        divideButton.addActionListener(e -> performOperation(firstNumberInput, secondNumberInput, resultLabel, AppCommands.SIGN_DIVIDE));
    }

    /**
     * <h1>
     *     Methode performOperation
     * </h1>
     * <h3>
     * Diese Methode führt die gewählte Rechenoperation durch und aktualisiert das resultLabel mit dem Ergebnis.
     * java
     * </h3>
     * @param firstNumberinput - Erste Zahl, die eingegeben werden soll
     * @param secondNumberInput - Zweite Zahl, die eingegeben werden soll
     * @param resultLabel - Hier wird das anzuzeigende Ergebnis gespeichert
     * @param operation - der ausgewählte Operator
     */
    private static void performOperation(JTextField firstNumberinput, JTextField secondNumberInput, JLabel resultLabel, String operation) {
        /**
         * Die eingegebenen Werte werden von den Textfeldern geholt und in double-Werte umgewandelt.
         */
        try {
            double firstNumber = Double.parseDouble(firstNumberinput.getText());
            double secondNumber = Double.parseDouble(secondNumberInput.getText());
            double result;

            /**
             * <h3>
             * Ein switch-Statement wird verwendet, um die gewählte Rechenoperation zu bestimmen und das Ergebnis zu berechnen.
             * Bei einer Division durch Null wird eine Fehlermeldung angezeigt.
             * </h3>
             */
            switch (operation) {
                case AppCommands.SIGN_ADDITION:
                    result = firstNumber + secondNumber;
                    break;
                case AppCommands.SIGN_SUBSTRACT:
                    result = firstNumber - secondNumber;
                    break;
                case AppCommands.SIGN_MULTIPLY:
                    result = firstNumber * secondNumber;
                    break;
                case AppCommands.SIGN_DIVIDE:
                    if (secondNumber == 0) {
                        JOptionPane.showMessageDialog(null, AppTexts.TXT_DIVIDE_NULL_NOT_VALID, AppTexts.TXT_ERROR, JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    result = firstNumber / secondNumber;
                    break;
                default:
                    return;
            }
            /**
             * <h3>
             * Das resultLabel wird aktualisiert, um das Ergebnis und den Rechenweg anzuzeigen.
             * Wenn die Eingabe keine gültige Zahl ist, wird eine Fehlermeldung angezeigt.
             * </h3>
             */
            resultLabel.setText(AppTexts.TXT_RESULT + firstNumber + " " + operation + " " + secondNumber + " = " + result);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, AppTexts.TXT_INPUT_VALID_NUMBER, AppTexts.TXT_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }
}
