package BackEnd.Herramientas;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
/**
 *
 * @author ryoumen_kyoma
 */
public class NumeracionFilas extends JPanel
        implements CaretListener, DocumentListener {

    private JTextComponent component;
    private JTextArea textArea;  
    private int lastLine;

    public NumeracionFilas(JTextComponent component) {
        this.component = component;

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setOpaque(false);
        textArea.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));  
        textArea.setEditable(false);

        add(textArea, BorderLayout.CENTER);

        component.getDocument().addDocumentListener(this);
        component.addCaretListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        FontMetrics fontMetrics = textArea.getFontMetrics(textArea.getFont());
        int lineHeight = fontMetrics.getHeight();
        int startOffset = component.viewToModel(new Point(0, g.getClipBounds().y));
        Element root = component.getDocument().getDefaultRootElement();

        int currentLine = root.getElementIndex(startOffset);
        int endOffset = component.viewToModel(new Point(0, g.getClipBounds().y + g.getClipBounds().height));

        while (startOffset <= endOffset) {
            try {
                String lineNumber = String.valueOf(currentLine + 1);
                int x = 0;
                int y = (currentLine + 0) * lineHeight + lineHeight / 1;  // Centrar verticalmente
                int stringWidth = fontMetrics.stringWidth(lineNumber);
                g.setColor(Color.BLACK);
                g.drawString(lineNumber, x + (20 - stringWidth), y);  // Centrar horizontalmente
                startOffset = Utilities.getRowEnd(component, startOffset) + 1;
                currentLine++;
            } catch (BadLocationException ex) {
                Logger.getLogger(NumeracionFilas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        int caretPosition = component.getCaretPosition();
        Element root = component.getDocument().getDefaultRootElement();
        int currentLine = root.getElementIndex(caretPosition);

        if (lastLine != currentLine) {
            repaint();
            lastLine = currentLine;
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        documentChanged();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        documentChanged();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        documentChanged();
    }

    private void documentChanged() {
        SwingUtilities.invokeLater(() -> {
            textArea.setText("");  
            int lineCount = component.getDocument().getDefaultRootElement().getElementCount();
            int padding = Math.max(3, String.valueOf(lineCount).length());  
            textArea.setBorder(BorderFactory.createEmptyBorder(0, padding * 10, 0, 0)); 
            textArea.setRows(lineCount);  
            repaint();
        });
    }
}