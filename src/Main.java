public class Main {
    public static void main(String[] args) {



    }

    private static void mostrarPosicionActual(Explorador explorador) {
        System.out.println(explorador.getNombre() + " está en la siguiente posición del tablero:");
        System.out.println("FILA: " + explorador.getPosicionActual().getCoordenadaFila());
        System.out.println("COLUMNA: " + explorador.getPosicionActual().getCoordenadaCol());
    }

    private static void explorar(Mapa mapa, Explorador explorador) {
        int trampasAlrededor = explorador.explorar(mapa);

        System.out.println("Tiene " + trampasAlrededor + " trampas alrededor.");

        if (trampasAlrededor > 0) {
            System.out.println(explorador.getNombre() + " ha caído en una trampa. Fin del juego.");
            System.exit(0);
        } else {
            int resultado = explorador.checkPosicion(mapa);
            if (resultado == 2) {
                System.exit(0);  //el explorador ha encontrado el tesoro fin del juego
            }
        }
    }
}