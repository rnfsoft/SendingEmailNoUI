package com.rnfsoft.sendingmailnoui;


import android.os.AsyncTask;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by taehee on 9/21/15.
 */
public class Mail  {
    private String user;
    private String password;
    private Session session;
    private String host;
    private String port;
    private String sPort;
    private String sClass;
    private String auth;
    private String from;
    private String to;
    private String subject;
    private String body;


    public Mail() {
        host = "smtp.gmail.com";
        port = "465";
        sPort = "465";
        sClass = "javax.net.ssl.SSLSocketFactory";
        auth = "true";
        from = "";
        to ="";
        subject = "";
        body = "";
    }

    public Mail(String user, String password){
        this();
        this.user = user;
        this.password = password;

    }

    public void setTo(String to) {
        this.to = to;
    }


    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public boolean send(){

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.socketFactory.port", sPort);
        props.put("mail.smtp.socketFactory.class", sClass);
        props.put("mail.smtp.auth", auth);

        if(!user.equals("") && ! password.equals("") && !to.equals("") && !subject.equals("")) {
            session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

            SendTask task = new SendTask();
            task.execute();

            return true;
        } else {
            return false;
        }
    }

    class SendTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try{

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(user));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                message.setSubject(subject);
                message.setContent(body, "text/html; charset=utf-8");
                Transport.send(message);

            } catch(MessagingException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
