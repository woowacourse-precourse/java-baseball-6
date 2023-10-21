# ✨ 기능 구현 목록 ✨

## Domain 구성
***
### BaseballPosition
#### **Field**
    1부터 9까지의 범위 중 하나의 위치를 저장(ballPosition)
#### **Method**
    위치가 같은지 확인(equals)
    위치를 입력으로 받아서 BaseballPosition 인스턴스 생성(from)

### 2. Pitcher(컴퓨터)
#### Method
    랜덤한 위치(1부터 9 사이)로 공을 던짐(pitch)

### 3. Batter(사용자)
#### **Field**
    Pitcher(컴퓨터)가 생성한 숫자를 추측한 내용(battedPositions)
#### **Method**
    입력을 받은 후 battedPositions에 값을 저장(bat)

### 4. Umpire(심판)
#### **Field**
    Pitcher가 던질 위치를 저장 => Batter의 추측 결과 판단(umpireBasis)
#### **Method**
    Batter의 추측을 기준으로 스트라이크와 볼 결과 반환(umpire)

### 5. BaseballGame
#### **Field**
    Pitcher
    Batter
    Umpire
### **Method**
    플레이 시작(play)
