# 게임 메세지
- 게임 도중 표시되는 메세지를 무엇으로 구현할 것인가?
- `enum` vs `interface`
- `enum`
  - enum을 class내부에 집어넣고, enum에 필드를 추가시킨다
  - 추가적인 로직 삽입에 유용
  - ```java
      public enum GameMessage {
        START("게임 시작"),
        END("게임 끝");

        private final String message;
    
        GameMessage(String message) {
            this.message = message;
        }
    
        public String getMessage() {
            return message;
        }
      }
    ```
- `interface`
  - 인터페이스에 메세지 변수를 선언한다
  - 단순, 상속에 의한 활용이 가능
  - ```java
    public interface Message {
      String START = "게임 시작";
      String END = "게임 끝";
    }
    ```
