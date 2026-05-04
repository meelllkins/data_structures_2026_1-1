package com.packages.linked_list;
 
public class LSLPoly {
 
    public NodePoly head;
    public boolean ordenado;
 
    public LSLPoly() {
        head = null;
        ordenado = false;
    }
 
    // ─── CREAR ───────────────────────────────────────────────
    // Agrega un término al final de la lista.
    // Si el exponente ya existe, actualiza el coeficiente en vez de duplicar.
    public void agregarTermino(int coef, int exp) {
        // Verificar si el exponente ya existe
        NodePoly buscar = head;
        while (buscar != null) {
            if (buscar.exponente == exp) {
                buscar.coeficiente = coef;
                System.out.println("El exponente " + exp + " ya existía. Coeficiente actualizado.");
                return;
            }
            buscar = buscar.link;
        }
        // Si no existe, crear nodo nuevo al final
        NodePoly p = new NodePoly();
        p.coeficiente = coef;
        p.exponente = exp;
        p.link = null;
 
        if (head == null) {
            head = p;
        } else {
            NodePoly q = head;
            while (q.link != null) {
                q = q.link;
            }
            q.link = p;
        }
        ordenado = false;
    }
 
    // ─── MOSTRAR ─────────────────────────────────────────────
    // Muestra el polinomio en forma matemática: 8x^4 + 2x^3 + 5x + 9
    public void mostrarPolinomio(String nombre) {
        if (head == null) {
            System.out.println(nombre + "(x) = [vacío]");
            return;
        }
        System.out.print(nombre + "(x) = ");
        NodePoly p = head;
        boolean primero = true;
        while (p != null) {
            // Signo
            if (!primero) {
                System.out.print(p.coeficiente >= 0 ? " + " : " - ");
            } else if (p.coeficiente < 0) {
                System.out.print("-");
            }
 
            int coefAbs = p.coeficiente < 0 ? -p.coeficiente : p.coeficiente;
 
            // Formato del término según exponente
            if (p.exponente == 0) {
                System.out.print(coefAbs);
            } else if (p.exponente == 1) {
                System.out.print(coefAbs + "x");
            } else {
                System.out.print(coefAbs + "x^" + p.exponente);
            }
 
            primero = false;
            p = p.link;
        }
        System.out.println();
    }
 
    // ─── ORDENAR ─────────────────────────────────────────────
    // Ordena de mayor a menor exponente (burbuja sobre nodos)
    public void ordenarPolinomio() {
        if (head == null) return;
        boolean cambio = true;
        while (cambio) {
            cambio = false;
            NodePoly p = head;
            while (p.link != null) {
                if (p.exponente < p.link.exponente) {
                    // Intercambiar datos (no nodos)
                    int tempCoef = p.coeficiente;
                    int tempExp  = p.exponente;
                    p.coeficiente = p.link.coeficiente;
                    p.exponente   = p.link.exponente;
                    p.link.coeficiente = tempCoef;
                    p.link.exponente   = tempExp;
                    cambio = true;
                }
                p = p.link;
            }
        }
        ordenado = true;
        System.out.println("Polinomio ordenado de mayor a menor exponente.");
    }
 
    // ─── MODIFICAR ───────────────────────────────────────────
    // El usuario ingresa el exponente y el nuevo coeficiente
    public boolean modificarTermino(int exp, int nuevoCoef) {
        NodePoly p = head;
        while (p != null) {
            if (p.exponente == exp) {
                p.coeficiente = nuevoCoef;
                return true;
            }
            p = p.link;
        }
        return false;
    }
 
    // ─── ELIMINAR ────────────────────────────────────────────
    // Elimina el nodo cuyo exponente coincida
    public boolean eliminarTermino(int exp) {
        if (head == null) return false;
 
        if (head.exponente == exp) {
            head = head.link;
            return true;
        }
 
        NodePoly q = head;
        NodePoly p = q.link;
        while (p != null) {
            if (p.exponente == exp) {
                q.link = p.link;
                return true;
            }
            q = p;
            p = p.link;
        }
        return false;
    }
 
    // ─── AGREGAR CONSERVANDO ORDEN ───────────────────────────
    // Si el polinomio ya fue ordenado, inserta en la posición correcta
    public void agregarOrdenado(int coef, int exp) {
        // Verificar si el exponente ya existe
        NodePoly buscar = head;
        while (buscar != null) {
            if (buscar.exponente == exp) {
                buscar.coeficiente = coef;
                System.out.println("El exponente " + exp + " ya existía. Coeficiente actualizado.");
                return;
            }
            buscar = buscar.link;
        }
 
        NodePoly nuevo = new NodePoly();
        nuevo.coeficiente = coef;
        nuevo.exponente   = exp;
 
        // Insertar al inicio si es el mayor
        if (head == null || exp > head.exponente) {
            nuevo.link = head;
            head = nuevo;
            return;
        }
 
        // Buscar posición correcta
        NodePoly q = head;
        NodePoly p = q.link;
        while (p != null && p.exponente > exp) {
            q = p;
            p = p.link;
        }
        nuevo.link = p;
        q.link = nuevo;
    }
 
    // ─── SUMAR DOS POLINOMIOS ────────────────────────────────
    // Retorna una nueva LSLPoly con la suma de this y otro
    public LSLPoly sumar(LSLPoly otro) {
        LSLPoly resultado = new LSLPoly();
 
        NodePoly p = this.head;
        while (p != null) {
            resultado.agregarTermino(p.coeficiente, p.exponente);
            p = p.link;
        }
 
        NodePoly q = otro.head;
        while (q != null) {
            NodePoly existe = resultado.head;
            boolean encontrado = false;
            while (existe != null) {
                if (existe.exponente == q.exponente) {
                    existe.coeficiente += q.coeficiente;
                    encontrado = true;
                    break;
                }
                existe = existe.link;
            }
            if (!encontrado) {
                resultado.agregarTermino(q.coeficiente, q.exponente);
            }
            q = q.link;
        }
        resultado.ordenarPolinomio();
        return resultado;
    }
 
    // ─── RESTAR DOS POLINOMIOS ───────────────────────────────
    // Retorna una nueva LSLPoly con this - otro
    public LSLPoly restar(LSLPoly otro) {
        LSLPoly resultado = new LSLPoly();
 
        NodePoly p = this.head;
        while (p != null) {
            resultado.agregarTermino(p.coeficiente, p.exponente);
            p = p.link;
        }
 
        NodePoly q = otro.head;
        while (q != null) {
            NodePoly existe = resultado.head;
            boolean encontrado = false;
            while (existe != null) {
                if (existe.exponente == q.exponente) {
                    existe.coeficiente -= q.coeficiente;
                    encontrado = true;
                    break;
                }
                existe = existe.link;
            }
            if (!encontrado) {
                resultado.agregarTermino(-q.coeficiente, q.exponente);
            }
            q = q.link;
        }
        resultado.ordenarPolinomio();
        return resultado;
    }
 
    // ─── EVALUAR f(a) ────────────────────────────────────────
    // Sustituye x por el valor 'a' y calcula el resultado
    public double evaluar(double a) {
        NodePoly p = head;
        double resultado = 0;
        while (p != null) {
            // Calcula a^exponente de forma manual
            double potencia = 1;
            for (int i = 0; i < p.exponente; i++) {
                potencia *= a;
            }
            resultado += p.coeficiente * potencia;
            p = p.link;
        }
        return resultado;
    }
}