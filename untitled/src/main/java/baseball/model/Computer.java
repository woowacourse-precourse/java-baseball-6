package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;

public class Computer {

    private String computer;

    public Computer() {
        setGameNumber();
    }

    public String getComputer(){
        return computer;
    }

    public void setGameNumber() {
        LinkedHashSet<String> computerNumberCheck = new LinkedHashSet<>();
        while (computerNumberCheck.size() < 3) {
            computerNumberCheck.add(getRandomNumber());
        }
        this.computer = String.join("", computerNumberCheck);
    }

    public static String getRandomNumber() {
        return Integer.toString(Randoms.pickNumberInRange(1, 9));
    }
}
