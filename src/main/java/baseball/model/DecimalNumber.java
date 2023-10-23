package baseball.model;

import java.util.List;

public class DecimalNumber {

    private static List<Integer> computer;
    private static List<Integer> user;

    public List<Integer> getComputer() {
        return computer;
    }

    public void setComputer(List<Integer> computer) {
        DecimalNumber.computer = computer;
    }

    public void setUser(String input) {
        DecimalNumber.user = user;
    }
}
