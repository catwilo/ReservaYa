/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

/**
 *
 * @author W1
 * @param <T>
 */
public class BTree<T extends Comparable> {

    private TrieNode root;

    public BTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public TrieNode insert(T data) {
        //devuelve el nodo donde inserto el valor data
        return insert(data, root);
    }

    public TrieNode findMin(TrieNode temp) {
        if (temp == null) {
            return null;
        }
        if (temp.getLeft() == null) {
            return temp;
        }

        return findMin(temp.getLeft());
    }

    public TrieNode remove(T data) {
        return remove(data, root);
    }

    public int height() {
        return height(this.root);
    }

    public TrieNode contains(T data) {
        return contains(data, this.root);
    }

    private int height(TrieNode temp) {
        if (temp == null) {
            return -1;
        } else {
            return 1 + Math.max(height(temp.getLeft()), height(temp.getRight()));
        }
    }

    private TrieNode insert(T data, TrieNode temp) {
        if (temp == null) {
            temp = new TrieNode(data);
            return temp;
        }
        if (data.compareTo(temp.getData()) > 0) {
            temp.setRight(insert(data, temp.getRight()));
        } else if (data.compareTo(temp.getData()) < 0) {
            temp.setLeft(insert(data, temp.getLeft()));
        }
        /*else { // para valores duplicados
            
        }*/
        return temp;
    }

    private TrieNode remove(T data, TrieNode temp) {
        if (temp == null) {
            return temp;
        }
        int comparacion = data.compareTo(temp.getData());
        if (comparacion < 0) {
            temp.setLeft(remove(data, temp.getLeft()));
        } else if (comparacion > 0) {
            temp.setRight(remove(data, temp.getRight()));
        } else if (temp.getLeft() != null && temp.getRight() != null) {
            //cuanto compare es 0 entra a este condicional 
            //pues temp tiene el dato a borrar
            //le doy el valor de su sucesor a temp para borrar el valor data
            temp.setData(findMin(temp.getRight()).getData());
            //y elimino la copia del sucesor que pertenecia al valor borrado
            temp.setRight(remove((T) temp.getData(), temp.getRight()));
        } else {
            temp = (temp.getLeft() != null) ? temp.getLeft() : temp.getRight();
        }
        return temp;
    }

    private TrieNode contains(T data, TrieNode temp) {
        //devuelve el nodo con el dato o el nodo que seria el padre
        if (temp == null) {
            return temp;
        }
        int comparacion = data.compareTo(temp.getData());
        if (comparacion > 0) {
            return contains(data, temp.getRight());
        }
        if (comparacion < 0) {
            return contains(data, temp.getLeft());

        }
        /*else { // para valores duplicados
            
        }*/

        return null;
    }

}
