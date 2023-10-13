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
            buscarDeclaracionVariable();
//        } else if (lexema.equals("for")) {
//            procesarCicloFor();
//        } else if (lexema.equals("while")) {
//            procesarCicloWhile();
//        } else if (lexema.equals("def")) {
//            procesarDefinicionFuncion();
        } else if (tipoToken.equals("COMENTARIO")) {
            procesarComentario(tokenInfo);
        }
    }

    private void mostrarBloqueDeCodigo(int inicioBloque, int finBloque) {
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
    private void buscarDeclaracionVariable() {
    int inicioDeclaracion = indiceActual;
    StringBuilder identificador = new StringBuilder();
    StringBuilder valor = new StringBuilder();
    boolean asignacionEncontrada = false;

    while (indiceActual < tablaToken.size()) {
        String tokenActual = ((String) tablaToken.get(indiceActual).get(2)).trim();

        if (tokenActual.equals("=") && !identificador.toString().isEmpty()) {
            asignacionEncontrada = true;
        } else if (tokenActual.equals("\n")) {
            if (asignacionEncontrada) {
                // Termina la declaración al encontrar un salto de línea
                break;
            }
        }

        if (!asignacionEncontrada) {
            identificador.append(tokenActual);
        } else {
            valor.append(tokenActual);
        }

        indiceActual++;
    }

    if (asignacionEncontrada) {
        procesarDeclaracionVariable(identificador.toString(), valor.toString());
    } else {
        // Si no se encontró el operador de asignación, regresar al inicio de la declaración
        indiceActual = inicioDeclaracion;
    }
}
    private void procesarDeclaracionVariable(String identificador, String valor) {
        String tipo = "";

        String trimmedValor = valor.trim();

        // Validar la estructura de valor para los ejemplos específicos
        if (trimmedValor.matches("\".*\"")) {
            tipo = "Cadena de texto";
        } else if (trimmedValor.matches("\\d+")) {
            tipo = "Número entero";
        } else if (trimmedValor.matches("\\{.*\\}")) {
            tipo = "Diccionario";
        } else {
            tipo = "Error: Estructura no válida";
        }

        System.out.println("Declaración de Variable:");
        System.out.println("  Identificador: " + identificador);
        System.out.println("  Valor: " + valor);
        System.out.println("  Tipo: " + tipo);
    }

}
