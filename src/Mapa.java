import java.util.Random;

public class Mapa  {
    private int[][] tablero;
    private Posicion posTesoro;

    //constructor
    public Mapa() {
        this.tablero = new int[10][10];
        generarTablero();
        generarPosicionTesoro();
    }

    //metodo para generar el tablero
    private void generarTablero() {
        Random rand = new Random();

        //primera columna
        for (int i = 0; i < 10; i++) {
            tablero[i][0] = 0;
        }

        //ultima columna
        int filaTesoro = rand.nextInt(10);
        tablero[filaTesoro][9] = 2;

        //resto de columnas
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 9; j++) {
                int probabilidad = rand.nextInt(100);
                if (probabilidad < 80) {
                    tablero[i][j] = 0;  //80% de probabilidad de 0 (nada)
                } else {
                    tablero[i][j] = 1;  //20% de probabilidad de 1 (trampa)
                }
            }
        }
    }

    //metodo para generar la posicion del tesoro
    private void generarPosicionTesoro() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] == 2) {
                    posTesoro = new Posicion(i, j);
                    return;
                }
            }
        }
    }

    //metodo para obtener el tablero
    public int[][] getTablero() {
        return tablero;
    }

    // Método para obtener la posicion del tesoro
    public Posicion getPosTesoro() {
        return posTesoro;
    }

    //clase interna para representar la posicion
    public class Posicion {
        private int fila;
        private int columna;

        public Posicion(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        public int getFila() {
            return fila;
        }

        public int getColumna() {
            return columna;
        }
    }

    //ejemplo de uso
    public static void main(String[] args) {
        Mapa mapa = new Mapa();
        int[][] tablero = mapa.getTablero();
        Posicion posTesoro = mapa.getPosTesoro();

        //aqui puedes realizar acciones con el tablero y la posicion del tesoro
        System.out.println("Posición del tesoro: Fila " + posTesoro.getFila() + ", Columna " + posTesoro.getColumna());
    }
}
