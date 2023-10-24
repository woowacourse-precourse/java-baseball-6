package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int TOTAL_COMPUTER_NUMBERS = 3;
    private String[] computerNumbers;
    private String[] playerNumbers;
    private GameMachine gameMachine;
    String[] pickedNumbers = new String[TOTAL_COMPUTER_NUMBERS];

    public String[] getComputerNumbers() {
        return computerNumbers;
    }

    public void setPlayerNumbers(String[] playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void setGameMachine(GameMachine newGameMachine) {
        this.gameMachine = newGameMachine;
    }

    public void changeGameMachinePlayerNumbers() {
        this.gameMachine.setPlayerNumbers(this.playerNumbers);
    }

    public GameResult activateMachine() {
        if (this.gameMachine == null) {
            throw new NullPointerException("NULL인 GameMachine을 가동하려 했습니다.");
        }
        return this.gameMachine.playGame();
    }

    // Computer 클래스가 Randoms 클래스에 의존함.
    // 변경될 가능성이 있거나 테스트에서 랜덤 값이 아닌 고정 값을 받는 경우 의존성 주입을 고려할 수 있음.
    public void pickComputerNumbers() {
        for (int count = 0; count < TOTAL_COMPUTER_NUMBERS; count++) {
            pickedNumbers[count] = String.valueOf(Randoms.pickNumberInRange(1, 9));
        }
        if (pickedNumbers[0].equals(pickedNumbers[1]) || pickedNumbers[0].equals(pickedNumbers[2])
                || pickedNumbers[1].equals(pickedNumbers[2])) {
            this.pickComputerNumbers();
        }
        this.computerNumbers = pickedNumbers;
    }
}
