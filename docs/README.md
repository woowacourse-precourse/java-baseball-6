## ❗️구현할 기능 목록 정리하기

### ✅ 기능 목록

#### 게임결과를 얻어오는 역할 (Referee)

- [x] GameResult를 반환한다. `public`

##

#### 힌트를 계산하여 담고있는 역할 (GameResult)

- [x] 힌트 getter `public`
- [x] 힌트를 계산한다 `private`
- [x] 낫싱 힌트 문자열 생성 `private`
- [x] 스트라이크 힌트 문자열 생성 `private`
- [x] 볼 힌트 문자열 생성 `private`

##

#### 1 ~ 9까지 유니크한 3자리의 야구공을 관리하는 자료구조 역할(BaseballCollection)

- [x] 컴퓨터 야구공을 생성 `public`
- [x] 사용자 야구공을 생성 `public`
- [x] 스트라이크 개수 구하기 `public`
- [x] 볼 개수 구하기 `public`
- [x] 3자리 유니크한 숫자 String을 생성 `private`
- [x] 유효한 List<.Integer> 야구공을 생성 `private`
- [x] String 유니크 유효성 검증 `private`
- [x] String 3자리 유효성 검증 `private`
- [x] String 1 ~ 9 범위 유효성 검증 `private`
- [x] String 숫자가 아닌 문자 포함 여부 유효성 검증 `private`
- [x] 스트라이크 확인 `private`
- [x] 볼 확인 `private`

##

#### 입력 역할 (Input)

- [x] 콘솔 입력 기능

##

#### 출력 역할 (Output)

- [x] 콘솔 출력 기능
    - [x] 숫자 야구 게임을 시작합니다.
    - [x] 숫자를 입력해주세요 :
    - [x] 힌트 출력
    - [x] 3개의 숫자를 모두 맞히셨습니다! 게임 종료
    - [x] 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

##

#### 야구공 검증 역할 (BaseballValidator)

- [x] 사용자 공 입력 검증 기능
    - [x] length 자릿수로 입력해야 한다
    - [x] 숫자만 입력해야 한다
    - [x] 서로 다른 숫자로만 입력해야 한다
    - [ ] 0이 포함되지 않아야 한다

##

#### 재시작 커맨드 검증 역할 (RestartCommandValidator)

- [x] 게임 재시작 입력 검증 기능
    - [x] length 자릿수로 입력해야 한다
    - [x] 숫자만 입력해야 한다
    - [x] 1 또는 2만 입력해야 한다

##

#### 게임 관리자 역할  (GameManager)

- [x] 게임을 최초로 시작한다
- [x] 게임 순서에 맞게 게임을 진행한다
- [x] 힌트가 3스트라이크면 게임 종료
- [x] 게임 종료 후, 게임 재시작 여부를 확인한다