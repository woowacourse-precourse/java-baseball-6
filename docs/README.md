# **🚩️ 구현해야 하는 기능 정리**

## **✅ 입력 값을 검증하는 검증 클래스 (InputValidator)**

- 입력에는 **두 가지의 종류**가 있다. 문제의 정답을 제시하는 입력, 재시작/종료 여부에 관한 입력
- 플레이어가 제시한 숫자게임의 정답 3자리 문자열에 대한 Validator ( **GuessNumbersValidator** )
    - 중복없는 3자리의 1~9 사이의 숫자를 입력해야 한다.
        - 중복 검사
        - 3자리 검사
- 플레이어가 제시한 재시작/종료 여부에 대한 Validator ( **GameStateNumberValidator** )
    - 1 또는 2의 숫자만 입력
        - 길이가 1인지 검사
        - ‘1’인지 ‘2’인지 검사
- 플레이어가 제시한 숫자게임의 정답 1자리 문자에 대한 Validador **(GuessNumberValidator)**
    - 1~9 사이의 ‘숫자’ 검사 -> 검증 실패 시 throw IllegalArgumentException

## **✅ 난수(숫자게임의 정답) 생성 클래스 (Computer - GameAnswer)**

- 라이브러리가 제공하는 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용

## **✅ 입력 값으로부터 점수를 계산하는 클래스 (Computer - Score)**

1. Strike 검사
    1. 입력
    2. 3의 컨버터로 List input 로 변환
    3. 2에 의해 생성된 정답도 List answer로 변환
    4. .filter().count() 로 동일한 인덱스에 대해 값이 일치하는 갯수를 구해서 리턴한다.
2. Ball 검사
    1. 입력
    2. 3의 컨버터로 List input 로 변환
    3. 2에 의해 생성된 정답도 List answer로 변환
    4. .filter().count()로 (동일한 인덱스에 대해 값이 일치하지 않으면서) && ( 값을 포함하고 있는 ) 갯수를 구해서 리턴한다.

## **✅ 입력 받은 String을 List로 바꾸는 컨버터 (StringToIntegerListConverter)**

1. 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
2. 라이브러리를 살펴보면 String으로 리턴하는데, 점수를 계산하기 용이하게 하기 위해 이 컨버터 클래스를 만들어 List 형태로 바꾸어 주도록 하자.

```
public static String readLine() {
    return getInstance().nextLine();
}

```

---

# **🚩 구현 방식 정리**

- MVC 패턴에 입각해서 구현해보자.

## **📦 Model**

1. Computer(Model) : 숫자게임의 정답인 난수를 스스로 생성해서 필드로 가지고 있는 객체이자, 플레이어가 제시한 입력에 대한 점수를 계산한 결과를 가지고 있는 객체.
    - (GameAnswer) - 숫자게임의 정답인 난수를 클래스 내부에서 생성하여 가지고 있음.
        - 내부 필드는 List를 가진다.
        - 정답은 클래스 내부에서 생성한다.
    - (Score) - Player로부터 값을 받아 숫자게임의 정답(GameAnswer)과 비교해서 계산한 점수를 가지고 있음.
        - 숫자게임의 결과인 스코어를 담고 있는 객체
        - 내부 필드는 Integer strike, Integer ball을 가진다.
        - 점수는 클래스 내부에서 계산한다.

**❗️즉,** **GameAnswer, Score는 일급 컬렉션으로 관리한다.**

1. Player(Model) : 사용자가 입력한 값(숫자야구게임에서 제시한 값, 재시작/종료 여부에 대한 값)을 담고 있는 객체
    - (GuessNumbers) - 숫자게임에 대한 입력값(GuessNumber) 3개를 List형태로 가지고 있다.
        - 즉, 내부 필드는 List<GuessNumber>을 가진다.
        - 필드에 할당할 입력값 3개에 대한 검증은 GuessNumbers 클래스 내부에서 이루어진다.
    - (GuessNumber) - 숫자게임에 대한 입력값 1개
        - 내부 필드는 Integer number를 가진다.
        - 필드에 할당할 입력값 1개에 대한 검증은 GuessNumber 클래스 내부에서 이루어진다.
    - (GameStateNumber) - 게임상태의 입력값을 가지고 있다.
        - 내부 필드는 Integer stateNumber를 가진다.
        - 필드에 할당할 입력, 검증은 클래스 내부에서 이루어진다.

**❗️GuessNumbers, GameStateNumber을 일급 컬렉션으로 관리한다.**

‘’입력한 값에 대한 검증은 위에서 구현한 validator를 사용해 자체적으로 클래스 내부에서 검사한다.’’ -> 검증 실패 시 예외 발생

## **📺 View**

1. OutputView
    1. 콘솔을 통해 사용자에게 '각각 다르게' 보여줄 **숫자게임의 결과**를 출력하는 클래스
    2. Score(Model)로부터 점수, 결과를 받아서 콘솔로 출력하자.

   > 낫싱, 1스트라이크, 2스트라이크, 3스트라이크, 1볼, 2볼, 3볼, 1볼 1스트라이크, 2볼 1스트라이크, 3개의 숫자를 모두 맞히셨습니다! 게임 종료

>

2. InputView
    1. 사용자에게 ‘모두 동일하게’ 출력해야 하는 메시지인 (입력에 대한 요청 메시지)를 출력

   > "숫자 야구 게임을 시작합니다." "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." "숫자를 입력해주세요 : "

>

## **🎮 Controller**

1. BaseballGameController
    1. Model과 View를 연결하는 역할로, 전반적인 프로그램의 흐름을 조율한다.
    2. Model로부터 데이터를 받는다.
    3. 2에서 받은 데이터를 View에게 전달한다.

---

# **🚩 MVC 패턴에 입각하여 구현 시 지켜야 할 사항**

### **☑️ Model은 Controller와 View에 의존해서는 안된다.**

→ 즉, Model내부에서 Controller와 View와 관련된 코드가 있어서는 안된다.

### **☑️ View는 Model에만 의존해야 하고, Controller에는 의존해서는 안된다.**

### **☑️ View가 Model로 부터 데이터를 받을 때 “사용자마다 다르게 보여주어야 하는 데이터”에 대해서만 받아야 한다.**

### **☑️ Controller는 Model과 View에 의존할 수 있다.**

### **☑️ View가 Model로부터 데이터를 받을 때, 반드시 Controller에서 받아야 한다.**