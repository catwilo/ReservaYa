/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Structure;
import ReservaYa.Restaurant;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; 
/**
 *
 * @author Juan Ortega
 */

class HashNode<K, V> 
{ 
	K key; 
	V value; 

	
	HashNode<K, V> next; 

	// Constructor 
	public HashNode(K key, V value) 
	{ 
		this.key = key; 
		this.value = value; 
	} 
} 


public class Hash<K, V> 
{ 
	
	private ArrayList<HashNode<K, V>> bucketArray; 

	
	private int numBuckets; 

	
	private int size; 

	
	public Hash() 
	{ 
		bucketArray = new ArrayList<>(); 
		numBuckets = 20; 
		size = 0; 

		
		for (int i = 0; i < numBuckets; i++) 
			bucketArray.add(null); 
	} 

	public int size() { return size; } 
	public boolean isEmpty() { return size() == 0; } 

	 
	private int getBucketIndex(K key) 
	{ 
		int hashCode = key.hashCode();
                System.out.println(hashCode);
		int index = hashCode % numBuckets; 
                System.out.println(index);
		return index; 
	} 

	
	public V remove(K key) 
	{ 
		
		int bucketIndex = getBucketIndex(key); 

		
		HashNode<K, V> head = bucketArray.get(bucketIndex); 

		
		HashNode<K, V> prev = null; 
		while (head != null) 
		{ 
			
			if (head.key.equals(key)) 
				break; 

			
			prev = head; 
			head = head.next; 
		} 

		
		if (head == null) 
			return null; 

		
		size--; 

		
		if (prev != null) 
			prev.next = head.next; 
		else
			bucketArray.set(bucketIndex, head.next); 

		return head.value; 
	} 

	
	public V get(K key) 
	{ 
		 
		int bucketIndex = getBucketIndex(key); 
		HashNode<K, V> head = bucketArray.get(bucketIndex); 

		
		while (head != null) 
		{ 
			if (head.key.equals(key)) 
				return head.value; 
			head = head.next; 
		} 

		
		return null; 
	} 

	
	public void add(K key, V value) 
	{ 
		
		int bucketIndex = getBucketIndex(key); 
		HashNode<K, V> head = bucketArray.get(bucketIndex); 

		
		while (head != null) 
		{ 
			if (head.key.equals(key)) 
			{ 
				head.value = value; 
				return; 
			} 
			head = head.next; 
		} 

		
		size++; 
		head = bucketArray.get(bucketIndex); 
		HashNode<K, V> newNode = new HashNode<K, V>(key, value); 
		newNode.next = head; 
		bucketArray.set(bucketIndex, newNode); 

		
		if ((1.0*size)/numBuckets >= 0.7) 
		{ 
			ArrayList<HashNode<K, V>> temp = bucketArray; 
			bucketArray = new ArrayList<>(); 
			numBuckets = 2 * numBuckets; 
			size = 0; 
			for (int i = 0; i < numBuckets; i++) 
				bucketArray.add(null); 

			for (HashNode<K, V> headNode : temp) 
			{ 
				while (headNode != null) 
				{ 
					add(headNode.key, headNode.value); 
					headNode = headNode.next; 
				} 
			} 
		} 
	} // Driver method to test Map class 
	/*public static void main(String[] args) throws IOException 
	{ 
		Hash map = new Hash <String, Integer>(); 
		map.add("this",1 ); 
		map.add("coder",2 ); 
		map.add("this",4 ); 
		map.add("hi",5 ); 
		System.out.println(map.size()); 
		System.out.println(map.remove("this")); 
		System.out.println(map.remove("this")); 
		System.out.println(map.size());
                System.out.println(map.get("coder"));
		System.out.println(map.isEmpty()); 
                FileReader F = null;
        try {
            F = new FileReader("restaurant3.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
        BufferedReader br = new BufferedReader(F);
        Hash R = new Hash<String, Integer>(); 
       
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
        
        
         //System.out.println(R.get(""));
        
               
        
                
	} */
        
           /* static private void loadRest(Map R) throws IOException {
        FileReader F = null;
        try {
            F = new FileReader("Restauran1.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo");
        }
        BufferedReader br = new BufferedReader(F);
        R = new Map<String, Integer>(); 
        //R = new AVL<Restaurant>();
        String[] atributosPorRestaurante = br.readLine().split(";");
        long inicio = System.nanoTime();       
       
        while (atributosPorRestaurante[0] != null) {
            
            R.add(atributosPorRestaurante[0], Integer.parseInt(atributosPorRestaurante[1]));
            try {
                atributosPorRestaurante = br.readLine().split(";");
            } catch (Exception r) {
                atributosPorRestaurante[0] = null;
            }
        }
        long fin = System.nanoTime();
        System.out.println("Tiempo loadRest(): " + (fin - inicio) * 1.0e-9);
        //return R;
    }*/
}
