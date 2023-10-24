package baseball.view;

import baseball.verification.Verification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewInput {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private Verification verification = new Verification();

    /**
     * 사용자에게 숫자입력 받기
     */
    public int getAnswer() throws IOException {
        int answer = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("숫자를 입력해주세요: ");
            String input = bufferedReader.readLine();

            if (input == null) {
                System.out.println("입력에서 문제가 발생했습니다. 프로그램을 종료합니다.");
                System.exit(1);
            }

            answer = Integer.parseInt(input.trim());
            isValid = verification.checkInputValid(answer);
        }

        return answer;
    }

    /**
     * Continue or End
     */
    public int continueOrEnd() throws IOException{
        int opinion = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = bufferedReader.readLine();

            if (input == null) {
                System.out.println("입력에서 문제가 발생했습니다. 프로그램을 종료합니다.");
                System.exit(1);
            }

            opinion = Integer.parseInt(input.trim());
            isValid = verification.checkInputOpinion(opinion);
        }

        return opinion;
    }
}
