package com.example.monitor;

import com.dopee.module.database.SourceTest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@RequiredArgsConstructor
@SpringBootApplication
public class MonitoringApplication {

    public static void main(String[] args) {
        SourceTest.Hello();
        SpringApplication.run(MonitoringApplication.class, args);

    }

}
