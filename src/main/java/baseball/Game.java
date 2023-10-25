package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

record QueryResult(int balls, int strikes) {
}


public class Game {
    private final List<Integer> answer;

    Game(List<Integer> answer) {
        this.answer = answer;
    }

    public void run() {
        while (true) {
            List<Integer> query = this.askQuery();
            QueryResult result = this.judge(query);
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

        int[] digits = {queryInt / 100, (queryInt / 10) % 10, queryInt % 10};
        List<Integer> query = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (digits[i] < 1 || digits[i] > 9) {
                throw new IllegalArgumentException("Digits must be ranged 1 to 9");
            }
            if (query.contains(digits[i])) {
                throw new IllegalArgumentException("Digits must be unique");
            }
            query.add(digits[i]);
        }
        return query;
    }

    private QueryResult judge(List<Integer> query) {
        int balls = 0;
        int strikes = 0;

        // Ball judgement
        Set<Integer> answerSet = new HashSet<>(this.answer);
        Set<Integer> querySet = new HashSet<>(query);

        querySet.retainAll(answerSet);
        balls = querySet.size();

        // Strike judgement
        for (int i = 0; i < 3; i++) {
            if (query.get(i).equals(this.answer.get(i))) {
                balls -= 1;
                strikes += 1;
            }
        }

        return new QueryResult(balls, strikes);
    }

    private void printResult(QueryResult result) {
        if (result.balls() > 0 && result.strikes() > 0) {
            System.out.println(result.balls() + "볼 " + result.strikes() + "스트라이크");
        } else if (result.strikes() > 0) {
            System.out.println(result.strikes() + "스트라이크");
        } else if (result.balls() > 0) {
            System.out.println(result.balls() + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    private boolean isCorrect(QueryResult result) {
        return result.strikes() == 3;
    }
}
