package baseball.Model;

public class Referee {
    private int[] getQueryDecoding(String queryString) {
        int asciiZero = 48;
        int[] query = new int[3];
        for(int i = 0; i < queryString.length(); ++i)
            query[i] = queryString.charAt(i) - asciiZero;
        return query;
    }

    public String judge(String queryString, Computer computer) {
        int strikeCount = 0;
        int ballCount = 0;
        int[] query = getQueryDecoding(queryString);
        int[] answer = computer.getAnswer();
        boolean[] pickedMap = computer.getPickedMap();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 3; ++i) { 
            if(pickedMap[query[i]]) {
                if(query[i] == answer[i]) ++strikeCount;
                else ++ballCount;
            }
        }

        if(strikeCount == 0 && ballCount == 0)
            return "낫싱";
        if(ballCount > 0)
            sb.append(ballCount).append("볼 ");
        if(strikeCount > 0)
            sb.append(strikeCount).append("스트라이크 ");

        return sb.toString();
    }
}
