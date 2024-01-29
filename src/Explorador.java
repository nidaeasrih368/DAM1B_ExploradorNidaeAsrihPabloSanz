public class Explorador {
    private String nombre;
    private Posicion posicionActual;

    // Constantes de movimiento:
    private static final int ARRIBA = 1;
    private static final int ABAJO = 2;
    private static final int IZQUIERDA = 3;
    private static final int DERECHA = 4;

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

    /**
     * Revisamos la posicionActual del Explorador : si esta en una trampa =1
     * si esta en un tesoro = 2, y en otro caso = 0.
     * @param mapa
     * @return 0, 1, 2
     */
    public int checkPosicion(Mapa mapa){
        int fila = posicionActual.getCoordenadaFila();
        int columna = posicionActual.getCoordenadaCol();

        if (mapa.getTablero()[fila][columna] == 1){
            System.out.println(nombre + " " + "ha caido en una trampa");
            return 1;
        } else if (mapa.getTablero()[fila][columna] == 2) {
            System.out.println(nombre + " " + "Ha encontrado el tesoro, ENHORABUENA. Fin del juego.");
            return 2;
        } else {
            System.out.println("No pasa nada. Sigue jugando...");
            return 0;
        }
    }

    /**
     * Revisamos las casillas, devuelve el numero de casillas con trampas
     * @param mapa
     * @return
     */
    public int explorar(Mapa mapa){
        int fila = posicionActual.getCoordenadaFila();
        int columna = posicionActual.getCoordenadaCol();
        int trampasAlrededor = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int filaA = fila + i;
                int columnaA = columna + j;

                if (filaA >= 0 && filaA < 10 && columnaA >= 0 && columnaA < 10){
                    if (mapa.getTablero()[filaA][columnaA] == 1){
                        trampasAlrededor++;
                    }
                }
            }
        }

        return trampasAlrededor;
    }
}
