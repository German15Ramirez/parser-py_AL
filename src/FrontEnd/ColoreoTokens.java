/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import FrontEnd.*;
import javax.swing.text.BadLocationException;

/**
 *
 * @author ryoumen_kyoma
 */
public class ColoreoTokens {
    private JTextPane jtextPane;
    
    public ColoreoTokens(JTextPane jTextPane){
    this.jtextPane=jtextPane;
    
    }
    public void ColoreoTokens(List<Token>tokens){
        StyledDocument doc = jtextPane.getStyledDocument();
        SimpleAttributeSet defaultstyle = new SimpleAttributeSet();
        StyleConstants.setForeground(defaultstyle, Color.BLACK);
        for (Token token : tokens){
        SimpleAttributeSet tokenType = new SimpleAttributeSet();
        Color tokenColor = getColorForTokenType(token.tokensList);
        StyleConstants.setForeground(tokenType, tokenColor);
        int startPos = doc.getLength();
            try {
                doc.insertString(startPos, token.valor, tokenType);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        
        }
    
    }
    private Color getColorForTokenType(TokenType tokenType){
    switch (tokenType) {
            case SUMA:
                return Color.RED;
            case RESTA:
                return Color.BLUE;
            default:
                return Color.BLACK;
        }
    
    
    }
}
