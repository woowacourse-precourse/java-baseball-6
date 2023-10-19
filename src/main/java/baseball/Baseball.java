package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    private List<Integer> computer = new ArrayList<>();
    private List<Integer> user = new ArrayList<>();

    public Baseball() {
    }

    public void playGame() {
        generateComputerNumber();

        System.out.println(START_GAME_MESSAGE);
        System.out.print(NUMBER_INPUT_MESSAGE);

        String inputValue = userNumberInput();

        if (!validateNumberLength(inputValue)) {
            throw new IllegalArgumentException();
        }

        generateUserNumber(inputValue);
    }

    public void generateComputerNumber() {
        while (computer.size() < 3) {
            int randomNumber = getRandomNumber();

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public String userNumberInput() {
        return Console.readLine();
    }

    public void generateUserNumber(String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            int userNumber = parseNumber(inputValue.charAt(i));
            user.add(userNumber);
        }
    }

    public int parseNumber(char character) {
        return character - '0';
    }

    public boolean validateNumberLength(String inputValue) {
        return inputValue.length() <= 3;
    }
}
