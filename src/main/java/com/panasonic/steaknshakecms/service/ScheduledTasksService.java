package com.panasonic.steaknshakecms.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasksService {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"HH:mm:ss");
    int i= 0;
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println(i++ + ":" +"The time is now " + dateFormat.format(new Date()) );
	}

}
