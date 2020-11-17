/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structure;

import ReservaYa.Restaurant;
import ReservaYa.User;

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

    private int height(AVLNode temp) {
        return (temp != null) ? temp.getHeight() : 0;
    }

    private AVLNode rotarLeft(AVLNode nodoDesbalanced) {
        AVLNode nodoASubir = nodoDesbalanced.getRight();
        nodoDesbalanced.setRight(nodoASubir.getLeft());
        nodoASubir.setLeft(nodoDesbalanced);
        reHeight(nodoDesbalanced);//re calculo sus alturas
        reHeight(nodoASubir);
        return nodoASubir;
    }

    private AVLNode rotarRight(AVLNode nodoDesbalanced) {
        AVLNode nodoASubir = nodoDesbalanced.getLeft();
        nodoDesbalanced.setLeft(nodoASubir.getRight());
        nodoASubir.setRight(nodoDesbalanced);
        reHeight(nodoDesbalanced);//re calculo sus alturas
        reHeight(nodoASubir);
        return nodoASubir;
    }

    private AVLNode leftLeftCase(AVLNode node) {
        return rotarRight(node);
    }

    private void reHeight(AVLNode temp) {
        int aux = 0;
        if (temp.getData() == null) {
            temp.setHeight(aux);
        } else {
            temp.setHeight(1 + Math.max((true) ? height(temp.getRight()) : 0, height(temp.getLeft())));

        }
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

    private AVLNode insert(T data, AVLNode temp) {
        if (temp == null) {
            temp = new AVLNode();
            temp.setData(data);
        } else if (data.compareTo(temp.getData()) > 0) {
            temp.setRight(insert(data, temp.getRight()));
            reHeight(temp);
            if (height(temp.getRight()) - height(temp.getLeft()) == 2) {
                if (data.compareTo(temp.getRight().getData()) > 0) {
                    temp = rightRightCase(temp);
                } else {
                    temp = rightLeftCase(temp);
                }
            }
        } else if (data.compareTo(temp.getData()) < 0) {
            temp.setLeft(insert(data, temp.getLeft()));
            reHeight(temp);
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

    private AVLNode remove(T data, AVLNode temp) {
        if (temp == null) {
            return temp;
        }
        int comparacion = data.compareTo(temp.getData());
        if (comparacion < 0) {
            temp.setLeft(remove(data, temp.getLeft()));
        } else if (comparacion > 0) {
            temp.setRight(remove(data, temp.getRight()));
        } //cuanto compare es 0 entra a este condicional 
        else {
            if (temp.getLeft() == null && temp.getRight() == null) {
                return null;
            } else {
                //pues temp tiene el dato a borrar
                //le doy el valor de su sucesor a temp para borrar el valor data
                temp.setData(findMin(temp.getRight()).getData());
                //y elimino la copia del sucesor que pertenecia al valor borrado
                temp.setRight(remove((T) temp.getData(), temp.getRight()));
            }
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

    private AVLNode search(T data, AVLNode temp) {
        while (temp != null) {
            int t = data.compareTo(temp.getData());
            if (t > 0) {
                temp = temp.getRight();
            } else if (t < 0) {
                temp = temp.getLeft();
            } else {
                break;
            }
            temp = search(data, temp);
        }
        return temp;
    }

    private void inOrder(AVLNode temp) {
        if (temp != null) {
            inOrder(temp.getLeft());
            if(temp.getData() instanceof Restaurant) {
                System.out.print(((Restaurant)temp.getData()).getName() + " -   ");
            }else if (temp.getData() instanceof User) {
                System.out.print(((User)temp.getData()).getName() + " - ");
            }else{
                System.out.println(temp.getData() + " - ");
            }
            inOrder(temp.getRight());
        }
    }

    private void preOrder(AVLNode temp) {
        if (temp != null) {
            if (temp.getData() instanceof Restaurant){
                System.out.print(((Restaurant)temp.getData()).getName() + " -   ");
            }else if (temp.getData() instanceof User) {
                System.out.print(((User)temp.getData()).getName() + " - ");
            }else {
                System.out.println(temp.getData() + " - ");
            }
            preOrder(temp.getLeft());
            preOrder(temp.getRight());
        }
    }

    private void postOrder(AVLNode temp) {
        if (temp != null) {
            postOrder(temp.getLeft());
            postOrder(temp.getRight());
            if(temp.getData() instanceof Restaurant){
                System.out.print(((Restaurant)temp.getData()).getName() + " -   ");
            } else if (temp.getData() instanceof User) {
                System.out.print(((User)temp.getData()).getName() + " - ");
            }else{
                System.out.println(temp.getData() + " - ");
            }
        }
    }

    public void makeEmpty() {
        this.root = null;
    }

    public AVLNode insert(T data) {
        //devuelve el nodo donde inserto el valor data
        this.root = insert(data, this.root);
        return this.root;
    }

    public AVLNode search(T data) {
        return search(data, this.root);
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

    public AVLNode findMax(AVLNode temp) {
        if (temp == null) {
            return null;
        }
        if (temp.getRight() == null) {
            return temp;
        }
        return findMax(temp.getRight());
    }

    public AVLNode remove(T data) {
        return remove(data, root);
    }// por corregir

    public AVLNode contains(T data) {
        return contains(data, this.root);
    }

    public int countNodes() {
        return countNodes(this.root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int height() {
        return height(this.root);
    }

    public void inOrder() {
        inOrder(this.root);
        System.out.println("");
    }

    public void preOrder() {
        preOrder(this.root);
        System.out.println("");
    }

    public void postOrder() {
        postOrder(this.root);
        System.out.println("");
    }

    public AVLNode getRoot() {
        return root;
    }

    public void setRoot(AVLNode root) {
        this.root = root;
    }

}
