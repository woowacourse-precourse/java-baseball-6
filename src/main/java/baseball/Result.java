package baseball;

import java.util.List;

public class Result {
    private Integer strikeCount;
    private Integer ballCount;
    private boolean isAnswer = false;

    public void init(){
        strikeCount = 0;
        ballCount = 0;
        isAnswer = false;
    }

    public boolean getIsAnswer(){
        return isAnswer;
    }

    public boolean compare(List<Integer> computerNumbs, List<Integer> userNumbs){
        init();
        for(int i=0; i<3; i++){
            if(computerNumbs.get(i).equals(userNumbs.get(i))){ //strike 판별
                strikeCount++;
            }
            for(int j=i+1; j<3; j++){
                if(computerNumbs.get(i).equals(userNumbs.get(j))){ //ball 판별
                    ballCount++;
                }
            }
        }
        printResult();
        return isAnswer;
    }

    public void printResult(){
        String prompt;
        if(strikeCount == 3){
            isAnswer = true;
            prompt = "3스트라이크\n";
            prompt += "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }else if(strikeCount == 0 && ballCount == 0){
            prompt = "낫싱";
        }else if(strikeCount == 0){
            prompt = ballCount + "볼";
        }else if(ballCount == 0){
            prompt = strikeCount + "스트라이크";
        }else{
            prompt = ballCount + "볼 " + strikeCount + "스트라이크";
        }
        System.out.println(prompt);
    }
}
