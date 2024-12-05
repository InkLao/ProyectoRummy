/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduar
 */
public class GrupoFichas {
    
    private List<Ficha> fichas;
    private TipoGrupo tipo;

    public GrupoFichas() {
    }

    public GrupoFichas(List<Ficha> fichas, TipoGrupo tipo) {
        this.fichas = fichas;
        this.tipo = tipo;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public TipoGrupo getTipo() {
        return tipo;
    }

    public void setTipo(TipoGrupo tipo) {
        this.tipo = tipo;
    }

    public void agregarFicha(Ficha ficha) {
        this.fichas.add(ficha);
    }

    public void clasificarGrupo() {
        if (this.esTerna()) {
            this.tipo = TipoGrupo.TERNA;
        } else if (this.esCuaterna()) {
            this.tipo = TipoGrupo.CUATERNA;
        } else if (this.esEscalera()) {
            this.tipo = TipoGrupo.ESCALERA;
        } else {
            this.tipo = TipoGrupo.INVALIDO;
        }
    }
    
    private boolean esTerna() {
        // bandera para verificar si el grupo es terna
        boolean terna = true;
        
        // si no son exactamente tres fichas, entonces el grupo no es terna
        if (fichas.size() != 3) {
            terna = false;
        }
        
        // si no son todas del mismo número, entonces no es terna
        int numero = -1;
        // busca una ficha numerica en el grupo
        for (Ficha ficha: this.fichas) {
            if (ficha instanceof FichaNumerica fichaNumerica) {
                numero = fichaNumerica.getNumero(); // guarda el primer número que encuentra, todos los demás deberán coincidir con él
                break;
            }
        }
        // verifica que las demás fichas coincidan con el número encontrado (las fichas que son numéricas)
        for (Ficha ficha: this.fichas) {
            // si no todos los números son iguales, entonces la ficha no es terna
            if (ficha instanceof FichaNumerica fichaNumerica) {
                if (fichaNumerica.getNumero() != numero) {
                    terna = false;
                }
            }
        }
        
        // si no son todas de diferente color, entonces la ficha no es terna
        List<String> colores = new ArrayList<>();
        
        for (Ficha ficha: this.fichas) {
            // si la ficha es numérica, se almacena el color en la lista
            if (ficha instanceof FichaNumerica) {
                colores.add(((FichaNumerica) ficha).getColor());
            }
        }
        
        int contadorRojo = 0;
        int contadorVerde = 0;
        int contadorAzul = 0;
        int contadorAmarillo = 0;
        
        // se incrementan los contadores a los colores que correspondan
        for (String color: colores) {
            switch(color) {
                case "rojo" -> contadorRojo++;
                case "verde" -> contadorVerde++;
                case "azul" -> contadorAzul++;
                case "amarillo" -> contadorAmarillo++;
            }
        }
        
        // si alguno de los colores se repite, entonces el grupo no es terna
        if (contadorRojo > 1 || contadorVerde > 1 || contadorAzul > 1 || contadorAmarillo > 1) {
            terna = false;
        }
        
        // retorna si el grupo es terna o si no lo es
        return terna;
    }
    
    private boolean esCuaterna() {
        // bandera para verificar si el grupo es terna
        boolean cuaterna = true;
        
        // si no son exactamente cuatro fichas, entonces el grupo no es cuaterna
        if (fichas.size() != 4) {
            cuaterna = false;
        }
        
        // si no son todas del mismo número, entonces no es cuaterna
        int numero = -1;
        // busca una ficha numerica en el grupo
        for (Ficha ficha: this.fichas) {
            if (ficha instanceof FichaNumerica fichaNumerica) {
                numero = fichaNumerica.getNumero(); // guarda el primer número que encuentra, todos los demás deberán coincidir con él
                break;
            }
        }
        // verifica que las demás fichas coincidan con el número encontrado (las fichas que son numéricas)
        for (Ficha ficha: this.fichas) {
            // si no todos los números son iguales, entonces la ficha no es cuaterna
            if (ficha instanceof FichaNumerica fichaNumerica) {
                if (fichaNumerica.getNumero() != numero) {
                    cuaterna = false;
                }
            }
        }
        
        // si no son todas de diferente color, entonces la ficha no es cuaterna
        List<String> colores = new ArrayList<>();
        
        for (Ficha ficha: this.fichas) {
            // si la ficha es numérica, se almacena el color en la lista
            if (ficha instanceof FichaNumerica) {
                colores.add(((FichaNumerica) ficha).getColor());
            }
        }
        
        int contadorRojo = 0;
        int contadorVerde = 0;
        int contadorAzul = 0;
        int contadorAmarillo = 0;
        
        // se incrementan los contadores a los colores que correspondan
        for (String color: colores) {
            switch(color) {
                case "rojo" -> contadorRojo++;
                case "verde" -> contadorVerde++;
                case "azul" -> contadorAzul++;
                case "amarillo" -> contadorAmarillo++;
            }
        }
        
        // si alguno de los colores se repite, entonces el grupo no es cuaterna
        if (contadorRojo > 1 || contadorVerde > 1 || contadorAzul > 1 || contadorAmarillo > 1) {
            cuaterna = false;
        }
        
        // retorna si el grupo es cuaterna o si no lo es
        return cuaterna;
    }
    
    private boolean esEscalera() {
        boolean escalera = true;
        
        // si no son por lo menos tres fichas, entonces no es escalera
        if (this.fichas.size() < 3) {
            escalera = false;
        }
        
        // si la diferencia entre los números es diferente de uno, entonces no es escalera
        for (int i = 0; i < fichas.size() - 1; i++) {
            // verificar si la ficha es numérica
            Ficha ficha1 = fichas.get(i+1);
            Ficha ficha2 = fichas.get(i);
            if (ficha1 instanceof FichaNumerica fichaNum1 && ficha2 instanceof FichaNumerica fichaNum2) {
                if (fichaNum1.getNumero() - fichaNum2.getNumero() != 1) {
                    escalera = false;
                }
            }
        }
        
        // guarda el color de la primera ficha numerica que encuentra
        String color = "";
        for (Ficha ficha: fichas) {
            if (ficha instanceof FichaNumerica fichaNum) {
                color = fichaNum.getColor();
                break;
            }
        }
        
        // si no son todas del mismo color
        for (Ficha ficha: fichas) {
            // verifica si la ficha es numérica
            if (ficha instanceof FichaNumerica fichaNum) {
                // si el color de la ficha actual es diferente al color de cualquier otra del mismo grupo, entonces no es escalera
                if (!(color.equals(fichaNum.getColor()))) {
                    escalera = false;
                }
            }
        }
        
        // regresa si es escalera o si no lo es
        return escalera;
    }
    
}
