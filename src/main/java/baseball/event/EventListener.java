package baseball.event;

import java.util.function.Consumer;
import java.util.function.Function;

public record EventListener(EventContext eventContext) {

    public void listen(Function<EventContext, Event> eventConstructor) {
        eventConstructor.apply(eventContext).execute();
    }

    public <R> R listenWithResult(Function<EventContext, ReturnEvent<R>> eventConstructor) {
        return eventConstructor.apply(eventContext).execute();
    }

    public <T> Consumer<T> listenWithParameter(Function<EventContext, ParameterEvent<T>> eventConstructor) {
        return (input) -> eventConstructor.apply(eventContext).execute(input);
    }

    public <T, R> Function<T, R> listenWithParameterAndResult(Function<EventContext, ParameterAndReturnEvent<T, R>> eventConstructor) {
        return (input) -> eventConstructor.apply(eventContext).execute(input);

    }


    public interface Event {
        void execute();
    }

    public interface ParameterEvent<T> {
        void execute(T input);
    }

    public interface ReturnEvent<R> {
        R execute();
    }

    public interface ParameterAndReturnEvent<T, R> {
        R execute(T input);
    }

}
