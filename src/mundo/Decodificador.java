/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mundo;

import java.util.Hashtable;

public class Decodificador {

    private Hashtable<Integer, String> diccionario;
    private String SE;
    private String PE;
    private String PS;
    private String decodificado;
    private int contador;

    public Decodificador() {
        diccionario = new Hashtable<>();
        SE = "";
        PE = "";
        PS = "";
        this.decodificado = "";
        contador = 255;
        inicializarDiccionario();
    }

    public void inicializarDiccionario() {
        for (int c = 0; c <= 255; c++) {
            diccionario.put(c, Character.toString((char) c));
        }
    }

    public String obtenerValor(int indice) {
        return diccionario.get(indice);
    }

    public String decodificar(String mensajeRecibido) {
        String num = mensajeRecibido.trim();
        if (!num.isEmpty()) {
            if (PE.isEmpty() && SE.isEmpty()) {
                PE = num;
                decodificado = obtenerValor(Integer.parseInt(PE));
            } else if (SE.isEmpty()) {
                SE = num;
                PS = obtenerValor(Integer.parseInt(PE)) + obtenerValor(Integer.parseInt(SE));
                diccionario.put(++contador, PS);
                decodificado = obtenerValor(Integer.parseInt(SE));
            } else {
                PE = SE;
                SE = num;
                if (obtenerValor(Integer.parseInt(SE)) == null) {
                    PS = obtenerValor(Integer.parseInt(PE)) + obtenerValor(Integer.parseInt(PE)).charAt(0);
                    diccionario.put(++contador, PS);
                } else {
                    PS = obtenerValor(Integer.parseInt(PE)) + obtenerValor(Integer.parseInt(SE)).charAt(0);
                    diccionario.put(++contador, PS);

                }
                decodificado = obtenerValor(Integer.parseInt(SE));
            }
        }

        return decodificado;
    }

}
