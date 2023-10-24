package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    public static void numberBaseball(List<Integer> answer){
        //사용자 입력값 받기
        System.out.print("숫자를 입력해주세요 : ");
        String inputValue = readLine();

        //사용자가 잘못된 값을 입력한 경우 오류 던지기
        //숫자가 아니거나, 길이가 3이 아니거나
        if (!inputValue.matches("\\d{3}")){
            throw new IllegalArgumentException();
        }

        //문자열 문자 배열로 변경
        char[] inputNum = inputValue.toCharArray();
        //스트라이크 판단했는지 보는 배열
        int[] visitedOfStrike = new int[3];
        //볼 판단했는지 보는 배열
        int[] visitedOfBall = new int[3];

        //스트라이크 판단하는 로직
        for(int i=0;i<3;i++){
            if (answer.get(i) == Integer.parseInt(String.valueOf(inputNum[i]))){
                visitedOfStrike[i] = 1;
            }
        }
        //볼 판단하는 로직
        for(int i=0;i<3;i++){
            for(int j=0; j<3;j++){
                //만약 이미 스트라이크라고 알려준 것이라면,
                if (visitedOfStrike[i] == 1){
                    continue;
                }
                //볼이라면
                if ( i != j && answer.get(i) == Integer.parseInt(String.valueOf(inputNum[j]))){
                    visitedOfBall[i] = 1;
                }
            }
        }

        //  사용자가 입력한 값이 정답인 경우, 정답임을 알려주고 다시 게임을 진행할지 판단하는 로직
        int strikeSum = 0;
        int ballSum = 0;
        for (int i=0;i<3;i++){
            if (visitedOfStrike[i] == 1){
                strikeSum += 1;
            }
            if(visitedOfBall[i] == 1){
                ballSum += 1;
            }
        }
        if (strikeSum == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String retryValue = readLine();
            if (Integer.parseInt(String.valueOf(retryValue)) == 1){
                game();
            } else if (Integer.parseInt(String.valueOf(retryValue)) == 2){
                //종료
            } else {
                throw new IllegalArgumentException();
            }
        }
        // 정답이 아니라면, 힌트 출력해주는 로직
        else{
            if(ballSum > 0){
                System.out.print(ballSum);
                System.out.print("볼 ");
            }
            if(strikeSum > 0){
                System.out.print(strikeSum);
                System.out.print("스트라이크");
            }
            if(strikeSum == 0 && ballSum == 0){
                System.out.println("낫싱");
            } else{
                System.out.println();
            }
            //같은 정답으로 다시 실행하는 로직
            numberBaseball(answer);
        }

    }

    //  힌트를 출력하는 로직
    public static void game (){
        //정답 생성
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        numberBaseball(answer);
    }

    public static void main(String[] args) {
        // 숫자 야구 진행 기능
        try {
            game();
        } catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

    }
}
