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
        switch (this.status) {
            case START -> this.Ready();
            case PROCEEDING -> this.Proceed();
            case END -> this.choiceReStart();
            default -> throw new IllegalStateException("Unexpected value: " + this.status);
        }
    }

    /**
     * 사용자에게 입력받은 값을 검증하고 재시작과 종료로 상태변화
     */
    public void choiceReStart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (userInput.length() == 1) {
            Number number = new Number(userInput.charAt(0));
            if (number.num == 1) {
                this.status = GameStatus.START;
            } else if (number.num == 2) {
                this.status = GameStatus.EXIT;
            } else {
                throw new IllegalArgumentException("잘못된 값 입력");
            }
        } else {
            throw new IllegalArgumentException("잘못된 값 입력");
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