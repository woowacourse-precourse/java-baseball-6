package baseball;

import java.io.ByteArrayInputStream;

public abstract class IOTest {

    // 이 메서드를 실행하면 input값의 바이트 배열을 스트림에 담아 System.in에 할당해줍니다.
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}

