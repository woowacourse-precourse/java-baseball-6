package baseball;

import baseball.model.Computer;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer(3);
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean correct = false; // 정답 여부

        while (!correct) { // 정답을 맞출 때 까지 반복한다.
            correct = guessTheAnswer();
        }
    }

    /**
     * 사용자로부터 새로운 정답을 받는다.
     *
     * @return 입력받은 값을 반환한다.
     */
    private static String newNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    /**
     * 정답을 맞추는 과정을 진행한다.
     *
     * @return 정답: true, 오답: false
     */
    private static boolean guessTheAnswer() {
        User user = new User(newNumbers());
        return false;
    }
}
