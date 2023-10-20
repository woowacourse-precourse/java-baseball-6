package baseball;

import camp.nextstep.edu.missionutils.Console;

class Game {
    public int answer;
    Game(int answer) {
        this.answer = answer;
    }

    void run() {
        // TODO: print as spec format
        while(true) {
            int query = this.askQuery();
            int[] result = this.judge(query);
            System.out.println(result[0] + "스트라이크 " + result[1] + "볼");
            if (result[0] == 3) {
                System.out.println("게임 종료");
                break;
            }
        }
    }

    int askQuery() {
        // TODO: Add Query Validation
        int query = Integer.parseInt(Console.readLine());
        return query;
    }

    int[] judge(int query) {
        int[] result = {0, 0};

        int[] queryDigit = {
                query % 10,
                (query / 10) % 10,
                (query / 100) % 10};
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