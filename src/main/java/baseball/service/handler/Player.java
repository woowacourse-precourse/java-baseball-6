package baseball.service.handler;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.service.InputValidator;

public class Player {

    private String player_number = "";

    //입력 관련 validator
    private final InputValidator validator = new InputValidator();

    /**
     * 플레이어 숫자 입력 받기
     */
    public void inputNumber() {
        String input_number = readLine();

        if (!validator.lengthCheck(input_number.length()) || !validator.validNumCheck(input_number)) {
            throw new IllegalArgumentException();
        }

        this.player_number = input_number;
    }

    public String getPlayer_number() {
        return player_number;
    }
}
