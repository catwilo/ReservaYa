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

    public TrieNode insert(T data, TrieNode temp) {
        if (temp == null) {
            return new TrieNode (data);
        }
        if (data.compareTo(temp.getData()) > 0) {
            temp.setRight(insert(data, temp.getRight()));
        } else if (data.compareTo(temp.getData()) < 0) {
            temp.setLeft(insert (data, temp.getLeft()));
        } /*else { // para valores duplicados
            
        }*/
        return temp;
    }
}
