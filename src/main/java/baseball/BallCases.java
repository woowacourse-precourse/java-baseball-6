package baseball;

public class BallCases extends StrikeAndBall {
    public BallCases() {
    }

    public void checkingNoStrikes (int strkies , int correctBalls){

        if(correctBalls>0){
            if(strkies == 0){
            System.out.println(correctBalls + "볼");
            }
        }
    }

    public boolean checkingThreeStrike(int strikes) {

        boolean allStrikes = false;

        if(strikes == 3) {
            System.out.println(strikes + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            allStrikes = true;
        }
        return allStrikes;
    }

    public boolean allCorrectBallIsStrike(int strikes, int correctBalls){

        boolean allBallisStrkie = false;

        if(correctBalls>0){
            if(correctBalls - strikes == 0){
                System.out.println(strikes + "스트라이크");
                allBallisStrkie = true;
            }
        }

        return allBallisStrkie;
    }

    public void correctBallsAndStrikes(int strikes, int correctBalls){
        System.out.print((correctBalls - strikes) + "볼");
        System.out.print(" ");
        System.out.println(strikes + "스트라이크");
    }

    public void nothingCorrect(int correctBalls){
        if(correctBalls == 0){
            System.out.println("낫싱");
        }
    }

}
