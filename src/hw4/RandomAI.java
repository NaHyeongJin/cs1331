package hw4;

import java.util.Random;

public class RandomAI extends AI {

    // 얘는 swapCannonTarget()에 명령하면
    // 50프로 확률로 타겟을 바꾸고
    // 50프로 확률로 안 바꾸는데
    // 안 바꾸면 50프로 확률로 얘가 자폭

    Random randomizer = new Random(); // 얘가 확률결정

    public RandomAI(Coordinates cannonTarget, Coordinates secretHQ) {
        this.cannonTarget = cannonTarget;
        this.secretHQ = secretHQ;
    }

    // 얘는 50퍼 확률로 true 반환
    @Override
    public boolean shouldSwapCannonTarget() {
        return percent50();
    }

    // 얘도 50퍼 확률로 true 반환
    public boolean shouldSelfDestruct() {
        return percent50();
    }

    private boolean percent50() {
        if (randomizer.nextInt(100) < 50)
            return true;
        return false;
    }
}
