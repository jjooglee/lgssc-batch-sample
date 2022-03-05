package net.huray.lgssc.batch.sample.dynamic2;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class DynamicSchedule extends DynamicAbstractScheduler { // 실행로직


    @Override
    public void runner() {
        //job.helloJob();
    }

    // 실행주기
    @Override
    public Trigger getTrigger() {
        return new PeriodicTrigger(1, TimeUnit.SECONDS);
    }


}