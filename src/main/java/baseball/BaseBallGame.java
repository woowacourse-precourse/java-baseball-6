package baseball;

import java.util.List;

public class BaseBallGame {
    private List<Integer> inputNumber;
    private List<Integer> computerNumber;
    private Input input;
    private Rand rand;
    private Check check;

    BaseBallGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        input = new Input();
        rand = new Rand();
        check = new Check();
    }

    void start() {
        computerNumber = rand.makeRandomNumber();
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = input.getNumber();
            check.compareNumber(inputNumber, computerNumber);
        } while (true);

    }

}
