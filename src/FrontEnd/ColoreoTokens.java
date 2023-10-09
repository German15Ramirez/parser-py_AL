/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;
import BackEnd.Herramientas.TokenType.*;
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

    public static void colorPalabras(StyledDocument doc, String text, List<List<Object>> tablaToken) {
        SwingUtilities.invokeLater(() -> {
            doc.setCharacterAttributes(0, text.length(), doc.getStyle("default"), true);
            System.out.println("tablaToken: " + tablaToken);

            int startIndex = 0;
            for (List<Object> fila : tablaToken) {
                Object tokenType = fila.get(0);
                Color color = getColorForTokenType(tokenType);
                String tokenValue = fila.get(2).toString();

                // Encuentra la posición de inicio del token en la sección actual del texto
                int tokenStart = text.indexOf(tokenValue, startIndex);

                // Si se encuentra el token en la sección actual del texto, aplica el estilo
                if (tokenStart >= 0) {
                    int tokenEnd = tokenStart + tokenValue.length();
                    Style style = doc.addStyle("MyStyle", null);
                    StyleConstants.setForeground(style, color);
                    doc.setCharacterAttributes(tokenStart, tokenEnd - tokenStart, style, false);

                    // Actualiza el índice de inicio para continuar desde el final del token
                    startIndex = tokenEnd;
                }
            }
        });
    }

    public static Color getColorForTokenType(Object tokenType) {
        if (tokenType instanceof TypeIdentificador) {
            return Color.BLACK;
        } else if (tokenType instanceof TypePalabraReservada) {
            return new Color(128, 0, 128);
        } else if (tokenType instanceof TypeAritmetico || tokenType instanceof TypeComparacion || tokenType instanceof TypeLogico || tokenType instanceof TypeAsignacion) {
            return new Color(0, 191, 255);
        } else if (tokenType instanceof TypeOtro) {
            return Color.GREEN;
        } else if (tokenType instanceof TypeConstante) {
            return new Color(216, 112, 0);
        } else if (tokenType instanceof TypeComentario) {
            return Color.GRAY;
        } else {
            System.out.println("Token desconocido: " + tokenType);
            return Color.DARK_GRAY; // Valor por defecto para tipos desconocidos
        }
    }
}