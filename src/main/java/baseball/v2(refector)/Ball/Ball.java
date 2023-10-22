package baseball.Ball;

public class Ball {
    private final int number;  //절대 변하지 않는 공 번호

    Ball(char inputBallNumber) {
        number = checkBallNumber(inputBallNumber); //공 번호를 받아서 체크, 맞으면 넣음
    }

    public Ball(int inputBallNumber){
        number = inputBallNumber;
    }

    private static int checkBallNumber(char inputBallNumber) { // 1~9가 아니면 몽땅 에러
        int ballNumber = inputBallNumber - '0';
        if (ballNumber < 1 || ballNumber > 9) {
            throw new IllegalArgumentException();
        }
        return ballNumber;

    }
}
