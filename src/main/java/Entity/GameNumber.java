package Entity;

import static Constants.Constants.NUM_LENGTH;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 컴퓨터의 랜덤 숫자, 유저가 입력한 숫자
 */
public class GameNumber {

    private List<Integer> computer;
    private List<Integer> user;

    public GameNumber() {
        computer = new ArrayList<>();
        user = new ArrayList<>();
    }

    public boolean validateUserNumber() {
        Set<Integer> uniqueElements = new HashSet<>();
        if (user.size() != NUM_LENGTH) {    // 세 자리가 아니면 false
            return false;
        }
        for (Integer value : user) {
            if (uniqueElements.add(value)) continue;    // 서로 다르지 않으면 false
            if (value >= 1 && value <= 9) continue;     // 숫자가 아니면 false
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