package com.biarca.sms.ws.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "server")
@SequenceGenerator(name = "seq", initialValue = 1)
public class ServerEntity implements Serializable {
  private static final long serialVersionUID = -7320539531865284665L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "serverid", nullable = false)
  private String serverId;

  @Column(name = "ip_address", nullable = false, length = 45)
  private String ipAddress;

  @Column(name = "created_time", nullable = false)
  @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private Calendar createdTime;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "created_by")
  private SmsUserEntity owner;

  @Column(name = "status")
  private boolean activeStatus;

  @OneToMany(mappedBy = "server")
  private List<ServerUserEntity> serverUsers = new ArrayList<ServerUserEntity>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getServerId() {
    return serverId;
  }

  public void setServerId(String serverId) {
    this.serverId = serverId;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
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

  public boolean isActiveStatus() {
    return activeStatus;
  }

  public void setActiveStatus(boolean activeStatus) {
    this.activeStatus = activeStatus;
  }

  public List<ServerUserEntity> getServerUsers() {
    return serverUsers;
  }

  public void setServerUsers(List<ServerUserEntity> serverUsers) {
    this.serverUsers = serverUsers;
  }

}
