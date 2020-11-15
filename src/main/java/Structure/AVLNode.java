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
public class AVLNode <T extends Comparable> extends TrieNode {
    int height;
    
    public AVLNode (T data){
        super(data);
    }
}
