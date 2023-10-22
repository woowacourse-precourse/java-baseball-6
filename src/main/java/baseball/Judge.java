package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Judge {
    //스트라이크와 볼을 판별하기 위해 인덱스 위치에 값을 저장해서 인덱스의 밸류 값이 같으면 스트라이크 아닐 때 보유하고 있으면 볼 둘 다 아니면 낫싱
    private final Map<Integer, Integer> computerNumberMap;


    //랜덤으로 생성한 리스트 값을 맵으로 저장
    public Judge(List<Integer> computerNumberList) {
        computerNumberMap = IntStream.range(0, computerNumberList.size())
                .boxed()
                .collect(Collectors.toMap(index -> index, computerNumberList::get));
    }

    public void evaluateUserNumberList(List<Integer> userNumberList) {
        List<String> ScoreBoardList = new ArrayList<>();
        for (int i = 0; i < computerNumberMap.size(); i++) {
            if (computerNumberMap.get(i) == userNumberList.get(i)) { //map의 인덱스의 밸류와 사용자 숫자 리스트의 값이 같으면 스트라이크
                ScoreBoardList.add("STRIKE");
                continue;
            }
        }

    }


}
