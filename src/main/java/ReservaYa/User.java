/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReservaYa;

/**
 *
 * @author W1
 */
public class User implements Comparable {

    int id, age;
    String name, email;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    @Override
    public int compareTo(Object o) {
        return compareTo((User) o);
    }

    private int compareTo(User u) {
        if (this.name.compareTo(u.getName()) < 0) {
            return -1;
        } else if (this.name.compareTo(u.getName()) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
