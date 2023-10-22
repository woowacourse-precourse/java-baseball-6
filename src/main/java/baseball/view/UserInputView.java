package baseball.view;

import camp.nextstep.edu.missionutils.Console;

// 사용자의 입력 처리 뷰(입력 과정 : 게임 정답 입력, 재시작 입력)
public class UserInputView {

    // 사용자에게 숫자를 입력받는 메소드
    public static String setInputNumber() {
        System.out.println("숫자를 입력해주세요 : "); // 얘는 바로 뒤이어서 입력하네
        return Console.readLine(); // 사용자로부터 한 줄의 텍스트를 입력 받고 그 값을 문자열로 반환
    }

    // 사용자에게 재시작 여부를 입력받는 메소드
    public static String setInputRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); // 얘는 다음 줄에 이어서 입력하네
        return Console.readLine();
    }
}

// 입력줄 어딘지 테스트할 때 파악하기
