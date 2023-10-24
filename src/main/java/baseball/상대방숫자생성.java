package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class 상대방숫자생성 {
        private static int count;
        private static int startInclusive;
        private static int endInclusive;

        public 상대방숫자생성(int count, int startInclusive, int endInclusive) {

                this.count = count;
                this.startInclusive = startInclusive;
                this.endInclusive = endInclusive;
        }

        List<Integer> 랜덤숫자생성(){

                List<Integer> 컴퓨터숫자배열 = new ArrayList<>();

                while (컴퓨터숫자배열.size() < count) {
                        int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);

                        if (!컴퓨터숫자배열.contains(randomNumber)) {

                                컴퓨터숫자배열.add(randomNumber);
                        }
                }

                return 컴퓨터숫자배열;
        }
}
