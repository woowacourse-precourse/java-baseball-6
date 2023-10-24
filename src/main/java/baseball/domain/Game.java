package baseball.domain;

import baseball.domain.Computer;

import java.util.List;

public class Game {
    private int strikes;
    private int balls;
    private Computer computer;

    public Game() {
        // 게임 초기화 로직
        this.strikes =  0;
        this.balls = 0;
        this.computer = new Computer();
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

//    public List<Integer> getComputerNumbers() {
//        return computer.getAnswer(); // Computer 객체의 숫자를 가져옴
//    }

    // 게임의 결과를 업데이트하는 메서드
    public void updateGameResult(int[] userNumbers) {
        int[] result = calculateStrikesAndBalls(userNumbers);
        strikes = result[0];
        balls = result[1];
    }

    private int[] calculateStrikesAndBalls(int[] userNumbers) {
        int[] result = new int[2];
        List<Integer> computerNumbers = computer.getAnswer(); // Computer 객체에서 숫자 가져옴

        if (computerNumbers == null || computerNumbers.size() != 3) {
            throw new IllegalArgumentException("컴퓨터 숫자가 유효하지 않습니다.");
        }
        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers.get(i)) {
                result[0]++; // 스트라이크
            } else if (computerNumbers.contains(userNumbers[i])) {
                result[1]++; // 볼
            }
        }
        return result;
    }

    // 게임 초기화 메서드
    public void resetGame() {
        this.strikes = 0;
        this.balls = 0;
    }

    // 승리 여부를 판단하는 메서드
    public boolean isWin() {
        return strikes == 3;
    }


}


