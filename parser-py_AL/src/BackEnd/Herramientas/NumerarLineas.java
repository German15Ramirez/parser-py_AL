/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.Herramientas;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author ryoumen_kyoma
 */
public class NumerarLineas extends JTextPane {
    private JTextPane targetTextPane;

    public NumerarLineas(JTextPane targetTextPane) {
        this.targetTextPane = targetTextPane;
        setEditable(false);
        setPreferredSize(new Dimension(40, Integer.MAX_VALUE));

        targetTextPane.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateNumbers();
            }

            public void removeUpdate(DocumentEvent e) {
                updateNumbers();
            }

            public void changedUpdate(DocumentEvent e) {
                updateNumbers();
            }
        });

        updateNumbers();
    }

    private void updateNumbers() {
        Document doc = targetTextPane.getDocument();
        int lines = doc.getDefaultRootElement().getElementCount();
        StringBuilder numbersText = new StringBuilder();
        
        for (int i = 1; i <= lines; i++) {
            numbersText.append(i).append('\n');
        }
        
        setText(numbersText.toString());
    }

}
