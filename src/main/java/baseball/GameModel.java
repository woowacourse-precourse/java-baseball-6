package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GameModel {
    private final Computer computer;

    public GameModel(Computer computer) {
        this.computer = computer;
    }

    public void setRandomNumberInComputer() {
        Set<Integer> nums = new HashSet<>();
        while (nums.size() < 3) {
            nums.add(Randoms.pickNumberInRange(1, 9));
        }

        String computerNumber = nums.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        
        computer.setNumber(computerNumber);
    }

    public ResultAndView compareUserAndComputerNumber(String userNumber) {
        validateUserNumber(userNumber);

        Result result = computer.compareNumber(userNumber);
        if (result.getStrike() == 3) {
            return new ResultAndView("3스트라이크", false);
        } else if (result.getStrike() == 0 && result.getBall() == 0) {
            return new ResultAndView("낫싱", true);
        } else {
            int ballCount = result.getBall();
            int strikeCount = result.getStrike();
            StringBuilder sb = new StringBuilder();

            if (ballCount > 0) sb.append(ballCount).append("볼");
            if (ballCount > 0 && strikeCount > 0) sb.append(" ");
            if (strikeCount > 0) sb.append(strikeCount).append("스트라이크");

            return new ResultAndView(sb.toString(), true);
        }
    }

    private void validateUserNumber(String userNumber) {
        // 유효성 검사
        if (!Pattern.matches("^[1-9][1-9][1-9]$", userNumber)) throw new IllegalArgumentException();
        if (Arrays.stream(userNumber.split("")).distinct().count() < 3) throw new IllegalArgumentException();
    }

    public boolean isGameExit(String userInput) {
        // 유효성 검사
        if (!Pattern.matches("^[12]$", userInput)) throw new IllegalArgumentException();
        return userInput.equals("2");
    }

    public Computer getComputer() {
        return computer;
    }
}
