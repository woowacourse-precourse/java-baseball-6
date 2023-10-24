package baseball.model;

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

    /**
     * 1. Goal Number 생성
     */
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

    /**
     * 2. 볼판정하기
     */
    public int[] callBallCount(String number) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (!isGoalContainPlayerNumber(number.charAt(i)))
                continue;
            if (isStrike(number, i)) {
                strike++;
                continue;
            }
            ball++;
        }
        return new int[]{ball, strike};
    }

    private boolean isGoalContainPlayerNumber(char playerNumber) {
        return this.goalNumber.contains(String.valueOf(playerNumber));
    }

    private boolean isStrike(String number, int index) {
        return number.charAt(index) == this.goalNumber.charAt(index);
    }

    /**
     * 3. 삼진 아웃 판정
     */
    public boolean isStrikeOut(int[] ballCount) {
        return ballCount[1] == 3;
    }

    /**
     * 4. 경기 재시작 요청
     */
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