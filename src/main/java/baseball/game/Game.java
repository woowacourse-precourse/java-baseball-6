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
    public void next() {
        switch (this.status) {
            case START -> this.ready();
            case PROCEEDING -> this.proceed();
            case END -> this.choiceReStart();
            default -> throw new IllegalStateException("Unexpected value: " + this.status);
        }
    }

    /**
     * 사용자에게 입력받은 값을 검증하고 START와 EXIT로 상태변환
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
    public void proceed() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            NumberList userNumberList = new NumberList(userInput);
            if (compareNumbers(userNumberList)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                this.status = GameStatus.END;
                break;
            }
        }
    }

    /**
     * 사용자가 입력한 숫자리스트와 컴퓨터의 숫자리스트와 비교하여 볼, 스트라이크를 판별합니다.
     */
    public boolean compareNumbers(NumberList numberList) {
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
        this.printResult(ballCount, strikeCount);
        return strikeCount == BASEBALL_NUM_COUNT;
    }

    /**
     * 볼, 스트라이크 판별 결과를 출력합니다.
     */
    public void printResult(int ballCount, int strikeCount) {
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

    /**
     * 컴퓨터의 숫자리스트를 초기화하고 PROCEEDING상태로 상태변환합니다.
     */
    public void ready() {
        this.computerNumberList = new NumberList();
        while (computerNumberList.numbers.size() < BASEBALL_NUM_COUNT) {
            Number number = new Number(pickNumberInRange(1, 9));
            try {
                computerNumberList.add(number);
            } catch (IllegalArgumentException ignored) {
                //숫자 중복을 제외하고 다른 예외가 나오지 않기 때문에 괜찮습니다.
            }
        }
        this.status = GameStatus.PROCEEDING;
    }
}