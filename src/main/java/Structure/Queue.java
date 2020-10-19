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
public interface Queue<T> {

    boolean isEmpty();

    T getFrontElement();

    T getRearElement();

    void push(T theObject);

    T remove();
}
