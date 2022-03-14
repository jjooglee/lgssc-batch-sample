package net.huray.lgssc.batch.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
//@Component
public class Counter {

    private AtomicInteger count = new AtomicInteger(0);

    @Scheduled(fixedDelay = 5)
    @Scheduled(cron = "${fetch-rate:0 * * * * MON-FRI}")
    public void scheduled() {
        this.count.incrementAndGet();
        log.debug("==================" + String.valueOf(this.count.get()));
    }

    public int getInvocationCount() {
        return this.count.get();
    }
}
