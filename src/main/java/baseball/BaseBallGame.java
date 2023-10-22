package baseball;

import java.util.List;

public class BaseBallGame {
    private List<Integer> inputNumber; // 사용자로부터 입력받은 숫자
    private List<Integer> computerNumber; // 컴퓨터가 생성한 숫자
    private Input input; // 입력 처리 객체
    private Rand rand; // 난수 생성 객체
    private Check check; // 사용자와 컴퓨터 숫자를 비교하는 객체

    BaseBallGame() {
        input = new Input();
        rand = new Rand();
        check = new Check();
    }

    void start() {
        computerNumber = rand.makeRandomNumber(); // 컴퓨터가 생성한 숫자를 저장
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = input.getNumber(); // 사용자로부터 숫자를 입력받고 저장
            check.compareNumber(inputNumber, computerNumber); // 사용자와 컴퓨터 숫자를 비교
        } while (true);

    }

}
