package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> answer;


    /**
     * answer에 서로 다른 3개의 정수를 가진 List<Integer>을 저장
     */
    public void init(){
        answer = new ArrayList<>();
        while(answer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    /**
     * 사용자의 입력에 대한 결과 반환
     * @param input 사용자가 입력한 서로 다른 3개의 숫자 리스트
     * @return 사용자의 입력과 answer를 비교한 결과 리스트
     */
    public Result getResult(List<Integer> input){

        if(input.size() != 3){
            throw new IllegalArgumentException("사용자의 입력 숫자는 정확히 3개여야 합니다.");
        }

        Result result = new Result();
        for (int i = 0; i < 3; i++) {
            int number = input.get(i);
            if (answer.get(i).equals(number)) {
                result.addStrike();
            } else if (answer.contains(number)) {
                result.addBall();
            }
        }
        return result;
    }

    //== 테스트용 메서드 ==//

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(int[] list) {
        answer = new ArrayList<>();
        for (int i : list) {
            answer.add(i);
        }
    }
}
