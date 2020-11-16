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

        //declaracion de arboles
        AVL arbolRestaurants = null, arbolUsers = null;

        //carga de arboles ordenando datos por su nombre
        arbolRestaurants = loadRest(arbolRestaurants);
        //arbolUsers = loadUsers(arbolUsers);

        /*
        //prueba update
        Restaurant encontrado = findNameRest("t", arbolRestaurants);
        System.out.println("la busqueda de t encontro' " + encontrado.getName() + " y " + encontrado.getNtables() + " numero de mesas");
        //updateRest("t", "cambiado", arbolRestaurants);

        encontrado = findNameRest("t", arbolRestaurants);
        if (null != encontrado) {
            System.out.println("la busqueda de t encontro' " + encontrado.getName() + " y " + encontrado.getNtables() + " numero de mesas");
        }

        encontrado = findNameRest("cambiado", arbolRestaurants);
        if (null != encontrado) {
            System.out.println("la busqueda de cambiado encontro' " + encontrado.getName() + " y " + encontrado.getNtables() + " numero de mesas");
        }

        /*
        //Output de datos en arboles
        arbolRestaurants.postOrder();
        arbolRestaurants.inOrder();
         */
        arbolRestaurants.preOrder();
        /*
        arbolUsers.postOrder();
        arbolUsers.inOrder();
        arbolUsers.preOrder();
         */
    }

    static private void updateRest(String namebefore, String nameafter, AVL A) {
        AVLNode R = findRest(namebefore, A);
        ((Restaurant) R.getData()).setName(nameafter);

    }

    static private AVLNode findRest(String name, AVL arbolRestaurants) {
        long inicio = System.nanoTime();

        Restaurant R = new Restaurant(name);
        AVLNode aux = arbolRestaurants.search(R);//retorna nodo buscado
        long fin = System.nanoTime();
        System.out.println("Tiempo findNameRest(): " + (fin - inicio) * 1.0e-9);
        return aux;

    }

    static private Restaurant findNameRest(String name, AVL arbolRestaurants) {
        long inicio = System.nanoTime();
        AVLNode restauranteEncontrado = findRest(name, arbolRestaurants);
        if (restauranteEncontrado != null) {
            return (Restaurant) restauranteEncontrado.getData();
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
