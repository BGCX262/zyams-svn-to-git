package com.zhiye.common.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 
 * @version Nov 26, 2009
 */
public class MailHelper {

    private final Log log = LogFactory.getLog(MailHelper.class);

    private JavaMailSender mailSender;
    private SimpleMailMessage msg;
    private String errorMessage = "Sending email failed, '";
    private String from;

    /**
     * @return the mailSender
     */
    public JavaMailSender getMailSender() {
        return mailSender;
    }

    /**
     * @param mailSender
     *            the mailSender to set
     */
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * @return the msg
     */
    public SimpleMailMessage getMsg() {
        return msg;
    }

    /**
     * @param msg
     *            the msg to set
     */
    public void setMsg(SimpleMailMessage msg) {
        this.msg = msg;
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from
     *            the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * 
     * @param to
     *            mailTo array
     * @param content
     *            mail content
     * @param subject
     *            mail subject
     * @throws MessagingException
     *             if send mail fail ,will happend this exception
     */
    public void sendMimeMessage(String to, String content, String subject)
            throws MessagingException {
        this.sendMimeMessage(new String[] { to }, content, subject);
    }

    /**
     * Send mimemessage with attchment List<File>.If mailFrom is null set
     * default.If fileList is null no attachments.
     * 
     * @param to
     *            mailTo array
     * @param content
     *            mail content
     * @param subject
     *            mail subject
     * @throws MailSendException
     *             if send mail fail ,will happend this exception
     * @throws MailParseException
     *             if send mail fail ,will happend this exception
     */
    public void sendEmail(String to[], String content, String subject)
            throws MailSendException, MailParseException {
        log.info("Sending to:" + Arrays.toString(to) + ", message:[" + content
                + "]");

        // Create a thread-safe sandbox for the email message
        SimpleMailMessage mailMsg = new SimpleMailMessage(this.msg);
        mailMsg.setFrom(from);
        mailMsg.setTo(to);
        mailMsg.setText(content);
        mailMsg.setSubject(subject);

        try {
            mailSender.send(mailMsg);
        } catch (MailParseException e1) {
            log.info(errorMessage + ", error parse the email address");
            log.debug(e1.getStackTrace());
            throw e1;
        } catch (MailSendException e) {
            log.info(errorMessage + ", error connecting to the Mail Server");
            log.debug(e.getStackTrace());
            throw e;
        }

        log.info("Email Sent");
    }

    /**
     * Send mimemessage with attchment List<File>.If mailFrom is null set
     * default.If fileList is null no attachments.
     * 
     * @param to
     *            mailTo array
     * @param content
     *            mail content
     * @param subject
     *            mail subject
     * @throws MessagingException
     *             if send mail fail ,will happend this exception
     */
    public void sendMimeMessage(String to[], String content, String subject)
            throws MessagingException {
        MimeMessage mimeMsg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMsg,
                Constant.ENCODING_UTF8);
        helper.setTo(to);
        helper.setFrom(this.from);
        helper.setSubject(subject);
        helper.setText(content, true);

        try {
            mailSender.send(mimeMsg);
        } catch (MailParseException e2) {
            log.info(errorMessage + ", error parse the email address");
            throw e2;
        } catch (MailSendException e1) {
            log.info(errorMessage + ", error connecting to the Mail Server");
            throw e1;
        }

        log.info("Email have been sent to:" + Arrays.toString(to));
    }

    /**
     * Send mimemessage with attchment List<File>.If mailFrom is null set
     * default.If fileList is null no attachments.
     * 
     * @param mailFrom
     *            mailTo array
     * @param to
     *            to array
     * @param content
     *            mail content
     * @param subject
     *            mail subject
     * @param attachments
     *            all
     * @throws MessagingException
     *             if send mail fail ,will happend this exception
     */
    public void sendMimeMessageWithAttchment(String mailFrom, String to[],
            String content, String subject, List<File> attachments)
            throws MessagingException {
        MimeMessage mimeMsg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true,
                Constant.ENCODING_UTF8);
        helper.setTo(to);
        if (null == mailFrom || "".equals(mailFrom)) {
            mailFrom = this.from;
        }
        helper.setFrom(mailFrom);
        helper.setSubject(subject);
        helper.setText(content, true);
        if (null != attachments) {
            for (int i = 0; i < attachments.size(); i++) {
                File file = attachments.get(i);
                if (null != file) {
                    String filename = file.getName();
                    helper.addAttachment(filename, file);
                }
            }
        }
        try {
            mailSender.send(mimeMsg);
        } catch (MailParseException e2) {
            log.error(errorMessage + ", error parse the email address");
            throw e2;
        } catch (MailSendException e1) {
            log.error(errorMessage + ", error connecting to the Mail Server");
            throw e1;
        }

        log.info("Email have been sent to:" + Arrays.toString(to));
    }

    /**
     * Send mime message special the mail from.
     * 
     * @param mailFrom
     *            mailFrom
     * @param to
     *            mailTo array
     * @param content
     *            mail content
     * @param subject
     *            mail subject
     * @throws MessagingException
     *             if send mail fail ,will happend this exception
     * @author tangjun
     */
    public void sendMimeMessage(String mailFrom, String to[], String content,
            String subject) throws MessagingException {
        MimeMessage mimeMsg = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMsg,
                Constant.ENCODING_UTF8);
        helper.setTo(to);
        if (null == mailFrom || "".equals(mailFrom)) {
            mailFrom = this.from;
        }
        helper.setFrom(mailFrom);
        helper.setSubject(subject);
        helper.setText(content, true);

        try {
            mailSender.send(mimeMsg);
        } catch (MailParseException e2) {
            log.info(errorMessage + ", error parse the email address");
            throw new MessagingException();
        } catch (MailSendException e1) {
            log.info(errorMessage + ", error connecting to the Mail Server");
            throw new MessagingException();
        } catch (Exception e) {
            log.info(errorMessage + ", other exception to the Mail Server");
            throw new MessagingException();
        }
        log.info("Email have been sent to:" + Arrays.toString(to));
    }
}
