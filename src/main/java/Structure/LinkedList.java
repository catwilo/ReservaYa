/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

/**
 *
 * @author causugamo
 */
public class LinkedList<T extends Comparable> {

    private Nodo head;
    private Nodo tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void pushFront(T key) {
        Nodo node = new Nodo(key, this.head);
        this.head = node;
        if (this.tail == null) {
            this.tail = this.head;
        }

    }

    public void popFront() {
        if (this.head == null) {
            System.out.println("ERROR: empty list");
        }
        this.head = head.getNext();
        if (this.head == null) {
            this.tail = null;
        }
    }

    public Nodo getHead() {
        return this.head;
    }

    public void pushBack(T key) {
        Nodo node = new Nodo(key, null);
        if (this.head == null) {
            this.tail = node;
            this.head = this.tail;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public void popBack() {
        if (this.head == null) {
            System.out.println("ERROR: Empty list");
        }
        if (this.head == tail) {
            this.tail = null;
            this.head = tail;
        } else {
            Nodo p = this.head;
            while (p.getNext().getNext() != null) {
                p = p.getNext();
            }
            p.setNext(null);
            this.tail = p;
        }
    }

    public void addAfter(Nodo node, T key) {
        Nodo nod = new Nodo(key, node.getNext());
        node.setNext(nod);
        if (this.tail == node) {
            this.tail = nod;
        }
    }

    public void printL() {
        Nodo R = this.head;
        if (R==null){
            System.out.println("Lista vacía");
            return;
        }
        while (R!=null) {
            System.out.println(R.getData());
            R=R.getNext();

        }
    }
}
