package baseball;

import baseball.core.code.Message;
import baseball.core.print.MessagePrinter;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Application {

    public static final int STANDARD_NUMBER = 3;

    public static void main(String[] args) {
        palyGame();

        // 6. 게임 새로 시작 및 종료 문구 출력
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        // 7. 게임 새로 시작 또는 종료 기능 구현
        String input = Console.readLine();
        switch (input) {
            case "1":
                palyGame();
                break;
            case "2":
                break;
            default:
                throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }

    }

    private static void palyGame() {
        // 1. 시작 메시지 출력
        MessagePrinter.print(Message.START);

        // 2. 숫자 3자리 추출
        List<Integer> computerNumbers = getComputerNumbers();

        boolean gameOver = false;
        while (!gameOver) {
            // 3. 사용자 숫지 입력 기능 및 유효성 체크
            String input = Console.readLine();
            validInput(input);

            // 4. 사용자 입력 받은 수와 기존 지정된 숫자 비교
            gameOver = compare(computerNumbers, input);
        }

        // 5. 3개 숫자가 모두 동일한 경우 안내 멘트 출력 후 게임 종료 처리
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static boolean compare(List<Integer> computerNumbers, String input) {
        List<Integer> inputNumbers = Arrays.stream(input.split("")).map(Integer::parseInt).toList();

        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < STANDARD_NUMBER; i++) {
            Integer computerNumber = computerNumbers.get(i);
            Integer inputNumber = inputNumbers.get(i);

            if (computerNumber == inputNumber) {
                strikeCount++;
            } else if (inputNumbers.contains(computerNumber)) {
                ballCount++;
            }
        }

        String resultMessage = getResultMessage(strikeCount, ballCount);
        System.out.println(resultMessage);

        return strikeCount == STANDARD_NUMBER;
    }

    private static String getResultMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }

        String resultMessage = "";
        if (ballCount != 0) {
            resultMessage = ballCount + "볼";
        }

        if (ballCount != 0 && strikeCount!= 0) {
            resultMessage += " ";
        }

        if (strikeCount != 0) {
            resultMessage += strikeCount + "스트라이크";
        }
        return resultMessage;
    }

    /**
     * 사용자 입력 값 유효성 체크
     * @param input
     */
    private static void validInput(String input) {
        // 입력 값 유효성 체크
        if (input.isBlank()) {
            throw new IllegalArgumentException("숫자를 입력 해야 합니다.");
        }

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        if (input.length() != STANDARD_NUMBER) {
            throw new IllegalArgumentException("숫자는 " + STANDARD_NUMBER + "자리로 입력 해야 합니다.");
        }

        long distinctRemoveStringCount = Arrays.asList(input.split("")).stream().distinct().count();
        if (distinctRemoveStringCount != input.length()) {
            throw new IllegalArgumentException("숫자는 중복 될 수 없습니다.");
        }
    }

    /**
     * 게임용 숫자 3자리 추출
     * @return List<Integer> 컴퓨터 숫자 리스트
     */
    private static List<Integer> getComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < STANDARD_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}
