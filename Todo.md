# 각 클래스 별 역할, 기능(메서드) 구현

## 🔥 Application.class
### main 메서드
- "야구게임 시작" 메세지 출력
- baseball객체의 play메서드 호출

## 🔥 Baseball.class
1. Answer 생성자를 통해 정답이 되는 숫자 생성
2. while(true){ ... }
   - try-catch문 : 사용자에게 숫자 입력 받기 -> userInput 객체 생성
3. score 객체를 생성하여 점수 내고 출력
4. 게임이 종료 되었을 때 재시작 or 종료 조건문 -> `gameover()` 메서드로 작성

## 🔥 Answer.class
- 조건에 만족하는 수가 만들어 지도록 `createAnswer()` 메서드에 구현
- Answer 생성자 호출 시 createAnswer() 메서드를 통해서 정답이 생성됨
  ```
  camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  ```

## 🔥 UserInput.class
- UserInput 생성자 호출 시, 
  1. String으로 들어온 입력값의 길이 유효성 검사 (`validateLength()`)
  2. String을 List<Integer>로 변환 (`stringToList()`)
  3. 3자리 수 중에서 중복되는 수가 있는지 유효성 검사 (`validateNum()`)
      - if, 올바르게 입력된 숫자(3자리 수, 1~9중 서로 다른 수로 이루어짐) -> pass
      - else, 잘못 입력한 숫자 -> `throw IllegalArgumentException`
        , catch문에서 게임 종료시키기

## 🔥 Score.class
   - Score 생성자 호출 시, answer 객체와 userInput 객체 주입받음
   - 점수 구하는 메서드 호출 -> 점수 리턴 (`checkScore()`)
   - 출력 로직 구현
     - [3, 0] : 3스트라이크 출력, 반복문 break
     - [0, 0] : 미싱 출력
     - [1, 2] : 2볼 1스트라이크 출력

## 🚨 주의사항
- 생성자는 가볍게 만들기