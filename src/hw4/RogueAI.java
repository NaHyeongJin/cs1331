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

    // 얘는 firewallProtection을 줄여야 함
    // alertLevel++;
    public void lowerFirewall() {
        firewallProtection -= 2;
        alertLevel++;
    }

    public boolean shouldSwapCannonTarget() {
        return (firewallProtection <= 0);
    }

    @Override
    public boolean shouldSelfDestruct() {
        return (alertLevel >= maxAlert);
    }

    @Override
    public String toString() {
        return super.toString() + ", and is at alert level " + alertLevel + " with firewall protection "
                + firewallProtection;
    }

    public int getFirewallProtection() {
        return firewallProtection;
    }
}