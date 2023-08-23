/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd.Herramientas;

/**
 *
 * @author ryoumen_kyoma
 */
public class Token {

    private String lexema;
    private String token;
    private String patron = "?";
    private String inputString;
    private int posicionActual;
    private int currentLine;
    private int currentColumn;

    public Token() {

    }

    public Token(String token, String patron, String lexema, int fila, int columna) {
        this.token = token;
        this.lexema = lexema;
        this.patron = patron;
        this.inputString = lexema;
        this.posicionActual = posicionActual >= 0 ? posicionActual : 0;
        this.currentLine = 1;
        this.currentColumn = 1;
    }

    public String getToken() {
        return this.token;

    }

    public void setToken(String tipo) {
        this.token = tipo;
    }

    public String getLexema() {
        return this.lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public String establecerPatron(String token) {
        if (token.equals(ListTokens.ARIT_SUMA)) {
            return "[+]";
        }
        if (token.equals(ListTokens.ARIT_RESTA)) {
            return "[-]";
        }
        if (token.equals(ListTokens.ARIT_EXPONENTE)) {
            return "[**]";
        }
        if (token.equals(ListTokens.ARIT_DIVISION)) {
            return "[/]|[//]";
        }
        if (token.equals(ListTokens.ARIT_MODULO)) {
            return "[%]";
        }
        if (token.equals(ListTokens.ARIT_MULTIPLICACION)) {
            return "[*]";
        }
        if (token.equals(ListTokens.COMPARA_IGUAL)) {
            return "[==]";
        }
        if (token.equals(ListTokens.COMPARA_DIFERENTE)) {
            return "[!=]";
        }
        if (token.equals(ListTokens.COMPARA_MAYOR_QUE)) {
            return "[>]";
        }
        if (token.equals(ListTokens.COMPARA_MENOR_QUE)) {
            return "[<]";
        }
        if (token.equals(ListTokens.COMPARA_MAYOR_O_IGUAL_QUE)) {
            return "[>=]";
        }
        if (token.equals(ListTokens.COMPARA_MENOR_O_IGUAL_QUE)) {
            return "[<=]";
        }
        if (token.equals(ListTokens.LOGIC_Y)) {
            return "[and]";
        }
        if (token.equals(ListTokens.LOGIC_O)) {
            return "[or]";
        }
        if (token.equals(ListTokens.LOGIC_NEGACION)) {
            return "[not]";
        }
        if (token.equals(ListTokens.ASIGNACION)) {
            return "[=]";
        }
        if (token.equals(ListTokens.PALABRA_RESERVADA)) {
            return "";
        }
        if (token.equals(ListTokens.CONST_ENTERO)) {
            return "[0-9]+";
        }
        if (token.equals(ListTokens.CONST_DECIMAL)) {
            return "[0-9]+[.][0-9]+";
        }
        if (token.equals(ListTokens.CONST_CADENA)) {
            return "(\"([a-z]*[0-9]*)\" | \"([A-Z]*[0-9])\")";
        }
        if (token.equals(ListTokens.CONST_BOOLEANAS)) {
            return "[True]|[False]";
        }
        if (token.equals(ListTokens.COMENTARIO)) {
            return "(#([a-z]*[0-9]*) | #([A-Z]*[0-9]))";
        }
        if (token.equals(ListTokens.OTROS_PARENTESIS)) {
            return "[(]|[)]";
        }
        if (token.equals(ListTokens.OTROS_CORCHETES)) {
            return "[[]|[]]";
        }
        if (token.equals(ListTokens.OTROS_LLAVES)) {
            return "[{]|[}]";
        }

        if (token.equals(ListTokens.OTROS_PUNTO_Y_COMA)) {
            return "[;]";
        }
        if (token.equals(ListTokens.OTROS_DOS_PUNTOS)) {
            return "[:]";
        }
        if (token.equals(ListTokens.OTROS_COMA)) {
            return "[,]";
        }
        if (token.equals(ListTokens.OTROS_IDENTIFICADOR)) {
            return "[a-zA-Z_]|[a-zA-Z0-9_]*";
        }

        return this.lexema;

    }
public String getValor() {
    return this.lexema;
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
