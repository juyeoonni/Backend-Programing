package kr.ac.kopo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

    @Scheduled(cron = "0/10 * * * * *")
    public void crontest() {
        System.out.println("10초에 한번 crontest입니다.");
    }
}
