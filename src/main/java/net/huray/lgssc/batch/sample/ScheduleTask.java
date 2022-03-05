package net.huray.lgssc.batch.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class ScheduleTask {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job helloJob;

    @Scheduled(cron="${crontab.hello}")
    public void helloJob() throws Exception{
        JobParameter param = new JobParameter(System.currentTimeMillis());
        Map<String,JobParameter> parameters = new HashMap<String,JobParameter>();
        parameters.put("requestDate", param);
        jobLauncher.run(helloJob, new JobParameters(parameters));
    }
}
