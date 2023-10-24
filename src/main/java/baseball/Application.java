package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        Player player = new Player();
        int exitNumber = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (exitNumber == 1) {
            int answerNumber = computer.getRandomNumber();
            System.out.println("answernum : " + answerNumber);
            Umpire umpire = new Umpire(toArray(answerNumber));

            while (umpire.getStrike() < 3) {
                int enterNum = 0;
                System.out.print("숫자를 입력해주세요 : ");
                enterNum = player.enterNumber();
                System.out.println("enternum : " + enterNum);
                if ((enterNum > 999) || (enterNum < 100)) {
                    throw new IllegalArgumentException();
                }
                umpire.judge(toArray(enterNum));
                umpire.speak();
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            exitNumber = Integer.parseInt(Console.readLine());
            if ((exitNumber < 1) || (exitNumber > 2)) {
                throw new IllegalArgumentException();
            }

        }
    }

    public static int[] toArray(int num) {
        return Stream.of(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
