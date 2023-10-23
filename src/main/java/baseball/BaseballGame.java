package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final List<Integer> generatedAnswers = new ArrayList<>();

    public void run() {
        generateAnswers();
        guess();
    }

    public List<Integer> getGeneratedAnswers() {
        return generatedAnswers;
    }

    /**
     * (1) 게임 시작 - 정답 생성
     */
    public void generateAnswers() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        generatedAnswers.clear();
        for (int i = 0; i < Constants.ANS_LEN; i++) {
            int candidateNum;
            do {
                candidateNum = Randoms.pickNumberInRange(1, 9);
            } while (checkDuplicateNum(candidateNum));
            generatedAnswers.add(candidateNum);
        }
    }

    // 무작위로 생성한 숫자가 정답 숫자 리스트에 포함되어 있는지 검사
    // 중복: true, 중복되지 않음: false
    private boolean checkDuplicateNum(int candidateNum) {
        if (generatedAnswers.contains(candidateNum)) {
            return true;
        }
        return false;
    }

    /**
     * (2) 사용자 입력
     */
    public void guess() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput;
            do {
                System.out.print("숫자를 입력해주세요 : ");
                userInput = br.readLine();
                Validator.validateUserInput(userInput);
            } while (!isCorrectAnswer(userInput));
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }

    public boolean isCorrectAnswer(String userInput) {
        return userInput.equals(collectAnswers());
    }

    /**
     * (기타) 출력을 위한 메서드
     */
    public String collectAnswers() {
        String ans = "";
        for (int i = 0; i < generatedAnswers.size(); i++) {
            ans += generatedAnswers.get(i);
        }
        return ans;
    }
}
