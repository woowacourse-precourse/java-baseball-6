# 숫자 야구 기능 목록

## 1. 숫자 야구 게임 시작

- 게임 시작 문구 출력
  > `숫자 야구 게임을 시작합니다.`

<br>

## 2. Random 값 추출

- 라이브러리는 `camp.nextstemp.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API 사용
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용

<br>

## 3. 사용자 숫자 입력 받기

- 1부터 9까지 서로 다른 3개의 숫자 입력
- 라이브러리는 `camp.nextstemp.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API 사용
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용
- 예외 처리 `IllegalArgumentException`
    - 중복된 숫자를 입력받은 경우
    - 숫자의 개수가 3개가 아닌 경우
    - 숫자가 아닌 값을 입력받은 경우
    - 0을 입력받은 경우

<br>

## 4. 입력한 숫자로 정답 힌트 얻기

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
    - 예시는 볼을 스트라이크보다 먼저 출력
- 같은 수가 같은 자리에 있으면 스트라이크
- 같은 수가 다른 자리에 있으면 볼
- 같은 수가 전혀 없으면 낫싱
- 3 스트라이크 즉, 정답인 경우 게임 종료
- 정답이 아닌 경우, `3번`으로 돌아가 다시 사용자 숫자 입력 받기

<br>

## 5. 게임 종료 시

- 1번 입력받을 시 게임 재시작
- 2번 입력받을 시 프로그램 종료