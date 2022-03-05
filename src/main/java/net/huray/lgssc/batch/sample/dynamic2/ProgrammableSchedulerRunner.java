package net.huray.lgssc.batch.sample.dynamic2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProgrammableSchedulerRunner {
    @Autowired
    ProgrammableScheduler scheduler;

    public void runSchedule() { // called by somewhere
        scheduler.startScheduler();
    }
}
