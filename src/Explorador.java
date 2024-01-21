public class Explorador {
    private String nombre;
    private Posicion posicionActual;

    // Constantes de movimiento:
    public static final int ARRIBA = 1;
    public static final int ABAJO = 2;
    public static final int IZQUIERDA = 3;
    public static final int DERECHA = 4;

    /**
     * Constructor de Explorador
     * @param nombre , y posicionActual en la primera columna y la fila obtener aleatoriamente.
     */
    public Explorador(String nombre){
        this.nombre = nombre;

        int numFilaAleatorio = (int) (Math.random()*10+1);
        this.posicionActual = new Posicion(numFilaAleatorio,0);

    }
    public String getNombre(){
        return nombre;
    }

    public Posicion getPosicionActual(){
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual){
        this.posicionActual = posicionActual;
    }

    /**
     * Se modificará la posicionActual del explorador
     * @param direccion numero entero entre 1 y 4 (constantes)
     */
    public void moverse(int direccion){
        switch (direccion){
            case ARRIBA:
                posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() -1);
                break;
            case ABAJO:
                posicionActual.setCoordenadaFila(posicionActual.getCoordenadaFila() +1);
                break;
            case IZQUIERDA:
                posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() -1);
                break;
            case DERECHA:
                posicionActual.setCoordenadaCol(posicionActual.getCoordenadaCol() +1);
                break;
            default:
                System.out.println("La Direccion no es valida!");
        }
    }
    public int explorar(Mapa mapa){

        return 0;
    }

    public int checkPosicion(Mapa mapa){

        return 0;
    }
}
