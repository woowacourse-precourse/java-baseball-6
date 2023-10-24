package Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Constants.Constants.NUM_LENGTH;

public class GameNumber {

    private List<Integer> computer;
    private List<Integer> user;

    public GameNumber() {
        computer = new ArrayList<>();
        user = new ArrayList<>();
    }

    public boolean validateUserNumber() {
        Set<Integer> uniqueElements = new HashSet<>();
        if (user.size() != NUM_LENGTH) {
            return false;
        }
        for (Integer value : user) {
            if (uniqueElements.add(value)) continue;
            if (value >= 1 && value <= 9) continue;
            return false;
        }
        return true;
    }

    public List<Integer> getComputer() {
        return computer;
    }

    public List<Integer> getUser() {
        return user;
    }

    public void setComputer(List<Integer> computer) {
        this.computer = computer;
    }

    public void setUser(List<Integer> user) {
        this.user = user;
    }
}