package baseball;

import java.util.List;

public class GameNumber {

    private List<Integer> computer;
    private List<Integer> user;

    public GameNumber(List<Integer> computer, List<Integer> user) {
        this.computer = computer;
        this.user = user;
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