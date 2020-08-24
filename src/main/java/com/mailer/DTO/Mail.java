package com.mailer.DTO;

import java.util.Date;

public class Mail {

    private Long id;

    private String subject;

    private String text;

    private Date postedTime;

    private Sender sender;

    public Mail() {
    }

    public Mail(Long id, String subject, String text, Date postedTime, Sender sender) {
        this.id = id;
        this.subject = subject;
        this.text = text;
        this.postedTime = postedTime;
        this.sender = sender;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public Date getPostedTime() {
        return postedTime;
    }

}