package hw4;

// 얘가 히어로인듯
public class DoctorCS {
    AI ai;
    final private String secretldentity;
    final public int jlaid; // DoctorCS
    boolean safe;

    public DoctorCS(AI ai, String secretIdentity, int jlaid) {
        this.ai = ai;
        this.secretldentity = secretIdentity;
        this.jlaid = jlaid;
        safe = false;
    }

    // 얘는 safe에 대한 setter임
    // ai가 RougeAI의 인스턴스면
    // firewallProtection이 0보다 큰 동안 lowerFirewall()을 계속 호출함
    // 저게 끝나거나 ai가 RandomAI면 ai에서 swapConnonTarget()을 호출하고
    // 매개변수는 ai의 secretHQ필드를 전달함
    // 반환값은 safe에 할당되어야 함
    public void saveTheDay() {
        if (ai instanceof RogueAI) {
            RogueAI newAI = (RogueAI) ai;
            while (newAI.getFirewallProtection() > 0) {
                newAI.lowerFirewall();
            }
            safe = newAI.swapCannonTarget(newAI.secretHQ);
        } else {
            RandomAI newAI = (RandomAI) ai;
            safe = newAI.swapCannonTarget(newAI.secretHQ);
        }
    }

    // 얘는 safe값과 ai에서 destructed값에 따라 다른 문자열을 반환함
    // safe가 참이면 “Doctor CS has saved the day!”
    // safe가 false고 destructed가 true면 “Dr. Chipotle has succeeded in his plan…”
    // 둘 다 아니면 “Georgia Tech is still in danger!”
    public String getStatus() {
        return (safe) ? "Doctor CS has saved the day!"
                : (ai.destructed) ? "Dr. Chipotle has succeeded in his plan…" : "Georgia Tech is still in danger!";
    }

    // "(secretIdentity) aka Doctor CS with JLAID: (jlaid)"
    @Override
    public String toString() {
        return secretldentity + "aka Doctor CS with JLAID: " + jlaid;
    }

    public String getSecretldentity() {
        return secretldentity;
    }

    public AI getAI() {
        return ai;
    }

    public void setAi(AI ai) {
        this.ai = ai;
    }

    public boolean isSafe() {
        return safe;
    }
}
