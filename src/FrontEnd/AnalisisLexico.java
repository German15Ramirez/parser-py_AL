/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;
import BackEnd.Herramientas.*;
import BackEnd.Herramientas.TokenType.*;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ryoumen_kyoma
 */
public class AnalisisLexico {
     private Map<Object, Object> mapTokens = new HashMap<>();
    private List<List<Object>> infoTabla = new ArrayList<>();
    private List<List<Object>> tablaToken = new ArrayList<>();
    private String text;

    public AnalisisLexico(String inputText) {
        this.text = inputText;
    }

    public void analyze() {
        clearData();

        Reader reader = new StringReader(text);
        Lexer lexico = new Lexer(reader);
        Token token;
        int fila = 0;

        do {
            token = lexico.nextToken();
            if (!isTypeSpace(token.type)) {
                processToken(token, lexico, fila);
                fila++;
            }
        } while (token.type != TypeSpace.FINAL_ARCHIVE);
    }

    private void clearData() {
        mapTokens.clear();
        infoTabla.clear();
        tablaToken.clear();
    }

    private void processToken(Token token, Lexer lexico, int fila) {
        
        if (!isTypeSpace(token.type)) {
            String tipo = "";
            String patron = "";
            String valor = token.value.toString();
           
            if(token.type instanceof TypeAritmetico){
                tipo = "TypeArtimetico";
                patron = "[" + token.value.toString() + "]";
            }
            if(token.type instanceof TypeComentario){
                tipo = "TypeComentario";
                patron = "#(\\\"[a-z]*[0-9]*\\\")"; // Patrón para comentarios: cualquier cosa hasta el final de la línea
            }
            if(token.type instanceof TypeAsignacion){
                tipo = "TypeAsignacion";
                patron = "[" + token.value.toString() + "]";
            }
            if(token.type instanceof TypeComparacion){
                tipo = "TypeComparacion";
                patron = "[" + token.value.toString() + "]";
            }
            if(token.type instanceof TypeConstante){
                tipo = "TypeConstante";
                patron = "((\\\"[a-z]*[0-9]*\\\") | (\\\"[A-Z]*[0-9])\\\") | (('[a-z]*[0-9]*') | ('[A-Z]*[0-9])')";
            }
            if(token.type instanceof TypeIdentificador){
                tipo = "TypeIdentificador";
                patron = "([\\\\w]|_)+(\\\\w|\\\\d)*";
            }
            if(token.type instanceof TypeLogico){
                tipo = "TypeLogico";
                patron = "[" + token.value.toString() + "]";
            }
            if(token.type instanceof TypeOtro){
                tipo = "TypeOtro";
                patron = "[" + token.value.toString() + "]";
            }
            if(token.type instanceof TypePalabraReservada){
                tipo = "TypePalabraReservada";
                patron = "[" + token.value.toString() + "]";
            }
            
            
            String tokenText = tipo + ": " + valor + " fila : " + lexico.fila() + " columna : " + lexico.columna();
            tablaToken.add(Arrays.asList(token.type,token.type.toString().toLowerCase(),token.value, lexico.fila(),lexico.columna()));
            infoTabla.add(Arrays.asList(tipo + " = " + token.type,patron,token.value, lexico.fila(),lexico.columna()));

            if (mapTokens.containsKey(token.type)) {
                valor = mapTokens.get(token.type).toString() + "," + valor;
            }
            mapTokens.put(token.type, valor);
        }
    }

    private boolean isTypeSpace(Object type) {
        return type instanceof TypeSpace;
    }

    public Map<Object, Object> getMapTokens() {
        return mapTokens;
    }

    public List<List<Object>> getInfoTabla() {
        return infoTabla;
    }
    public List<List<Object>> getTablaToken() {
        return tablaToken;
    }
}
