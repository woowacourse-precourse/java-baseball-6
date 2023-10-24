package baseball;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int exit = 1;
        Map<String, Integer> counter = new HashMap<>();
        String result;

        int strikeCount = 1;

        System.out.println("숫자 야구 게임을 시작합니다.");

            try {
                BallCounter bc = new BallCounter(); //counter 초기화

                while (exit == 1) {

                    //input 객체 생성 및 human에 입력 받아
                    Input input = new Input();

                    if (strikeCount == 1) {
                        bc.computer = input.extractRandom(); // 3스트라이크가 나올 때 까지 computer의 값은 유지해야해
                        strikeCount = 0;
                    }

                    bc.human = input.split();

                    if (bc.human.contains(0)) {
                        throw new IllegalArgumentException();
                    }

                    counter = bc.ballCounting(bc.computer, bc.human); // ballCounting으로 작성 된 스,볼 맵 받음

                    result = lastPrint(counter);

                    System.out.println(result);

                    if (counter.get("strike") == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                        strikeCount++;
                        exit = input.doOrDie(); //종료 or not
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    // 0스트라이크 or 0볼은 출력 X
    private static String lastPrint(Map<String, Integer> counter) {
        if (counter.get("strike") == 0 && counter.get("ball") == 0) {
            return "낫싱";
        }
        if (counter.get("strike") == 3) {
            return (counter.get("strike") + "스트라이크");
        }

        if (counter.get("strike") == 0) {
            return (counter.get("ball") + "볼");
        }
        if (counter.get("ball") == 0) {
            return (counter.get("strike") + "스트라이크");
        }

        return (counter.get("ball") + "볼 " + counter.get("strike") + "스트라이크");

    }
}



