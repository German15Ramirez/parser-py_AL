/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package BackEnd.Herramientas;

/**
 *
 * @author ryoumen_kyoma
 */
public enum ListTokens {
    //ARITMETICOS
    ARIT_SUMA,
    ARIT_RESTA,
    ARIT_EXPONENTE,
    ARIT_DIVISION,
    ARIT_MODULO,
    ARIT_MULTIPLICACION,
    //COMPARACION
    COMPARA_IGUAL,
    COMPARA_DIFERENTE,
    COMPARA_MAYOR_QUE,
    COMPARA_MENOR_QUE,
    COMPARA_MAYOR_O_IGUAL_QUE,
    COMPARA_MENOR_O_IGUAL_QUE,
    //LOGICOS
    LOGIC_Y,
    LOGIC_O,
    LOGIC_NEGACION,
    //ASIGNACION
    ASIGNACION,
    //PALABRA CLAVE
    PALABRA_RESERVADA,
    //CONSTANTES
    CONST_ENTERO,
    CONST_DECIMAL,
    CONST_CADENA,
    CONST_BOOLEANAS,
    //COMENTARIO
    COMENTARIO,
    //OTROS
    OTROS_PARENTESIS,
    OTROS_LLAVES,
    OTROS_CORCHETES,
    OTROS_COMA,
    OTROS_PUNTO_Y_COMA,
    OTROS_DOS_PUNTOS,
    OTROS_IDENTIFICADOR,
    ERROR_LEXICO;
    
}
