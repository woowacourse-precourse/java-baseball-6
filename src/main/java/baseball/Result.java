package baseball;

public class Result {
    private int strike, ball;
    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    } // strike와 ball이라는 객체를 받아옴

    public boolean isReGame() {
        if(strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        } // 스트라이크가 3개일 때 출력 값
        else if(strike == 0 && ball > 0){
            System.out.println(ball + "볼");
        } // 스트라이크가 없을 때 출력 값
        else if (strike > 0 && ball == 0){
            System.out.println(strike + "스트라이크");
        }// 볼이 없을 때 출력 값
        else if(strike > 0 && ball > 0){
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } // 스트라이크와 볼 둘 다 있을 때 출력 값
        else {
            System.out.println("낫싱");
        } // 그 무엇도 없을 대 출력 값
        return false;
        // 정답을 못맞췄으므로, 다시 User가 번호를 입력하도록 false 리턴
    }
}
