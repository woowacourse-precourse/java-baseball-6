package baseball.game;

import static baseball.game.Constant.BASEBALL_NUM_COUNT;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public GameStatus status;
    NumberList computerNumberList;

    public Game() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.status = GameStatus.START;
    }

    public void Next() {
        System.out.println(this.status);
        switch (this.status) {
            case START -> this.Ready();
            case PROCEEDING -> {

                String tempInput = Console.readLine();
                try {
                    NumberList numbers = new NumberList(tempInput);
//                    for (Number number : numbers.numbers) {
//                        System.out.println(number.num);
//                    }
                    for (Number number : this.computerNumberList.numbers) {
                        System.out.println(number.num);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.toString());
                }
            }
            case END -> {
                this.status = GameStatus.EXIT;
            }
            case EXIT -> {
            }
            default -> throw new IllegalStateException("Unexpected value: " + this.status);
        }
    }


    public void Ready() {
        this.computerNumberList = new NumberList();
        while (computerNumberList.numbers.size() < BASEBALL_NUM_COUNT) {
            Number number = new Number(pickNumberInRange(1, 9));
            try {
                computerNumberList.add(number);
            } catch (IllegalArgumentException ignored) {
            }
        }
        this.status = GameStatus.PROCEEDING;
    }
}