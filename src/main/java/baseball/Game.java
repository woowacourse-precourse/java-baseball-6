package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private int gameFlag;
    private StringBuilder computerNumber;
    private StringBuilder userNumber;

    int[] scoreBoard = {0, 0};
    Game() {}

    /*
    * setter
    * Game Class의 멤버 변수들에 대한 set method이다.
    * 멤버 변수들 모두 외부에서는 set할 수 없도록 접근제어자는 private으로 설정한다.
    * */
    private void setGameFlag(int gameFlag) {
        this.gameFlag = gameFlag;
    }

    private void setComputerNumber(StringBuilder computerNumber) {
        this.computerNumber = computerNumber;
    }

    private void setUserNumber(StringBuilder userNumber) {
        this.userNumber = userNumber;
    }
    //

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.gameFlag = 1;
        this.generateComputerNumber();

        while(this.gameFlag == 1) {
            this.inputUserNumber();
            this.updateScoreBoard();
            this.printGameResult();
        }
    }

    // Generate Computer Number
    private void generateComputerNumber() {
        StringBuilder computerNumber = new StringBuilder();
        for(int i = 0; i < 3 ; i++) {
            computerNumber.append(Randoms.pickNumberInRange(1, 9));
        }
        this.computerNumber = computerNumber;
    }

    // Input User Baseball Number
    private void inputUserNumber() {
        this.scoreBoard = new int[]{0, 0};
        System.out.print("숫자를 입력해주세요 : ");
        StringBuilder userNumber = new StringBuilder(Console.readLine());
        System.out.println(userNumber);
        this.validationCheckUserNumber(userNumber);
        this.userNumber = userNumber;

    }

    private void updateScoreBoard() {
        for(int i = 0; i < 3 ; i++) {
            String userSubNum = this.userNumber.substring(i , i+1);
            if(this.computerNumber.indexOf(userSubNum) > -1) {
                if(this.computerNumber.substring(i, i+1).equals(userSubNum)) {
                    this.scoreBoard[1]++;
                } else {
                    this.scoreBoard[0]++;
                }
            }
        }
    }

    private void validationCheckUserNumber(StringBuilder userNumber) {
        // 1. 자리수 세자리
        if(userNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < 3 ; i++) {
            if(!(userNumber.substring(i, i+1).charAt(0) >= 49 && userNumber.substring(i, i+1).charAt(0) <= 57)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void printGameResult() {
        if(this.scoreBoard[1] == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            // updateGameFlag
            this.updateGameFlag();

            if(this.gameFlag == 1) {
                // generateComputerNumber();
                this.generateComputerNumber();
            }
        } else if(this.scoreBoard[0] + this.scoreBoard[1] == 0) {
            System.out.println("낫싱");
        } else if(this.scoreBoard[0] > 0 && this.scoreBoard[1] > 0) {
            System.out.println(this.scoreBoard[0]+"볼 "+this.scoreBoard[1]+"스트라이크");
        } else if(this.scoreBoard[0] > 0) {
            System.out.println(this.scoreBoard[0]+"볼");
        } else {
            System.out.println(this.scoreBoard[1]+"스트라이크");
        }
    }

    private void updateGameFlag() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
        String gameFlag = Console.readLine();
        this.validationCheckReGame(gameFlag);
        this.gameFlag = Integer.parseInt(gameFlag);
    }

    private void validationCheckReGame(String gameFlag) {
        if(!(gameFlag.charAt(0) == 49 || gameFlag.charAt(0) == 50)) {
            throw new IllegalArgumentException();
        }
    }
}
