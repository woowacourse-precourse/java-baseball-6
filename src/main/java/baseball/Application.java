package baseball;

import baseball.model.Computer;
import baseball.model.Number;
import baseball.model.User;
import baseball.util.Baseball;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        boolean reGame = true;
        while (reGame) {
            Computer computer = new Computer(3);
            System.out.println("숫자 야구 게임을 시작합니다.");
            boolean correct = false; // 정답 여부

            while (!correct) { // 정답을 맞출 때 까지 반복한다.
                correct = guessTheAnswer(computer);
            }
            reGame = reGame();
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
    private static boolean guessTheAnswer(Computer computer) {
        User user = new User(newNumbers()); // 유저로부터 게임에 제출할 숫자를 받는다.
        // 컴퓨터와 유저가 제시한 숫자로 게임을 만든다.
        Baseball baseball = new Baseball(computer.getRandomNumbers(), user.getNumbers());
        boolean result = baseball.play(); // 경기를 진행한다.

        return result ? true : false;
    }

    private static boolean reGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Number number = new Number(Console.readLine());
        if (number.getNumber() < 0 || number.getNumber() > 2) {
            throw new IllegalArgumentException();
        }

        return number.getNumber() == 1;
    }
}
