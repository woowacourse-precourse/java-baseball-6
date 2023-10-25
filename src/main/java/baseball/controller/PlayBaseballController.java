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
    private static final String gameOverComment = "게임 종료";
    public PlayBaseballController(){
        this.playBaseballService = new PlayBaseballService();
    }

    public void play(){
        String menu = "1";
        do{
            //게임시작 출력문
            printComment(initComment);
            //서비스 클래스의 도메인 생성 메서드
            playBaseballService.playGame();
            String result = "";
            do{
                //숫자입력 출력문
                printComment(inputNumComment);
                //사용자 숫자 입력
                String inputNum = insertMethod();
                //스트라이크와 볼 점수 출력 메서드
                result = DefineStrikeAndBallScore(playBaseballService.showGameResult(inputNum));
                printScore(result);
            }while(!checkStrikeScore(result)); //3스트라이크인지 여부 확인 메서드

            //게임 재시작 또는 게임 종료 여부 입력
            System.out.println(inputMenuComment);
            menu = insertMethod();

        }while(checkMenuRestart(menu));
        printComment(gameOverComment);

    }

    public void printComment(String comment){
        System.out.println(comment);
    }

    public String insertMethod(){
        return Console.readLine();
    }

    public String DefineStrikeAndBallScore(GameScoreSet gameScoreSet){
        int ballScore = gameScoreSet.getBallNum();
        int strikeScore = gameScoreSet.getStrikeNum();
        String result = "";
        if(checkIsNotShing(ballScore, strikeScore)) return "낫싱";

        if(ballScore >0) result += ballScore + "볼 ";
        if(strikeScore >0) result += strikeScore + "스트라이크";
        return result;
    }

    public boolean checkIsNotShing(int ballScore, int strikeScore){
        return ballScore == 0 && strikeScore == 0;
    }

    public void printScore(String result){
        System.out.println(result);
    }

    public boolean checkStrikeScore(String result){
        return result.equals("3스트라이크");
    }

    public boolean checkMenuRestart(String menu){
        return menu.equals("1");
    }

}
