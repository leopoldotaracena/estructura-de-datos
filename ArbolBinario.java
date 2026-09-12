public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    // ===== FASE 1: INSERCIÓN =====
    public void insertar(int d) {
        raiz = insertarRec(raiz, d);
    }

    private Nodo insertarRec(Nodo n, int d) {
        if (n == null) {
            return new Nodo(d);
        }

        if (d < n.getDato()) {
            n.setIzq(insertarRec(n.getIzq(), d));
        } else if (d > n.getDato()) {
            n.setDer(insertarRec(n.getDer(), d));
        }

        return n;
    }

    // ===== FASE 2: RECORRIDOS =====
    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        return sb.toString();
    }

    private void inordenRec(Nodo n, StringBuilder sb) {
        if (n == null) {
            return;
        }
        inordenRec(n.getIzq(), sb);
        
        if (sb.length() > 0) {
            sb.append(",");
        }
        sb.append(n.getDato());
        
        inordenRec(n.getDer(), sb);
    }

    public String preorden() {
        StringBuilder sb = new StringBuilder();
        preordenRec(raiz, sb);
        return sb.toString();
    }

    private void preordenRec(Nodo n, StringBuilder sb) {
        if (n == null) {
            return;
        }
        
        if (sb.length() > 0) {
            sb.append(",");
        }
        sb.append(n.getDato());
        
        preordenRec(n.getIzq(), sb);
        preordenRec(n.getDer(), sb);
    }

    public String postorden() {
        StringBuilder sb = new StringBuilder();
        postordenRec(raiz, sb);
        return sb.toString();
    }

    private void postordenRec(Nodo n, StringBuilder sb) {
        if (n == null) {
            return;
        }
        postordenRec(n.getIzq(), sb);
        postordenRec(n.getDer(), sb);
        
        if (sb.length() > 0) {
            sb.append(",");
        }
        sb.append(n.getDato());
    }

    // ===== FASE 3: BÚSQUEDA Y CLASIFICACIÓN =====
    public boolean buscar(int d) {
        return buscarRec(raiz, d);
    }

    private boolean buscarRec(Nodo n, int d) {
        if (n == null) {
            return false;
        }

        if (d == n.getDato()) {
            return true;
        }

        if (d < n.getDato()) {
            return buscarRec(n.getIzq(), d);
        } else {
            return buscarRec(n.getDer(), d);
        }
    }

    public String claseNodo(int d) {
        Nodo target = buscarNodo(raiz, d);
        if (target == null) {
            return "NO_EXISTE";
        }

        if (target == raiz) {
            return "RAIZ";
        }

        boolean tieneIzq = target.getIzq() != null;
        boolean tieneDer = target.getDer() != null;

        if (tieneIzq && tieneDer) {
            return "DOS_HIJOS";
        } else if (tieneIzq || tieneDer) {
            return "UN_HIJO";
        } else {
            return "HOJA";
        }
    }

    private Nodo buscarNodo(Nodo n, int d) {
        if (n == null) {
            return null;
        }
        if (d == n.getDato()) {
            return n;
        }
        if (d < n.getDato()) {
            return buscarNodo(n.getIzq(), d);
        } else {
            return buscarNodo(n.getDer(), d);
        }
    }

    // ===== FASE 4: ELIMINACIÓN =====
    public boolean eliminar(int d) {
        if (!buscar(d)) {
            return false;
        }
        raiz = eliminarRec(raiz, d);
        return true;
    }

    private Nodo eliminarRec(Nodo n, int d) {
        if (n == null) {
            return null;
        }

        if (d < n.getDato()) {
            n.setIzq(eliminarRec(n.getIzq(), d));
        } else if (d > n.getDato()) {
            n.setDer(eliminarRec(n.getDer(), d));
        } else {
            // Caso 1: HOJA
            if (n.getIzq() == null && n.getDer() == null) {
                return null;
            }

            // Caso 2: UN HIJO
            if (n.getIzq() == null) {
                return n.getDer();
            }
            if (n.getDer() == null) {
                return n.getIzq();
            }

            // Caso 3: DOS HIJOS
            Nodo heir = minimo(n.getDer());
            n.setDato(heir.getDato());
            n.setDer(eliminarRec(n.getDer(), heir.getDato()));
        }

        return n;
    }

    private Nodo minimo(Nodo n) {
        while (n != null && n.getIzq() != null) {
            n = n.getIzq();
        }
        return n;
    }
}

