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
public class AVLNode<T extends Comparable> {

    private int height;
    T data;
    private AVLNode right;
    private AVLNode left;

    public AVLNode() {
        this.data = null;
        this.height = 0;
        this.right = null;
        this.left = null;

    }

    public AVLNode(T data) {
        this.data = data;
        this.height = 0;
        this.right = null;
        this.left = null;

    }

    public void reHeight() {
        this.height = 1 + Math.max(this.right.getHeight(), this.left.getHeight());
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
