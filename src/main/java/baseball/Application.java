package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        boolean gameBreak = false;
        boolean randomCreate = true;

        List<Integer> ans = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(!gameBreak){
            // 볼, 스트라이크 갯수 준비
            Integer ball = 0;
            Integer strike = 0;

            // 랜덤 값 선택
            // 매 게임 시작할 때, 한 번씩만 진행 해야 한다.
            if(randomCreate){
                ans.clear();
                Integer cur;

                // 3개 숫자를 선택해서 리스트에 넣는다.
                for(int i = 0; i < 3; i++){
                    // start ~ end 까지 랜덤으로 숫자 추출
                    cur = Randoms.pickNumberInRange(1, 9);

                    // 같은 값이 이미 리스트에 들어있는지 체크
                    while(ans.contains(cur)){
                        cur = Randoms.pickNumberInRange(1, 9);
                    }

                    ans.add(cur);
                }

                randomCreate = false;
            }


            // 입력 기능
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> inputList = new ArrayList<>();

            for(int i = 0; i < input.length(); i++){
                // 1 ~ 9 사이의 값이 오면, 해당 값 저장
                if(input.charAt(i) >= '1' && input.charAt(i) <= '9'){
                    // 만약 이미 있는 숫자가 들어온다면, 예외 발생
                    // 112 이런 거 제외
                    if(inputList.contains(input.charAt(i) - '0')){
                        gameBreak = true;
                        throw new IllegalArgumentException("input miss");
                    }

                    // 문제 없으면 입력에 추가
                    inputList.add(input.charAt(i) - '0');
                } else{
                    gameBreak = true;
                    throw new IllegalArgumentException("input miss");
                }
            }

            if(inputList.size() != 3){
                throw new IllegalArgumentException("input miss");
            }

            if(gameBreak) break;

            // 판정 기능
            for(int i = 0; i < 3; i++){
                if(ans.get(i) == inputList.get(i)){
                    strike += 1;
                } else if(ans.contains(inputList.get(i))) {
                    ball += 1;
                }
            }


            // 출력 기능
            if(ball == 0 && strike == 0){
                System.out.println("낫싱");
            }else if (strike == 3){
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

                String gameStr = Console.readLine();

                // 게임을 다시 시작하면, 다시 답을 생성해야 한다.
                if(gameStr.equals("1")){
                    gameBreak = false;
                    randomCreate = true;
                    System.out.println("숫자 야구 게임을 시작합니다.");
                } else if (gameStr.equals("2")) {
                    gameBreak = true;
                    System.out.println("숫자 야구 게임을 종료합니다.");
                }else{
                    gameBreak = true;
                    throw new IllegalArgumentException("input miss");
                }

            } else if (strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            } else{
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }

    }
}
