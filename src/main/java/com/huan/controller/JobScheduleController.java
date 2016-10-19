package com.huan.controller;

import com.huan.service.JobScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

/**
 * Created by ptmind on 2016/5/21.
 */
@Controller
@Configurable
@EnableScheduling
public class JobScheduleController {
    private static final Logger logger = LoggerFactory.getLogger(JobScheduleController.class);

    @Autowired
    private JobScheduleService jobScheduleService;

    @RequestMapping("/send")
    @ResponseBody
    public String testSend() throws MessagingException {
        jobScheduleService.sendMail();
        return "send success";
    }

    /**
     * 定时任务入口
     * 测试20秒一次0/20 * * * * ?
     * 测试5分钟一次0 0/5 * * * ?
     * 整点执行一次0 0 0-23 * * ?
     * 0 10 11 ? * MON-FRI  周一到周五每天11:10执行
     */
    @Scheduled(cron = "0 10 11 ? * MON-FRI")
    public void startSchedulingJob() {
        try {
            jobScheduleService.sendMail();
            logger.debug("-----------------execute SchedulingJob success");
        } catch (Exception e) {
            logger.error("execute SchedulingJob error! ", e);
        }
    }

}