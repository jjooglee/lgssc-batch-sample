package net.huray.lgssc.batch;


import net.huray.lgssc.batch.sample.Counter;
import org.awaitility.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.atLeast;

@SpringBootTest(properties = "fetch-rate=* * * * * *")
public class ScheduledIntegrationTest {

    @SpyBean
    Counter counter;

    @Test
    public void givenSleepBy100ms_whenGetInvocationCount_thenIsGreaterThanZero()
        throws InterruptedException{

        await()
                .atMost(Duration.ONE_SECOND)
                .untilAsserted(() -> verify(counter, atLeast(1)).scheduled());
    }

}
