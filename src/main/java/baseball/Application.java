package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> answer = new ArrayList<>();
            while (answer.size() < 3) {
                int number = Randoms.pickNumberInRange(1, 9);
                if (!answer.contains(number)) {
                    answer.add(number);
                }
            }

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> query;
                try {
                    String input = readLine();
                    if (input.length() != 3) {
                        throw new IllegalArgumentException();
                    }
                    query = Arrays.stream(input.split(""))
                            .map(Integer::parseInt)
                            .toList();
                    if (new HashSet<>(query).size() != 3) {
                        throw new IllegalArgumentException();
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }

                int strike = 0, ball = 0;
                for (int i = 0; i < 3; i++) {
                    if (answer.contains(query.get(i))) {
                        if (query.get(i).equals(answer.get(i))) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }

                String response = "";
                if (ball != 0){
                    response += ball + "볼 ";
                }
                if (strike != 0) {
                    response += strike + "스트라이크";
                }
                if (response.isBlank()) {
                    response = "낫싱";
                }

                System.out.println(response);
                if (strike == 3) {
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
}
