package com.huan.service;

import javax.mail.MessagingException;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/6/28 - 11:04
 */
public interface JobScheduleService {

    void sendMail() throws MessagingException;
}
