package baseball;

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
        }
        replay();
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
            throw new IllegalArgumentException("입력하신 숫자가 3자리 수가 아닙니다.");
        }

        for (String s : input) {
            if (!s.matches("^[1-9]$")) {
                throw new IllegalArgumentException("입력하신 숫자가 1 ~ 9에 해당하지 않습니다.");
            }
        }

        if (Arrays.stream(input).distinct().count() != 3) {
            throw new IllegalArgumentException("입력하신 숫자 중 중복되는 값이 존재합니다.");
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
