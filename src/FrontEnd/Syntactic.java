/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//analizador sintáctico descendente recursivo (LL-parser)
package FrontEnd;

import java.util.List;

/**
 *
 * @author ryoumen_kyoma
 */
public class Syntactic {
    private List<List<Object>> tablaToken;
    private int indiceActual;
    private int nivelIndentacion;
    private StringBuilder bloqueDeCodigoIdentificado = new StringBuilder();

    public Syntactic(List<List<Object>> tablaToken) {
        this.tablaToken = tablaToken;
        this.indiceActual = 0;
        this.nivelIndentacion = 0;
    }

    public void analizar() {
         while (indiceActual < tablaToken.size()) {
            List<Object> tokenInfo = tablaToken.get(indiceActual);
            String lexema = (String) tokenInfo.get(2);
            int indentacionActual = detectarIndentacion(lexema);

            if (indentacionActual > nivelIndentacion) {
                nivelIndentacion = indentacionActual;
            } else if (indentacionActual < nivelIndentacion) {
                mostrarBloqueDeCodigo(indiceActual, indiceActual);
                nivelIndentacion = indentacionActual;
            }

             procesarToken(tokenInfo, lexema);

            indiceActual++;
            
        }
    }
    private void procesarToken(List<Object> tokenInfo, String lexema) {
        String tipoToken = tokenInfo.get(0).toString();

        if (tipoToken.equals("IDENTIFICADOR")) {
            procesarDeclaracionVariable();
        } else if (lexema.equals("for")) {
            procesarCicloFor();
        } else if (lexema.equals("while")) {
            procesarCicloWhile();
        } else if (lexema.equals("def")) {
            procesarDefinicionFuncion();
        } else if (tipoToken.equals("COMENTARIO")) {
            procesarComentario(tokenInfo);
        }
    }

    private void mostrarBloqueDeCodigo(int inicioBloque, int finBloque) {
        System.out.println("Bloque de código:");
        StringBuilder bloqueActual = new StringBuilder();
        for (int i = inicioBloque; i <= finBloque; i++) {
            if (i < tablaToken.size()) {
                List<Object> tokenInfo = tablaToken.get(i);
                bloqueActual.append("Línea ").append(tokenInfo.get(3)).append(": ").append(tokenInfo.get(2)).append("\n");
            }
        }
        System.out.print(bloqueActual.toString());
        bloqueDeCodigoIdentificado.append(bloqueActual.toString());
        System.out.println(); // Agregamos un salto de línea después de cada bloque
        indiceActual = finBloque + 1;
    }
 private void procesarComentario(List<Object> tokenInfo) {
        String lexema = (String) tokenInfo.get(2);
        System.out.println("Comentario en línea " + tokenInfo.get(3) + ": " + lexema);
    }
    private int obtenerFinBloque() {
        int i = indiceActual;
        while (i < tablaToken.size() && !((String) tablaToken.get(i).get(2)).equals(";")) {
            i++;
        }
        return i;
    }

    public String getBloqueDeCodigoIdentificado() {
        return bloqueDeCodigoIdentificado.toString();
    }

    private int detectarIndentacion(String lexema) {
        int espacios = 0;
        for (int i = 0; i < lexema.length() && (lexema.charAt(i) == ' ' || lexema.charAt(i) == '\t'); i++) {
            espacios++;
        }
        return espacios;
    }

    //procedimientos segun el tipo de bloque
    private void procesarOperadorTernario() {
        List<Object> identificadorInfo = tablaToken.get(indiceActual);
        List<Object> operadorTernarioInfo = tablaToken.get(indiceActual + 1);
        List<Object> expresionInfo = tablaToken.get(indiceActual + 2);
        List<Object> valorTrueInfo = tablaToken.get(indiceActual + 3);
        List<Object> separadorInfo = tablaToken.get(indiceActual + 4);
        List<Object> valorFalseInfo = tablaToken.get(indiceActual + 5);

        String identificador = (String) identificadorInfo.get(2);
        String operadorTernario = (String) operadorTernarioInfo.get(2);
        String expresion = (String) expresionInfo.get(2);
        String valorTrue = (String) valorTrueInfo.get(2);
        String separador = (String) separadorInfo.get(2);
        String valorFalse = (String) valorFalseInfo.get(2);

        System.out.println("Operador ternario:");
        System.out.println("Identificador: " + identificador);
        System.out.println("Operador ternario: " + operadorTernario);
        System.out.println("Expresión: " + expresion);
        System.out.println("Valor True: " + valorTrue);
        System.out.println("Separador: " + separador);
        System.out.println("Valor False: " + valorFalse);

        indiceActual += 6;
        mostrarBloqueDeCodigo(indiceActual, indiceActual);
    }

    private void procesarDeclaracionVariable() {
        List<Object> identificadorInfo = tablaToken.get(indiceActual);
        List<Object> asignacionInfo = tablaToken.get(indiceActual + 1);
        List<Object> valorInfo = tablaToken.get(indiceActual + 2);

        String identificador = (String) identificadorInfo.get(2);
        String asignacion = (String) asignacionInfo.get(2);
        String valor = (String) valorInfo.get(2);

        System.out.println("Declaración de Variable:");
        System.out.println("Identificador: " + identificador);
        System.out.println("Operador de Asignación: " + asignacion);
        System.out.println("Valor: " + valor);

        indiceActual += 3;
        mostrarBloqueDeCodigo(indiceActual, indiceActual);
    }

    private void procesarCicloFor() {
        List<Object> forTokenInfo = tablaToken.get(indiceActual);
        List<Object> variableInfo = tablaToken.get(indiceActual + 1);
        List<Object> inTokenInfo = tablaToken.get(indiceActual + 2);
        List<Object> rangeTokenInfo = tablaToken.get(indiceActual + 3);
        List<Object> dosPuntosInfo = tablaToken.get(indiceActual + 4);

        String forToken = (String) forTokenInfo.get(2);
        String variable = (String) variableInfo.get(2);
        String inToken = (String) inTokenInfo.get(2);
        String rangeToken = (String) rangeTokenInfo.get(2);
        String dosPuntos = (String) dosPuntosInfo.get(2);

        System.out.println("Ciclo For:");
        System.out.println("Token 'for': " + forToken);
        System.out.println("Variable: " + variable);
        System.out.println("Token 'in': " + inToken);
        System.out.println("Token 'range': " + rangeToken);
        System.out.println("Token ':': " + dosPuntos);

        indiceActual += 5;
        mostrarBloqueDeCodigo(indiceActual, indiceActual);
    }

    private void procesarCicloWhile() {
        List<Object> whileTokenInfo = tablaToken.get(indiceActual);
        List<Object> condicionInfo = tablaToken.get(indiceActual + 1);
        List<Object> dosPuntosInfo = tablaToken.get(indiceActual + 2);

        String whileToken = (String) whileTokenInfo.get(2);
        String condicion = (String) condicionInfo.get(2);
        String dosPuntos = (String) dosPuntosInfo.get(2);

        System.out.println("Ciclo While:");
        System.out.println("Token 'while': " + whileToken);
        System.out.println("Condición: " + condicion);
        System.out.println("Token ':': " + dosPuntos);

        indiceActual += 3;
        mostrarBloqueDeCodigo(indiceActual, indiceActual);
    }

    private void procesarDefinicionFuncion() {
        List<Object> defTokenInfo = tablaToken.get(indiceActual);
        List<Object> nombreFuncionInfo = tablaToken.get(indiceActual + 1);
        List<Object> parentesisAbreInfo = tablaToken.get(indiceActual + 2);
        List<Object> parametroInfo = tablaToken.get(indiceActual + 3);
        List<Object> parentesisCierraInfo = tablaToken.get(indiceActual + 4);
        List<Object> dosPuntosInfo = tablaToken.get(indiceActual + 5);

        String defToken = (String) defTokenInfo.get(2);
        String nombreFuncion = (String) nombreFuncionInfo.get(2);
        String parentesisAbre = (String) parentesisAbreInfo.get(2);
        String parametro = (String) parametroInfo.get(2);
        String parentesisCierra = (String) parentesisCierraInfo.get(2);
        String dosPuntos = (String) dosPuntosInfo.get(2);

        System.out.println("Definición de Función:");
        System.out.println("Token 'def': " + defToken);
        System.out.println("Nombre de la función: " + nombreFuncion);
        System.out.println("Token '(': " + parentesisAbre);
        System.out.println("Parámetro: " + parametro);
        System.out.println("Token ')': " + parentesisCierra);
        System.out.println("Token ':': " + dosPuntos);

        indiceActual += 6;
        mostrarBloqueDeCodigo(indiceActual, indiceActual);
    }

}
