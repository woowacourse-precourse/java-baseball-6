package baseball;

import baseball.Computer.ComputerService;
import baseball.Computer.ComputerServiceImpl;
import baseball.Parse.ParseService;
import baseball.Parse.ParseServiceImpl;
import baseball.check.CheckService;
import baseball.check.CheckServiceImpl;
import baseball.input.InputService;
import baseball.input.InputServiceImpl;
import baseball.print.PrintService;
import baseball.print.PrintServiceImpl;

public class AppConfig {

    public PrintService printService() {return new PrintServiceImpl();}

    public ComputerService computerService() {return new ComputerServiceImpl();}

    public InputService inputService() {return new InputServiceImpl();}

    public ParseService parseService() {return new ParseServiceImpl();}

    public CheckService checkService() {return new CheckServiceImpl();}

}
