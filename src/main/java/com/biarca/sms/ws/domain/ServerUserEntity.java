package com.biarca.sms.ws.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "server_user")
public class ServerUserEntity implements Serializable {
  private static final long serialVersionUID = 4876366427289473446L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "server_id", referencedColumnName = "id")
  private ServerEntity server;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity user;

  @Column(name = "password")
  private String password;

  @Column(name = "created_time", nullable = false)
  @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private Calendar createdTime;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "created_by")
  private SmsUserEntity owner;

  @Column(name = "status")
  private boolean activeStatus;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ServerEntity getServer() {
    return server;
  }

  public void setServer(ServerEntity server) {
    this.server = server;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Calendar getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Calendar createdTime) {
    this.createdTime = createdTime;
  }

  public SmsUserEntity getOwner() {
    return owner;
  }

  public void setOwner(SmsUserEntity owner) {
    this.owner = owner;
  }

  public boolean getActiveStatus() {
    return activeStatus;
  }

  public void setActiveStatus(boolean activeStatus) {
    this.activeStatus = activeStatus;
  }
}
