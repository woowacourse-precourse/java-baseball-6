package baseball;

import java.util.List;

public class Result {
    private Integer strikeCount;
    private Integer ballCount;

    public void init(){
        strikeCount = 0;
        ballCount = 0;
    }

    public void compare(List<Integer> computerNumbs, List<Integer> userNumbs){
        init();
        for(int i=0; i<3; i++){
            if(computerNumbs.get(i).equals(userNumbs.get(i))){ //strike 판별
                computerNumbs.set(i, 0);
                strikeCount++;
            }
            if(userNumbs.contains(computerNumbs.get(i))){ //ball 판별
                ballCount++;
            }
        }
        printResult();
    }

    public void printResult(){
        String prompt;
        if(strikeCount == 3){
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

    public boolean findAnswer(){
        if(strikeCount == 3){
            return true;
        }
        return false;
    }
}
