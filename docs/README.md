# 기능 요구 사항
### 1~9까지의 서도 다른 수로 이루어진 3자리 수 (RandomNumberGenerator)
- [x] 1~9까지의 랜덤한 숫자를 생성한다. (generateRandomNumber)
- [x] 랜덤한 숫자가 이미 존재하는 숫자인지 판별한다. (isNumberExisted)
- [x] 1~9까지의 서도 다른 수로 이루어진 3자리 수를 반환한다. (getRandomNumber)
- [x] 3자리의 1~9까지의 서로 다른 수로 이루어진 숫자를 생성한다. (RandomNumberGenerator)
- [x] 1~9까지의 랜덤한 숫자를 생성한 후 이미 존재하는 숫자인지 판별하여 존재하지 않는 숫자일 경우 숫자를 추가한다. (addUniqueRandomNumber)
### 랜더한 3자리 수를 적용할 공 객체 (Ball)
- [x] 공은 위치와 숫자를 가진다. (Ball)
- [x] 공의 위치와 숫자가 같은면 같은 공이다. (equals, hashCode)
### 볼 판정을 나타내는 Enum (BallStatus)
- [x] STRIKE, BALL, NOTHING을 가진다. (BallStatus)
### 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱을 판정하는 클래스(BallJudgement)
- [x] 랜덤한 3자리 수를 3개의 볼객체 리스트로 변환한다. (BallJudgement)
- [x] 컴퓨터의 공들과 사용자의 공을 비교하여 스트라이크, 볼, 낫싱을 판별한다. (BallJudgement)
- [x] 컴퓨터의 볼들 중 같은 숫자를 가진 볼이 있는 경우 true를 반환한다. (isAnyMatchBallNumber)
### 사용자가 입력한 3자리 수에 대한 결과를 볼, 스트라이크 개수로 표시 (JudgeResult)
- [ ] 사용자가 입력한 3자리의 수를 3개의 볼객체 리스트로 변환한다.
- [ ] 컴퓨터의 공들과 사용자의 공을 비교하여 스트라이크, 볼, 낫싱을 판별한다
- [ ] 스트라이크, 볼, 낫싱 결과를 출력한다.
### 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다. (PlayerInputValidator)
- [ ] 사용자가 입력한 값이 3자리의 숫자인지 판별한다.
- [ ] 사용자가 입력한 값이 1~9까지의 서로 다른 수로 이루어진 숫자인지 판별한다.
- [ ] 사용자가 입력한 값이 서로 다른 수로 이루어진 숫자인지 판별한다.