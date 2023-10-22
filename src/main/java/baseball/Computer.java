package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private String[] computerNumbers;
    private GameMachine gameMachine;
    // TODO: playerNumbers 멤버 변수 추가
    private static final int TOTAL_COMPUTER_NUMBERS = 3;

    // TODO: 게임 머신을 받아서 setting 하는 것으로 변경
    public void setGameMachine(String[] playerNumbers) {
        if (this.computerNumbers == null) {
            throw new IllegalStateException("computerNumbers shouldn't be NULL");
        }
        this.gameMachine = new GameMachine(this.computerNumbers, playerNumbers);
    }

    // TODO: 구동할 때 playerNumbers 를 받아서 구동하는 것으로 변경
    public GameResult activateMachine() {
        if (this.gameMachine == null) {
            throw new NullPointerException("gameMachine shouldn't be NULL");
        }
        return this.gameMachine.playGame();
    }

    // Computer 클래스가 Randoms 클래스에 의존함.
    // 변경될 가능성이 있거나 테스트에서 랜덤 값이 아닌 고정 값을 받는 경우 의존성 주입을 고려할 수 있음.
    public void pickComputerNumbers() {
        String[] pickedNumbers = new String[TOTAL_COMPUTER_NUMBERS];
        for (int count = 0; count < TOTAL_COMPUTER_NUMBERS; count++) {
            pickedNumbers[count] = String.valueOf(Randoms.pickNumberInRange(1, 9));
        }
        this.computerNumbers = pickedNumbers;
    }
}
