package com.mailer.DTO;

public class Sender {
    private Long id;

    private String username;

    private String password;

    private String name;

    private String recipientEmail;

    private boolean isAttached;

    public Sender() {
    }

    public Sender(Long id, String username, String password, String name, String recipientEmail, boolean isAttached) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.recipientEmail = recipientEmail;
        this.isAttached = isAttached;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public boolean getIsAttached() {
        return isAttached;
    }

    public void setIsAttached(boolean isAttached) {
        this.isAttached = isAttached;
    }

}
