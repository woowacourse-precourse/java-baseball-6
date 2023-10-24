package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean isGameRestarting = true;
        boolean isRoundRunning = true;

        while(isGameRestarting){
            isRoundRunning = true;
            // 1~9 중 중복되지 않는 3개의 숫자를 생성
            List<Integer> computer = generateComputerNum();
            System.out.println("숫자 야구 게임을 시작합니다.");

            while(isRoundRunning){
                System.out.println("숫자를 입력해주세요 : ");
                // 사용자 입력 받음
                String userInput = Console.readLine();

                //사용자 입력값의 유효성을 검사
                if(validateInput(userInput)){
                    int[] userNum = parseUserInput(userInput);
                    isRoundRunning = calculateNum(userNum, computer);
                } else{
                    // 게임 종료
                    throw new IllegalArgumentException();
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String isRestart = Console.readLine();
            // 사용자가 잘못 입력했을 경우
            if(!isRestart.equals("1") && !isRestart.equals("2")){
                // 게임 종료
                throw new IllegalArgumentException();
            }
            isGameRestarting = isRestart.equals("1");
        }
    }

    public static List<Integer> generateComputerNum() {
        List<Integer> computerNum = new ArrayList<>();
        while(computerNum.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computerNum.contains(randomNumber)){
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    public static boolean validateInput(String userInput){
        // 1~9의 3자리 숫자로 구성되어 있는지
        return userInput.length() == 3 && userInput.matches("[1-9]+");
    }

    public static int[] parseUserInput(String userInput){
        //사용자 입력값을 int 배열로 반환
        int[] userNum = new int[3];
        for(int i=0; i<3; i++){
            userNum[i] = Integer.parseInt(userInput.substring(i, i+1));
        }
        return userNum;
    }

    public static boolean calculateNum(int[] userNum, List<Integer> computerNum){
        boolean resultRoundERun = true;

        int ball = 0;
        int strike = 0;

        for(int i=0; i<3; i++){
            if(userNum[i] == computerNum.get(i)){
                strike++;
            } else if(computerNum.contains(userNum[i])){
                ball++;
            }
        }

        String resultStr = "";
        if(ball > 0){
            resultStr += ball + "볼 ";
        }
        if(strike > 0){
            resultStr += strike + "스트라이크";
        }

        if(resultStr.isEmpty()){
            resultStr = "낫싱";
        }

        System.out.println(resultStr);
        if(strike == 3){
            // 3개를 모두 맞힐 경우, 한 라운드 종료
            resultRoundERun = false;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        return resultRoundERun;
    }
}
