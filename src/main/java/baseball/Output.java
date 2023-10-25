package baseball;

import java.util.Map;

public class Output {
    public void startPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputPrint() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public boolean resultPrint(Map<String, Integer> result) {
        if (result.get("strike") == 0 && result.get("ball") == 0) {
            System.out.println("낫싱");
        } else if (result.get("strike") == 3) {
            System.out.println(result.get("strike") + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restartPrint();
            return false;
        } else if (result.get("strike") == 0) {
            System.out.println(result.get("ball") + "볼");
        } else if (result.get("ball") == 0) {
            System.out.println(result.get("strike") + "스트라이크");
        } else {
            System.out.println(result.get("ball") + "볼 " + result.get("strike") + "스트라이크 ");
        }
        return true;
    }

    public void restartPrint() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
