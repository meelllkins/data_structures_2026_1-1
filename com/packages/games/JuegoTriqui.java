package com.packages.games;

import java.util.Scanner;

public class JuegoTriqui {

    private Scanner input = new Scanner(System.in);
    private char[][] tablero  = new char[3][3];
    private Jugador  j1, j2;
    private Jugador  turno;
    private boolean  juegoActivo = false;

    // ─── MENÚ PRINCIPAL DEL JUEGO ────────────────────────────────────────────
    public void menu() {
        String op;
        do {
            System.out.println("\n====== TRIQUI ======");
            System.out.println("0. Salir");
            System.out.println("1. Ingresar jugadores");
            System.out.println("2. Sorteo de inicio");
            System.out.println("3. Jugar");
            System.out.println("4. Modificar jugadores");
            System.out.print("Ingrese su opción: ");
            op = input.nextLine();

            switch (op) {
                case "0":
                    break;
                case "1":
                    ingresarJugadores();
                    break;
                case "2":
                    sorteo();
                    break;
                case "3":
                    jugar();
                    break;
                case "4":
                    modificar();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!op.equals("0"));
    }

    // ─── a. INGRESAR JUGADORES ───────────────────────────────────────────────
    public void ingresarJugadores() {
        System.out.print("Nombre jugador 1: ");
        String n1 = input.nextLine();

        System.out.print("Símbolo jugador 1 (X u O): ");
        char s1 = input.nextLine().toUpperCase().charAt(0);
        while (s1 != 'X' && s1 != 'O') {
            System.out.print("Solo se permite X o O. Intente de nuevo: ");
            s1 = input.nextLine().toUpperCase().charAt(0);
        }

        char s2 = (s1 == 'X') ? 'O' : 'X';

        System.out.print("Nombre jugador 2: ");
        String n2 = input.nextLine();

        j1 = new Jugador(n1, s1);
        j2 = new Jugador(n2, s2);

        System.out.println("\nJugador 1: " + n1 + " (" + s1 + ")");
        System.out.println("Jugador 2: " + n2 + " (" + s2 + ")");
        System.out.println("Jugadores registrados. Realice el sorteo para comenzar.");

        juegoActivo = false;
    }

    // ─── b. SORTEO ───────────────────────────────────────────────────────────
    public void sorteo() {
        if (j1 == null || j2 == null) {
            System.out.println("Primero ingrese los jugadores.");
            return;
        }
        turno = (Math.random() < 0.5) ? j1 : j2;
        inicializarTablero();
        juegoActivo = true;
        System.out.println("\nSorteo realizado. Empieza: " + turno.nombre + " (" + turno.simbolo + ")");
    }

    // ─── INICIALIZAR TABLERO ─────────────────────────────────────────────────
    public void inicializarTablero() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tablero[i][j] = ' ';
    }

    // ─── c, e, f, g. JUGAR ───────────────────────────────────────────────────
    public void jugar() {
        if (!juegoActivo) {
            System.out.println("Debe realizar el sorteo primero.");
            return;
        }

        while (true) {
            mostrarTablero();
            System.out.println("\nTurno de: " + turno.nombre + " (" + turno.simbolo + ")");
            System.out.println("1. Jugar");
            System.out.println("2. Pausar");
            System.out.println("3. Cancelar");
            System.out.print("Opción: ");
            String op = input.nextLine();

            if (op.equals("2")) {
                System.out.println("Juego pausado. Puede modificar jugadores y volver.");
                return;
            }

            if (op.equals("3")) {
                System.out.println("Juego cancelado.");
                juegoActivo = false;
                return;
            }

            if (!op.equals("1")) {
                System.out.println("Opción no válida.");
                continue;
            }

            // e. Ingresar coordenada
            int fila   = pedirCoordenada("Fila (0-2): ");
            int columna = pedirCoordenada("Columna (0-2): ");

            if (tablero[fila][columna] != ' ') {
                System.out.println("Casilla ocupada. Intente de nuevo.");
                continue;
            }

            tablero[fila][columna] = turno.simbolo;

            // h. Verificar ganador
            if (hayGanador()) {
                mostrarTablero();
                mensajeGanador(turno);
                juegoActivo = false;
                return;
            }

            // Verificar empate
            if (tableroLleno()) {
                mostrarTablero();
                System.out.println("\n¡Empate! Ningún jugador completó tres en línea.");
                juegoActivo = false;
                return;
            }

            cambiarTurno();
        }
    }

    // ─── PEDIR COORDENADA CON VALIDACIÓN ────────────────────────────────────
    private int pedirCoordenada(String mensaje) {
        int valor = -1;
        while (valor < 0 || valor > 2) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(input.nextLine());
                if (valor < 0 || valor > 2) {
                    System.out.println("Valor debe ser 0, 1 o 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
        return valor;
    }

    // ─── MOSTRAR TABLERO ─────────────────────────────────────────────────────
    public void mostrarTablero() {
        System.out.println("\n  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + tablero[i][j] + "]");
                if (j < 2) System.out.print(" ");
            }
            System.out.println();
        }
    }

    // ─── CAMBIAR TURNO ───────────────────────────────────────────────────────
    public void cambiarTurno() {
        turno = (turno == j1) ? j2 : j1;
    }

    // ─── VERIFICAR GANADOR ───────────────────────────────────────────────────
    public boolean hayGanador() {
        // Filas y columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == turno.simbolo &&
                tablero[i][1] == turno.simbolo &&
                tablero[i][2] == turno.simbolo) return true;

            if (tablero[0][i] == turno.simbolo &&
                tablero[1][i] == turno.simbolo &&
                tablero[2][i] == turno.simbolo) return true;
        }
        // Diagonal principal
        if (tablero[0][0] == turno.simbolo &&
            tablero[1][1] == turno.simbolo &&
            tablero[2][2] == turno.simbolo) return true;
        // Diagonal secundaria
        if (tablero[0][2] == turno.simbolo &&
            tablero[1][1] == turno.simbolo &&
            tablero[2][0] == turno.simbolo) return true;

        return false;
    }

    // ─── VERIFICAR EMPATE ────────────────────────────────────────────────────
    public boolean tableroLleno() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j] == ' ') return false;
        return true;
    }

    // ─── h. MENSAJE GANADOR CON ASCII ART ───────────────────────────────────
    // Muestra "TRIQUI" formado con el símbolo del ganador (igual a la Figura 2)
    public void mensajeGanador(Jugador j) {
        char s = j.simbolo;
        String ss = "" + s + s;   // doble símbolo: XX o OO

        System.out.println();
        // T          R          I          Q              U          I
        System.out.println(ss+ss+ss+ss + "  " + ss+ss+ss   + "  " + ss+ss+ss   + "  " + ss+ss+ss   + "  " + s+"  "+s  + "  " + s +"  " + s  + "  " + ss+ss+ss  );
        System.out.println("  "+ss      + "      " + s+" "+s + "  " + ss + "   " + ss + "  " + ss + "  " + s+" "+s + "  " + ss + "  " + ss + "  " + ss + "  " + s+"  "+s  );
        System.out.println("  "+ss      + "      " + ss+ss+ss + "  " + ss + "   " + ss + "  " + ss + "  " + s+" "+s + "  " + ss + "  " + ss + "  " + ss + "  " + s+"  "+s  );
        System.out.println("  "+ss      + "      " + s+" "+s + "  " + ss + "   " + ss + "  " + ss + "  " + ss+ss+ss + " " + ss + "  " + ss + "  " + ss + "  " + s+"  "+s  );
        System.out.println("  "+ss      + "      " + s+" "+s + "  " + ss + " "+ss+ss+ss+ss + "  " + ss+ss+ss   + "     " + ss+ss+ss + "  " + ss+ss+ss );
        System.out.println("                                                  "+ss);
        System.out.println("\n¡Felicitaciones, " + j.nombre + "! Ganaste el TRIQUI.");
    }

    // ─── d. MODIFICAR JUGADORES ──────────────────────────────────────────────
    public void modificar() {
        if (j1 == null || j2 == null) {
            System.out.println("No hay jugadores registrados.");
            return;
        }
        System.out.println("1. Modificar nombre");
        System.out.println("2. Modificar símbolo");
        System.out.print("Opción: ");
        String op = input.nextLine();

        if (op.equals("1")) {
            System.out.print("Nuevo nombre jugador 1: ");
            j1.nombre = input.nextLine();
            System.out.print("Nuevo nombre jugador 2: ");
            j2.nombre = input.nextLine();
            System.out.println("Nombres actualizados.");
        } else if (op.equals("2")) {
            System.out.print("Nuevo símbolo jugador 1 (X u O): ");
            char s1 = input.nextLine().toUpperCase().charAt(0);
            while (s1 != 'X' && s1 != 'O') {
                System.out.print("Solo X o O: ");
                s1 = input.nextLine().toUpperCase().charAt(0);
            }
            j1.simbolo = s1;
            j2.simbolo = (s1 == 'X') ? 'O' : 'X';
            System.out.println("Símbolos actualizados: " + j1.nombre + "=" + j1.simbolo + ", " + j2.nombre + "=" + j2.simbolo);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}