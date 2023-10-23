# 미션 - 숫자 야구

숫자 야구에서 문제를 출제하고, 볼/스트라이크를 판정하는 컴퓨터를 구현한다. 

구현할 프로그램의 flowchart를 그려보면 다음과 같다. 

![image](flowchart.png)


## 기능 목록

<details>
<summary>1. 문제 생성</summary>
<div markdown="1">

1~9 사이의 **서로 다른 임의의 수 3개를 선택**한다.

`camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용

</div>
</details>
<details>
<summary>2. 사용자로부터 입력 값을 받아 검증한다. </summary>
<div markdown="1">

`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용해 사용자로부터 입력받는다.

사용자는 3개의 중복되지 않는 숫자를 연속하여 입력해야 한다. 이외의 입력이 들어오면 예외를 발생시킨다.

2-1. 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.

2-2. 사용자가 올바른 값을 입력한 경우, 3을 진행한다.

</div>
</details>

<details>
<summary>3. 스트라이크/볼을 판단한다. </summary>
<div markdown="1">

3-1. 정답에 해당하는 숫자가 적절한 위치에 있으면 '스트라이크' 로 판정한다.

3-2. 정답에 해당하는 숫자가 존재하나, 부적절한 위치에 있는 경우 '볼' 로 판정한다.

</div>
</details>
<details>
<summary> 4. 결과를 판정한다. </summary>
<div markdown="1">

모든 입력값에 대해 다음을 조사한다.

4-1. 입력받은 값이 문제 내에 존재하고, 같은 인덱스에 있으면 스트라이크 값을 1 증가시킨다.

4-2. 입력받은 값이 문제 내에 존재하고, 다른 인덱스에 있으면 볼 값을 1 증가시킨다.

</div>
</details>

<details>
<summary> 5. 결과를 출력한다. </summary>
<div markdown="1">

5-1. 스트라이크와 볼이 모두 0이면, "낫싱"을 출력한다.

5-2. 볼이 0 이상이면, 볼 개수를 출력한다.

5-3. 스트라이크가 0 이상이면, 스트라이크 개수를 출력한다.
</div>
</details>
<details>
<summary> 6. 게임 프로세스의 종료 여부를 확인한다.  </summary>
<div markdown="1">

사용자로부터 값을 입력받는다. 

6-1. 1을 입력받은 경우 1로 돌아간다.

6-2. 2를 입력받은 경우 게임 프로세스를 종료한다.

6-3. 1과 2를 제외한 값을 입력받은 경우, `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
</div>
</details>


---

## 주요 고려사항

1. 코드의 가독성

반복문과 조건문을 줄이기 위해 Stream을 사용했고, 주요 기능별로 메서드를 분리해주었다.
그러나 여전히 코드의 가독성이 좋지 않아 조금 더 고민해봐야할 것 같다. 
스트라이크와 볼을 판정하고 결과값을 출력하는 부분을 병합하는 것을 고려하고 있다.

2. 효율

어떤 데이터 타입을 사용하는 것이 적절한가