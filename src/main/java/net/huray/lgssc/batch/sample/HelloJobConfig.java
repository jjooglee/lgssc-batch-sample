package net.huray.lgssc.batch.sample;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Slf4j
@AllArgsConstructor
@Configuration
public class HelloJobConfig {

    @Bean
    public Job helloJob(JobBuilderFactory jobBuilderFactory, Step helloStep) {
        return jobBuilderFactory.get("helloJob")
                .preventRestart()
                .start(helloStep)
                .build();
    }

    @Bean
    public Step helloStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("helloStep")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                        System.out.println("Hello~~~~~~~~~" + new Date());
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }
}
