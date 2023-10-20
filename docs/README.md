

## 기능 요구사항
1. 기본적으로 1부터 9까지 "서로 다른 수"로 이루어진 3자리의 수를 맞추는 게임이다.
   -> 즉 0이 들어가지 않음 + 중복 불가.
2. 조건
    * 스트라이크 : 같은 수 같은 자리
    * 볼 : 같은 수 다른 자리
    * 낫싱 : 다른 수 다른 자리
3. 사용자가 답을 맞출 때까지 입력하는 동작 방식.
   -> 답을 맞추면 사용자는 종료(1), 재도전(2)할 수 있음
   -> 옳지 않은 답 입력시 즉시 IllegalArgumentException을 발생		
   (예를 들어 3자리의 정수가 아닌 수, 문자형 등)

    
---

## 입출력 요구사항
* 입력
    * 서로 다른 3자리의 수
    * 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

* 출력
  : 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
  ex1) 1볼 1스트라이크
  ex2) 맞는 수가 하나도 없는 경우
  -> 낫싱
  ex3) 3개의 숫자를 모두 맞춘 경우
  -> 3스트라이크
  ->3개의 숫자를 모두 맞히셨습니다! 게임 종료
  ex4) 시작문구 출력
  ->숫자 야구 게임을 시작합니다.

---


## 프로그래밍 요구사항
1. 외부 라이브러리 사용금지
2. JAVA 코드 컨벤션 가이드를 준수할 것!!(아주중요)
3. 프로그램 종료 시 System.exit()를 호출하지 않는다.
4. 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. (테스트가 실패할 경우 0점 처리한다.)

---

## 라이브러리

: camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
* Random 값 추출
:  camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
* 사용자가 입력하는 값
: camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

사용예시
```
코드를 List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

