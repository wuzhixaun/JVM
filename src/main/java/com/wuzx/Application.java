package com.wuzx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 *  paralle
 * -Xloggc:/Users/wuzhixuan/logs/gc/gc-%t.log
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintGCCause
 * -XX:+UseGCLogFileRotation
 * -XX:NumberOfGCLogFiles=10
 * -XX:GCLogFileSize=100M
 * -XX:MetaspaceSize=256M
 * -XX:MaxMetaspaceSize=256M
 */

/**
 * CMS
 * -Xloggc:d:/gc‐cms‐%t.log
 * -Xms50M
 * -Xmx50M
 * -XX:MetaspaceSize=256M
 * -XX:MaxMetaspaceSize=256M
 * -XX:+PrintGCDetails
 * -XX:+P rintGCDateStamps
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintGCCause
 * -XX:+UseGCLogFileRotation
 * -XX:NumberOfGCLogFiles=10
 * -XX:GCLogFileSize=100M
 * -XX:+UseParNewGC
 * -XX:+UseConcMarkSweepGC
 */

/**
 * 最开始设置的参数 -Xms1536M -Xmx1536M -Xmn512M -Xss256K -XX:SurvivorRatio=6 -XX:MetaspaceSize=256M -XX:MaxMetaspaceSize=256M -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSInitiatingOccupancyOnly
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}