# ⚾️ 미션 - 숫자 야구

## 📌 기능 구현 목록

1. 게임 시작을 위한 Console Class인 *BaseBallGame* 을 생성한다.
2. 게임을 시작한다.
    1. *camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API*를 사용하여 *computer* 의 정답 숫자 3자리를 저장한다.
    2. *player* 의 숫자 3자리를 입력한다.
    3. player과 computer의 숫자를 비교하여 결과를 출력한다.
        1. 숫자와 자릿수가 같은 값이 3개일 경우 게임종료
            - 게임 재시작 또는 게임 종료 선택
        2. 숫자와 자릿수가 같을 경우 Strike 카운트 +1만큼 증가
        3. 숫자는 같지만, 자릿수가 다를경우 Ball 카운트 +1만큼 증가
- 게임을 위한 domain package에 *BaseBall.class* 를 생성한다.
    - player, computer 각각 인스턴스를 생성한다.
- 게임 진행 시 필요한 기능은 *BaseBallService.class* 에서 처리한다.
  - 3Strike인가?
  - 3Strike 이외의 경우(1B 2S, 3B 등) 
  - 사용자 입력 값에 대한 결과 출력
  - 게임 재시작 또는 종료 안내
- 상수 문자열 처리를 위한 *Constant.class* 를 생성한다.

## 📌 예외처리 목록
#### 모든 예외는 IllegalArgumentException으로 처리한 후 Application을 종료한다.
- 상수 문자열 처리를 위한 *InputValidate.class* 를 생성한다.
- 숫자를 3개 초과 또는 미만 입력했을 경우
- 1~9 까지의 숫자가 아닌 다른 값을 입력했을 경우
- 게임 종료 후 재시작 1번 또는 종료 2번 이외의 값을 입력했을 경우
- 숫자가 아닌 특수문자, 문자 등을 입력했을 경우
- 입력받은 숫자 3개 중 중복된 값이 있는지 검증

## 📌 테스트 검증
- 난수를 생성할 때 숫자 3자리가 올바르게 생성이 되는가?
- IllegalArgumentException이 발생하는가?
    - 숫자를 3개 초과 또는 미만 입력했을 경우
    - 1~9 까지의 숫자가 아닌 다른 값을 입력했을 경우
    - 게임 종료 후 재시작 1번 또는 종료 2번 이외의 값을 입력했을 경우
    - 숫자가 아닌 특수문자, 문자 등을 입력했을 경우
    - 입력받은 숫자 3개 중 중복된 값이 있는지 검증
