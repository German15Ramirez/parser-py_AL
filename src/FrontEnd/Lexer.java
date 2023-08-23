/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import BackEnd.Herramientas.*;

/**
 *
 * @author ryoumen_kyoma
 */
public class Lexer {

    private String inputString;
    private int posicionActual;
    private int currentLine;
    private int currentColumn;
    private Map<String, ListTokens> Tokens;
    private ArrayList<Token> listado;

    public ArrayList<Token> getListado() {
        return this.listado;
    }

    public Lexer(ArrayList<Token> listado) {
        this.listado = listado;
        iniciarAlmacen();
    }

    public void analize(String inputString) {
        String buffer = "";
        char[] inputChar = inputString.toCharArray();
        this.posicionActual = posicionActual >= 0 ? posicionActual : 0;
        this.currentLine = 1;
        this.currentColumn = 1;
        boolean typeCadena = false;
        boolean typeComentario = false;
        for (char letter : inputChar) {
            if (typeCadena) {
                buffer = buffer + letter;
                if (letter == '"' || letter == '\'') {
                    typeCadena = false;
                    createToken(buffer, currentLine, currentColumn);
                    buffer = "";
                }

            } else if (typeComentario) {
                buffer = buffer + letter;
                if (letter == '\n') {
                    typeComentario = false;
                    createToken(buffer, currentLine, currentColumn);
                    buffer = "";
                }

            } else {
                switch (letter) {
                    case '\t':
                    case ' ':
                        if (!buffer.isEmpty()) {
                            createToken(buffer, currentLine, currentColumn);
                            buffer = "";

                        }
                        currentColumn++;

                        break;
                        case '\n':
                currentLine++;
                currentColumn = 1; // Reiniciar la columna a 1 en cada nueva línea
                if (!buffer.isEmpty()) {
                    createToken(buffer, currentLine, currentColumn);
                    buffer = "";
                }
                break;
                    case '#':
                        if (!buffer.isEmpty()) {
                            createToken(buffer, currentLine, currentColumn);
                            buffer = "";
                        }
                        buffer = buffer + letter;
                        typeComentario = true;
                        currentColumn++;
                        break;
                    case '"':
                    case '\'':
                        if (!buffer.isEmpty()) {
                            createToken(buffer, currentLine, currentColumn);
                            buffer = "";
                        }
                        if (typeCadena) {
                            buffer = buffer + letter;
                            typeCadena = false;
                            createToken(buffer, currentLine, currentColumn);
                            buffer = "";
                        } else {
                            buffer = buffer + letter;
                            typeCadena = true;
                        }
                        currentColumn++;
                        break;
                    default:
                        switch (letter) {
                            case '%':
                            case '*':
                            case '+':
                            case '-':
                            case '/':
                                if (!buffer.isEmpty()) {
                                    createToken(buffer, currentLine, currentColumn);
                                    buffer = "";
                                }
                                createToken(String.valueOf(letter), currentLine, currentColumn);
                                currentColumn++;
                                break;
                            case '=':

                                this.listado.add(new Token(ListTokens.ASIGNACION.toString(), "=", "=", currentLine, currentColumn));
                                break;
                            case '!':
                            case '<':
                            case '>':
                                if (!buffer.isEmpty()) {
                                    createToken(buffer, currentLine, currentColumn);
                                    buffer = "";
                                }
                                buffer = buffer + letter;
                                createToken(buffer, currentLine, currentColumn);
                                buffer = "";
                                currentColumn++;
                                break;
                            case '|':
                                if (!buffer.isEmpty()) {
                                    createToken(buffer, currentLine, currentColumn);
                                    buffer = "";
                                }
                                if (currentColumn < inputChar.length - 1 && inputChar[currentColumn] == '|') {
                                    buffer = "||";
                                    createToken(buffer, currentLine, currentColumn);
                                    buffer = "";
                                    currentColumn++;
                                }
                                break;
                            case '(':
                            case ')':
                            case ',':
                            case ':':
                            case ';':
                            case '[':
                            case ']':
                            case '{':
                            case '}':
                                if (!buffer.isEmpty()) {
                                    createToken(buffer, currentLine, currentColumn);
                                    buffer = "";
                                }
                                buffer = buffer + letter;
                                createToken(buffer, currentLine, currentColumn);
                                buffer = "";
                                currentColumn++;
                                break;
                        }
                        if (typeIdentificador(buffer)) {
                            if (this.Tokens.containsKey(buffer)) {
                                createToken(buffer, currentLine, currentColumn);
                                buffer = "";
                            } else {
                                buffer = buffer + letter;
                            }
                            currentColumn++;
                            break;
                        }
                        buffer = buffer + letter;
                        currentColumn++;
                        break;
                }
            }
        }
        if (typeCadena) {
            createToken("error " + buffer, currentLine, currentColumn);
            buffer = "";
        }

    }

    private void createToken(String lexema, int currentLine, int currentColumn) {
        if (typeNumero(lexema)) {
            if (lexema.contains(".")) {
                this.listado.add(new Token(ListTokens.CONST_DECIMAL.toString(), "[0-9]+\\.[0-9]+", lexema, currentLine, currentColumn));
            } else {
                this.listado.add(new Token(ListTokens.CONST_ENTERO.toString(), "[0-9]+", lexema, currentLine, currentColumn));
            }
        } else if (typeCadena(lexema)) {
            this.listado.add(new Token(ListTokens.CONST_CADENA.toString(), "((\"[a-z]*[0-9]*\") | (\"[A-Z]*[0-9])\") | (('[a-z]*[0-9]*') | ('[A-Z]*[0-9])')", lexema, currentLine, currentColumn));

        } else if (this.Tokens.containsKey(lexema)) {
            ListTokens typeTokens = this.Tokens.get(lexema);
            if (typeTokens == ListTokens.OTROS_IDENTIFICADOR) {
                this.listado.add(new Token(ListTokens.PALABRA_RESERVADA.toString(), "", lexema, currentLine, currentColumn));
            } else {
                this.listado.add(new Token(typeTokens.toString(), "", lexema, currentLine, currentColumn));

            }

        } else if (lexema.contains("#")) {
            this.listado.add(new Token(ListTokens.COMENTARIO.toString(), "(#[0-9]*[a-z]* | #[0-9]*[A-Z]* #[a-z]*[0-9]* | #[A-Z]*[0-9]*)", lexema, currentLine, currentColumn));
        } else if (lexema.contains("Error")) {
            String[] text = lexema.split("error");
            this.listado.add(new Token(ListTokens.ERROR_LEXICO.toString(), "no existe", lexema, currentLine, currentColumn));
        } else if (lexema.contains("_")) {
            char[] text = lexema.toCharArray();
            String inicial = String.valueOf(text[0]);
            boolean startNumber = false;
            startNumber = typeNumero(inicial);
            if (startNumber) {
                this.listado.add(new Token(ListTokens.ERROR_LEXICO.toString(), "no existe", lexema, currentLine, currentColumn));
            } else {
                this.listado.add(new Token(ListTokens.OTROS_IDENTIFICADOR.toString(), "([w]|_)+(w|d)*", lexema, currentLine, currentColumn));
            }
        } else if (isComparativeOperator(lexema)) {
        // Agregar los tokens de comparación
        this.listado.add(new Token(getComparativeOperatorCategory(lexema).toString(), lexema, lexema, currentLine, currentColumn));
    } else {
        // Agregar otros tokens
        this.listado.add(new Token(ListTokens.ERROR_LEXICO.toString(), lexema, lexema, currentLine, currentColumn));
    }
        }

    
private boolean isComparativeOperator(String lexema) {
    return lexema.equals("==") || lexema.equals("!=") || lexema.equals(">") ||
           lexema.equals("<") || lexema.equals(">=") || lexema.equals("<=");
}
private ListTokens getComparativeOperatorCategory(String lexema) {
    switch (lexema) {
        case "==":
            return ListTokens.COMPARA_IGUAL;
        case "!=":
            return ListTokens.COMPARA_DIFERENTE;
        case ">":
            return ListTokens.COMPARA_MAYOR_QUE;
        case "<":
            return ListTokens.COMPARA_MENOR_QUE;
        case ">=":
            return ListTokens.COMPARA_MAYOR_O_IGUAL_QUE;
        case "<=":
            return ListTokens.COMPARA_MENOR_O_IGUAL_QUE;
        default:
            return ListTokens.ERROR_LEXICO; // En caso de algún error
    }
}
    private boolean typeNumero(String lexema) {
    try {
        Integer.parseInt(lexema);
        return true;
    } catch (NumberFormatException e1) {
        try {
            Double.parseDouble(lexema);
            return true;
        } catch (NumberFormatException e2) {
            return false;
        }
    }}

    private boolean typeCadena(String lexema) {
        return ((lexema.startsWith("\"") && lexema.endsWith("\"")) || (lexema.startsWith("'") && lexema.endsWith("'")));
    }

    private boolean typeIdentificador(String lexema) {
        return !this.Tokens.containsKey(lexema);
    }

    private void iniciarAlmacen() {
        this.Tokens = new HashMap<>();
        this.Tokens.put("+", ListTokens.ARIT_SUMA);
        this.Tokens.put("-", ListTokens.ARIT_RESTA);
        this.Tokens.put("**", ListTokens.ARIT_EXPONENTE);
        this.Tokens.put("/", ListTokens.ARIT_DIVISION);
        this.Tokens.put("//", ListTokens.ARIT_DIVISION);
        this.Tokens.put("%", ListTokens.ARIT_MODULO);
        this.Tokens.put("*", ListTokens.ARIT_MULTIPLICACION);
        this.Tokens.put("==", ListTokens.COMPARA_IGUAL);
        this.Tokens.put("!=", ListTokens.COMPARA_DIFERENTE);
        this.Tokens.put(">", ListTokens.COMPARA_MAYOR_QUE);
        this.Tokens.put("<", ListTokens.COMPARA_MENOR_QUE);
        this.Tokens.put(">=", ListTokens.COMPARA_MAYOR_O_IGUAL_QUE);
        this.Tokens.put("<=", ListTokens.COMPARA_MENOR_O_IGUAL_QUE);
        this.Tokens.put("and", ListTokens.LOGIC_Y);
        this.Tokens.put("or", ListTokens.LOGIC_O);
        this.Tokens.put("not", ListTokens.LOGIC_NEGACION);
        this.Tokens.put("=", ListTokens.ASIGNACION);
        this.Tokens.put("as", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("assert", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("break", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("class", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("continue", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("def", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("del", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("elif", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("else", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("except", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("finally", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("from", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("for", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("global", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("if", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("import", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("in", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("is", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("lambda", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("None", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("nonlocal", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("pass", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("raise", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("return", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("try", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("while", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("with", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("yeald", ListTokens.PALABRA_RESERVADA);
        this.Tokens.put("(", ListTokens.OTROS_PARENTESIS);
        this.Tokens.put(")", ListTokens.OTROS_PARENTESIS);
        this.Tokens.put("{", ListTokens.OTROS_LLAVES);
        this.Tokens.put("}", ListTokens.OTROS_LLAVES);
        this.Tokens.put("[", ListTokens.OTROS_CORCHETES);
        this.Tokens.put("]", ListTokens.OTROS_CORCHETES);
        this.Tokens.put(",", ListTokens.OTROS_COMA);
        this.Tokens.put(";", ListTokens.OTROS_PUNTO_Y_COMA);
        this.Tokens.put(":", ListTokens.OTROS_DOS_PUNTOS);

    }
}
