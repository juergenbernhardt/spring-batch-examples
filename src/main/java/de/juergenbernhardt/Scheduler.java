package de.juergenbernhardt;

import java.util.concurrent.TimeUnit;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    public void runJob(Job sampleJob, JobOperator jobLauncher) throws Exception {
        System.out.println("start scheduler");
        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(sampleJob, params);
    }

}
