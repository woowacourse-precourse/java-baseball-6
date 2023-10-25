package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    private static final int NUM_LENGTH = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean continue_game = true;   // 게임 재시작 여부 변수
        while(continue_game){
            // '서로 다른' 3자리의 랜덤 숫자 뽑기
            List<Integer> num_correct = new ArrayList<>();
            while (num_correct.size() < NUM_LENGTH) {
                int random_num = pickNumberInRange(1, 9);
                if(!num_correct.contains(random_num))
                    num_correct.add(random_num);
            }

            while(true) {
                // 사용자 입력 받기
                System.out.print("숫자를 입력해주세요 : ");
                String num_input = readLine();
                // 사용자 입력 예외사항
                if (num_input.length() != NUM_LENGTH)
                    throw new IllegalArgumentException(NUM_LENGTH + "자리의 수를 입력해주세요.");
                for(int i = 0; i < NUM_LENGTH; i++){
                    for(int j = i + 1; j < NUM_LENGTH; j++){
                        if(num_input.charAt(i) == num_input.charAt(j))
                            throw new IllegalArgumentException("'서로 다른'" +  NUM_LENGTH + "자리의 수를 입력해주세요.");
                    }
                }

                // 숫자 매칭 확인
                int strike = 0, ball = 0;
                for (int i = 0; i < NUM_LENGTH; i++) {
                    // 사용자가 입력한 각각의 수가 정답의 몇번째 index에 있는지 찾기(없으면 -1)
                    int find_index = num_correct.indexOf(Character.getNumericValue(num_input.charAt(i)));

                    if (find_index == i)
                        strike++;
                    else if (find_index != -1)
                        ball++;
                }

                // 결과 문자열 생성 및 출력
                String result = "";
                if (strike == 0 && ball == 0)
                    result = "낫싱";
                else {
                    if (ball > 0)
                        result += ball + "볼 ";
                    if (strike > 0)
                        result += strike + "스트라이크";
                }
                System.out.println(result);

                // 정답을 맞춘 경우, 게임 재시작 여부 입력
                if (strike == NUM_LENGTH) {
                    System.out.println(NUM_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    String is_continue = readLine();
                    if ("2".equals(is_continue)) {
                        continue_game = false;
                        break;
                    }
                    else if (!"1".equals(is_continue))
                        throw new IllegalArgumentException("'1 또는 2'를 입력해주세요.");
                    break;
                }
            }
        }
    }
}
