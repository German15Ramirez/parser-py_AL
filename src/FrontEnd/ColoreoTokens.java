/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;
import BackEnd.Herramientas.TokenType.TypeArtimetico;
import BackEnd.Herramientas.TokenType.TypeAsignacion;
import BackEnd.Herramientas.TokenType.TypeComentario;
import BackEnd.Herramientas.TokenType.TypeComparacion;
import BackEnd.Herramientas.TokenType.TypeConstante;
import BackEnd.Herramientas.TokenType.TypeIdentificador;
import BackEnd.Herramientas.TokenType.TypeLogico;
import BackEnd.Herramientas.TokenType.TypeOtro;
import BackEnd.Herramientas.TokenType.TypePalabraReservada;
import javax.swing.text.StyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import java.awt.Color;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author ryoumen_kyoma
 */
public class ColoreoTokens {

     public static void colorPalabras(StyledDocument doc, String text, List<List<Object>> newListOfLists) {
        SwingUtilities.invokeLater(() -> {
            doc.setCharacterAttributes(0, text.length(), doc.getStyle("default"), true);

            for (List<Object> tabla : newListOfLists) {
                Color color = getColorForTokenType(tabla.get(0));
                String tokenValue = tabla.get(1).toString();

                int startIndex = 0;
                while ((startIndex = text.indexOf(tokenValue, startIndex)) >= 0) {
                    Style style = doc.addStyle("MyStyle", null);
                    StyleConstants.setForeground(style, color);
                    doc.setCharacterAttributes(startIndex, tokenValue.length(), style, false);
                    startIndex += tokenValue.length();
                }
            }
        });
    }

    public static Color getColorForTokenType(Object tokenType) {
        if (tokenType instanceof TypeIdentificador) {
            return Color.BLACK;
        } else if (tokenType instanceof TypePalabraReservada) {
            return new Color(128, 0, 128);
        } else if (tokenType instanceof TypeArtimetico || tokenType instanceof TypeComparacion || tokenType instanceof TypeLogico || tokenType instanceof TypeAsignacion) {
            return new Color(0, 191, 255);
        } else if (tokenType instanceof TypeOtro) {
            return Color.GREEN;
        } else if (tokenType instanceof TypeConstante) {
            return Color.RED;
        } else if (tokenType instanceof TypeComentario) {
            return Color.GRAY;
        } else {
            return Color.DARK_GRAY; // Valor por defecto para tipos desconocidos
        }
    }
}