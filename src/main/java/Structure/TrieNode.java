/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

/**
 *
 * @author W1
 */
class TrieNode<T extends Comparable<? super T>> {

    T data;
    TrieNode right;
    TrieNode left;

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
