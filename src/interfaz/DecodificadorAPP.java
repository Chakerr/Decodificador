/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz;

import controlador.ControladorDeco;
import mundo.Decodificador;

/**
 *
 * @author mario
 */
public class DecodificadorAPP {

    private ControladorDeco cd;

    public DecodificadorAPP(ControladorDeco cd) {
        this.cd = cd;
        System.out.println("Servidor en linea.....");
    }

    public static void main(String[] args) {
        new DecodificadorAPP(new ControladorDeco());

    }
}
