package baseball.config;

import baseball.controller.BusinessController;
import baseball.controller.InteractionController;
import baseball.controller.MainController;
import baseball.view.View;

public class DependencyContainer {
    private final MainController mainController;

    public DependencyContainer() {
        View view = createView();
        InteractionController interactionController = createInteractionController();
        BusinessController businessController = createBusinessController(interactionController);
        this.mainController = createMainController(view, interactionController, businessController);
    }

    private View createView() {
        return new View();
    }

    private InteractionController createInteractionController() {
        return new InteractionController();
    }

    private BusinessController createBusinessController(InteractionController interactionController) {
        return new BusinessController(interactionController);
    }

    private MainController createMainController(View view, InteractionController interactionController, BusinessController businessController) {
        return new MainController(view, interactionController, businessController);
    }

    public MainController getMainController() {
        return mainController;
    }
}
