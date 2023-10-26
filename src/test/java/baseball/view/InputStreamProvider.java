package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputStreamProvider implements AutoCloseable{
    private final InputStream originalIn = System.in;

    public void setInputStreamFrom(String input) {
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
    }

    @Override
    public void close() {
        System.setIn(originalIn);
        Console.close();
    }
}
