# 숫자 야구게임 

---

## 구현 기능 목록

1. BaseballGame

- 숫자 야구 게임의 주요 동작을 관리하는 클래스로 책임은 다음과 같다.
  - 게임을 시작한다(start).
    - 게임 시작 문구를 출력한다.
    - BotPlayer가 임의의 수를 생성하도록 한다.
    - Player가 수를 입력하도록 한다.
    - 심판(BaseballUmpire)의 판단을 보고 게임의 상태(GameStatus)를 결정한다.
  - 게임 재시작(1) 및 종료(2) 여부를 가린다.
    - 입력이 1이라면 게임을 다시 시작(start)한다.
    - 입력이 2라면 게임을 종료(end)한다.
    - 1, 2 외의 입력이 들어온다면 `IllegalArgumentException`을 발생시킨다.

2. BaseballGameConfig

- BaseballGame 생성에 필요한 설정과 초기화 로직을 구성하는 클래스이다.
  - 게임 규칙(GameRule), 게임의 초기 상태(GameStatus), 상대 플레이어(BotPlayer), 심판(BaseballUmpire) 객체를 생성한다. 

3. GameRule, BaseballRule

- 야구 게임의 규칙을 정의하는 인터페이스 및 구현체 클래스이다.
  - 인터페이스 GameRule에서는 주어진 봇 플레이어와 사용자의 숫자들로부터 현재 게임 상태를 판단할 수 있는 기능을 제공한다.
  - 구현체인 BaseballRule은 BotPlayer와 Player의 숫자를 비교하여 게임의 상태를 반환한다. 

4. BotPlayer

- 숫자 야구게임에서 '상대방 플레이어'로 책임은 다음과 같다.
  - 1에서 9까지의 서로 다른 임의의 수를 생성하여 List<Integer> 형태로 반환한다.

5. Player

- 숫자 야구게임을 하는 '플레이어(본인)'로 책임은 다음과 같다.
  - 서로 다른 3자리 임의의 수를 입력한다.
  - 서로 다른 3자리의 수 이외의 입력을 검증하고 잘못된 입력이라면 `IllegalArgumentException`을 발생시키고, 검증에 성공한다면 입력한 수를 List<Integer> 형태로 반환한다. 
    - 검증이 필요한 값은 다음과 같다.
      - 공백이 입력된 경우
      - 입력된 입력의 길이가 3이 아닌 경우
      - 1에서 9 외의 숫자가 입력된 경우
      - 중복된 값이 입력된 경우

6. BaseballUmpire
  - 숫자야구 게임의 '심판 역할'로 책임은 다음과 같다.
    - 주어진 규칙(GameRule)에 따라 경기 진행상황을 판단하며, 결과로 현재 경기 상태를 반환한다.

7. GameStatus
  - 게임의 진행 상태를 나타내는 책임을 가진 ENUM
    - 상태로 ONGOING(진행 중), END(종료)를 가진다.
