package io;
import camp.nextstep.edu.missionutils.Console;
import domain.GameResult;

public class ConsoleView implements View {

    @Override
    public String inputNumbers() {
        return Console.readLine();
    }

    @Override
    public String inputRetryMenu() {
        return Console.readLine();
    }

    @Override
    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void printEnterNumberMsg() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printResult(GameResult gameResult) {
        System.out.println(gameResult.toString());
    }

    @Override
    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void printEndOrRetryMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
