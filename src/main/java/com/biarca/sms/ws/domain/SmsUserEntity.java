package com.biarca.sms.ws.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "smsuser")
public class SmsUserEntity implements Serializable {
  private static final long serialVersionUID = 323252700227935319L;

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "password")
  private String password;

  @Column(name = "name")
  private String name;

  @Column(name = "emailid")
  private String email;

  @Column(name = "is_admin")
  private boolean adminStatus;

  @Column(name = "created_time")
  @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private Calendar createdTime;

  @Column(name = "status")
  private boolean activeStatus;

  @ManyToOne(cascade = {CascadeType.ALL})
  @JoinColumn(name = "created_by")
  private SmsUserEntity owner;

  @OneToMany(mappedBy = "owner")
  private Set<SmsUserEntity> smsUsers = new HashSet<SmsUserEntity>();

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean getAdminStatus() {
    return adminStatus;
  }

  public void setAdminStatus(boolean adminStatus) {
    this.adminStatus = adminStatus;
  }

  public Calendar getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Calendar createdTime) {
    this.createdTime = createdTime;
  }

  public boolean getActiveStatus() {
    return activeStatus;
  }

  public void setActiveStatus(boolean activeStatus) {
    this.activeStatus = activeStatus;
  }

  public SmsUserEntity getOwner() {
    return owner;
  }

  public void setOwner(SmsUserEntity owner) {
    this.owner = owner;
  }

  public Set<SmsUserEntity> getSmsUsers() {
    return smsUsers;
  }

  public void setSmsUsers(Set<SmsUserEntity> smsUsers) {
    this.smsUsers = smsUsers;
  }

  @Override
  public String toString() {
    return "SmsUserEntity{id=" + id + ",name=" + name + ",email id=" + email + "}";
  }

  @Override
  public int hashCode() {
    return this.id.hashCode() + this.password.hashCode() + this.name.hashCode();
  }

  @Override
  public boolean equals(Object u) {
    if (u instanceof SmsUserEntity) {
      SmsUserEntity smsUserEntity = (SmsUserEntity) u;

      if (this.id.equals(smsUserEntity.getId()) && this.password.equals(smsUserEntity.getPassword())
          && this.name.equals(smsUserEntity.getName())) {
        return true;
      }
    }
    return false;
  }

  public Role getRole() {
    if (this.adminStatus) {
      return Role.ADMIN;
    } else {
      return Role.USER;
    }
  }
}
