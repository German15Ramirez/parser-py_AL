/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.Herramientas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;

public abstract class NumeracionLineas extends JPanel implements CaretListener, DocumentListener, PropertyChangeListener {
    
    static class LineNumberedDocument extends DefaultStyledDocument {
        private Element rootElement;
        private JTextPane parentPane;
        private int lineHeight;
        
        public LineNumberedDocument() {
            rootElement = getDefaultRootElement();
        }
        
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            super.insertString(offs, str, a);
            updateLineNumbers();
        }
        
        public void remove(int offs, int len) throws BadLocationException {
            super.remove(offs, len);
            updateLineNumbers();
        }
        
        private void updateLineNumbers() {
            SwingUtilities.invokeLater(() -> {
                if (parentPane == null) {
                    parentPane = (JTextPane) SwingUtilities.getAncestorOfClass(JTextPane.class, (Component) rootElement);
                    lineHeight = parentPane.getFontMetrics(parentPane.getFont()).getHeight();
                }
                
                Element element = rootElement.getElement(0);
                int lines = rootElement.getElementCount();
                String lineNumberText = "";
                
                for (int i = 0; i < lines; i++) {
                    lineNumberText += (i + 1) + "\n";
                }
                
                JTextPane lineNumberPane = new JTextPane();
                lineNumberPane.setText(lineNumberText);
                lineNumberPane.setEditable(false);
                lineNumberPane.setBackground(parentPane.getBackground());
                lineNumberPane.setPreferredSize(new Dimension(lineHeight * lines, parentPane.getHeight()));
                
                parentPane.add(lineNumberPane, BorderLayout.WEST);
                parentPane.revalidate();
                parentPane.repaint();
            });
        }
    }
}