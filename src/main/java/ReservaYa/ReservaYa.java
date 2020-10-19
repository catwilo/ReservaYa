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
        // TODO code application logic here
        //CARGAR LISTAS DE USUARIOS Y RESTAURANTES
        LinkedList R = loadRest();
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

    static private LinkedList loadRest() throws IOException {
        FileReader F = null;
        try {
            F = new FileReader("Restauran3.csv");
        } catch (Exception e) {
            System.out.println("No existe el archivo");
        }
        BufferedReader br = new BufferedReader(F);
        var lisR = new LinkedList<Restaurant>();
        String[] R = br.readLine().split(";");
        long inicio = System.nanoTime();
        while (R[0] != null) {
            lisR.pushBack(new Restaurant(R[0], Integer.parseInt(R[1])));
            try {
                R = br.readLine().split(";");
            } catch (Exception r) {
                R[0] = null;
            }
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo loadRest(): " + (fin - inicio) * 1.0e-9);
        return lisR;
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
            } catch (Exception r) {
                U[0] = null;
            }
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo loadUsers(): " + (fin - inicio) * 1.0e-9);
        return lisU;
    }
}
