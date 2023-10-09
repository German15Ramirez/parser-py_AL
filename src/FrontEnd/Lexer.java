/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import BackEnd.Herramientas.*;
import BackEnd.Herramientas.TokenType.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author ryoumen_kyoma
 */
public class Lexer {

     private final Reader reader;
    private int columna;
    private int fila;
    private int currentChar;
    private final ArrayList<Object> palabrasG;

    public Lexer(Reader reader) {
        this.palabrasG = new ArrayList<>();
        this.reader = new BufferedReader(reader);
        this.currentChar = -1;
        this.columna = 0;
        this.fila = 1;
        try {
            advance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void advance() throws IOException {
        int nextChar = reader.read();
        if (nextChar != -1) {
            currentChar = nextChar;
            columna++;
        } else {
            currentChar = -1;
        }
    }

    private char currentChar() {
        return (char) currentChar;
    }

    public Token nextToken() {
        try {
            while (currentChar != -1) {
                char current = currentChar();
                if (Character.isWhitespace(current)) {
                    advance();
                    if (current == ' ') {
                        return new Token(TypeSpace.SPACE, " ");
                    } else if (current == '\n') {
                        fila++;
                        columna = 0;
                        return new Token(TypeSpace.SALTO, "SALTO");
                    }
                } else if (Character.isLetter(current)) {
                    return readLetter();
                } else if (Character.isDigit(current)) {
                    return readInteger();
                } else if (current == '"') {
                    advance();
                    return cadenaComDob('"');
                } else if (current == '\'') {
                    advance();
                    return cadena('\'');
                } else if (isSingleCharacterToken(current)) {
                    advance();
                    return getSingleCharacterToken(current);
                } else if (current == '#') {
                    advance();
                    return comentario();
                } else if (current == '=' || current == '!' || current == '>' || current == '<' || current == '/') {
                    advance();
                    return handleSpecialTokens(current);
                } else {
                    advance();
                    return new Token(TypeOtro.ERROR_LEXICO, "Caracter Desconocido");
                }
            }
            advance();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fila++;
        columna = 0;
        return new Token(TypeSpace.FINAL_ARCHIVE, "");
    }

    private boolean isSingleCharacterToken(char current) {
        return "(){}[];,:+-".contains(String.valueOf(current));
    }

    private Token getSingleCharacterToken(char current) {
        switch (current) {
            case '(':
                return new Token(TypeOtro.PARENTESIS, "(");
            case ')':
                return new Token(TypeOtro.PARENTESIS, ")");
            case '{':
                return new Token(TypeOtro.LLAVES, "{");
            case '}':
                return new Token(TypeOtro.LLAVES, "}");
            case '[':
                return new Token(TypeOtro.CORCHETES, "[");
            case ']':
                return new Token(TypeOtro.CORCHETES, "]");
            case ';':
                return new Token(TypeOtro.PUNTO_Y_COMA, ";");
            case ',':
                return new Token(TypeOtro.COMA, ",");
            case ':':
                return new Token(TypeOtro.DOS_PUNTOS, ":");
            case '+':
                return new Token(TypeArtimetico.SUMA, "+");
            case '-':
                return new Token(TypeArtimetico.RESTA, "-");
            case '!':
                return new Token(TypeAsignacion.ASIGNACION, "!");
            case '>':
                return new Token(TypeComparacion.MAYOR_QUE, ">");
            case '<':
                return new Token(TypeComparacion.MENOR_QUE, "<");
            default:
                return new Token(TypeOtro.ERROR_LEXICO, "Caracter Desconocido");
        }
    }

    private Token readInteger() {
        StringBuilder value = new StringBuilder();

        try {
            while (Character.isDigit(currentChar())) {
                value.append(currentChar());
                advance();
            }

            if (currentChar() == '.') {
                value.append(currentChar());
                advance();
                while (Character.isDigit(currentChar())) {
                    value.append(currentChar());
                    advance();
                }
                return new Token(TypeConstante.DECIMAL, value.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Token(TypeConstante.ENTERO, value.toString());
    }

    private Token readLetter() {
        StringBuilder value = new StringBuilder();

        try {
            while (Character.isLetter(currentChar()) || currentChar() == '_' || Character.isDigit(currentChar())) {
                value.append(currentChar());
                advance();
            }

            String valuestring = value.toString();
            Map<String, TypePalabraReservada> palabraResMap = new HashMap<>();
            palabraResMap.put("as", TypePalabraReservada.AS);
        palabraResMap.put("assert", TypePalabraReservada.ASSERT);
        palabraResMap.put("break", TypePalabraReservada.BREAK);
        palabraResMap.put("class", TypePalabraReservada.CLASS);
        palabraResMap.put("continue", TypePalabraReservada.CONTINUE);
        palabraResMap.put("def", TypePalabraReservada.DEF);
        palabraResMap.put("del", TypePalabraReservada.DEL);
        palabraResMap.put("for", TypePalabraReservada.FOR);
        palabraResMap.put("elif", TypePalabraReservada.ELIF);
        palabraResMap.put("else", TypePalabraReservada.ELSE);
        palabraResMap.put("except", TypePalabraReservada.EXCEPT);
        palabraResMap.put("finally", TypePalabraReservada.FINALLY);
        palabraResMap.put("from", TypePalabraReservada.FROM);
        palabraResMap.put("global", TypePalabraReservada.GLOBAL);
        palabraResMap.put("import", TypePalabraReservada.IMPORT);
        palabraResMap.put("in", TypePalabraReservada.IN);
        palabraResMap.put("is", TypePalabraReservada.IS);
        palabraResMap.put("if", TypePalabraReservada.IF);
        palabraResMap.put("lambda", TypePalabraReservada.LAMBDA);
        palabraResMap.put("None", TypePalabraReservada.NONE);
        palabraResMap.put("nonlocal", TypePalabraReservada.NONLOCAL);
        palabraResMap.put("pass", TypePalabraReservada.PASS);
        palabraResMap.put("raise", TypePalabraReservada.RAISE);
        palabraResMap.put("return", TypePalabraReservada.RETURN);
        palabraResMap.put("try", TypePalabraReservada.TRY);
        palabraResMap.put("while", TypePalabraReservada.WHILE);
        palabraResMap.put("with", TypePalabraReservada.WITH);
        palabraResMap.put("yield", TypePalabraReservada.YIELD);

            if (palabraResMap.containsKey(valuestring)) {
                TypePalabraReservada tipoPalabraRes = palabraResMap.get(valuestring);
                return new Token(tipoPalabraRes, valuestring);
            }

            if (value.toString().equals("and")) {
                return new Token(TypeLogico.Y, valuestring);
            }

            if (value.toString().equals("not")) {
                return new Token(TypeLogico.NEGACION, valuestring);
            }

            if (value.toString().equals("or")) {
                return new Token(TypeLogico.O, valuestring);
            }

            if (value.toString().equals("True") || value.toString().equals("False")) {
                return new Token(TypeConstante.BOOLEANAS, valuestring);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Token(TypeIdentificador.IDENTIFICADOR, value.toString());
    }

    public Token comentario() {
        StringBuilder value = new StringBuilder();

        try {
            while (Character.isLetterOrDigit(currentChar()) || (Character.isWhitespace(currentChar()) && currentChar() != '\n')) {
                value.append(currentChar());
                advance();
            }

            if (currentChar() == '\n') {
                return new Token(TypeComentario.COMENTARIO, "#" + value.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Token(TypeOtro.ERROR_LEXICO, value.toString());
    }

    public Token cadena(char current) {
        StringBuilder value = new StringBuilder();
        value.append(current);

        try {
            while (currentChar() != '\0' && currentChar() != current) {
                value.append(currentChar());
                advance();
            }

            if (currentChar() == current) {
                value.append(currentChar());
                advance();
                return new Token(TypeConstante.CADENA, value.toString());
            } else {
                throw new RuntimeException("Cadena no cerrada correctamente");
            }
        } catch (Exception e) {
            System.err.println("Error al leer cadena: " + e.getMessage());
            return new Token(TypeOtro.ERROR_LEXICO, value.toString());
        }
    }

    public Token cadenaComDob(char current) {
        StringBuilder value = new StringBuilder();
        value.append(current);

        try {
            while (currentChar() != '\0' && currentChar() != current) {
                value.append(currentChar());
                advance();
            }

            if (currentChar() == current) {
                value.append(currentChar());
                advance();
                return new Token(TypeConstante.CADENA, value.toString());
            } else {
                throw new RuntimeException("Cadena no cerrada correctamente");
            }
        } catch (Exception e) {
            System.err.println("Error al leer cadena con comillas dobles: " + e.getMessage());
            return new Token(TypeOtro.ERROR_LEXICO, value.toString());
        }
    }

    public int fila() {
        return fila;
    }

    public int columna() {
        return columna;
    }

    private Token handleSpecialTokens(char current) throws IOException {
        advance();
        char nextChar = currentChar();

        if (current == '=') {
            if (nextChar == '=') {
                advance();
                return new Token(TypeComparacion.IGUAL_QUE, "==");
            } else {
                return new Token(TypeAsignacion.ASIGNACION, "=");
            }
        } else if (current == '!') {
            if (nextChar == '=') {
                advance();
                return new Token(TypeComparacion.DIFERENTE_DE, "!=");
            } else {
                return new Token(TypeAsignacion.ASIGNACION, "!");
            }
        } else if (current == '>') {
            if (nextChar == '=') {
                advance();
                return new Token(TypeComparacion.MAYOR_O_IGUAL_QUE, ">=");
            } else {
                return new Token(TypeComparacion.MAYOR_QUE, ">");
            }
        } else if (current == '<') {
            if (nextChar == '=') {
                advance();
                return new Token(TypeComparacion.MENOR_O_IGUAL_QUE, "<=");
            } else {
                return new Token(TypeComparacion.MENOR_QUE, "<");
            }
        } else if (current == '/') {
            if (nextChar == '/') {
                advance();
                return new Token(TypeArtimetico.DIVISION, "//");
            } else {
                return new Token(TypeArtimetico.DIVISION, "/");
            }
        }

        return new Token(TypeOtro.ERROR_LEXICO, "Caracter Desconocido");
    }
}