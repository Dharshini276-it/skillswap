package com.skillswap;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Connection {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String senderEmail;
private String receiverEmail;
private String status;

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getSenderEmail() {
return senderEmail;
}

public void setSenderEmail(String senderEmail) {
this.senderEmail = senderEmail;
}

public String getReceiverEmail() {
return receiverEmail;
}

public void setReceiverEmail(String receiverEmail) {
this.receiverEmail = receiverEmail;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}
}