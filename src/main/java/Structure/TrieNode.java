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
public class TrieNode<T extends Comparable> {

    private T data;
    private TrieNode right;
    private TrieNode left;

    public TrieNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TrieNode getRight() {
        return right;
    }

    public void setRight(TrieNode right) {
        this.right = right;
    }

    public TrieNode getLeft() {
        return left;
    }

    public void setLeft(TrieNode left) {
        this.left = left;
    }

}
