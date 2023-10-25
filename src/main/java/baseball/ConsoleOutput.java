package baseball;

import java.util.Map;

public class ConsoleOutput implements OutPut {

    private void print(String letter) {
        System.out.print(letter);
    }

    @Override
    public void printStart() {
        print("숫자 야구 게임을 시작합니다.\n");
    }

    @Override
    public void printInputRequest() {
        print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printScore(Map<String, Integer> result) {
        StringBuilder sb = new StringBuilder();

        if (result.get("ball") == 0 && result.get("strike") == 0) {
            sb.append("낫싱");
        } else {
            if (result.get("ball") != 0) {
                sb.append("" + result.get("ball") + "볼 ");
            }

            if (result.get("strike") != 0) {
                sb.append("" + result.get("strike") + "스트라이크");
            }
        }

        print(sb.toString().strip() + "\n");
    }

    @Override
    public void printFinish() {
        print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    @Override
    public void askRestart() {
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }
}
