package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameManager {

    private int[] position;
    private int strike;
    private int ball;

    private final static int QUIZ_LENGTH = 3;

    private final static String START_COMMENT = "숫자 야구 게임을 시작합니다.";
    private final static String GUIDE_COMMENT = "숫자를 입력해주세요 : ";
    private final static String CORRECT_COMMENT = QUIZ_LENGTH+"개의 숫자를 모두 맞히셨습니다!";
    private final static String END_COMMENT = " 게임 종료";
    private final static String RESTART_COMMENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final static String NOTHING_SCORE = "낫싱";
    private final static String BALL_SCORE = "볼";
    private final static String STRIKE_SCORE = "스트라이크";
    GameManager(){
        gameInit();
    }
    public void gameInit(){
        position = new int[10];
        setResult();
    }
    private void setResult(){
        int cnt = 0;
        do {
            int num = Randoms.pickNumberInRange(1, 9);
            if (position[num]==0){
                position[num] = ++cnt;
            }
        }while(cnt<3);
    }

    public int startGames(){
        System.out.println(START_COMMENT);
        do{
            playGames();
        }while(printScore());

        System.out.println(END_COMMENT);
        System.out.println(RESTART_COMMENT);
        String answer = Console.readLine();
        if(!answer.equals("1") && !answer.equals("2"))
            throw new IllegalArgumentException();
        return answer.charAt(0)-0x30;
    }

    public void playGames(){
        ball = 0;
        strike = 0;
        System.out.print(GUIDE_COMMENT);
        String answer = Console.readLine();
        if(answer.length()!=QUIZ_LENGTH) throw new IllegalArgumentException();
        for(int i=0;i<QUIZ_LENGTH;i++){
            char num = answer.charAt(i);
            setScore(num-0x30,i+1);
        }
    }
    // 점수 매기기
    private void setScore(int num, int pos){
        try{
            if(position[num]==pos) {
                strike++;
                return;
            }
            if(position[num]!=0){
                ball++;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            throw new IllegalArgumentException();
        }
    }
    // 출력문구 생성
    private String setPrint(){
        String scorePrint = "";
        if(ball!=0)
            scorePrint = ball+BALL_SCORE;
        if(ball!=0 && strike!=0)
            scorePrint += " ";
        if(strike!=0)
            scorePrint += strike+STRIKE_SCORE;
        if(ball==0 && strike ==0)
            scorePrint = NOTHING_SCORE;
        return scorePrint;
    }
    // 문구 출력 및 종료 여부 확인
    private boolean printScore(){
        System.out.println(setPrint());
        if( strike==3 ) {
            System.out.print(CORRECT_COMMENT);
            return false;
        }
        return true;
    }
}
