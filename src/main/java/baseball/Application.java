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
}


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}