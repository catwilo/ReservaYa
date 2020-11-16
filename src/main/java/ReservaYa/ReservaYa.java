/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservaYa;

import Structure.*;
import java.io.*;

/**
 *
 * @author W1
 */
public class ReservaYa {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*// TODO code application logic here
        //CARGAR LISTAS DE USUARIOS Y RESTAURANTES
        LinkedList R = new LinkedList();
        loadRest(R);
        //LinkedList U = loadUsers();

        //BUSCAR UN RESTAURANTE POR EL NOMBRE
        String name = "Ultimo dato";
        Restaurant w = findNameRest(name, R);
        System.out.println(w.getName() + " igual a: " + name);
        /*
        //ACTUALIZAR Nombre DE RESTAURANTE
        String NuevoName = "newName";
        UpdateRest(name, NuevoName, R);
         */
        
        AVL arbol = new AVL();
        /*
        arbol.insert("j");
        arbol.insert("e");
        arbol.insert("t");
        arbol.insert("d");
        arbol.insert("ee");
        arbol.insert("ec");
        arbol.insert("eb");
         */
        arbol = loadRest(arbol);
        
        arbol.preOrder();

    }

    static private void UpdateRest(String namebefore, String nameafter, LinkedList A) {
        Nodo R = findRest(namebefore, A);
        ((Restaurant) R.getData()).setName(nameafter);
    }

    static private Nodo findRest(String name, LinkedList A) {
        Restaurant R = new Restaurant(name);
        Nodo T = A.getHead();
        long inicio = System.nanoTime();
        while (T != null) {
            if (R.compareTo((Restaurant) T.getData()) == 0) {
                long fin = System.nanoTime();
                System.out.println("Tiempo findNameRest(): " + (fin - inicio) * 1.0e-9);
                return T;
            }
            T = T.getNext();
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo findNameRest(): " + (fin - inicio) * 1.0e-9);
        return null;
    }

    static private Restaurant findNameRest(String name, LinkedList A) {
        Restaurant R = new Restaurant(name);
        Nodo T = A.getHead();
        long inicio = System.nanoTime();
        while (T != null) {
            if (R.compareTo((Restaurant) T.getData()) == 0) {
                long fin = System.nanoTime();
                System.out.println("Tiempo findNameRest(): " + (fin - inicio) * 1.0e-9);
                return (Restaurant) T.getData();
            }
            T = T.getNext();
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo findNameRest(): " + (fin - inicio) * 1.0e-9);
        return null;
    }

    static private LinkedList loadRest(LinkedList R) throws IOException {
        FileReader F = null;
        try {
            F = new FileReader("Restauran3.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
        BufferedReader br = new BufferedReader(F);
        R = new LinkedList<Restaurant>();
        String[] atributosPorRestaurante = br.readLine().split(";");
        long inicio = System.nanoTime();
        while (atributosPorRestaurante[0] != null) {
            R.pushBack(new Restaurant(atributosPorRestaurante[0], Integer.parseInt(atributosPorRestaurante[1])));
            try {
                atributosPorRestaurante = br.readLine().split(";");
            } catch (IOException r) {
                atributosPorRestaurante[0] = null;
            }
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo loadRest(): " + (fin - inicio) * 1.0e-9);
        return R;
    }

    static private LinkedList loadUsers() throws IOException {
        FileReader F = null;
        try {
            F = new FileReader("User1.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
        BufferedReader br = new BufferedReader(F);
        var lisU = new LinkedList();

        String[] U = br.readLine().split(";");
        long inicio = System.nanoTime();
        while (U[0] != null) {
            lisU.pushBack(new User(Integer.parseInt(U[0]), Integer.parseInt(U[1]), U[2]));
            try {
                U = br.readLine().split(";");
            } catch (IOException r) {
                U[0] = null;
            }
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo loadUsers(): " + (fin - inicio) * 1.0e-9);
        return lisU;
    }

    static private AVL loadRest(AVL R) throws IOException {
        FileReader F = null;
        try {
            F = new FileReader("Restaurant.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
        BufferedReader br = new BufferedReader(F);
        R = new AVL<Restaurant>();
        String[] atributosPorRestaurante = br.readLine().split(";");
        long inicio = System.nanoTime();
        while (atributosPorRestaurante[0] != null) {
            R.insert(new Restaurant(atributosPorRestaurante[0], Integer.parseInt(atributosPorRestaurante[1])));
            try {
                atributosPorRestaurante = br.readLine().split(";");
            } catch (Exception r) {
                atributosPorRestaurante[0] = null;
            }
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo loadRest(): " + (fin - inicio) * 1.0e-9);
        return R;
    }
}
