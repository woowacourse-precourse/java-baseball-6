package baseball;

import java.util.List;

//게임 전체 컨트롤
public class BaseBallGame {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";

    private NumberGenerator numberGenerator;
    private PlayerNumber playerNumber;

    private boolean allStrike;
    private boolean playOrNot;

    public BaseBallGame(){
        this.playOrNot = true;
        this.allStrike = false;
    }
    //최초 실행
    public void playGame(){
        System.out.println(GAME_START);

        //게임 실행 메소드 호출
        while (playOrNot) {
            //랜덤 숫자 생성
            numberGenerator = NumberGenerator.generateComputer();
            System.out.println(numberGenerator.getComputer());

            //게임 실행
            runGame();

            //게임 재시작/종료 입력
        }
    }

    //게임 실행
    public void runGame(){
        while (!allStrike) {
            //입력 받기
            playerNumber = PlayerNumber.inputPlayer();

            //결과 계산 및 출력
            Result result = new Result();
            int strike = result.resultGame(numberGenerator.getComputer(), playerNumber.getPlayer());

            //allStrike 확인
            if (strike == 3){
                allStrike = true;
            }
        }
    }

}
