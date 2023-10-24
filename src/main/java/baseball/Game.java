package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    // 멤버 변수
    private int gameFlag;
    private StringBuilder computerNumber;
    private StringBuilder userNumber;
    private int[] scoreBoard = {0, 0};

    // 상수
    // 게임을 진행한다는 의미의 상수
    private static final int GAME_START = 1;

    // 게임을 끝낸다는 의미의 상수
    private static final int GAME_END = 2;

    // Baseball Game Number의 최대 사이즈
    private static final int MAX_LENGTH = 3;

    // Baseball Game 숫자 범위
    private static final int FIRST_RANGE_NUMBER = 1;
    private static final int LAST_RANGE_NUMBER = 9;

    // ASCII CODE
    private static final int ASCII_GAME_START = 49;
    private static final int ASCII_GAME_END = 50;

    private static final int ASCII_FIRST_RANGE_NUMBER = 49;
    private static final int ASCII_LAST_RANGE_NUMBER = 57;
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

    private void setScoreBoard() {
        StringBuilder userNumber = this.getUserNumber();
        StringBuilder computerNumber = this.getComputerNumber();
        for(int i = 0; i < MAX_LENGTH ; i++) {
            String userSubNum = userNumber.substring(i , i+1);
            if(computerNumber.indexOf(userSubNum) > -1) {
                if(computerNumber.substring(i, i+1).equals(userSubNum)) {
                    this.scoreBoard[1]++;
                } else {
                    this.scoreBoard[0]++;
                }
            }
        }
    }
    //

    /* getter */
    private StringBuilder getComputerNumber() {
        return this.computerNumber;
    }

    private StringBuilder getUserNumber() {
        return this.userNumber;
    }

    private int getGameFlag() {
        return this.gameFlag;
    }

    private int[] getScoreBoard() {
        return this.scoreBoard;
    }
    //

    // scoreBoard 초기화 메소드
    private void initializeScoreBoard() {
        this.scoreBoard[0] = 0;
        this.scoreBoard[1] = 0;
    }

    // Print Method
    // System.out.print 함수 대신 사용
    private static void print(String content) {
        System.out.print(content);
    }

    public void start() {
        print("숫자 야구 게임을 시작합니다.\n");
        setGameFlag(GAME_START);
        this.generateComputerNumber();

        while(this.gameFlag == GAME_START) {
            this.inputUserNumber();
            this.setScoreBoard();
            this.printGameResult();
        }
    }

    // Generate Computer Number
    private void generateComputerNumber() {
        StringBuilder computerNumber = new StringBuilder();
        for(int i = 0; i < MAX_LENGTH ; i++) {
            computerNumber.append(Randoms.pickNumberInRange(FIRST_RANGE_NUMBER, LAST_RANGE_NUMBER));
        }
        this.setComputerNumber(computerNumber);
    }

    // Input User Baseball Number
    private void inputUserNumber() {
        this.initializeScoreBoard();
        print("숫자를 입력해주세요 : ");
        StringBuilder userNumber = new StringBuilder(Console.readLine());
        print(userNumber+"\n");
        this.validationCheckUserNumber(userNumber);
        this.setUserNumber(userNumber);
    }

    private void validationCheckUserNumber(StringBuilder userNumber) {
        // 1. 자리수 세자리
        if(userNumber.length() != MAX_LENGTH) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < MAX_LENGTH; i++) {
            char c = userNumber.substring(i, i+1).charAt(0);
            if (!( c >= ASCII_FIRST_RANGE_NUMBER
                    && c <= ASCII_LAST_RANGE_NUMBER)
            ) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void printGameResult() {
        int[] _scoreBoard = this.getScoreBoard();
        int ball = _scoreBoard[0];
        int strike = _scoreBoard[1];
        int gameFlag = this.getGameFlag();

        if(strike == MAX_LENGTH) {
            print("3스트라이크\n");
            print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");

            // updateGameFlag
            this.updateGameFlag();

            if(gameFlag == GAME_START) {
                // generateComputerNumber();
                this.generateComputerNumber();
            }
        } else if(ball + strike == 0) {
            print("낫싱\n");
        } else if(ball > 0 && strike > 0) {
            print(ball + "볼 " + strike + "스트라이크\n");
        } else if(ball> 0) {
            print(ball + "볼\n");
        } else {
            print(ball + "스트라이크\n");
        }
    }

    private void updateGameFlag() {
        print("게임을 새로 시작하려면 " + GAME_START + ", 종료하려면 " + GAME_END + "를 입력해주세요.\n");
        String gameFlag = Console.readLine();
        this.validationCheckReGame(gameFlag);
        this.setGameFlag(Integer.parseInt(gameFlag));
    }

    private void validationCheckReGame(String gameFlag) {
        int _gameFlag = gameFlag.charAt(0);
        if (!(_gameFlag == ASCII_GAME_START
                || _gameFlag == ASCII_GAME_END)
        ) {
            throw new IllegalArgumentException();
        }
    }
}
