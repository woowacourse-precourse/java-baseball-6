package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int restart = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {

            List<Integer> computerNumList = setGameNumber();
            List<Integer> userNumList = getUserNumber();
            List<Integer> scoreList = getScoreList(computerNumList, userNumList);

            System.out.println(computerNumList);
            System.out.println(userNumList);
            System.out.println(scoreList);

            int ball = scoreList.get(0);
            int strike = scoreList.get(1);

            System.out.println(ball);
            System.out.println(strike);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restart = Integer.parseInt(readLine());
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike > 0 || ball > 0) {
                System.out.println(ball + "볼" + strike + "스트라이크");
            }


        } while (restart == 1);
    }

    //컴퓨터가 정수 3자리를 세트시키는 메소드
    public static List<Integer> setGameNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //유저에게서 정수 3자리를 입력받는 메소드
    public static List<Integer> getUserNumber() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("숫자를 입력해주세요 : ");
//        try{
            int buffer = Integer.parseInt(readLine());

            System.out.println("buffer에 데이터 저장됨");
            System.out.println(buffer);
//        } catch (IllegalArgumentException e){
//            System.out.println("프로그램이 종료됩니다.");
//        }
        return numberToList(buffer);
    }

    private static List<Integer> numberToList(int buffer) {
        List<Integer> userNumList = new ArrayList<>();

        System.out.println("numberToList 함수 호출됨");

        int unitsNum = buffer % 10;
        int tensNum = (buffer / 10) % 10;
        int hundredsNum = buffer / 100;

        userNumList.add(hundredsNum);
        userNumList.add(tensNum);
        userNumList.add(unitsNum);

        System.out.println(userNumList);

        return userNumList;
    }

    public static List<Integer> getScoreList(List<Integer> computerNum, List<Integer> userNum){

        int ball = 0;
        int strike = 0;
        List<Integer> scoreList = new ArrayList<>();

        for(int i = 0; i < computerNum.size(); i++){
            for (int j = 0; j < computerNum.size(); j++){
                if(computerNum.get(i).equals(userNum.get(i))){
                    strike++;
                } else if (computerNum.get(i).equals(userNum.get(j))) {
                    ball++;
                }
            }
        }
        scoreList.add(ball);
        scoreList.add(strike);

        return scoreList;
    }
}
