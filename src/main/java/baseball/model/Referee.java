package baseball.model;

import baseball.view.Message;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public String goalNumber;

    public void setGame() {
        this.goalNumber = generateGoalNumber();
    }

    private String generateGoalNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    public int[] callBallCount(String number) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            char player_number = number.charAt(i);
            char goal_number = this.goalNumber.charAt(i);

            if (this.goalNumber.contains(String.valueOf(player_number))) {
                if (player_number != goal_number)
                    ball++;
                else
                    strike++;
            }
        }
        return new int[]{ball, strike};
    }

    public boolean isStrikeOut(int[] ballCount) {
        return ballCount[1] == 3;
    }

    public boolean isRestart() {
        String number = Console.readLine();
        isValid(number);

        return number.equals("1");
    }

    private void isValid(String number) {
        if (!number.equals("1") && !number.equals("2"))
            throw new IllegalArgumentException("Invalid Input");
    }


}