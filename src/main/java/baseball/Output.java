package baseball;

import java.util.Map;

public class Output {
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void hint(Map<String, Integer> result) {
        if (result.get("스트라이크") == 0 && result.get("볼") == 0) {
            System.out.print("낫싱");;
        }
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.print(entry.getValue() + entry.getKey() + " ");
            }
        }
        System.out.println();
    }
}