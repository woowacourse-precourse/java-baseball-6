package baseball;

public class BaseBall {
    private Ball userBall = new Ball();
    private Ball comBall = new Ball();
    private Referee referee = new Referee();
    public void startService(){
        do {
            startGame();
            // outputPrint로부터 게임의 최종결과를 출력함
        }while();  // inputPrint로부터 게임을 계속할지 여부를 받아옴 return boolean 값으로 판단하는 부분
    }
    public void startGame(){
        comBall.createRandBall();

        do {
            userBall.createUserBall(); // InputPrint로부터 유저의 응답을 받아옴
            // ErrorCatcher로부터 에러 여부 검사
            referee.judge(userBall, comBall); // temp -> OutPrint로 보냄
            // 게임 결과를 출력하는 부분 -> OutputPrint
        }while(referee.getStrike() < 3);
    }
}
