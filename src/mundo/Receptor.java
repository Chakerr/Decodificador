/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mundo;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receptor implements Runnable {

    private Decodificador decodificador;

    public Receptor() {
        this.decodificador = new Decodificador();
        Thread treadListener = new Thread(this);
        treadListener.start();
    }

    @Override
    public void run() {
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream inDataBuffer;
        try {
            serverSocket = new ServerSocket(5000);
            while (true) {
                socket = serverSocket.accept();
                inDataBuffer = new DataInputStream(socket.getInputStream());
                String msg = inDataBuffer.readUTF();
                String deco = decodificador.decodificar(msg);
                if (deco.length() == 1) {
                    System.out.print("\u001B[30m" + deco);
                } else {
                    System.out.print("\u001B[31m" + deco + "\u001B[0m");
                }
                Thread.sleep(50);
                socket.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());

        } catch (InterruptedException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
