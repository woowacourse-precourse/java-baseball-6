# 🚩️ 구현해야 하는 기능 정리

## ✅ 입력 값을 검증하는 검증 클래스 (InputValidator)

- 입력에는 **두 가지의 종류**가 있다. 문제의 정답을 제시하는 입력, 재시작/종료 여부에 관한 입력
- 문제의 정답을 제시하는 입력
    - 중복없는 3자리의 1~9 사이의 숫자를 입력해야 한다.
        - 중복 검사
        - 3자리 검사
        - 1~9 사이의 숫자 검사
        - 입력값에 문자 포함 검사
- 재시작/종료 여부에 관한 입력
    - 1 또는 2의 숫자만 입력
        - 길이가 1인지 검사
        - ‘1’인지 ‘2’인지 검사
- 검증 실패 시 throw IllegalArgumentException

## ✅ 난수(숫자게임의 정답) 생성 클래스 (Computer)

- 라이브러리가 제공하는 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용

## ✅ 입력 값으로부터 점수를 계산하는 클래스 (Computer)

1. Strike 검사
    1. 입력
    2. 3의 컨버터로 List<Integer> input 로 변환
    3. 2에 의해 생성된 정답도 List<Integer> answer로 변환
    4. .filter().count() 로 동일한 인덱스에 대해 값이 일치하는 갯수를 구해서 리턴한다.
2. Ball 검사
    1. 입력
    2. 3의 컨버터로 List<Integer> input 로 변환
    3. 2에 의해 생성된 정답도 List<Integer> answer로 변환
    4. .filter().count()로 (동일한 인덱스에 대해 값이 일치하지 않으면서) && ( 값을 포함하고 있는 ) 갯수를 구해서 리턴한다.

## ✅ 입력 받은 String을 List<Integer>로 바꾸는 컨버터 (StringToIntegerListConverter)

1. 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
2. 라이브러리를 살펴보면 String으로 리턴하는데, 점수를 계산하기 용이하게 하기 위해 이 컨버터 클래스를 만들어 List<Integer> 형태로 바꾸어 주도록 하자.

```
public static String readLine() {
    returngetInstance().nextLine();
}
```

---

# 구현 방식 정리

- MVC 패턴에 입각해서 구현해보자.

## 📦 Model

1. Computer(Model)  : 숫자게임의 정답인 난수를 생성해서 리턴하는 객체이자, 점수를 계산한 결과를 리턴하는 객체
    1. 숫자게임의 정답인 난수를 생성해서 컨트롤러에게 전달한다.
    2. Player로부터 값을 전달 받아 숫자게임의 정답과 비교해서 점수를 Score에 담자.
2. Player(Model) : 사용자가 입력한 값(숫자야구게임에서 제시한 값, 재시작/종료 여부에 대한 값)을 담고 있는 객체
    1. 입력한 값에 대한 검증은 InputValidator를 사용해 자체적으로 클래스 내부에서 검사한다. -> 검증 실패 시 예외 발생
    2. 즉, Player 객체는 사용자가 입력한 값을 검증하고 검증된 값을 담고 있음.
3. Score(Model) : 숫자게임의 결과인 스코어를 담고 있는 객체
    1. 필드는 Integer strike, Integer Ball을 가진다.
    2. strike 필드의 값이 3인지 검사하는 메소드를 갖는다.

## 📺 View

1. OutputView
    1. 콘솔을 통해 사용자에게 ‘각각’ 다르게 보여줄 **결과**를 출력하는 클래스

   > 0볼 1스트라이크, 0볼 2스트라이크, 1볼 0스트라이크, 1볼 1스트라이크, 2볼 0스트라이크, 낫싱, 3스트라이크, 3개의 숫자를 모두 맞히셨습니다!  게임 종료

2. InputView
    1. Score(Model)로부터 점수, 결과를 받아서 콘솔로 출력하자.
    2. 사용자에게 ‘모두 동일하게’ 출력해야 하는 메시지(입력에 대한 요청 메시지)를 출력
   > "숫자 야구 게임을 시작합니다." "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." "숫자를 입력해주세요 : "

## 🎮 Controller

1. BaseballGameController
    1. Model과 View를 연결해주는 역할.
    2. Model로부터 데이터를 받는다.
    3. 2에서 받은 데이터를 View에게 전달한다.
