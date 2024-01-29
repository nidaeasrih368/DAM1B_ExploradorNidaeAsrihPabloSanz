import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {


        System.out.println("Indica el nombre del explorador: ");
        String nombreExplorador = teclado.nextLine();

        Explorador explorador = new Explorador(nombreExplorador);
        Mapa mapa = new Mapa();
        int opcion;
        do {
            System.out.println("""
                    MENU:
                    *************************************************************
                    Bienvenido al juego del explorador
                    *************************************************************
                    1. Ver posicion actual del explorador.
                    2. Mover explorador.
                    3. Explorar.
                    4. Salir.
                    """);
            System.out.println("Seleccione una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    mostrarPosicionActual(explorador);
                    break;
                case 2:
                    moverExplorador(explorador, mapa);
                    break;
                case 3:
                    explorar(mapa, explorador);
                    break;
                case 4:
                    System.out.println("Exit");
                    salir();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 4);

    }
    private static void mostrarPosicionActual(Explorador explorador) {
        System.out.println(explorador.getNombre() + " está en la siguiente posición del tablero:");
        System.out.println("FILA: " + explorador.getPosicionActual().getCoordenadaFila());
        System.out.println("COLUMNA: " + explorador.getPosicionActual().getCoordenadaCol());
    }

    static void moverExplorador(Explorador explorador, Mapa mapa){
        System.out.println("""
                Indique la direccion de movimiento:
                1- ARRIBA
                2- ABAJO
                3- IZQUIERDA
                4- DERECHA
                """);
        int direccion = teclado.nextInt();
        explorador.moverse(direccion);

        int resul = explorador.checkPosicion(mapa);
        if (resul == 1 || resul == 2){
            System.exit(0);
        }
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
    static void salir(){
        System.exit(0);
    }
}