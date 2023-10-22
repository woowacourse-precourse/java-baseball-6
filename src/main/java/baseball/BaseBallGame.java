package baseball;
import java.util.List;


public class BaseBallGame {
    private List<Integer> inputNumber;
    private Input input;

    BaseBallGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        input = new Input();
    }

    void start() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = input.getNumber();
        } while (true);
    }
}
