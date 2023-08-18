/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ryoumen_kyoma
 */

enum TokenType {
    SUMA,
    RESTA,
    EXPONENTE,
    DIVISION,
    MODULO,
    MULTIPLICACION,
    IGUAL,
    DIFERENTE,
    MAYOR_QUE,
    MENOR_QUE,
    MAYOR_O_IGUAL_QUE,
    MENOR_O_IGUAL_QUE,
    Y,
    O,
    NEGACION,
    ASIGNACION,
    PALABRA_RESERVADA,
    ENTERO,
    DECIMAL,
    CADENA,
    BOOLEANAS,
    COMENTARIO,
    PARENTESIS,
    LLAVES,
    CORCHETES,
    PUNTO,
    COMA,
    PUNTO_Y_COMA,
    DOS_PUNTOS,
    IDENTIFICADOR,
}

class Token {
    TokenType tokensList;
    String valor;
int lineNumber;
    int columnNumber;
    Token(TokenType tokensList, String valor,int lineNumber,int columnNumber) {
        this.tokensList = tokensList;
        this.valor = valor;
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
        
    }
}
class Lexer {
    private String inputString;
    private int posicionActual;
    private int currentLine;
    private int currentColumn;
    
List<Token> analyzeTokens() {
        List<Token> tokens = new ArrayList<>();
        Token token;
        while ((token = getNextToken()) != null) {
            tokens.add(token);
        }
        return tokens;
    }
    Lexer(String inputString, int posicionActual) {
        this.inputString = inputString;
        this.posicionActual = posicionActual >= 0 ? posicionActual : 0;
        this.currentLine = 1;
        this.currentColumn = 1;
    }

    Token getNextToken() {
        if (posicionActual >= inputString.length()) {
            return null;
        }
        char currentChar = inputString.charAt(posicionActual);
        switch (currentChar) {
            case '+':
            case '-':
                Token token = new Token(TokenType.EXPONENTE, String.valueOf(currentChar),currentLine,currentColumn);
            avanzarCoordenadas(1);
            return token;
            case '%':
                posicionActual++;
                return new Token(AnalisisLexico.ARITMETICAS, "%",currentLine,currentColumn);
                case '*':
                    posicionActual++;
                 if (posicionActual < inputString.length() && inputString.charAt(posicionActual) == '*') {
            posicionActual++;
            return new Token(AnalisisLexico.ARITMETICAS, "**",currentLine,currentColumn);
        } else {
            return new Token(AnalisisLexico.ARITMETICAS, "*",currentLine,currentColumn);
        }                 case '/':
                 posicionActual++;
                 if (posicionActual < inputString.length() && inputString.charAt(posicionActual) == '/') {
            posicionActual++;
            return new Token(AnalisisLexico.ARITMETICAS, "//",currentLine,currentColumn);
        } else {
            return new Token(AnalisisLexico.ARITMETICAS, "/",currentLine,currentColumn);
        }      
            default:
                
                avanzarCoordenadas(1);
                return getNextToken();
        }
    }
    
    private void avanzarCoordenadas(int avance) {
        for (int i = 0; i < avance; i++) {
            if (posicionActual >= inputString.length()) {
                break;
            }
            char currentChar = inputString.charAt(posicionActual);
            if (currentChar == '\n') {
                currentLine++;
                currentColumn = 1; // Reiniciar la columna al inicio de una nueva línea
            } else {
                currentColumn++;
            }
            posicionActual++;
        }
    }
    // Métodos públicos para acceder a la información de línea y columna
    public int getCurrentLine() {
        return currentLine;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }
    }
