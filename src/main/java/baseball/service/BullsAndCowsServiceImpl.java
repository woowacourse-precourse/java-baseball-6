package baseball.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BullsAndCowsServiceImpl implements BullsAndCowsService {

    private static final int GAME_RESTART = 1;
    private static final int GAME_END = 2;
    private static final int DIGIT_LENGTH = 3;

    // 컴퓨터 랜덤값 3자리 생성값 반환
    @Override
    public List<Integer> createComputerRandomValue() {

        List<Integer> computer = new ArrayList<>();

        while (checkComputerRandomValueSize(computer)) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (validateRandomNumber(computer, randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    // 사용자 추측값 3자리 입력값 반환
    @Override
    public List<Integer> getThreeDigits() {

        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();

        // 예외 처리 필요!!
        if (!isValidThreeDigitNumber(inputString)) {
            throw new IllegalArgumentException();
        }

        List<Integer> user = new ArrayList<>();
        for (char c : inputString.toCharArray()) {
            user.add(Character.getNumericValue(c));
        }

        return user;
    }

    // 게임 종료 여부 값 반환
    @Override
    public boolean isGameRunning() {

        int gameStatus; // 재시작: 1, 종료: 2

        do {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameStatus = Integer.parseInt(Console.readLine());
        } while (checkGameStatusValue(gameStatus));

        return gameStatus == GAME_RESTART;
    }

    @Override
    public boolean compareUserGuessWithRandom(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;
        int strikeCount = 0;

        int size = user.size();

        for (int i = 0; i < size; i++) {
            int userNum = user.get(i);

            for (int j = 0; j < size; j++) {
                if (userNum == computer.get(j)) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }

        printResult(ballCount, strikeCount);

        return strikeCount == DIGIT_LENGTH;
    }

    private void printResult(int ballCount, int strikeCount) {
        StringBuilder message = new StringBuilder();

        if (ballCount > 0) {
            message.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            message.append(strikeCount).append("스트라이크");
        }

        String resultMessage = message.toString();

        if (resultMessage.isEmpty()) {
            resultMessage = "낫싱";
        }

        System.out.println(resultMessage);
    }


    private boolean isValidThreeDigitNumber(String str) {

        // 입력한 값이 3자리가 아닌 경우
        if (str.length() != DIGIT_LENGTH) {
            return false;
        }

        Set<Character> uniqueDigits = new HashSet<>();

        for (char c : str.toCharArray()) {

            // 숫자가 아닌 값이 포함되어 있는 경우
            if (!Character.isDigit(c)) {
                return false;
            }

            // 숫자 0이 포함되어 있는 경우
            if (Character.getNumericValue(c) == 0) {
                return false;
            }

            // 동일한 숫자가 이미 존재하는 경우
            if (!uniqueDigits.add(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkComputerRandomValueSize(List<Integer> computer) {
        return computer.size() < DIGIT_LENGTH;
    }

    private boolean validateRandomNumber(List<Integer> computer, int randomNumber) {
        return !computer.contains(randomNumber);
    }

    private boolean checkGameStatusValue(int gameStatus) {
        return gameStatus != GAME_RESTART && gameStatus != GAME_END;
    }
}
