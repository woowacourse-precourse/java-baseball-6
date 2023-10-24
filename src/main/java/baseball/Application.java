package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // 사용자 입력을 받기 위한 scanner
        Scanner scanner = new Scanner(System.in);

        // game state
        boolean isPlaying = true;

        // 사용자 입력 숫자
        int number = 0;

        System.out.println("숫자 야구게임을 시작합니다.");

        // computer 리스트에 랜덤 숫자 3개를 가진다
        List<Integer> computer = getRandomNumberList();

        while (isPlaying) {

            System.out.println("숫자를 입력해주세요 :");

            // 사용자 입력 숫자
            number = scanner.nextInt();

            // 예외처리 - 사용자 입력이 3자리수가 아니라면 throw
            if (getIntList(number).length != 3) {
                throw new IllegalArgumentException();
            }

            // 사용자가 입력한 숫자와 랜덤 숫자의 hit check
            int[] hit = checkScore(number, computer);

            // 아무것도 맞는 게 없을 때
            if (hit[0] + hit[1] == 0) {
                System.out.println("낫싱");

                // 3스트라이크 정답 - 게임종료
            } else if (hit[1] == 3) {

                // 게임 종료
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                // 게임 재시작 여부
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                if (scanner.nextInt() == 1) {

                    // 새로운 랜덤 숫자 생성
                    computer = getRandomNumberList();
                } else {

                    // 게임 종료 - while문 탈출
                    isPlaying = false;
                }

                // 스트라이크만 존재
            } else if (hit[0] == 0) {
                System.out.println(hit[1] + "스트라이크");

                // 볼만 존재
            } else if (hit[1] == 0) {
                System.out.println(hit[0] + "볼");

                // 볼과 스트라이크 모두 존재
            } else {
                System.out.println(hit[0] + "볼 " + hit[1] + "스트라이크");
            }
        }

        // 게임 종료
        System.out.println("게임종료");
    }

    public static int[] checkScore(int userNumber, List<Integer> computerNumber) {

        int[] hit = new int[2];

        // 사용자 입력 int를 int list로 변환
        // 각 자리수 비교하기 위함
        int[] userNumberList = getIntList(userNumber);

        for (int i = 0; i < 3; i++) {

            // 동일한 숫자를 포함한다면 최소한 볼
            if (computerNumber.contains(userNumberList[i])) {

                // 같은 자리의 수가 같다면 스트라이크
                if (computerNumber.get(i).equals(userNumberList[i])) {
                    hit[1] += 1;

                    // 볼
                } else {
                    hit[0] += 1;
                }
            }
        }

        return hit;
    }

    public static List<Integer> getRandomNumberList() {

        // 랜덤 숫자 3개를 생성하여 배열로 만들어 반환한다
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static int[] getIntList(Integer number) {

        // 숫자를 문자열로 변환
        String numberString = Integer.toString(number);

        int[] array = new int[numberString.length()];

        for (int i = 0; i < numberString.length(); i++) {

            // 문자열의 각 문자 가져오기
            char digitChar = numberString.charAt(i);

            // 문자를 정수로 변환
            int digit = Character.getNumericValue(digitChar);

            // 배열에 저장
            array[i] = digit;
        }

        return array;
    }
}
