
// ============================================================
//  ESCAPE DEL LABORATORIO - Actividad 3 (Backtracking)
//  PLANTILLA DE INICIO: completa lo que falta
// ============================================================
//  Leyenda del laberinto:
//    'S' = inicio,  'T' = meta,  '#' = pared,  '.' = camino
//
//  Tu programa lee el laberinto SOLO (archivo maze.txt en el
//  navegador, o entrada estandar en tu IDE). Tu unica tarea es
//  implementar la BUSQUEDA con backtracking en el metodo buscar().
//
//  Salida que el sitio espera de tu programa:
//    - Cada celda que VISITAS mientras exploras, una por linea:
//          fila,columna        (ejemplo: 3,5)
//    - Al final, el camino ELEGIDO asi:
//          RUTA:r0,c0;r1,c1;r2,c2;...
//  Ya esta programado imprimir eso. Completa buscar() y listo.
// ============================================================

import java.io.*;
import java.util.*;

public class laberinto {

    // Laberinto y su tamano
    static int filas;
    static int columnas;
    static char[][] laberinto;       // '#' pared, '.' camino, 'V' ya visitado

    // Ahí guardaras el camino MAS CORTO que encuentres
    static List<int[]> mejorCamino;

    // Las 4 direcciones en las que te puedes mover
    static int[] dr = { -1, 1, 0, 0 };  // arriba, abajo, izquierda, derecha
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        // ===== (YA ESTA HECHO, no lo borres) =====
        List<String> lineas = leerLaberinto();

        filas = lineas.size();
        columnas = lineas.get(0).length();
        laberinto = new char[filas][columnas];

        int sr = 0, sc = 0, tr = 0, tc = 0;   // sr,sc = inicio (S)
                                              // tr,tc = meta  (T)
        for (int r = 0; r < filas; r++) {
            laberinto[r] = lineas.get(r).toCharArray();
            for (int c = 0; c < columnas; c++) {
                if (laberinto[r][c] == 'S') { sr = r; sc = c; }
                if (laberinto[r][c] == 'T') { tr = r; tc = c; }
            }
        }

        mejorCamino = null;

        // El camino que se va construyendo; empieza en el inicio
        List<int[]> caminoActual = new ArrayList<>();
        caminoActual.add(new int[]{ sr, sc });
        laberinto[sr][sc] = 'V';               // el inicio ya se "visito"

        // ===== TU TAREA: implementa buscar() (esta abajo) =====
        buscar(sr, sc, tr, tc, caminoActual);

        laberinto[sr][sc] = 'S';               // restauramos el inicio

        // ===== (YA ESTA HECHO: imprime el resultado) =====
        List<int[]> caminoFinal = mejorCamino == null ? caminoActual : mejorCamino;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < caminoFinal.size(); i++) {
            if (i > 0) sb.append(";");
            int[] p = caminoFinal.get(i);
            sb.append(p[0]).append(",").append(p[1]);
        }
        System.out.println("RUTA:" + sb.toString());
    }

    /**
     *  ========= COMPLETA ESTE METODO =========
     *  Busca la meta (tr,tc) con backtracking.
     *
     *  PASO 1. Si (r,c) es la meta:
     *          - Si nunca habia encontrado camino (mejorCamino == null)
     *            o el actual es mas corto (camino.size() < mejorCamino.size()),
     *            guarda una COPIA:  mejorCamino = new ArrayList<>(camino);
     *          - Regresa (return) para seguir buscando otro camino mejor.
     *
     *  PASO 2. Prueba cada una de las 4 direcciones usando dr[] y dc[].
     *          Para cada vecino (nr, nc):
     *          - Si queda FUERA del laberinto, continue.
     *          - Si es pared '#' o ya visitado 'V', continue.
     *
     *  PASO 3. Moverse (backtracking):
     *          - Guarda el caracter original de la celda: char original = laberinto[nr][nc];
     *          - Marcala como visitada: laberinto[nr][nc] = 'V';
     *          - Agregala al camino: camino.add(new int[]{ nr, nc });
     *          - Imprime la celda que visitas: System.out.println(nr + "," + nc);
     *          - Llama recursivamente: buscar(nr, nc, tr, tc, camino);
     *          - AL REGRESAR deshace el movimiento:
     *              camino.remove(camino.size() - 1);
     *              laberinto[nr][nc] = original;
     */
    static void buscar(int r, int c, int tr, int tc, List<int[]> camino) {

        // PASO 1. Si (r,c) es la meta:
        if (r == tr && c == tc) {
            if (mejorCamino == null || camino.size() < mejorCamino.size()) {
                mejorCamino = new ArrayList<>(camino);
            }
            return;
        }

        // PASO 2. Prueba cada una de las 4 direcciones
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // Si queda FUERA del laberinto, continue.
            if (nr < 0 || nr >= filas || nc < 0 || nc >= columnas) {
                continue;
            }

            // Si es pared '#' o ya visitado 'V', continue.
            if (laberinto[nr][nc] == '#' || laberinto[nr][nc] == 'V') {
                continue;
            }

            // PASO 3. Moverse (backtracking)
            char original = laberinto[nr][nc];
            laberinto[nr][nc] = 'V';
            camino.add(new int[]{ nr, nc });
            System.out.println(nr + "," + nc);
            
            buscar(nr, nc, tr, tc, camino);
            
            camino.remove(camino.size() - 1);
            laberinto[nr][nc] = original;
        }
    }
    // ===== (YA ESTA HECHO: lectura del laberinto) =====
    static List<String> leerLaberinto() throws IOException {
        List<String> lineas = new ArrayList<>();
        File f = new File("/str/maze.txt");
        Scanner sc = null;
        try {
            if (f.exists()) sc = new Scanner(f);
        } catch (Exception e) {
            sc = null;
        }
        // Si no hay archivo (en tu IDE), lee de la entrada estandar
        if (sc == null) sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String l = sc.nextLine().trim();
            if (!l.isEmpty()) lineas.add(l);
        }
        sc.close();
        return lineas;
    }
}
