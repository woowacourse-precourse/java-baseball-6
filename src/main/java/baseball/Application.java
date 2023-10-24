package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static Integer ball;
    static Integer strike;

    static boolean gameBreakFlag;
    static boolean randomCreateFlag;



    public static void main(String[] args) {
        // TODO: 프로그램 구현

        gameBreakFlag = false;
        randomCreateFlag = true;

        List<Integer> ans = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(!gameBreakFlag){
            // 볼, 스트라이크 갯수 준비
            ball = 0;
            strike = 0;

            // 랜덤 값 선택
            // 매 게임 시작할 때, 한 번씩만 진행 해야 한다.
            // 실행에 대한 플레그 정보를 저장할 randomCreateFlag
            randomCreateFlag = randomCreateProcess(randomCreateFlag, ans);

            // 입력 기능
            // 입력에 대한 처리는 각 자리의 숫자를 개별로 저장하기 위해 리스트로 저장
            List<Integer> inputList = new ArrayList<>();
            gameBreakFlag = inputProcess(gameBreakFlag, inputList);


            // 입력 상에서 문제가 생겼을 때,
            if(gameBreakFlag) break;


            // 판정 기능
            // 반복문을 돌며 ball과 strike 갯수를 확인한다.
            checkBaseballCount(ans, inputList);


            // 출력 기능
            printProcess();
        }

    }


    /**
     *  inputProcess는 사용자가 숫자야구 게임에서 입력해야 하는 숫자들에 대한 입력을 받는 부분입니다.
     *
     *  한 줄을 읽어 문자열에 저장하고,
     *  문자열의 처음 부터 끝까지 1 ~ 9 사이의 값이 아닌 값이 있다면, 예외를 발생시킵니다.
     *  각 자리의 문자 값에서 '0' 을 뺌으로써 정수형 값을 생성합니다.
     *
     */
    private static boolean inputProcess(boolean gameBreak, List<Integer> inputList) {

        inputList.clear();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();


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
        return gameBreak;
    }


    /**
     *    random으로 값을 생성하는 부분입니다.
     *    게임마다 한 번씩 실행해야 하기 때문에, 실행 여부에 대한 값을 randomCreateFlag에 저장합니다.
     *
     *    3개의 숫자를 랜덤으로 뽑되 중복되어서는 안되기에
     *    매번 숫자를 뽑을 때마다 기존에 뽑았는지를 확인합니다.
     */
    private static boolean randomCreateProcess(boolean randomCreateFlag, List<Integer> ans) {
        if(randomCreateFlag){
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

            randomCreateFlag = false;
        }
        return randomCreateFlag;
    }


    /**
     *    판정 기능을 담당하는 부분입니다.
     *    해당 부분에서는 입력한 숫자와 생성한 랜덤 값을 비교해 ball, strike 갯수를 측정합니다.
     */
    private static void checkBaseballCount(List<Integer> ans, List<Integer> inputList) {
        for(int i = 0; i < 3; i++){
            if(ans.get(i) == inputList.get(i)){
                strike += 1;
            } else if(ans.contains(inputList.get(i))) {
                ball += 1;
            }
        }
    }


    /**
     *    출력 기능을 담당하는 부분입니다.
     *
     *    ball, strike 갯수 및 숫자를 모두 맞혔다면, 게임을 다시할 건지 물어봅니다.
     *    게임을 다시 한다면, 다시 랜덤으로 값을 생성하기 위해 randomCreateFlag값으 조정합니다.
     *
     */
    private static void printProcess() {
        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        }else if (strike == 3){
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

            String gameStr = Console.readLine();

            // 게임을 다시 시작하면, 다시 답을 생성해야 한다.
            if(gameStr.equals("1")){
                gameBreakFlag = false;
                randomCreateFlag = true;
                System.out.println("숫자 야구 게임을 시작합니다.");
            } else if (gameStr.equals("2")) {
                gameBreakFlag = true;
                System.out.println("숫자 야구 게임을 종료합니다.");
            }else{
                gameBreakFlag = true;
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
