package baseball.controller;

import java.util.Map;

public class ResultCalculator {

    public boolean resultAnalysis(Map<String, Integer> result) {
        if (result.get("ball") != 0 && result.get("strike") != 0) {
            System.out.println(result.get("ball") + "볼 " + result.get("strike") + "스트라이크");
        }
        else if (result.get("strike") == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        else if (result.get("strike") == 0 && result.get("ball") != 0) {
            System.out.println(result.get("ball") + "볼");
        }
        else if (result.get("ball") == 0 && result.get("strike") != 0) {
            System.out.println(result.get("strike") + "스트라이크");
        }
        else {
            System.out.println("낫싱");
        }
        return false;
    }
}