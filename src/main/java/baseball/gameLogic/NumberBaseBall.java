package baseball.gameLogic;

import baseball.models.Score;

import java.util.List;

import static baseball.userInterface.MessageViewer.*;
import static baseball.utils.Constants.*;

/*
  게임 구동을 담당하는 메인 클래스
*/

public class NumberBaseBall {
    NumberChecker numberChecker;
    ComputerAction computerAction;
    UserAction userAction;
    Score score;

    List<Integer> computerNumList, userNumList;

    int gameStatus;

    /*
    멤버 초기화
     */
    public void init(){
        numberChecker = new NumberChecker();
        computerAction = new ComputerAction();
        userAction = new UserAction();

        gameStatus = WANNA_KEEP_PLAYING;
    }

    /*
    게임을 구동하는 함수
    1. 컴퓨터 난수 생성 요청
    2. 시작 문장 출력 요청
    3. 유저 입력 요청
    4. 점수 도출 요청
    5. 점수 출력 요청
    6. 게임을 계속 진행할 지 확인
    이하 3. ~  6. 반복
     */
    public void run(){
        generateComputerNumber();
        printStartMsg();

        while (gameStatus == WANNA_KEEP_PLAYING){
            getUserAnswer();
            getScore();
            printResultMsg(score.ballCount, score.strikeCount);
            checkKeepPlaying();
        }
    }

    /*
    아래 함수들의 기능은 함수 이름과 동일
     */
    public void getScore(){
        score = numberChecker.checkNumber(userNumList, computerNumList);
    }

    public void getUserAnswer(){
        userAction.inputAnswer();
        userNumList = userAction.showNumberList();
    }

    public void checkKeepPlaying(){
        userAction.clearAnswer();

        if (score.strikeCount == MAX_STRIKES) {
            printGameEndMsg();

            userAction.inputRestartFactor();
            gameStatus = userAction.showMind();

            generateComputerNumber();
        }
    }

    public void generateComputerNumber(){
        if (gameStatus == WANNA_KEEP_PLAYING) {
            computerAction.clearAnswer();
            computerAction.generateNumber();
            computerNumList = computerAction.showNumberList();
        }
    }

}
