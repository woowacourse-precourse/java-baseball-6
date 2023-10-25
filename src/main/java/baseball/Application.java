package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        int userPlayNumber = 0;

        //플레이어가 게임 완전 종료를 선택할 때까지 반복한다.
        do{
            //임의의 3자리 수를 생성한다.
            List<Integer> randomNumberList = generateRandomNumberList();
            boolean correct = false;

            //정답이 입력될 때까지 반복한다.
            while (!correct) {
                //플레이어에게 3자리 수 문자열을 입력받는다.
                System.out.print("숫자를 입력해주세요 : ");
                String inputString = Console.readLine();

                //잘못된 값을 입력할 경우 예외를 발생시킨다.
                if (inputString.length() >= 4) {
                    throw new IllegalArgumentException();
                }

                //플레이어가 입력한 문자열을 정수 리스트로 변형한다.
                List<Integer> userNumberList = parseNumber(inputString);

                //임의의 값과 플레이어가 입력한 값을 비교하여 결과를 출력한다.
                String answer = checkAnswer(randomNumberList, userNumberList);
                System.out.println(answer);

                //정답을 맞췄다면 while문을 빠져나간다.
                if (answer.equals("3스트라이크")) {
                    correct = true;
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            //플레이어에게 게임 연장 여부를 입력받는다.
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userPlayNumber = Integer.parseInt(Console.readLine());

        } while (userPlayNumber != 2);
    }

    /*
    * 임의의 3자리 수와 플레이어가 입력한 3자리 수를 비교하여 결과를 반환하는 메서드
    * - 두 리스트 값을 비교하여 볼, 스트라이크 개수를 센다.
    */
    private static String checkAnswer(List<Integer> randomNumberList, List<Integer> userNumberList) {

        int ballCount = 0;
        int strikeCount = 0;
        String answer = "";

        for (int i=0; i<3; i++) {
            if (userNumberList.get(i).equals(randomNumberList.get(i))) {
                strikeCount++;
            }
            else {
                if (randomNumberList.contains(userNumberList.get(i))) {
                    ballCount++;
                }
            }
        }

        if (ballCount == 0 && strikeCount == 0) {
            answer = "낫싱";
        }
        else {
            answer += ballCount > 0 ? ballCount + "볼 " : "";
            answer += strikeCount > 0 ? strikeCount + "스트라이크" : "";
        }

        return answer;
    }

    /*
    * 플레이어가 입력한 문자열을 정수 리스트로 변형하는 메서드 (String -> ArrayList<Integer>)
    * - 문자를 하나씩 잘라서 Integer 타입으로 변경한 뒤 ArrayList에 저장한다.
    */
    private static ArrayList<Integer> parseNumber(String inputString){

        ArrayList<Integer> parseNumberList = new ArrayList<>();
        parseNumberList.add(Integer.valueOf(inputString.substring(0, 1)));
        parseNumberList.add(Integer.valueOf(inputString.substring(1, 2)));
        parseNumberList.add(Integer.valueOf(inputString.substring(2)));

        return parseNumberList;
    }

    /*
    * 임의의 3자리 수를 생성하는 메서드
    * - 1~9의 임의의 수 3개를 생성한 뒤, 겹치는 값없이 ArrayList에 저장한다.
    */
    private static ArrayList<Integer> generateRandomNumberList(){

        ArrayList<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }

        return randomNumberList;
    }
}
