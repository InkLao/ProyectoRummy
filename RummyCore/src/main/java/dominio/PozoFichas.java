/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;
import java.util.Random;

/**
 *
 * @author eduar
 */
public class PozoFichas {

    List<Ficha> fichas;

    public PozoFichas() {
    }

    public List<Ficha> getTipoFichas() {
        return fichas;
    }

    public void setTipoFichas(List<Ficha> tipoFichas) {
        this.fichas = tipoFichas;
    }

    public Ficha jalarFicha() {
        Ficha fichaJalada = null;

        if (!fichas.isEmpty()) {
            Random random = new Random();
            int numeroAleatorio = random.nextInt(fichas.size());
            fichaJalada = fichas.get(numeroAleatorio);
            fichas.remove(fichaJalada);
        }
        
        return fichaJalada;
    }
}
