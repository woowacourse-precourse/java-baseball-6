package baseball.repository;

import java.util.List;

public class BaseballRepository {
    public List<Integer> getComputer() {
        return Computer.getInstance().getComputerNumbers();
    }

    public void saveComputer(List<Integer> numbers) {
        Computer.getInstance().setComputerNumbers(numbers);
    }

    public List<Integer> getUser() {
        return User.getInstance().getUserNumbers();
    }

    public void saveUser(String numbers) {
        User.getInstance().setUserNumbers(numbers);
    }
}
