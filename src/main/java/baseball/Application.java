package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int[] ans; // 정답을 받을 배열
        int[] guess = new int[3];
        boolean play = true;

        // 프로그램 시작 메시지
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임을 계속할 것인지를 결정하는 외부 루프
        while (play){
            boolean[] visited = new boolean[10]; // 숫자의 중복 추첨 방지를 위한 배열
            visited[0] = true; // 0은 사용되지 않으므로 미리 true로 설정
            ans = new int[3]; // 정답을 받을 배열을 게임마다 초기화

            // 숫자 추첨
            int l = 0;
            while (l < 3){
                int randomNumber = Randoms.pickNumberInRange(1, 9); // 자리마다 다른 수 추첨

                if (!visited[randomNumber]) {
                    visited[randomNumber] = true;
                    ans[l++] = randomNumber;
                }
            }

            for (int an : ans) {
                System.out.print(an + " ");
            }
            System.out.println();

            // 사용자가 정답을 맞출 때까지 계속되는 내부 루프
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String ask = Console.readLine(); // 답변 받기

                // 입력값 검증
                if (ask.length() != 3) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 세 자리의 숫자를 입력하세요.");
                }


                try {
                    // 중복 숫자 검증을 위한 배열
                    boolean[] numberCheck = new boolean[10];

                    for (int i = 0; i < 3; i++) {
                        int number = Character.getNumericValue(ask.charAt(i));

                        // 숫자 범위와 중복 검사
                        if (number < 1 || number > 9 || numberCheck[number]) {
                            throw new IllegalArgumentException("잘못된 입력입니다. 1에서 9 사이의 서로 다른 숫자를 입력하세요.");
                        }
                        guess[i] = number;
                        numberCheck[number] = true; // 숫자 등장 표시
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다. 숫자만 입력하세요.", e);
                }

                int strike = 0;
                int ball = 0;

                // 스트라이크와 볼 판단 로직
                for(int i = 0; i < 3; i++){
                    if (guess[i] == ans[i]) {
                        strike++;
                    } else {
                        for(int j = 0; j < 3; j++){
                            if (guess[j] == ans[i]) {
                                ball++;
                            }
                        }
                    }
                }

                String result;
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else {
                    result = "";
                    if (ball > 0) {
                        result = ball + "볼 ";
                    }
                    if (strike > 0) {
                        result += strike + "스트라이크";
                    }
                    System.out.println(result);
                }



                // 3 스트라이크 시 게임 종료
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

                    int end = Integer.parseInt(Console.readLine());
                    if (end == 2) {
                        play = false; // 게임 종료 선택
                    }
                    break; // 현재 게임 종료, 새 게임 시작 또는 프로그램 종료
                }
            }
        }
    }
}
