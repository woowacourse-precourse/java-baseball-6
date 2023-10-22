package baseball.domain.user;


import baseball.domain.game.GameOption;
import baseball.domain.game.Input;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private static List<Integer> userInputs = new ArrayList<>();

    public Integer getWouldRestartGame() throws Exception {
        String input = Console.readLine();
        int numericInput = Integer.parseInt(input);

        GameOption option = Arrays.stream(GameOption.values())
                .filter(gameOption -> gameOption.getOption() == numericInput)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("재시작 여부는 1(재시작)과 2(종료) 중 하나만 입력해주세요."));

        return option.getOption();
    }

    public List<Integer> getUserInputs() {
        return this.userInputs;
    }

    public void getInputsFromUser() throws Exception {
        String input = Console.readLine();
        if (input.length() >= Input.NUMLENGTH.getLength()) {
            throw new IllegalArgumentException(String.format("%s자리의 숫자를 입력해주세요", Input.NUMLENGTH.getLength()));
        }
        for (int i = 0; i < input.length(); i++) {
            char eachNumber = input.charAt(i);
            boolean isDigit = Character.isDigit(eachNumber);
            if (isDigit != true) {
                throw new IllegalArgumentException("숫자만 입력해주세요");
            }
            int eachInputNumber = Character.getNumericValue(eachNumber);
            userInputs.add(eachInputNumber);
        }
    }
}
