package hw4;

public class RogueAI extends AI {
    // 얘는 방화벽과 경보 수준을 감지 가능
    // 방화벽을 낮출 수 있지만 그러면 경고 수준도 높아짐
    // 경고 수준이 최대 수준을 초과하면 자가 파괴 바이러스 활성
    // 해당 RogueAI가 제거됨

    // 방화벽의 보안 수준을 나타냄
    // 닥터 CS는 비밀 정보에 접근하기 위해 먼저 0으로 낮춰야 함
    private int firewallProtection;

    // 컴퓨터의 현재 경고 수준을 나타냄
    // 닥터 CS가 방화벽을 낮추거나 guacccanoon의 목표물을 교체하려고 할 때마다 오름
    private int alertLevel;

    // 컴퓨터가 자체적으로 파괴하는 경고 수준을 나타냄
    // alertLevel이 이 값을 초과하면 ㅂㅂ
    private final int maxAlert;

    public RogueAI(int firewallProtection, int alertLevel, int maxAlert, Coordinates cannonTarget,
            Coordinates secretHQ) {
        this.firewallProtection = firewallProtection;
        this.alertLevel = alertLevel;
        this.maxAlert = maxAlert;
        super.cannonTarget = cannonTarget;
        super.secretHQ = secretHQ;
    }

    public RogueAI(int firewallProtection, int maxAlert, Coordinates cannonTarget, Coordinates secretHQ) {
        this(firewallProtection, 0, maxAlert, cannonTarget, secretHQ);
    }

    public RogueAI(int firewallProtection, Coordinates cannonTarget, Coordinates secretHQ) {
        this(firewallProtection, 0, 10, cannonTarget, secretHQ);
    }
}

// Methods
// This class has the following methods alongside the getters specified in the
// Fields section:

// public void lowerFirewall(). This method should decrement firewallProtection
// by 2, and increment alertLevel by 1 when invoked.

// public boolean shouldSwapCannonTarget(). This method should override the
// abstract method found in AI.java. It should return whether or not
// firewallProtection is less than or equal to 0.

// public boolean shouldSelfDestruct(). This method should override the abstract
// method found in AI.java. It should return whether or not alertLevel is
// greater than or equal to maxAlert.

// public String toString(). This method returns the String representation of
// the RogueAI’s fields in the following format:

// "Dr. Chipotle’s guacamole cannon is currently pointed at (cannonTarget), and
// is at alert level (alertLevel) with firewall protection
// (firewallProtection)." Properly reuse code here or you could lose points

// For example, a possible output of the toString() method could look like this:

// "Dr. Chipotle's guacamole cannon is currently pointed at latitude: 13.31,
// longitude: 13.01, and is at alert level 10 with firewall protection 5."