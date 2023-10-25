package baseball;

import java.util.List;

public class Output {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void showResult(List<Integer> result) {
        if (result.get(1) == 0 && result.get(0) == 0) {
            System.out.print("낫싱");
        }
        else{
            if (result.get(1) > 0) {
                System.out.print(result.get(1) + "볼");
            }
            if (result.get(1) > 0 && result.get(0) > 0) {
                System.out.print(" ");
            }
            if (result.get(0) > 0) {
                System.out.print(result.get(0) + "스트라이크");
            }
        }
        System.out.println();
    }

    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void endProgram() {
        System.out.println("프로그램 종료.");
    }
}
