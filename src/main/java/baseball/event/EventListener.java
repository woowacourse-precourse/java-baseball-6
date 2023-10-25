package baseball.event;

import java.util.function.Consumer;
import java.util.function.Function;

public record EventListener(EventContext eventContext) {

    /**
     * 결과와 파라미터가 없는 이벤트
     *
     * @param eventConstructor
     */
    public void listen(Function<EventContext, Event> eventConstructor) {
        eventConstructor.apply(eventContext).execute();
    }


    /**
     * 결과만 있는 이벤트
     *
     * @param eventConstructor
     * @param <R>
     * @return
     */
    public <R> R listenWithResult(Function<EventContext, ReturnEvent<R>> eventConstructor) {
        return eventConstructor.apply(eventContext).execute();
    }

    /**
     * 파라미터만 있는 이벤트
     *
     * @param eventConstructor
     * @param <T>
     * @return
     */
    public <T> Consumer<T> listenWithParameter(Function<EventContext, ParameterEvent<T>> eventConstructor) {
        return (input) -> eventConstructor.apply(eventContext).execute(input);
    }

    /**
     * 파라미터와 결과 모두 있는 이벤트
     *
     * @param eventConstructor
     * @param <T>
     * @param <R>
     * @return
     */
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
