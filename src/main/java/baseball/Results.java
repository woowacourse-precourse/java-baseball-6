package baseball;

import java.util.List;

public class Results {
    List<Integer> answer_list;
    String[] expected_answer_list;
    int[] cnt_lst = {0, 0};

    Results(List<Integer> answer_list, String[] expected_answer_list) {
        this.answer_list = answer_list;
        this.expected_answer_list = expected_answer_list;
    }
    public void countBallStrike() {
        for (var i=0; i<3; i++) {
            if (Integer.parseInt(expected_answer_list[i]) == answer_list.get(i)) { // strike
                cnt_lst[1] += 1;
            } else if (answer_list.contains(Integer.parseInt(expected_answer_list[i]))) { // ball
                cnt_lst[0] += 1;
            }
        }
    }

    public String resultBallStrike() {
        countBallStrike();
        String result_str = "";
        if (cnt_lst[0] != 0) {
            result_str += cnt_lst[0] + "볼 ";
        }
        if (cnt_lst[1] != 0) {
            result_str += cnt_lst[1] + "스트라이크";
        } else if (cnt_lst[0] == 0) {
            result_str = "낫싱";
        }
        return result_str.trim();
    }
}
