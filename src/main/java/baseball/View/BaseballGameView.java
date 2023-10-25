package baseball.View;

import static baseball.handler.ExceptionHandler.validateNumber;
import static baseball.handler.ExceptionHandler.validateNumbers;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameView {

    // 3. 사용자로부터 숫자 3개를 입력받는 메서드
    public String[] inputThreeNums() {
        String inputNums; // 사용자에게 입력받을 값을 저장할 변수
        String[] listedInputNums; // 사용자에게 입력받은 값을 하나의 숫자씩 잘라서 보관하는 배열

        System.out.println("숫자를 입력해주세요 : ");
        inputNums = Console.readLine(); // 사용자에게 값 입력 받기
        validateNumbers(inputNums); // 입력받은 값 검증

        listedInputNums = inputNums.split(""); // 값이 문제가 없으면 하나의 숫자씩 잘라서 배열에 담기
        return listedInputNums;
    }

    // 4. 게임 재시작 여부를 결정할 숫자를 입력받을 메서드
    public String replayOrExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String decide = Console.readLine(); // 사용자에게 1 또는 2를 입력받기
        validateNumber(decide); // 사용자가 입력한 값이 1 또는 2인지 유효성 검사

        return decide;
    }

    public void showResult(String result) {
        System.out.println(result);
    }
}
