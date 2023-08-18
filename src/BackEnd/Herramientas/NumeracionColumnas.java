/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.Herramientas;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author ryoumen_kyoma
 */
public class NumeracionColumnas {
    private JTextPane jTextPane;
    private JLabel jLabel;
    private int lineNumber;
    private int columnNumber;
    public NumeracionColumnas(JTextPane jTextPane, JLabel jLabel) {
        this.jTextPane = jTextPane;
        this.jLabel = jLabel;

      jTextPane.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateColumnNumbers();
            }

            public void removeUpdate(DocumentEvent e) {
                updateColumnNumbers();
            }

            public void changedUpdate(DocumentEvent e) {
                updateColumnNumbers();
            }
        });

        jTextPane.addCaretListener(e -> updateColumnNumbers());
        updateColumnNumbers();
    }

    private void updateColumnNumbers() {
        int caretPosition = jTextPane.getCaretPosition();

        int caretLine = jTextPane.getDocument().getDefaultRootElement().getElementIndex(caretPosition);
        int startOffset = jTextPane.getDocument().getDefaultRootElement().getElement(caretLine).getStartOffset();
        caretLine++;
        lineNumber = caretLine;
        columnNumber = caretPosition - startOffset + 1;

        jLabel.setText("Columna: " + columnNumber);
        
        //lineNumber indica la fila
    }

public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}
