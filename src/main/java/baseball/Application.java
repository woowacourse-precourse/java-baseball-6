package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {

        try {
            baseballGame();
        }catch (IOException ioException){

        }

    }

    private static void baseballGame() throws IOException {
        List<Integer> answerNumber = createAnswerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        String input;
        while (true){
            System.out.println("숫자를 입력해주세요 : ");
            input = br.readLine();
            isValidNumber();
        }
    }

    private static boolean isValidNumber() {
        //TODO : 세자리 숫자인지 체크
        return false;
    }

    private static List<Integer> createAnswerNumber() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

}
