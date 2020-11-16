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
        /*//BUSCAR UN RESTAURANTE POR EL NOMBRE
        String name = "Ultimo dato";
        Restaurant w = findNameRest(name, R);
        System.out.println(w.getName() + " igual a: " + name);
        /*
        //ACTUALIZAR Nombre DE RESTAURANTE
        String NuevoName = "newName";
        UpdateRest(name, NuevoName, R);
         */
        
        AVL arbolRestaurants = null, arbolUsers = null;
        arbolRestaurants = loadRest(arbolRestaurants);
        arbolRestaurants.preOrder();
        arbolUsers = loadUsers(arbolUsers);
        arbolUsers.preOrder();
        

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

    static private AVL loadUsers(AVL arbol) throws IOException {
        FileReader F = null;
        try {
            F = new FileReader("User.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
        BufferedReader br = new BufferedReader(F);
        arbol = new AVL();

        String[] U = br.readLine().split(";");
        long inicio = System.nanoTime();
        while (U[0] != null) {
            arbol.insert(new User(Integer.parseInt(U[0]), Integer.parseInt(U[1]), U[2]));
            try {
                U = br.readLine().split(";");
            } catch (Exception r) {
                U[0] = null;
            }
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo loadUsers(): " + (fin - inicio) * 1.0e-9);
        return arbol;
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
