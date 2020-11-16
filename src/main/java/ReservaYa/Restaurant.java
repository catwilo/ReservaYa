/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservaYa;

import Structure.LinkedQueue;
import java.time.LocalDate;

/**
 *
 * @author W1
 */
public class Restaurant extends Object implements Comparable {

    String Description, name;
    LocalDate open, close;
    int Ntables;
    boolean[] table;
    LinkedQueue Qu;

    public Restaurant() {
        name = null;
        Qu = new LinkedQueue();

    }

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant(String name, int Ntables) {
        this.name = name;
        this.Ntables = Ntables;
        this.table = new boolean[Ntables];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNtables(int Ntables) {
        this.Ntables = Ntables;
    }

    public String getName() {
        return name;
    }

    public int getNtables() {
        return Ntables;
    }

    public void EncolarUser(User u) {
        Qu.push(u);
    }

    @Override
    public int compareTo(Object o) {
        return compareTo((Restaurant)o);
    }

    private int compareTo(Restaurant restaurante) {
        if (this.name.compareTo(restaurante.getName()) < 0) {
            return -1;
        } else if (this.name.compareTo(restaurante.getName()) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
