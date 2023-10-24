package baseball;

import java.util.List;

public class PlayGame {
    private int balls; // 볼의 개수를 저장할 변수
    private int strikes; // 스트라이크의 개수를 저장할 변수

    // 컴퓨터의 숫자와 유저의 숫자를 비교해 볼과 스트라이크의 개수를 확인한다
    public PlayGame(List<Integer> computerNumbers, List<Integer> userNumbers){
        for (int i = 0; i < computerNumbers.size(); i++){
            if(computerNumbers.get(i).equals(userNumbers.get(i))){
                strikes++;
            }
            else if(computerNumbers.contains(userNumbers.get(i))){
                balls++;
            }
        }
    }

    // 볼의 개수 반환
    public int getBalls(){
        return balls;
    }

    // 스트라이크의 개수 반환
    public int getStrikes() {
        return strikes;
    }

    // 게임 결과 반환
    public String getResult(){
        // 아무 것도 맞히지 못했을 때
        if(balls==0 && strikes==0){
            return "낫싱";
        }
        // 모두 맞았을 때
        if(strikes==3){
            return "3스트라이크";
        }
        // 위 두가지를 제외한 경우
        StringBuilder result = new StringBuilder(); //결과를 저장할 변수
        if(balls >0){
            result.append(balls).append("볼");
            if(strikes >0 ){
                result.append(" ");
            } // 스트라이크도 있을때 띄어쓰기
        }
        if(strikes > 0){
            result.append(strikes).append("스트라이크");
        }
        return result.toString().trim();
    }
}
