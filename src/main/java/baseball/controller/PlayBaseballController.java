package baseball.controller;

import baseball.domain.GameScoreSet;
import baseball.domain.PlayBaseball;
import baseball.service.PlayBaseballService;
import camp.nextstep.edu.missionutils.Console;

public class PlayBaseballController {
    private final PlayBaseballService playBaseballService;
    private static final String initComment = "숫자 야구 게임을 시작합니다.";
    private static final String inputNumComment = "숫자를 입력해주세요 : ";
    private static final String threeStrikeComment = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String inputMenuComment = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public PlayBaseballController(){
        this.playBaseballService = new PlayBaseballService();
    }

    public void play(){
        do{
            //게임시작 출력문
            System.out.println(initComment);
            //서비스 클래스의 도메인 생성 메서드
            playBaseballService.playGame();
            String menu = "1";
            do{
                //숫자입력 출력문
                System.out.print(inputNumComment);
                //숫자 입력 메서드
                String inputNum = insertMethod();
                //스트라이크와 볼 점수 출력 메서드
                printStrikeAndBallScore(playBaseballService.showGameResult(inputNum));
                //3스트라이크인지 여부 확인 메서드
                Boolean hasThreeStrike = checkStrikeScore(playBaseballService.showGameResult(inputNum));
                if(hasThreeStrike){
                    System.out.println(inputMenuComment);
                    menu = insertMethod();
                }
            }while(playBaseballService.checkMenu(menu));



        }while(true);

    }
}
