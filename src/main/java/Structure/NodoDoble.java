
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
public class NodoDoble <T> {

    T key;
    NodoDoble next;
    NodoDoble prev;

    public NodoDoble() {
    }

    ;
    public NodoDoble(T key, NodoDoble next, NodoDoble prev) {
        this.key = key;
        this.next = next;
        this.prev = prev;
    }
   
}
