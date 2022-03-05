package net.huray.lgssc.batch;

import lombok.RequiredArgsConstructor;
import net.huray.lgssc.batch.sample.dynamic2.DynamicSchedule;
import net.huray.lgssc.batch.sample.dynamic2.ProgrammableScheduler;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableBatchProcessing
@SpringBootApplication
public class LgsscBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LgsscBatchApplication.class, args);
	}

	@Autowired
	DynamicSchedule dynamicSchedule;

	@Bean
	public ApplicationRunner run() {
		return (ApplicationArguments args) -> {
			dynamicSchedule.startScheduler();
		};
	}
}
