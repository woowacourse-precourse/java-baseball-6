package baseball;

import baseball.commom.seeder.DateSetSeeder;
import baseball.controller.ControllerResolver;

public class Application {

    private static final DateSetSeeder dateSetSeeder = new DateSetSeeder();
    private static final ControllerResolver controllerResolver = new ControllerResolver();
    public static void main(String[] args) {
        dateSetSeeder.seed();
        controllerResolver.run();
    }
}
