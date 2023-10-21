package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView implements GameView {
    private void out(String message){
        System.out.println(message);
    }
    private String in(){
        return Console.readLine();
    }
    @Override
    public void printStart() {
        out("숫자 야구 게임을 시작합니다.");
    }
    @Override
    public String getRestart() {
        out("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return in();
    }
    @Override
    public String getInputNumber() {
        out("숫자를 입력해주세요 : ");
        return in();
    }
    @Override
    public void printBallScore(int score) {
        out(score + "볼");
    }
    @Override
    public void printStrikeScore(int score) {
        out(score + "스트라이크");
    }
    @Override
    public void printBothScore(int ball, int strike) {
        out(ball + "볼 " + strike + "스트라이크");
    }
    @Override
    public void printExit() {
        out("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    @Override
    public void printNoneScore() {
        out("낫싱");
    }
}
