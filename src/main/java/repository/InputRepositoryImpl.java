package repository;

import template.MessageTemplate;
import validation.Valid;

public class InputRepositoryImpl implements InputRepository {

    private final Valid valid = new Valid();
    private final MessageTemplate template = new MessageTemplate();

    @Override
    public String getMyNumber() {
        return template.execute("숫자를 입력해주세요 : ",
                str -> valid.myNumberValid(str));
    }

    @Override
    public String getRestartSelect() {
        return template.execute("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
                str -> valid.restartValid(str));
    }
}
