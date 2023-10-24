package baseball.controller;

import baseball.view.Input;
import baseball.view.Output;

public abstract class Controller {
    protected final Input inputView = Input.getInstance();
    protected final Output outputView = Output.getInstance();
}
