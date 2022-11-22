package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.Moving.UP;
import static bridge.Result.UP_FAIL;
import static bridge.Result.UP_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {

    @Test
    void 이동_성공_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean isSuccess = bridgeGame.move(0, "U");
        assertThat(isSuccess).isEqualTo(true);
    }

    @Test
    void 이동_실패_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean isSuccess = bridgeGame.move(0, "D");
        assertThat(isSuccess).isEqualTo(false);
    }

    @Test
    void 총_시도_횟수_증가_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.retry();
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }
}
