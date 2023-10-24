package baseball.service;

import baseball.util.ExceptionUtil;
import baseball.util.IntegerUtil;

public class InputService {

    private static final InputService inputService = new InputService();

    public static InputService getInstance(){
        return inputService;
    }

    private InputService(){

    }


}
