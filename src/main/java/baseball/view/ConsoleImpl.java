package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleImpl implements Console {
    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }

    @Override
    public void printApplicationStartMessage() {
        println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void printApplicationExitMessage() {
        println("애플리케이션을 종료합니다.");
    }

    @Override
    public void printSelectMenuMessage() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    public void printInputNumberMessage() {
        print("숫자를 입력해주세요 : ");
    }

    @Override
    public String getUserInput() {
        return readLine();
    }

    @Override
    public void printNumbersMatchResult(String matchResult) {
        println(matchResult);
    }

    @Override
    public void printPlayerWinMessage() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
