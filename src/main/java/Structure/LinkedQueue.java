/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

import java.util.*;

/**
 *
 * @author causugamo
 */
public class LinkedQueue<T extends Comparable<T>> implements Queue<T> {

    protected Nodo<T> front;
    protected Nodo<T> tail;

    public LinkedQueue() {
        front = tail = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public T getFrontElement() {
        return isEmpty() ? null : front.getData();
    }

    @Override
    public T getRearElement() {
        return isEmpty() ? null : tail.getData();
    }

    @Override
    public void push(T theElement) {
        Nodo<T> p = new Nodo<>(theElement, null);
        if (front == null) {
            front = p;
        } else {
            tail.setNext(p);
        }
        tail = p;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T frontElement = front.getData();
        front = front.getNext();
        if (isEmpty()) {
            tail = null;
        }
        return frontElement;
    }

}
