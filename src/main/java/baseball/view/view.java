package baseball.view;

import static baseball.domain.AnswerFactory.ANSWER_SIZE;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Referee;
import baseball.domain.convert.BaseballConverter;

public class view {

    BaseballConverter converter = new BaseballConverter();

    public void startView(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void endView() {
        System.out.println("게임 종료");
    }

    public int initView(){
       try{
           System.out.print("숫자를 입력해주세요 : ");
           String initNumber = readLine();

           if(initNumber.contains("0")|| initNumber.length() != ANSWER_SIZE){
               throw new IllegalArgumentException("0이 포함되어 있습니다.");
           }

           return Integer.parseInt(initNumber);

       }catch (Exception e) {
            e.printStackTrace();
            throw  new IllegalArgumentException("잘못된 입력입니다.");
       }
    }

    public int restartView(){
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int initNumber = Integer.parseInt(readLine());
            if ( initNumber< 1 || initNumber >2) {
                throw new IllegalArgumentException();
            }

            return initNumber;

        }catch (Exception e) {
            e.printStackTrace();
            throw  new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void resultTextView(Referee referee){
        if(referee.judgment()){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }else if(referee.judgmentZero()){
            System.out.println("낫싱");
        }else{
            System.out.println(converter.convertRefereeToScoreTextView(referee));
        }
    }
}