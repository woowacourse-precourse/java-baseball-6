# 🚩️ 구현해야 하는 기능 정리

✅ 입력 값을 검증하는 검증 클래스 (InputValidator)

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

✅ 난수(숫자게임의 정답) 생성 클래스 (Computer)

- 라이브러리가 제공하는 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용

✅ 입력 받은 String을 List<Integer>로 바꾸는 컨버터 (StringToIntegerListConverter)

1. 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다. 라이브러리를 살펴보면 String으로 리턴하는데, 점수를 계산하기 용이하게
   하기 위해 List<Integer> 형태로 바꾸어 준다.

```
public static String readLine() {
    returngetInstance().nextLine();
}
```

✅ 입력 값으로부터 점수를 계산하는 클래스

1. Strike 검사 :
    1. 입력
    2. 3의 컨버터로 List<Integer> input 로 변환
    3. 2에 의해 생성된 정답도 List<Integer> answer로 변환
    4. .filter().count() 로 동일한 인덱스에 대해 값이 일치하는 갯수를 구해서 리턴한다.
2. Ball 검사 :
    1. 입력
    2. 3의 컨버터로 List<Integer> input 로 변환
    3. 2에 의해 생성된 정답도 List<Integer> answer로 변환
    4. .filter().count()로 (동일한 인덱스에 대해 값이 일치하지 않으면서) && ( 값을 포함하고 있는 ) 갯수를 구해서 리턴한다.