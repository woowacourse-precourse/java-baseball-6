package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    private static final int ANSWER_LENGTH = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> answer = createAnswer();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> query = createQuery(readLine());

                BallCount ballCount = new BallCount(query, answer);
                System.out.println(ballCount.getDescription());
                if (ballCount.isStrikeOut()) {
                    break;
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (readLine().equals("2")) {
                System.out.println("게임 종료");
                break;
            }
        }
    }

    private static List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < ANSWER_LENGTH) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(number)) {
                answer.add(number);
            }
        }
        return answer;
    }

    private static List<Integer> createQuery(String input) {
        try {
            if (input.length() != ANSWER_LENGTH) {
                throw new IllegalArgumentException();
            }

            List<Integer> query = Arrays.stream(input.split(""))
                    .map(Integer::parseInt)
                    .toList();

            if (new HashSet<>(query).size() != ANSWER_LENGTH) {
                throw new IllegalArgumentException();
            }

            return query;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static class BallCount {
        private int ball = 0;
        private int strike = 0;

        BallCount(List<Integer> query, List<Integer> answer) {
            for (int i = 0; i < ANSWER_LENGTH; i++) {
                if (answer.contains(query.get(i))) {
                    if (query.get(i).equals(answer.get(i))) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }

        public String getDescription() {
            String response = "";

            if (ball != 0) {
                response += ball + "볼 ";
            }
            if (strike != 0) {
                response += strike + "스트라이크";
            }
            if (response.isBlank()) {
                response = "낫싱";
            }

            return response;
        }

        public boolean isStrikeOut() {
            return strike == ANSWER_LENGTH;
        }
    }
}
