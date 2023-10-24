package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        int gameFlag = 1;

        while (gameFlag == 1){
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computerNumbers = pickNumber();

            int strikeCnt = 0;
            int ballCnt = 0;

            while(strikeCnt < 3){
                strikeCnt = 0;
                ballCnt = 0;

                String userInput = Console.readLine();

                validateUserInput(userInput);

                int[] arrUserNumber = userInputToArray(userInput);

                strikeCnt = checkUserNumber(computerNumbers, arrUserNumber, strikeCnt, ballCnt);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            gameFlag = Integer.parseInt(Console.readLine());
        }
    }

    private static List<Integer> pickNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private static void validateUserInput(String userInput) {
        if(userInput.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    private static int[] userInputToArray(String userInput) {
        int[] arrUserNumber = new int[2];
        for(int i=0; i<3; i++){
            arrUserNumber = Stream.of(userInput.split("")).mapToInt(Integer::parseInt).toArray();
        }
        return arrUserNumber;
    }

    private static int checkUserNumber(List<Integer> computerNumbers, int[] arrUserNumber, int strikeCnt, int ballCnt) {
        int computerNumberCnt = 0;
        for (Integer computerNumber : computerNumbers) {
            computerNumberCnt++;
            int userNumberCnt = 0;
            for (int userNumber : arrUserNumber) {
                userNumberCnt++;
                if(computerNumber == userNumber){
                    if(computerNumberCnt == userNumberCnt){
                        strikeCnt++;
                        break;
                    }else{
                        ballCnt++;
                        break;
                    }
                }
            }
        }

        String resultMsg = "";
        if(ballCnt > 0) {
            resultMsg += ballCnt + "볼 ";
        }

        if(strikeCnt > 0){
            resultMsg += strikeCnt +"스트라이크 ";
        }

        if(ballCnt == 0 && strikeCnt == 0){
            resultMsg += "낫싱";
        }

        System.out.println(resultMsg);

        return strikeCnt;
    }
}
