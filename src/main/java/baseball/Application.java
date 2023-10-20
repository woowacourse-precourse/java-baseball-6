package baseball;

import camp.nextstep.edu.missionutils.Console;

class Game {
    public int answer;
    Game(int answer) {
        this.answer = answer;
    }

    void run() {
        // TODO: implement
    }

    int askQuery() {
        // TODO: Add Query Validation
        int query = Integer.parseInt(Console.readLine());
        return query;
    }

    int[] judge(int query) {
        int[] result = {0, 0};

        int[] queryDigit = {
                this.answer % 10,
                (this.answer / 10) % 10,
                (this.answer / 100) % 10};
        int[] answerDigit = {
                this.answer % 10,
                (this.answer / 10) % 10,
                (this.answer / 100) % 10};

        // Strike judgement
        for (int i = 0; i < 3; i++) {
            if (queryDigit[i] == answerDigit[i]) {
                result[0] += 1;
                queryDigit[i] = 0;
                answerDigit[i] = 0;
            }
        }

        // Ball judgement
        boolean[] queryDigitDistribution = new boolean[10];
        boolean[] answerDigitDistribution = new boolean[10];
        for (int i = 0; i < 10; i++) {
            queryDigitDistribution[i] = false;
            answerDigitDistribution[i] = false;
        }
        for (int i = 0; i < 3; i++) {
            queryDigitDistribution[queryDigit[i]] = true;
            answerDigitDistribution[answerDigit[i]] = true;
        }
        for (int i = 1; i < 10; i++) {
            if (queryDigitDistribution[i] & answerDigitDistribution[i])
                result[1]++;
        }

        return result;
    }
}


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}