package baseball.View;

import baseball.data.GameResult;
import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;

public class Cli implements View{
    @Override
    public void startView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public int inputView() {
        System.out.print("숫자를 입력해주세요 : ");
        return getIntConsole();
    }

    @Override
    public boolean outputView(GameResult gameResult) {
        int strike = gameResult.getStrike();
        int ball = gameResult.getBall();

        if (ball > 0) {
            System.out.printf("%d볼 ", ball);
        }
        if (strike > 0) {
            System.out.printf("%d스트라이크", strike);
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    @Override
    public boolean endView() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int number = getIntConsole();
        if (number == 1) {
            return true;
        }
        if (number == 2) {
            return false;
        }
        throw new IllegalArgumentException("1또는 2를 입력하세요!");
    }

    private int getIntConsole() {
        int num;
        try {
            num = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요!");
        }
        return num;
    }
}
