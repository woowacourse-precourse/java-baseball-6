package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        Scanner sc = new Scanner(System.in);

        List<Integer> randomComputerList = getRandomNumberList(); // 서로 다른 3자리 숫자 임의 생성
        while (true) {

            System.out.print("숫자를 입력해주세요 : ");

            int inputNum; // 사용자 입력 값
            try {
                inputNum = sc.nextInt();
            } catch (Exception e) { // 입력한 값이 숫자가 아닐 경우 IllegalArgumentException 발생
                throw new IllegalArgumentException("입력 값은 서로다른 3자리 숫자로 입력해야합니다.");
            }

            int numLength = (int) (Math.log10(inputNum) + 1); // 입력받는 숫자의 자릿수

            // 입력한 숫자가 3자리 수 가 아니면 IllegalArgumentException 발생
            if (numLength != 3) {
                throw new IllegalArgumentException("입력 값은 서로다른 3자리 숫자로 입력해야합니다.");
            }

        /*
            사용자가 입력한 숫자 3자리와, 컴퓨터가 임의로 만든 3자리 숫자 비교하기
         */
            String inputNumString = Integer.toString(inputNum);
            char[] inputNumCharArray = inputNumString.toCharArray();

            // 사용자가 입력한 숫자에 중복이 있는지 체크
            for (int i = 0; i < inputNumString.length(); i++) {
                char c = inputNumString.charAt(i);
                int indexOf = inputNumString.indexOf(c);
                if (i != indexOf) { // 중복의 경우
                    throw new IllegalArgumentException("입력 값은 서로다른 3자리 숫자로 입력해야합니다.");
                }
            }

            int strikeCount = 0; // 스트라이크 수
            int ballCount = 0; // 볼 수
            for (int i = 0; i < inputNumCharArray.length; i++) {
                int myNum = Character.getNumericValue(inputNumCharArray[i]);

                for (int j = 0; j < randomComputerList.size(); j++) {
                    int computerNum = randomComputerList.get(j);
                    if (myNum == computerNum && i == j) {
                        strikeCount++;
                    } else if (myNum == computerNum && i != j) {
                        ballCount++;
                    }
                }

            }

            if (strikeCount > 0 && ballCount > 0) {
                System.out.println(ballCount+"볼 " + strikeCount+"스트라이크");
            } else if (strikeCount > 0 && ballCount == 0) {
                System.out.println(strikeCount+"스트라이크");
            } else if (strikeCount == 0 && ballCount > 0) {
                System.out.println(ballCount+"볼");
            } else if (strikeCount == 0 && ballCount == 0) {
                System.out.println("낫싱");
            }

            // ===================================================================
            // 3 스트라이크로 모든 숫자 정답일 경우 > 종료할지, 게임을 새로 시작할지 결정한다
            // ===================================================================
            if (strikeCount == 3 && ballCount == 0) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int endNum = sc.nextInt(); // 1 - 새로시작, 2 - 종료
                if (endNum == 1) {
                    randomComputerList = getRandomNumberList(); // 새로운 랜덤한 숫자 3개를 불러와 저장한다
                } else if (endNum == 2) {
                    break;
                }
            }

        }

    }

    // 각각 다른 3자리 숫자를 랜덤하게 리턴해주는 메소드
    private static List<Integer> getRandomNumberList() {
        List<Integer> randomComputerList = new ArrayList<>();
        while (randomComputerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomComputerList.contains(randomNumber)) {
                randomComputerList.add(randomNumber);
            }
        }
        return randomComputerList;
    }

}