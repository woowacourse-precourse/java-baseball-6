package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private final List<Integer> answer;
    Game(List<Integer> answer) {
        this.answer = answer;
    }

    public void run() {
        while (true) {
            List<Integer> query = this.askQuery();
            int[] result = this.judge(query);
            this.printResult(result);
            if (this.isCorrect(result)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private List<Integer> askQuery() {
        System.out.print("숫자를 입력해주세요 : ");
        String queryString = Console.readLine();

        int queryInt;
        try {
            queryInt = Integer.parseInt(queryString);
        } catch (Exception e) {
            throw new IllegalArgumentException("Input must be a number");
        }

        List<Integer> query = Arrays.asList(
                queryInt / 100,
                (queryInt / 10) % 10,
                queryInt % 10);
        for (int i = 0; i < 3; i++) {
            if (query.get(i) < 1 || query.get(i) > 9) {
                throw new IllegalArgumentException("Digits must be ranged 1 to 9");
            }
            for (int j = i + 1; j < 3; j++) {
                if (query.get(i).equals(query.get(j))) {
                    throw new IllegalArgumentException("Digits must be unique");
                }
            }
        }
        return query;
    }

    private int[] judge(List<Integer> query) {
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

    private void printResult(int[] result) {
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

    private boolean isCorrect(int[] result) {
        return result[0] == 3;
    }
}
