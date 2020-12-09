/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservaYa;

import Structure.*;
import java.io.*;
import java.util.ArrayList;

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
        //declaracion de arboles
        AVL arbolRestaurants = null, arbolUsers = null;

        //carga de arboles ordenando datos por su nombre
        //arbolRestaurants = loadRest(arbolRestaurants);
        arbolUsers = loadUsers(arbolUsers);
         
        Hash R = new Hash();
        loadRestHash(R);
        System.out.println(R.get("burger "));
       
        
        
        
        
        
        /*//BUSCAR UN RESTAURANTE POR EL NOMBRE/**/
        String name = "Amet Inc.";        
        //Restaurant restauranteEncontrado = (Restaurant) (findRest(name, arbolRestaurants)).getData();
        //System.out.println(restauranteEncontrado.getName() + " igual a: " + name);
        
        /*//BUSCAR UN USUARIO POR EL NOMBRE/**/
        
        String usuario = "Xyla Burgess";        
        User usuarioEncontrado = (User) (findUser(usuario, arbolUsers)).getData();
        System.out.println(usuarioEncontrado.getName() + " igual a: " + usuario);
        
        /*Actualizar un restaurante/**/
        String newRestaurant = "BK";
        //updateRest(name,newRestaurant, arbolRestaurants);
        /**/
        
        
        /*Eliminar un restaurante/**/
        //arbolRestaurants.remove(restauranteEncontrado);
        /**/
        
        


 /**/
        //ACTUALIZAR Nombre DE RESTAURANTE
        //String NuevoName = "nuevoNombre";
        //updateRest(name, NuevoName, arbolRestaurants);
        /**/
        
        /*
        //Output de datos en arboles
        arbolRestaurants.postOrder();
        arbolRestaurants.inOrder();
         
        arbolRestaurants.preOrder();
        /*
        arbolUsers.postOrder();
        arbolUsers.inOrder();
        arbolUsers.preOrder();
         */
    }
    
    //static private Hash loadRest(){
        
    //}
    
    static private void loadRestHash(Hash R){
                FileReader F = null;
        try {
            F = new FileReader("Restaurant.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
        BufferedReader br = new BufferedReader(F);
        R = new Hash<String, Integer>(); 
       
        System.out.println(R.size());
        
        
        long inicio = System.nanoTime();   
       
        String linea;
        try{
           while((linea = br.readLine())!= null){
            String[] atributosPorRestaurante = linea.split(";");
            ArrayList<String> atributosTemporal = new ArrayList<String>();
            for(String atributo:atributosPorRestaurante){
                atributosTemporal.add(atributo);
            }
            
            R.add(atributosTemporal.get(0), Integer.parseInt(atributosTemporal.get(1)));
            System.out.println(linea);
            //R.add(atributosPorRestaurante[0], Integer.parseInt(atributosPorRestaurante[1]));
        } 
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    static private void updateRest(String namebefore, String nameafter, AVL arbolRestaurants) {
        long inicio = System.nanoTime();
        AVLNode encontrado = findRest(namebefore, arbolRestaurants);
        Restaurant r = (Restaurant) encontrado.getData();
        arbolRestaurants.remove(r);
        r.setName(nameafter);
        arbolRestaurants.insert(r);
        long fin = System.nanoTime();
        System.out.println("Tiempo updateRest: " + (fin - inicio) * 1.0e-9);
        System.out.println("Nombre del Restaurante " + namebefore + " cambiado a: " + r.getName());
    }

    static private AVLNode findUser(String name, AVL arbolUsers) {        
        User U = new User(name);
        long inicio = System.nanoTime();
        AVLNode usuarioEncontrado = arbolUsers.search(U);//retorna nodo buscado
        long fin = System.nanoTime();
        System.out.println("Tiempo en encontrar un USER: " + (fin - inicio) * 1.0e-9);
        return usuarioEncontrado;

    }

    static private AVLNode findRest(String name, AVL arbolRestaurants) {      
        Restaurant R = new Restaurant(name);
        long inicio = System.nanoTime();
        AVLNode restauranteEncontrado = arbolRestaurants.search(R);//retorna nodo buscado
        long fin = System.nanoTime();
        System.out.println("Tiempo en encontrar un RESTAURANT: " + (fin - inicio) * 1.0e-9);
        return restauranteEncontrado;
    }

    static private AVL loadUsers(AVL arbol) throws IOException {
        FileReader F = null;
        try {
            F = new FileReader("User4.csv");
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
    }/*
        static private HashTable loadUsers(HashTable hash) throws IOException {
        FileReader F = null;
        try {
            F = new FileReader("User4.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
        BufferedReader br = new BufferedReader(F);
        hash = new HashTable();

        String[] U = br.readLine().split(";");
        long inicio = System.nanoTime();
        while (U[0] != null) {
            hash.insert(new User(Integer.parseInt(U[0]), Integer.parseInt(U[1]), U[2]));
            try {
                U = br.readLine().split(";");
            } catch (Exception r) {
                U[0] = null;
            }
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo loadUsers(): " + (fin - inicio) * 1.0e-9);
        return hash;
    }*/
/*
    static private AVL loadRest(AVL R) throws IOException {
        FileReader F = null;
        try {
            F = new FileReader("Restauran4.csv");
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
    }*/
    
}
