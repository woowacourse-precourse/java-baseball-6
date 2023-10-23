package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final List<Integer> generatedAnswers = new ArrayList<>();

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        try {
            do {
                generateAnswers();
                guess();
            } while(restart());
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage() + " - " + e.getClass().getName());
        } finally {
            Console.close();
        }
    }

    public List<Integer> getGeneratedAnswers() {
        return generatedAnswers;
    }

    /**
     * (1) 게임 시작 - 정답 생성
     */
    public void generateAnswers() {
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
    public void guess() throws IllegalArgumentException {
        String userInput = null;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = Console.readLine();
            Validator.validateUserInput(userInput);
            System.out.println(ScoreJudge.judgeScore(generatedAnswers, userInput));
        } while (!isCorrectAnswer(userInput));
    }

    /**
     * (3) 정답 여부 판정
     */
    public boolean isCorrectAnswer(String userInput) {
        if (userInput.equals(collectAnswers())) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            
            return true;
        }
        return false;
    }

    /**
     * (4) 게임 재시작
     */
    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        Validator.validateRestartInput(userInput);
        if (userInput.equals("1")) {
            return true;
        }
        return false;
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
