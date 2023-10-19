# 1. 사용 가능 Library

- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
  - Random 값 추출 &ensp;&ensp;&ensp;&ensp; : Randoms.pickNumberInRange()
  - 사용자가 입력하는 값 :  Console.readLine() <br/><br/>
 - 사용 예시
```
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```
<br>

- - -

# 2. 구현 과정
## 2.1. 필수 구현 logic 작성
1. (컴퓨터): random한 숫자 3개를 추출 - pickNumberInRange() 이용
2. (사람) : String 입력 - Console.readLine() 사용
3. 조건 문을 통해서 출력값 나타내기 - System.out.println()
4. 예외 처리하기 - IllegalArgumentException

<br>

- - -

# 3. background 필요 학습
1. missionutils 자체 API를 gradle에 어떻게 넣었는지
2. ./gradlew clean test 이렇게 터미널에서 수행되는 코드 분석
3. assertSimpleTest, assertRandomNumberInRangeTest - test 코드 공부
4. md 문법 정리
5. git 공부 