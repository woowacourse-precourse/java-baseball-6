package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    int askQuery() {
        // TODO: Add Query Validation
        System.out.print("숫자를 입력해주세요 : ");
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
            int randomInt = randomList.get(0) * 100 + randomList.get(1) * 10 + randomList.get(2);

            // Run game
            Game game = new Game(randomInt);
            game.run();

            // Ask and restart or break.
            if (!askRestart())
                break;
        }
    }
}