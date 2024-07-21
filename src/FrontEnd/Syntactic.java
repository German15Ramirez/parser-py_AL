/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//analizador sintáctico descendente recursivo (LL-parser)
package FrontEnd;

import java.util.ArrayList;
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
    private List<String> impresiones = new ArrayList<>();
    private int contadorOperadorTernario = 0;
    private int contadorDeclaracionVariable = 0;
    private int contadorCicloFor = 0;
    private int contadorCicloWhile = 0;
    private int contadorDefinicionFuncion = 0;
    private int contadorComentarios = 0;

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
            procesarToken(tokenInfo, lexema, (int) tokenInfo.get(3), (int) tokenInfo.get(4));
            indiceActual++;
        }
    }

    private void procesarToken(List<Object> tokenInfo, String lexema, int fila, int columna) {
        String tipoToken = tokenInfo.get(0).toString();

        if (tipoToken.equals("IDENTIFICADOR")) {
            procesarDeclaracionVariable(fila, columna);
        } else if (lexema.equals("for")) {
            procesarCicloFor(fila, columna);
        } else if (lexema.equals("while")) {
            procesarCicloWhile(fila, columna);
        } else if (lexema.equals("def")) {
            procesarDefinicionFuncion(fila, columna);
        } else if (tipoToken.equals("COMENTARIO")) {
            procesarComentario(tokenInfo, fila, columna);
        } else if (esOperadorTernario(lexema)) {
            procesarOperadorTernario(fila, columna);
        }
    }

    private boolean esOperadorTernario(String lexema) {
        // Verificar si el lexema coincide con un patrón de operador ternario
        String pattern = ".+\\s+=\\s+.+\\s+if\\s+.+\\s+else\\s+.+";

        return lexema.matches(pattern);
    }

    private void mostrarBloqueDeCodigo(int inicioBloque, int finBloque) {
        StringBuilder bloqueActual = new StringBuilder();
        boolean comentarioEncontrado = false;

        for (int i = inicioBloque; i <= finBloque; i++) {
            if (i < tablaToken.size()) {
                List<Object> tokenInfo = tablaToken.get(i);
                String lexema = (String) tokenInfo.get(2);

                if (lexema.startsWith("#")) {
                    // Si el token es un comentario, mostramos el comentario como "Comentario en línea".
                    comentarioEncontrado = true;
                    contadorComentarios++;
                    String mensaje = " Comentario #" + contadorComentarios + " en línea " + tokenInfo.get(3) + ": " + lexema;
                    // Agregar la información del comentario a una lista o a la lista de impresiones
                    impresiones.add(mensaje);
                    System.out.println(mensaje);
                }
            }
        }

        System.out.print(bloqueActual.toString());

        bloqueDeCodigoIdentificado.append(bloqueActual.toString());

        // Agregar líneas en blanco para separar bloques
        System.out.println(); // Línea en blanco
        bloqueDeCodigoIdentificado.append("\n\n"); // Dos líneas en blanco

    }

    private void procesarComentario(List<Object> tokenInfo, int fila, int columna) {
        String lexema = (String) tokenInfo.get(2);

        // Incrementa el contador y agrega la información
        contadorComentarios++;
        String mensaje = " Comentario #" + contadorComentarios + " en línea " + fila + ", columna " + columna + ": " + lexema;
        impresiones.add(mensaje);

        System.out.println(mensaje);
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
    private void procesarOperadorTernario(int fila, int columna) {
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
        contadorOperadorTernario++;
        String mensaje = " Operador ternario #" + contadorOperadorTernario + ":\n"
                + " Identificador: " + identificador + "\n"
                + " Operador ternario: " + operadorTernario + "\n"
                + " Expresión: " + expresion + "\n"
                + " Valor True: " + valorTrue + "\n"
                + " Separador: " + separador + "\n"
                + " Valor False: " + valorFalse;
        impresiones.add(mensaje + " en línea " + fila + ", columna " + columna);
    }

    private void procesarDeclaracionVariable(int fila, int columna) {
        List<Object> identificadorInfo = tablaToken.get(indiceActual);
        List<Object> asignacionInfo = tablaToken.get(indiceActual + 1);
        List<Object> valorInfo = tablaToken.get(indiceActual + 2);

        String identificador = (String) identificadorInfo.get(2);
        String asignacion = (String) asignacionInfo.get(2);
        String valor = (String) valorInfo.get(2);

        System.out.println("Declaración de Variable:");
        System.out.println("Identificador: " + identificador);
        System.out.println("Operador de Asignación: " + asignacion);

        // Si el valor contiene "[" se considera un arreglo
        if (valor.contains("[")) {
            System.out.println("Arreglo:");

            // Procesar el arreglo
            int finArreglo = obtenerFinArreglo(valor);
            for (int i = indiceActual + 2; i <= finArreglo; i++) {
                if (i < tablaToken.size()) {
                    List<Object> tokenInfo = tablaToken.get(i);
                    String lexema = (String) tokenInfo.get(2);
                    System.out.println("Elemento de Arreglo: " + lexema);
                }
            }

            // Actualizar el índice
            indiceActual = finArreglo + 1;
        } else {
            // No es un arreglo, muestra el valor
            System.out.println("Valor: " + valor);
            indiceActual += 3;
        }

        mostrarBloqueDeCodigo(indiceActual, indiceActual);

        contadorDeclaracionVariable++;
        String mensaje = " Declaración de Variable #" + contadorDeclaracionVariable + ":\n"
                + " Identificador: " + identificador + "\n"
                + " Operador de Asignación: " + asignacion + "\n"
                + " Valor: " + valor;
        impresiones.add(mensaje + " en línea " + fila + ", columna " + columna);
    }

    private int obtenerFinArreglo(String valor) {
        int i = indiceActual + 2;
        while (i < tablaToken.size()) {
            String lexema = (String) tablaToken.get(i).get(2);
            if (lexema.contains("]")) {
                return i;
            }
            i++;
        }
        return i;
    }

    private void procesarCicloFor(int fila, int columna) {
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

        contadorCicloFor++;
        String mensaje = " Ciclo For #" + contadorCicloFor + ":\n"
                + " Token 'for': " + forToken + "\n"
                + " Variable: " + variable + "\n"
                + " Token 'in': " + inToken + "\n"
                + " Token 'range': " + rangeToken + "\n"
                + " Token ':': " + dosPuntos;
        impresiones.add(mensaje + " en línea " + fila + ", columna " + columna);
    }

    private void procesarCicloWhile(int fila, int columna) {
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

        contadorCicloWhile++;
        String mensaje = " Ciclo While #" + contadorCicloWhile + ":\n"
                + " Token 'while': " + whileToken + "\n"
                + " Condición: " + condicion + "\n"
                + " Token ':': " + dosPuntos;
        impresiones.add(mensaje + " en línea " + fila + ", columna " + columna);
    }

    private void procesarDefinicionFuncion(int fila, int columna) {
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

        contadorDefinicionFuncion++;
        String mensaje = " Definición de Función #" + contadorDefinicionFuncion + ":\n"
                + " Token 'def': " + defToken + "\n"
                + " Nombre de la función: " + nombreFuncion + "\n"
                + " Token '(': " + parentesisAbre + "\n"
                + " Parámetro: " + parametro + "\n"
                + " Token ')': " + parentesisCierra + "\n"
                + " Token ':': " + dosPuntos;
        impresiones.add(mensaje + " en línea " + fila + ", columna " + columna);
    }

    public List<String> getImpresiones() {
        return impresiones;
    }
}
