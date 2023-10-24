package baseball.service.impl;

import baseball.ioadapter.IoAdapter;
import baseball.service.InputConvertService;
import java.util.Arrays;
import java.util.List;

public class InputConvertServiceImpl implements InputConvertService {

    private final IoAdapter ioAdapter;

    public InputConvertServiceImpl(IoAdapter ioAdapter) {
        this.ioAdapter = ioAdapter;
    }

    @Override
    public List<Integer> convertIntegerList() {
        String inputStream = ioAdapter.inputStream();
        List<Integer> convertList = Arrays
                .stream(inputStream.split(""))
                .map(Integer::parseInt)
                .toList();
        return convertList;
    }

    @Override
    public Integer convertInteger() {
        String inputStream = ioAdapter.inputStream();
        return Integer.parseInt(inputStream);
    }
}
