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
public class AVL<T extends Comparable> {

    AVLNode root;

    public AVL() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private int height(AVLNode temp) {
        return (temp == null) ? -1 : temp.getHeight();
    }

    private AVLNode rotarLeft(AVLNode nodoDesbalanced) {
        AVLNode nodoASubir = nodoDesbalanced.getRight();
        nodoDesbalanced.setRight(nodoASubir.getLeft());
        nodoASubir.setLeft(nodoDesbalanced);
        nodoDesbalanced.reHeight();//re calculo sus alturas
        nodoASubir.reHeight();
        return nodoASubir;
    }

    private AVLNode rotarRight(AVLNode nodoDesbalanced) {
        AVLNode nodoASubir = nodoDesbalanced.getLeft();
        nodoDesbalanced.setLeft(nodoASubir.getRight());
        nodoASubir.setRight(nodoDesbalanced);
        nodoDesbalanced.reHeight();//re calculo sus alturas
        nodoASubir.reHeight();
        return nodoASubir;
    }

    private AVLNode leftLeftCase(AVLNode node) {
        return rotarRight(node);
    }

    private AVLNode leftRightCase(AVLNode nodoDesbalanced) {
        nodoDesbalanced.setLeft(rotarLeft(nodoDesbalanced.getLeft()));
        return leftLeftCase(nodoDesbalanced);
    }

    private AVLNode rightRightCase(AVLNode node) {
        return rotarLeft(node);
    }

    private AVLNode rightLeftCase(AVLNode nodoDesbalanced) {
        nodoDesbalanced.setRight(rotarRight(nodoDesbalanced.getRight()));
        return rightRightCase(nodoDesbalanced);
    }

    public AVLNode insert(T data) {
        //devuelve el nodo donde inserto el valor data
        AVLNode aux = insert(data, this.root);
        return aux;
    }

    private AVLNode insert(T data, AVLNode temp) {
        if (temp == null) {
            temp = new AVLNode(data);
        } else if (data.compareTo(temp.getData()) > 0) {
            temp.setRight(insert(data, temp.getRight()));
            if (height(temp.getRight()) - height(temp.getLeft()) == 2) {
                if (data.compareTo(temp.getRight().getData()) > 0) {
                    temp = rightRightCase(temp);
                } else {
                    temp = rightLeftCase(temp);
                }
            }
        } else if (data.compareTo(temp.getData()) < 0) {
            temp.setLeft(insert(data, temp.getLeft()));
            if (height(temp.getLeft()) - height(temp.getRight()) == 2) {
                if (data.compareTo(temp.getLeft().getData()) < 0) {
                    temp = leftLeftCase(temp);
                } else {
                    temp = leftRightCase(temp);
                }
            }
        }
        /*else { // para valores duplicados
            
        }*/
        return temp;
    }

    public int countNodes() {
        return countNodes(this.root);
    }

    private int countNodes(AVLNode pater) {
        if (pater == null) {
            return 0;
        } else {
            int contador = 1;
            contador += countNodes(pater.getLeft());
            contador += countNodes(pater.getRight());
            return contador;
        }
    }

    public AVLNode findMin(AVLNode temp) {
        if (temp == null) {
            return null;
        }
        if (temp.getLeft() == null) {
            return temp;
        }

        return findMin(temp.getLeft());
    }

    public AVLNode remove(T data) {
        return remove(data, root);
    }

    public AVLNode contains(T data) {
        return contains(data, this.root);
    }

    private AVLNode remove(T data, AVLNode temp) {
        if (temp == null) {
            return temp;
        }
        int comparacion = data.compareTo(temp.getData());
        if (comparacion < 0) {
            temp.setLeft(remove(data, temp.getLeft()));
        } else if (comparacion > 0) {
            temp.setRight(remove(data, temp.getRight()));
        } else if (temp.getLeft() != null && temp.getRight() != null) {
            //cuanto compare es 0 entra a este condicional 
            //pues temp tiene el dato a borrar
            //le doy el valor de su sucesor a temp para borrar el valor data
            temp.setData(findMin(temp.getRight()).getData());
            //y elimino la copia del sucesor que pertenecia al valor borrado
            temp.setRight(remove((T) temp.getData(), temp.getRight()));
        } else {
            temp = (temp.getLeft() != null) ? temp.getLeft() : temp.getRight();
        }
        return temp;
    }

    private AVLNode contains(T data, AVLNode temp) {
        //devuelve el nodo con el dato o el nodo que seria el padre
        if (temp == null) {
            return temp;
        }
        int comparacion = data.compareTo(temp.getData());
        if (comparacion > 0) {
            return contains(data, temp.getRight());
        }
        if (comparacion < 0) {
            return contains(data, temp.getLeft());

        }
        /*else { // para valores duplicados
            
        }*/

        return null;
    }
}
