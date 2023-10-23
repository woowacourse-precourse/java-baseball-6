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

    /**
     * 상태에 따른 게임 진행
     */
    public void Next() {
        System.out.println(this.status);
        switch (this.status) {
            case START -> this.Ready();
            case END -> {
                this.status = GameStatus.EXIT;
            }
            case PROCEEDING -> this.Proceed();
            default -> throw new IllegalStateException("Unexpected value: " + this.status);
        }
    }

    /**
     * 3개의 숫자를 모두 맞출 때까지 사용자에게 숫자 입력을 받습니다.
     */
    public void Proceed() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            NumberList userNumberList = new NumberList(userInput);
            if (CompareNumbers(userNumberList)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                this.status = GameStatus.END;
                break;
            }
        }
    }

    public boolean CompareNumbers(NumberList numberList) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < BASEBALL_NUM_COUNT; i++) {
            Number curNumber = this.computerNumberList.numbers.get(i);
            for (int i1 = 0; i1 < BASEBALL_NUM_COUNT; i1++) {
                if (curNumber.equals(numberList.numbers.get(i1))) {
                    if (i == i1) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                    break;
                }
            }
        }
        this.PrintResult(ballCount, strikeCount);
        return strikeCount == BASEBALL_NUM_COUNT;
    }

    public void PrintResult(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else {
            if (ballCount != 0) {
                System.out.printf("%d볼 ", ballCount);
            }
            if (strikeCount != 0) {
                System.out.printf("%d스트라이크", strikeCount);
            }
            System.out.print("\n");
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