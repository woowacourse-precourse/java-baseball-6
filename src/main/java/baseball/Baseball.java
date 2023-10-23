package baseball;
import baseball.number.Answer;
import baseball.number.UserInput;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    List<Integer> answer;
    List<Integer> inputList;

    // TODO 2. 야구게임 시작
    public void play(){

        // TODO 1. answer이 되는 숫자 생성
        answer = new ArrayList<>();
        while(answer.size() < 3){
            Integer randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }

        while(true){

            // TODO 3. 사용자가 입력한 값 유효성검사, 저장
            System.out.print("숫자를 입력해주세요 : ");
            try{
                String str = Console.readLine();
                if(str.length()!=3){
                    throw new IllegalArgumentException();       //길이 관련 예외처리
                }
                Integer input = Integer.parseInt(str);       // 입력값 Integer로 받기
                inputList = integerToList(input);     //Integer를 List<Integer>로 저장하기
                validateNum(inputList);     // 유효성 검사
            } catch (IllegalStateException ex){
                gameover();
                break;
            }

            //TODO 4. 점수 내기
            List<Integer> score = checkScore(inputList);

            //TODO 5. 점수 출력 or 예외처리
            if(score.get(0).equals(3)) {
                System.out.print("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! ");
                gameover();
                break;
            }
            if(score.get(0).equals(0) && score.get(1).equals(0)){
                System.out.print("낫싱");
            }
            if(!score.get(1).equals(0)){
                System.out.print(score.get(1)+"볼 ");
            }
            if(!score.get(0).equals(0)){
                System.out.print(score.get(0)+"스트라이크");
            }
            System.out.println();

        }
    }

    private void gameover() {
        System.out.print("게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Integer re = Integer.parseInt(Console.readLine());
        if(re.equals(1)) play();
        return;
    }

    List<Integer> checkScore(List<Integer> userInput){
        List<Integer> score = new ArrayList<>();
        int strikeNum = 0;
        int ballNum = 0;
        for (int i = 0; i < 3; i++) {
            if(userInput.get(i).equals(answer.get(i))) strikeNum++;
        }
        for (int i = 0; i < 3; i++) {
            if(answer.contains(userInput.get(i))) ballNum++;
        }
        ballNum -= strikeNum;
        score.add((Integer) strikeNum);
        score.add((Integer) ballNum);
        return score;
    }

    public static List<Integer> integerToList(Integer input){
        List<Integer> userInput = new ArrayList<>();
        userInput.add(input/100);
        userInput.add(input/10%10);
        userInput.add(input%10);
        return userInput;
    }

    //입력값 유효성 검사
    public static void validateNum(List<Integer> input){
        System.out.println(input.size());
        //숫자 길이가 3
        if(input.size()!=3){
            throw new IllegalArgumentException();
        }
        //0이 포함되면 안됨
        if(input.contains(0)){
            throw new IllegalArgumentException();
        }
        //3개의 수 중에서 겹치는게 없다.
        if(input.get(0).equals(input.get(1)) || input.get(1).equals(input.get(2)) ||
                input.get(0).equals(input.get(2))){
            throw new IllegalArgumentException();
        }
    }
}
