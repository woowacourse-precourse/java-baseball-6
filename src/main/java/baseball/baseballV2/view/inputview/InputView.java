package baseball.baseballV2.view.inputview;

import java.util.Map;

public interface InputView<K> {
    // readLine()
    // 변환에 필요한 정보는 model에 가지고 있어야 하는 상황
    // 읽고 난 이후에는 변환해야 한다 -> 원하는 객체 형태로
    K input(Map<String, Object> model);
}
