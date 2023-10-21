package baseball.core;

import java.util.List;

public class Referee {
    public String judge(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikeCount = 0;
        for(int i = 0; i < computerNumbers.size(); i++) {
            if(computerNumbers.get(i) == userNumbers.get(i)) strikeCount++;
        }

        int ballCount = 0;
        for(int i = 0; i < computerNumbers.size(); i++) {
            for(int j = 0; j < userNumbers.size(); j++) {
                if(i == j) continue;
                if(computerNumbers.get(i) == userNumbers.get(j)) ballCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(ballCount != 0) sb.append(ballCount).append("볼");
        if(!sb.isEmpty() && strikeCount != 0) sb.append(" ");
        if(strikeCount != 0) sb.append(strikeCount).append("스트라이크");
        if(!sb.isEmpty()) return sb.toString();

        return "낫싱";
    }
}
