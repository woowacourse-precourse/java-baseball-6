package baseball;

import static baseball.status.ErrorCode.INVALID_DISTINCT_INPUT;
import static baseball.status.ErrorCode.INVALID_FORMAT_INPUT;
import static baseball.status.ErrorCode.INVALID_LENGTH_INPUT;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Game {

    public void play() {
        List<Integer> computerNum = setComputerNum();
        List<Integer> inputNum = new ArrayList<>();
        while (!inputNum.equals(computerNum)) {
            String input = setInput();
            inputNum = getIntegerInput(input);
            output(computerNum, inputNum);
        }
        replay();
    }

    /**
     * 스트라이크, 볼, 낫싱 결과 출력
     *
     * @param computerNum 컴퓨터 수
     * @param inputNum    입력 수
     */
    private void output(List<Integer> computerNum, List<Integer> inputNum) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNum.contains(inputNum.get(i)) && computerNum.indexOf(inputNum.get(i)) == i) {
                strike++;
            } else if (computerNum.contains(inputNum.get(i)) && computerNum.indexOf(inputNum.get(i)) != i) {
                ball++;
            }
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }

        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    /**
     * 게임 재시작, 종료 여부
     */
    private void replay() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int game = Integer.parseInt(Console.readLine());
        if (game == 1) {
            play();
        } else if (game == 2) {
            System.out.println("--게임 종료--");
        }
    }

    /**
     * 컴퓨터 수 설정
     *
     * @return 컴퓨터 수
     */
    private List<Integer> setComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        System.out.print(computerNum.get(0));
        System.out.print(computerNum.get(1));
        System.out.println(computerNum.get(2));
        return computerNum;
    }

    /**
     * 서로 다른 3자리 수 공백 없이 입력받기
     *
     * @return 입력 값
     */
    private String setInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    /**
     * 입력 받은 문자열을 Integer 리스트로 변환
     *
     * @param input 입력 값
     * @return 숫자로 변환된 입력 수
     */
    public List<Integer> getIntegerInput(String input) {
        String[] inputArr = input.split("");
        validationInput(inputArr);

        List<Integer> inputNum = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            inputNum.add(Integer.parseInt(inputArr[i]));
        }
        return inputNum;
    }

    /**
     * 입력 값 유효성 체크
     *
     * @param input 입력 값
     */
    private void validationInput(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException(INVALID_LENGTH_INPUT.getMsg());
        }

        for (String s : input) {
            if (!s.matches("^[1-9]$")) {
                throw new IllegalArgumentException(INVALID_FORMAT_INPUT.getMsg());
            }
        }

        if (Arrays.stream(input).distinct().count() != 3) {
            throw new IllegalArgumentException(INVALID_DISTINCT_INPUT.getMsg());
        }
    }
}

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        game.play();
        Console.close();
    }
}
