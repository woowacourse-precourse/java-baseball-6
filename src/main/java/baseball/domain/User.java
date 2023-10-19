package baseball.domain;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Integer> number;

    public User(String name, ArrayList<Integer> number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getNumber() {
        return number;
    }

    public void setNumber(ArrayList<Integer> number) {
        this.number = number;
    }
}
