package baseball.service.handler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {

    private String playerNumber = "";  //사용자가 입력한 수

    //입력 관련 validator
    private final InputValidator validator = new InputValidator();

    /**
     * 플레이어 숫자 입력 받기
     *
     * @param numberOfDigits : 게임에서 지정된 입력값의 자리수
     */
    public void setPlayerNumber(int numberOfDigits) {
        String inputNumber = readLine();

        //입력받은 숫자가 valid한지 확인
        if (!validator.regexCheck(inputNumber, numberOfDigits) ||
                !validator.isDifferentEachDigit(inputNumber)) {
            throw new IllegalArgumentException();
        }

        this.playerNumber = inputNumber;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }
}
