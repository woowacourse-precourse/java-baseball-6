package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        String click = "0";
        while (!click.equals("2")) {
            List<Integer> computerBall = RandomBall.makeRandomBall();
            System.out.println(computerBall);
            boolean loop = false;
            while (!loop) {
                String tempBall = Console.readLine();
                loop = CheckBall.giveBallResult(tempBall, computerBall);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            click = Console.readLine();
        }

    }
}
