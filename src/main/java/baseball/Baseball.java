package baseball;

import baseball.number.Answer;
import baseball.number.UserInput;
import camp.nextstep.edu.missionutils.Console;

public class Baseball {

    Answer answer;
    UserInput userInput;
    Score score;

    // TODO 2. 야구게임 시작
    public void play(){

        // TODO 1. answer이 되는 숫자 생성
        answer = new Answer();

        while(true){

            // TODO 3. 사용자가 입력한 값 유효성검사, 저장
            System.out.print("숫자를 입력해주세요 : ");
            try{
                String str = Console.readLine();    // 입력값 Integer로 받기
                userInput = new UserInput(str);     // 유효성 검사, 저장
            } catch (IllegalStateException ex){
                gameover();
                break;
            }

            //TODO 4. 점수 내기
            score = new Score(answer, userInput);
            int[] scoreArr = score.checkScore(userInput);

            //TODO 5. 점수 출력 or 예외처리
            if (score.printScore(scoreArr)) break;
        }
    }

    public void gameover() {
        System.out.print("게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer re = Integer.parseInt(Console.readLine());
        if(re.equals(1)) play();
    }
}
