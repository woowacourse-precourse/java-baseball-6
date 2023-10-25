package baseball;

public class NumberBaseballGame {

    private final Computer computer;

    public NumberBaseballGame() {
        this.computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printGameResult(int[] score) {
        StringBuilder result = new StringBuilder();
        if (score[1] != 0) {
            result.append(score[1]);
            result.append('볼');
        }
        if (score[0] != 0) {
            if (!result.isEmpty()) {
                result.append(' ');
            }
            result.append(score[0]);
            result.append("스트라이크");
        }
        if (result.isEmpty()) {
            result.append("낫싱");
        }
        System.out.println(result);
    }

    private boolean gameOver(int[] score) {
        if (score[0] == Constants.NUMBER_SIZE) {
            System.out.println(Constants.NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (UserInput.getUserRestart()) {
                this.computer.resetNumber();
                return false;
            } else {
                System.out.println("게임 종료");
                return true;
            }
        }
        return false;
    }

    public void gameLoop() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int[] score = this.computer.getResult(UserInput.getUserNumber());
            printGameResult(score);
            if (gameOver(score)) {
                break;
            }
        }
    }
}