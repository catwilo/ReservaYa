/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

public class Nodo<T extends Comparable>{

    private T data;
    private Nodo<T> next;

    public Nodo(T data) {
        this.data = data;
        next = null;
    }

    public Nodo(T data, Nodo<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }
}
