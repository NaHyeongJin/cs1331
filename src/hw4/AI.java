package hw4;

public abstract class AI {
    private boolean destructed = false;
    protected Coordinates cannonTarget;
    protected Coordinates secretHQ;

    // 얘는 cannonTarget 변수 변경을 시도함
    // 그 다음 cannonTarget이 변경되었는지 확인함
    // destructed가 false고 newCoords가 cannonTarget이랑 다르면
    // shouldSwapCannonTarget()이 true를 반환하면
    // cannonTarget을 newCoords와 동일하게 설정
    // 설정 후 return true
    // shouldSelfDestruct()가 true를 반환하면
    // selfDestruct () 메서드를 호출 한 다음 return false
    // 그 외에는 전부 return false
    public boolean swapCannonTarget(Coordinates newCoords) {
        if (!destructed && !newCoords.equals(cannonTarget)) {
            if (shouldSwapCannonTarget()) {
                cannonTarget = newCoords;
                return true;
            }
        } else if (shouldSelfDestruct()) {
            selfDestruct();
        }
        return false;
    }

    public abstract boolean shouldSwapCannonTarget();

    // 얘는 destructed에 대한 setter로 작동하지만
    // 호출 될 때마다 destruceted를 true로 설정함
    public void selfDestruct() {
        destructed = true;
    }

    public abstract boolean shouldSelfDestruct();

    // "Dr. Chipotle’s guacamole cannon is currently pointed at (cannonTarget)."
    // for exam "Dr. Chipotle's guacamole cannon is currently pointed at latitude:
    // 13.31, longitude: 13.01."
    public String toString() {
        return "Dr. Chipotle's guacamole cannon is currently pointed at " + cannonTarget;
    }

    public boolean getDestructed() {
        return destructed;
    }

    public Coordinates getSecretHQ() {
        return secretHQ;
    }
}
