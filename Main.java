import com.packages.arrays.*;
import com.packages.linked_list.*;
import com.packages.strings.*;
import java.util.Scanner;
import com.packages.games.*;
import com.packages.stacks.Stack;
import com.packages.queues.Queue;
import com.packages.recursivity.Recursion;

public class Main 
{
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        String resp;
        do {
            System.out.println("Menú de opciones");
            System.out.println("0. Salir");
            System.out.println("1. Cadenas de caracteres");
            System.out.println("2. Vectores");
            System.out.println("3. Matrices");
            System.out.println("4. Registros");
            System.out.println("5. Lista Simplemente Ligada");
            System.out.println("6. Lista Simplemente Ligada Circular");
            System.out.println("7. Polinomios");
            System.out.println("8. Juego Triqui");
            System.out.println("9. Lista Doblemente Ligada");
            System.out.println("10. Pilas");
            System.out.println("11. Colas");
            System.out.println("12. Recursividad");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    System.out.println("Hasta pronto");
                    break;
                case "1":
                    menuString();
                    break;
                case "2":
                    menuVector();
                    break;
                case "3":
                    menuMatrix();
                    break;
                case "4":
                    menuRecords();
                    break;
                case "5":
                    menuLSL();
                    break;
                case "6":
                    menuLSLC();
                    break;
                case "7": 
                    menuPolynomial(); 
                    break;
                case "8": 
                    menuGames(); 
                    break;
                case "9":
                    menuLDL();
                    break;
                case "10":
                    menuStack();
                    break;
                case "11":
                    menuQueue();
                    break;
                case "12":
                    menuRecursion();
                    break; 
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuString()
    {
        String resp;
        StringChar str = new StringChar();
        do {
            System.out.println("Menú Cadenas de Caracteres");
            System.out.println("0. Regresar");
            System.out.println("1. Ingresar texto");
            System.out.println("2. Mostrar texto");
            System.out.println("3. Longitud texto");
            System.out.println("4. Texto mayúscula");
            System.out.println("5. Texto minúscula");
            System.out.println("6. Palíndromo");
            System.out.println("7. Ejemplos cadenas");
            System.out.println("8. Contar carácter del usuario");
            System.out.println("9. Convertir cadena a ASCII");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Ingrese un texto: ");
                    str.setText(input.nextLine());
                    break;
                case "2":
                    System.out.println("Texto ingresado: " + str.getText());
                    break;
                case "3":
                    System.out.println("Longitud texto: " + str.lengthString());
                    break;
                case "4":
                    System.out.println("Texto en mayúscula: " + str.upperString());
                    break;
                case "5":
                    System.out.println("Texto en minúscula: " + str.lowerString());
                    break;
                case "6":
                    str.palindrome();
                    break;
                case "7":
                    ExampleStrings es = new ExampleStrings();
                    break;
                case "8":
                    char charUser;
                    System.out.println("Carácter a contar: ");
                    charUser = input.next().charAt(0);
                    input.nextLine();
                    System.out.println("El carácter " + charUser + " se encuentra " + str.countChar(charUser));
                    break;
                case "9":
                    System.out.println("Cadena ASCII: " + str.stringASCII());
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }


    public static void menuVector()
    {
        String resp;
        int datum, pos;
        Vector v = new Vector();
        
        do {
            System.out.println("\n-------Menú Vectores------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar (secuencial)");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Insertar");
            System.out.println("8. Ordenar (burbuja)");
            System.out.println("9. Suma datos");
            System.out.println("10. Promedio datos");
            System.out.println("11. Mayor dato");
            System.out.println("12. Menor dato");
            System.out.println("13. Varianza");
            System.out.println("14. Desviación");
            System.out.println("15. Intercambio");
            System.out.println("16. Producto punto");
            System.out.println("17. Eliminar ocurrencias");
            System.out.println("18. Verificar orden ascendente");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Dato vector: ");
                    datum = input.nextInt();
                    input.nextLine();
                    if (v.getN() < v.getT()) {
                        v.addVector(datum);
                    } else {
                        System.out.println("Vector lleno");
                    }
                    // v.addVector(input.nextInt());
                    break;
                case "2":
                    System.out.println("Tamaño vector: " + v.getN());
                    break;
                case "3":
                    v.showVector();
                    break;
                case "4":
                    if (v.getN() > 0) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.println(datum + " encontrado en posición " + pos);
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "5":
                    if (v.getN() > 0) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            v.updateVector(datum, pos);
                            System.out.println("Dato actualizado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "6":
                    if (v.getN() > 0) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            v.deleteVector(pos);
                            System.out.println("Dato eliminado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "7":
                    if (v.getN() < v.getT()) {
                        System.out.print("Dato referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        pos = v.searchSecuencial(datum);
                        if (pos == -1) {
                            System.out.println(datum + " no se encuentra en el vector");
                        } else {
                            System.out.print("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            v.insertVector(pos, datum);
                            System.out.println("Dato insertado correctamente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "8":
                    if (v.getN() > 0) {
                        v.sortBubble();
                        System.out.println("Vector ordenado correctamente");
                    } else {
                        System.out.println("Vector vacío");
                    }
                case "9":
                    if (v.getN() > 0) {
                        System.out.println("Suma datos vector: " + v.sumVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "10":
                    if (v.getN() > 0) {
                        System.out.println("Promedio datos vector: " + v.avgVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "11":
                    if (v.getN() > 0) {
                        System.out.println("Mayor dato vector: " + v.maxVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "12":
                    if (v.getN() > 0) {
                        System.out.println("Menor dato vector: " + v.minVector());
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "13":
                    if (v.getN() > 1) {
                        System.out.println("Varianza: " + v.variance());
                    } else {
                        System.out.println("No hay datos suficientes");
                    }
                    break;
                case "14":
                    if (v.getN() > 1) {
                        System.out.println("Desviación estándar: " + v.desviation());
                    } else {
                        System.out.println("No hay datos suficientes");
                    }
                    break;
                case "15":
                    if (v.getN() > 0) {
                        v.interchange();
                        System.out.println("Se intercambiaron los datos del vector");
                    } else {
                        System.out.println("No hay datos");
                    }
                    break;
                case "16":
                    int [] v1 = {2, 5 ,-6};
                    int [] v2 = {1, 8 , 4};
                    System.out.println("Producto punto: " + v.productPoint(v1, v2, 3));
                    break;
                case "17":
                    if (v.getN() > 0) {
                        v.deleteOcurrencies();
                        v.showVector();
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                case "18":
                    if (v.getN() > 0) {
                        if (v.sortAsc()) {
                            System.out.println("Vector ordenado ascendentemente");
                        } else {
                            System.out.println("El vector no está ordenado ascendentemente");
                        }
                    } else {
                        System.out.println("Vector vacío");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuMatrix()
    {
        String resp;
        int rows, cols;
        Matrix matrix = new Matrix();
        Matrix matrix2 = new Matrix();
        rows = 0;
        cols = 0;
        
        do {
            System.out.println("\n-------Menú Matrices------");
            System.out.println("0. Regresar");
            System.out.println("1. Crear matriz");
            System.out.println("2. Tamaño (orden)");
            System.out.println("3. Mostrar");
            System.out.println("4. Suma matrices");
            System.out.println("5. Diagonal principal");
            System.out.println("6. Diagonal secundaria");
            System.out.println("7. Triángulo arriba");
            System.out.println("8. Triángulo izquierdo");
            System.out.println("9. Triángulo derecho");
            System.out.println("10. Triangular inferior");
            System.out.println("11. Triangular inferior secundaria");
            System.out.println("12. Mayor dato por fila");
            System.out.println("13. Promedio por columna");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Número filas: ");
                    rows = input.nextInt();
                    input.nextLine();
                    System.out.print("Número columnas: ");
                    cols = input.nextInt();
                    input.nextLine();
                    if (rows > 0 && rows <= 50 && cols > 0 && cols <= 50) {
                        matrix.setM(rows);
                        matrix.setN(cols);
                        matrix.createMatrix();
                        System.out.println("Matriz creada correctamente");
                    } else {
                        System.out.println("Tamaño no válido para la matriz");
                    }
                    break;
                case "2":
                    System.out.println("Tamaño matriz: " + matrix.getM() + " x " + matrix.getN());
                    break;
                case "3":
                    matrix.showMatrix(matrix.getMat());
                    break;
                case "4":
                    matrix2.setM(rows);
                    matrix2.setN(cols);
                    matrix2.createMatrix();
                    matrix.sumMatrix(matrix.getMat(), matrix2.getMat());
                    matrix.showMatrix(matrix.getMat());
                    System.out.println();
                    matrix2.showMatrix(matrix2.getMat());
                    System.out.println();
                    matrix.showMatrix(matrix.getMatSum());
                    break;
                case "5":
                    if (matrix.getM() == matrix.getN() && matrix.getM() > 1) {
                        matrix.mainDiagonal();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "6":
                    if (matrix.getM() == matrix.getN() && matrix.getM() > 1) {
                        matrix.secondaryDiagonal();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "7":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.upTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "8":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.leftTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "9":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.rightTriangle();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "10":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.lowerTriangular();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "11":
                    if (matrix.getM() > 1 && matrix.getN() > 1) {
                        matrix.lowerTriangularSecondary();
                    } else {
                        System.out.println("La matriz debe ser cuadrada");
                    }
                    break;
                case "12":
                    if (matrix.getM() > 0 && matrix.getN() > 0) {
                        matrix.maxRow();
                    } else {
                        System.out.println("Debe crear la matriz");
                    }
                    break;
                case "13":
                    if (matrix.getM() > 0 && matrix.getN() > 0) {
                        matrix.averageColumn();
                    } else {
                        System.out.println("Debe crear la matriz");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuRecords()
    {
        String name, resp;
        byte age;
        Persons per = new Persons();
        
        do {
            System.out.println("\n-------Menú Registros------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Persona joven");
            System.out.println("5. Porcentaje mayores");
            // System.out.println("5. Promedio datos");
            // System.out.println("6. Mayor dato");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nombre: ");
                    name = input.nextLine();
                    System.out.print("Edad: ");
                    age = input.nextByte();
                    input.nextLine();
                    if (per.getN() < per.getT()) {
                        per.createPerson(name, age);
                    } else {
                        System.out.println("Vector lleno");
                    }
                    break;
                case "2":
                    System.out.println("Tamaño vector: " + per.getN());
                    break;
                case "3":
                    per.showPerson();
                    break;
                case "4":
                    if (per.getN() > 0) {
                        per.youngPerson();
                    } else {
                        System.out.println("No hay personas registradas");
                    }
                    break;
                case "5":
                    if (per.getN() > 0) {
                        System.out.println("Porcentaje mayores de edad: " + per.percentageMax18());
                    } else {
                        System.out.println("No hay personas registradas");
                    }
                    break;
                
                // case "9":
                //     if (v.getN() > 0) {
                //         System.out.println("Suma datos vector: " + v.sumVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                // case "10":
                //     if (v.getN() > 0) {
                //         System.out.println("Promedio datos vector: " + v.avgVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                // case "11":
                //     if (v.getN() > 0) {
                //         System.out.println("Mayor dato vector: " + v.maxVector());
                //     } else {
                //         System.out.println("Vector vacío");
                //     }
                //     break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }


    public static void menuLSL()
    {
        int datum;
        String resp;
        LSL list = new LSL();
        Node r;
        do {
            System.out.println("\n-------Menú LSL------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Suma");
            System.out.println("5. Promedio");
            System.out.println("6. Buscar");
            System.out.println("7. Modificar");
            System.out.println("8. Eliminar");
            System.out.println("9. Insertar (antes de referencia)");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nuevo dato: ");
                    datum = input.nextInt();
                    input.nextLine();
                    list.createBeginLSL(datum);
                    System.out.println("Dato agregado en la LSL");
                    break;
                case "2":
                    System.out.println("Tamaño lista: " + list.countNodesLSL() + " nodos");
                    break;
                case "3":
                    list.showLSL();
                    break;
                case "4":
                    System.out.println("Suma lista: " + list.sumNodesLSL());
                    break;
                case "5":
                    if (list.head != null) {
                        System.out.println(
                            "Promedio lista: " + 
                            list.sumNodesLSL() / list.countNodesLSL()
                        );
                    } else {
                        System.out.println("Lista vacía");
                    }
                    break;
                case "6":
                    if (list.head != null) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        r = list.findLSL(datum);
                        if (r == null) {
                            System.out.println(datum + " no se encuentra en la LSL");
                        } else {
                            System.out.println(datum + " encontrado en dirección " + r);
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "7":
                    if (list.head != null) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        r = list.findLSL(datum);
                        if (r == null) {
                            System.out.println(datum + " no se encuentra en la LSL");
                        } else {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            list.updateNode(r, datum);
                            System.out.println("Se actualizó el dato correctamente");
                            
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "8":
                    if (list.head != null) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        list.deleteNodeLSL(datum);
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                case "9":
                    if (list.head != null) {
                        System.out.print("Dato de referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        Node dirRef = list.findReferenceLSL(datum);
                        if (dirRef != null) {
                            System.out.print("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            list.insertBeforeLSL(dirRef, datum);
                            System.out.println(datum + " se insertó correctamente");
                        }
                    } else {
                        System.out.println("No ha creado la LSL");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuLSLC()
    {
        int datum;
        String resp;
        LSLC list = new LSLC();
        Node r;
        do {
            System.out.println("\n-------Menú LSLC------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Insertar (despues de referencia)");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nuevo dato: ");
                    datum = input.nextInt();
                    input.nextLine();
                    
                    list.createEndLSLC(datum);
                    System.out.println("Dato agregado en la LSLC");
                    break;
                // case "2":
                //     System.out.println("Tamaño lista: " + list.countNodesLSL() + " nodos");
                //     break;
                case "3":
                    list.showLSLC();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    public static void menuLDL()
    {
        int datum;
        String resp;
        LDL ldl = new LDL();
        NodeLDL dir;
        do {
            System.out.println("\n-------Menú LDL------");
            System.out.println("0. Regresar");
            System.out.println("1. Agregar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Buscar");
            System.out.println("5. Modificar");
            System.out.println("6. Eliminar");
            System.out.println("7. Insertar (antes de referencia)");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Nuevo dato: ");
                    datum = input.nextInt();
                    input.nextLine();
                    ldl.createBeginLDL(datum);
                    System.out.println("Dato agregado en la LDL");
                    break;
                case "2":
                    System.out.println("Tamaño lista: " + ldl.getN() + " nodos");
                    break;
                case "3":
                    ldl.showLDL();
                    break;
                case "4":
                    if (ldl.head != null) {
                        System.out.print("Dato a buscar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir == null) {
                            System.out.println(datum + " no se encuentra en la LDL");
                        } else {
                            System.out.println(datum + " encontrado en dirección " + dir);
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                case "5":
                    if (ldl.head != null) {
                        System.out.print("Dato a modificar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir != null) {
                            System.out.print("Nuevo dato: ");
                            datum = input.nextInt();
                            input.nextLine();
                            ldl.updateNodeLDL(dir, datum);
                            System.out.println("Dato actualizado correctamente");
                        } else {
                            System.out.println(datum + " no se encuentra en la LDL");
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                case "6":
                    if (ldl.head != null) {
                        System.out.print("Dato a eliminar: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir != null) {
                            ldl.deleteNodeLDL(dir);
                            System.out.println("Dato eliminado correctamente");
                        } else {
                            System.out.println(datum + " no se encuentra en la LDL");
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                case "7":
                    if (ldl.head != null) {
                        System.out.println("Dato referencia: ");
                        datum = input.nextInt();
                        input.nextLine();
                        dir = ldl.findLDL(datum);
                        if (dir != null) {
                            System.out.println("Dato a insertar: ");
                            datum = input.nextInt();
                            input.nextLine();
                            ldl.insertAfterLDL(dir, datum);
                            System.out.println("Dato insertado correctamente");
                        } else {
                            System.out.println("El dato de referencia " + datum + " no se encuentra en la LDL");
                        }
                    } else {
                        System.out.println("No ha creado la LDL");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }
    
    
    public static void menuPolynomial() {
    String resp;
    LSLPoly f = new LSLPoly();
    LSLPoly g = new LSLPoly();
 
    do {
        System.out.println("\n======= MENÚ POLINOMIOS =======");
        System.out.println("0. Regresar");
        System.out.println("1. Crear / agregar término a f(x)");
        System.out.println("2. Crear / agregar término a g(x)");
        System.out.println("3. Mostrar ambos polinomios");
        System.out.println("4. Ordenar polinomios (mayor a menor exponente)");
        System.out.println("5. Modificar término de un polinomio");
        System.out.println("6. Eliminar término de un polinomio");
        System.out.println("7. Agregar término conservando orden");
        System.out.println("8. Sumar f(x) + g(x)");
        System.out.println("9. Restar f(x) - g(x)");
        System.out.println("10. Evaluar f(a) y g(a)");
        System.out.print("Ingrese su opción: ");
        resp = input.nextLine();
 
        switch (resp) {
 
            case "0":
                break;
 
            // ── a. Agregar término a f(x) ──
            case "1": {
                System.out.print("Coeficiente: ");
                int coef = input.nextInt(); input.nextLine();
                System.out.print("Exponente: ");
                int exp = input.nextInt(); input.nextLine();
                if (f.ordenado) {
                    f.agregarOrdenado(coef, exp);
                } else {
                    f.agregarTermino(coef, exp);
                }
                System.out.println("Término agregado a f(x).");
                break;
            }
 
            // ── a. Agregar término a g(x) ──
            case "2": {
                System.out.print("Coeficiente: ");
                int coef = input.nextInt(); input.nextLine();
                System.out.print("Exponente: ");
                int exp = input.nextInt(); input.nextLine();
                if (g.ordenado) {
                    g.agregarOrdenado(coef, exp);
                } else {
                    g.agregarTermino(coef, exp);
                }
                System.out.println("Término agregado a g(x).");
                break;
            }
 
            // ── b. Mostrar ambos ──
            case "3":
                f.mostrarPolinomio("f");
                g.mostrarPolinomio("g");
                break;
 
            // ── c. Ordenar ──
            case "4":
                f.ordenarPolinomio();
                g.ordenarPolinomio();
                f.mostrarPolinomio("f");
                g.mostrarPolinomio("g");
                break;
 
            // ── d. Modificar ──
            case "5": {
                System.out.println("¿Cuál polinomio? (1 = f, 2 = g): ");
                String cual = input.nextLine();
                System.out.print("Exponente del término a modificar: ");
                int exp = input.nextInt(); input.nextLine();
                System.out.print("Nuevo coeficiente: ");
                int coef = input.nextInt(); input.nextLine();
                LSLPoly objetivo = cual.equals("1") ? f : g;
                String nombre = cual.equals("1") ? "f" : "g";
                if (objetivo.modificarTermino(exp, coef)) {
                    System.out.println("Término modificado en " + nombre + "(x).");
                } else {
                    System.out.println("No se encontró el exponente " + exp + " en " + nombre + "(x).");
                }
                break;
            }
 
            // ── e. Eliminar ──
            case "6": {
                System.out.println("¿Cuál polinomio? (1 = f, 2 = g): ");
                String cual = input.nextLine();
                System.out.print("Exponente del término a eliminar: ");
                int exp = input.nextInt(); input.nextLine();
                LSLPoly objetivo = cual.equals("1") ? f : g;
                String nombre = cual.equals("1") ? "f" : "g";
                if (objetivo.eliminarTermino(exp)) {
                    System.out.println("Término con exponente " + exp + " eliminado de " + nombre + "(x).");
                } else {
                    System.out.println("No se encontró el exponente " + exp + " en " + nombre + "(x).");
                }
                break;
            }
 
            // ── f. Agregar conservando orden ──
            case "7": {
                System.out.println("¿Cuál polinomio? (1 = f, 2 = g): ");
                String cual = input.nextLine();
                System.out.print("Coeficiente: ");
                int coef = input.nextInt(); input.nextLine();
                System.out.print("Exponente: ");
                int exp = input.nextInt(); input.nextLine();
                LSLPoly objetivo = cual.equals("1") ? f : g;
                String nombre = cual.equals("1") ? "f" : "g";
                objetivo.agregarOrdenado(coef, exp);
                System.out.println("Término agregado a " + nombre + "(x) conservando orden.");
                break;
            }
 
            // ── g. Suma ──
            case "8": {
                LSLPoly suma = f.sumar(g);
                System.out.print("f(x) + g(x) = ");
                suma.mostrarPolinomio("h");
                break;
            }
 
            // ── h. Resta ──
            case "9": {
                LSLPoly resta = f.restar(g);
                System.out.print("f(x) - g(x) = ");
                resta.mostrarPolinomio("h");
                break;
            }
 
            // ── i. Evaluar ──
            case "10": {
                System.out.print("Ingrese el valor de a: ");
                double a = input.nextDouble(); input.nextLine();
                System.out.println("f(" + a + ") = " + f.evaluar(a));
                System.out.println("g(" + a + ") = " + g.evaluar(a));
                break;
            }
 
            default:
                System.out.println("Opción no válida");
                break;
        }
 
    } while (!resp.equals("0"));
}

        public static void menuGames() {
        JuegoTriqui juego = new JuegoTriqui();
        juego.menu();
}
    

public static void menuStack()
    {
        int datum;
        String resp;
        Stack objStack = new Stack();
        do {
            System.out.println("\n-------Menú Pilas------");
            System.out.println("0. Regresar");
            System.out.println("1. Apilar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Desapilar dato");
            System.out.println("Ingrese su opción: ");

            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Dato a apilar: ");
                    datum = input.nextInt();
                    input.nextLine();
                    objStack.stacking(datum);
                    System.out.println("Dato apilado en la pila");
                    break;
                case "2":
                    System.out.println("Tamaño pila: " + objStack.getTop() + " elementos");
                    break;
                case "3":
                if (objStack.getTop() > 0) {
                        objStack.showStack();
                    } else {
                        System.out.println("La pila está vacía");
                    }
                    break;
                case "4":
                    if (objStack.getTop() > 0) {
                        System.out.println("Dato desapilado de la pila: " + objStack.unstacking());
                    } else {
                        System.out.println("La pila está vacía");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    }

    public static void menuQueue()
    {
        int datum;
        String resp;
        Queue objQueue = new Queue();
        do {
            System.out.println("\n-------Menú Colas------");
            System.out.println("0. Regresar");
            System.out.println("1. Encolar dato");
            System.out.println("2. Tamaño");
            System.out.println("3. Mostrar");
            System.out.println("4. Desencolar dato");
            System.out.println("Ingrese su opción: ");

            resp = input.nextLine();
            
            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Dato a encolar: ");
                    datum = input.nextInt();
                    input.nextLine();
                    objQueue.addQueue(datum);
                    System.out.println("Dato encolado en la cola");
                    break;
                case "2":
                    System.out.println("Tamaño cola: " + objQueue.getEnd() + " elementos");
                    break;
                case "3":
                    if (objQueue.getEnd() > 0) {
                        objQueue.displayQueue();
                    } else {
                        System.out.println("La cola está vacía");
                    }
                    break;
                case "4":
                    if (objQueue.getEnd() > 0) {
                        System.out.println("Dato desencolado de la cola: " + objQueue.popQueue());
                    } else {
                        System.out.println("La cola está vacía");
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!resp.equals("0"));
    
}


    public static void menuRecursion() {
        int datum; 
        String resp;
        Recursion rec = new Recursion();
        
        do {
            System.out.println("\n-------Menú Recursividad------");
            System.out.println("0. Regresar");  
            System.out.println("1. Factorial");
            System.out.println("2. Imprimir primeros números naturales");
            System.out.println("3. Fibonacci");
            System.out.println("4. Capital");
            System.out.println("5. Mostrar vector ");
            System.out.println("6. Mostrar LSL");
            System.out.print("Ingrese su opción: ");
            resp = input.nextLine();

            switch (resp) {
                case "0":
                    break;
                case "1":
                    System.out.print("Ingrese un número para calcular su factorial: ");
                    int n = input.nextInt();
                    input.nextLine();
                    if (n >= 0) {
                        System.out.println(n + "! = " + rec.factorial(n));
                    } else {
                        System.out.println("El número debe ser no negativo");
                    }
                    break;
                case "2":
                    System.out.print("Ingrese el número de elementos a imprimir: ");
                    int count = input.nextInt();
                    input.nextLine();
                    if (count > 0) {
                        System.out.print("Primeros " + count + " números naturales: ");
                        rec.printNaturalNumbers(count);
                    } else {
                        System.out.println("El número debe ser positivo");
                    }
                    break;
                case "3":
                    System.out.print("Ingrese el número de elementos de Fibonacci a imprimir: ");
                    int fibCount = input.nextInt();
                    input.nextLine();
                    if (fibCount > 0) {
                        System.out.print("Serie de Fibonacci: ");
                        rec.printFibonacci(fibCount);
                    } else {
                        System.out.println("El número debe ser positivo");
                    }
                    break;
                case "4":
                    break;
                case "5":
                    System.out.print("Ingrese el tamaño del vector: ");
                    int size = input.nextInt();
                    input.nextLine();
                    if (size > 0) {
                        // Aquí deberías llamar a un método que muestre el vector, por ejemplo:
                        // rec.showVector(size);
                    } else {
                        System.out.println("El tamaño del vector debe ser positivo");
                    }
                    break;
                case "6":
                    System.out.println("Mostrando LSL:");
                    // Aquí deberías llamar a un método que muestre la LSL, por ejemplo:
                    // rec.showLSL();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
                }
            } while (!resp.equals("0"));
}
}
