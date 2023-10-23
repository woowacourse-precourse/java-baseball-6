# 각 클래스 별 역할, 기능(메서드) 구현

## 🔥 Application.class
### main 메서드
1. Answer클래스에서 숫자생성 메서드 호출
2. while(true){ ... }
   - 사용자에게 숫자 입력 받기 -> NaturalNum클래스 생성자로 만들기
     -> 생성자 안에 검증 로직을 넣어도 될까..
   - try-catch문
     - 숫자 검증 로직 메서드(`verify()`) 호출 -> 검증
       - if, 올바르게 입력된 숫자(3자리 수, 1~9중 서로 다른 수로 이루어짐) -> pass
       - else, 잘못 입력한 숫자 -> `throw IllegalArgumentException`
                                , catch문에서 게임 종료시키기
   - 점수 확인 로직 메서드(`score`) 호출 -> 점수 리턴
   - 출력 로직 구현
     - [0, 3] : 3스트라이크 출력, 반복문 break
     - [0, 0] : 미싱 출력
     - [1, 2] : 1볼 2스트라이크 출력


## 🔥 Baseball.class
- 점수 판단 해주는 메서드 : `score(int input)`
   return : 볼 개수, 스트라이크 개수 두 수를 저장하는 배열

- Q. 출력 로직을 구현할 때, main에서 score의 결과를 바탕으로 분기 형성해서 출력하는게 나을까..
    아니면 출력을 맡는 메서드를 새로 만드는게 나을까..?

## 🔥 Answer.class
- 처음에 baseball 게임의 기준이 되는 랜덤숫자 만드는 메서드
    - final static(상수)로 저장
```
camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
```

## 🔥 NaturalNum.class
- 입력된 숫자들의 유효성 검증 (숫자 검증 로직 메서드 : `verify(int input)`)
  - 숫자의 길이(3자리), 범위(1~9), 세 개의 숫자 중 겹치는 게 있는가
- List<Integer>로 리턴

## 🚨 주의사항
- 생성자는 가볍게 만들기