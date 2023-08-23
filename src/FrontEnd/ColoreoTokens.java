/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;
import BackEnd.Herramientas.Token;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author ryoumen_kyoma
 */
public class ColoreoTokens {
    private JTextPane jTextPane;

    public ColoreoTokens(JTextPane jtextPane) {
        this.jTextPane = jtextPane;
    }

    public void ColorearTokens(List<Token> tokens) {
        StyledDocument doc = jTextPane.getStyledDocument();
        SimpleAttributeSet defaultStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(defaultStyle, Color.BLACK);

        for (Token token : tokens) {
            int startPos = token.getCurrentColumn();
            int endPos = token.getCurrentLine();
            SimpleAttributeSet tokenType = new SimpleAttributeSet();
            Color tokenColor = getColorForTokenType(token.getToken());
            StyleConstants.setForeground(tokenType, tokenColor);

            try {
                doc.setCharacterAttributes(startPos, endPos - startPos, tokenType, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private Color getColorForTokenType(String tokenType){
        Color morado=new Color(117, 0, 134);
        
    switch (tokenType) {
            case "ARIT_SUMA":
                return Color.RED;
            case "ARIT_RESTA":
                return Color.BLUE;
                
            default:
                return Color.BLACK;
        }
    
    
    }
}
