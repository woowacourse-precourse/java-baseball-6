package baseball;

import baseball.domain.Count;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

import static baseball.exception.Exception.*;

public class Application {

    // 1 - 게임 계속 진행,  2 - 게임 종료
    static String CONTINUE_GAME = "1";
    static String STOP_GAME = "2";


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        playNumberBaseball();
    }


    private static void playNumberBaseball() {

        boolean continueGame = true;
        while (continueGame) {
            String computer = makeNum(); // 컴퓨터 3자리 수 생성
            System.out.println("computer = " + computer);

            while (true) {
                String number = predictNumber(); // 사용자 3자리 수 예측

                // 정답을 맞힌 경우
                if (computer.equals(number)) {

                    String finishCheck = getFinishCheck();

                    if (finishCheck.equals(CONTINUE_GAME)) {
                        break;
                    } else if (finishCheck.equals(STOP_GAME)) {
                        continueGame = false;
                        break;
                    }
                }
                // 틀린 경우 힌트 제공
                else {
                    printHint(computer, number);
                }
            }
        }
    }


    private static void printHint(String computer, String number) {
        Count count = checkStrikeAndBall(computer, number);

        if (count.getStrike() == 0 && count.getBall() == 0) {
            System.out.println("낫싱");
        } else if (count.getStrike() > 0 && count.getBall() == 0) {
            System.out.println(count.getStrike() + "스트라이크");
        } else if (count.getStrike() == 0 && count.getBall() > 0) {
            System.out.println(count.getBall() + "볼");
        } else if (count.getStrike() > 0 && count.getBall() > 0) {
            System.out.println(count.getBall() + "볼 " + count.getStrike() + "스트라이크");
        }
    }


    private static Count checkStrikeAndBall(String computer, String number) {
        int strike = 0;
        int ball = 0;

        List<String> computers = Arrays.asList(computer.split(""));
        List<String> numbers = Arrays.asList(number.split(""));

        for (int i = 0; i < 3; i++) {
            if (computer.contains(numbers.get(i))) {
                if (computers.get(i).equals(numbers.get(i))) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        return new Count(strike, ball);
    }


    private static String getFinishCheck() throws IllegalArgumentException {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String line = Console.readLine();

        checkBasicException(line, 1);
        checkGameContinueException(line);

        return line;
    }


    public static String predictNumber() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String line = Console.readLine();

        checkBasicException(line, 3);
        checkDuplicatedException(line);

        return line;
    }


    private static String makeNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

}