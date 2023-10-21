package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Game {
    public List<Integer> answer;
    Game(List<Integer> answer) {
        this.answer = answer;
    }

    void run() {
        while(true) {
            List<Integer> query = this.askQuery();
            int[] result = this.judge(query);
            this.printResult(result);
            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    List<Integer> askQuery() {
        System.out.print("숫자를 입력해주세요 : ");
        String queryString = Console.readLine();
        try {
            int queryInt = Integer.parseInt(queryString);
            List<Integer> query = Arrays.asList(
                    queryInt / 100,
                    (queryInt / 10) % 10,
                    queryInt % 10);
            for (int i = 0; i < 3; i++) {
                if (query.get(i) < 1 || query.get(i) > 9) {
                    throw new Exception("Digits must be ranged 1 to 9");
                }
                for (int j = i + 1; j < 3; j++) {
                    if (query.get(i).equals(query.get(j))) {
                        throw new Exception("Digits must be unique");
                    }
                }
            }
            return query;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    int[] judge(List<Integer> query) {
        int[] result = {0, 0};

        // Ball judgement
        Set<Integer> answerSet = new HashSet<>(this.answer);
        Set<Integer> querySet = new HashSet<>(query);

        querySet.retainAll(answerSet);
        result[1] = querySet.size();

        // Strike judgement
        for (int i = 0; i < 3; i++) {
            if (query.get(i).equals(this.answer.get(i))) {
                result[0] += 1;
                result[1] -= 1;
            }
        }

        return result;
    }

    void printResult(int[] result) {
        if (result[0] > 0 && result[1] > 0) {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        } else if (result[0] > 0) {
            System.out.println(result[0] + "스트라이크");
        } else if (result[1] > 0) {
            System.out.println(result[1] + "볼");
        } else {
            System.out.println("낫싱");
        }
    }
}


public class Application {
    static boolean askRestart() {
        // TODO: add inputString validation
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        return inputString.equals("1");
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            // Create random answer
            List<Integer> randomList = new ArrayList<>();
            while (randomList.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!randomList.contains(randomNumber)) {
                    randomList.add(randomNumber);
                }
            }

            // Run game
            Game game = new Game(randomList);
            game.run();

            // Ask and restart or break.
            if (!askRestart())
                break;
        }
    }
}