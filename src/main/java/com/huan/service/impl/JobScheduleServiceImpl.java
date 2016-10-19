package com.huan.service.impl;

import com.huan.service.JobScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/6/28 - 11:04
 */
@Service
public class JobScheduleServiceImpl implements JobScheduleService {
    private static final Logger logger = LoggerFactory.getLogger(JobScheduleServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${email.recive-user}")
    private String recive_user;

    public void sendMail() throws MessagingException {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("huan1987_z@163.com");
        msg.setTo("873089992@qq.com");
        msg.setTo(recive_user.split(","));
        msg.setSubject("该订单了");
        msg.setText("到订餐时间了，赶紧订单");
        javaMailSender.send(msg);
        logger.debug("----------------sendmail");
    }
}
