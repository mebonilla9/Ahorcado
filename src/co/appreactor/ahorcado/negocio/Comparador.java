/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.ahorcado.negocio;

import java.util.regex.Pattern;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lord_Nightmare
 */
public class Comparador {

    private final String palabra;
    private String[] armazonPalabra;
    private final JPanel plPalabra;

    public Comparador(String palabra, JPanel plPalabra) {
        this.palabra = palabra;
        this.plPalabra = plPalabra;
        this.armazonPalabra = this.palabra.split(Pattern.quote(""));
        this.plPalabra.removeAll();
        for (int i = 0; i < palabra.length(); i++) {
            JTextField t = new JTextField();
            t.setText("  ");
            t.setSize(60, 20);
            t.setEditable(false);
            plPalabra.add(t);
        }
        this.plPalabra.revalidate();
    }

    public boolean encontrarLetra(String letra) {
        int coincidencias = 0;
        for (int i = 0; i < armazonPalabra.length; i++) {
            if (letra.equalsIgnoreCase(armazonPalabra[i])) {
                ((JTextField) plPalabra.getComponent(i)).setText(armazonPalabra[i]);
                coincidencias++;
            }
        }
        return coincidencias > 0;
    }

}
