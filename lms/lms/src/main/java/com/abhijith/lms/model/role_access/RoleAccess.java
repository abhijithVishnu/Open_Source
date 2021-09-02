package com.abhijith.lms.model.role_access;
//Generated 2 Sep, 2021 1:29:12 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.abhijith.lms.model.role.Roles;

/**
* RoleAccess generated by hbm2java
*/
@Entity
@Table(name="role_access"
 ,catalog="libsys"
)
public class RoleAccess  implements java.io.Serializable {


  private Integer roleAccessId;
  private Roles roles;
  private String access;

 public RoleAccess() {
 }

 public RoleAccess(Roles roles, String access) {
    this.roles = roles;
    this.access = access;
 }

  @Id @GeneratedValue(strategy=IDENTITY)

 
 @Column(name="role_access_id", unique=true, nullable=false)
 public Integer getRoleAccessId() {
     return this.roleAccessId;
 }
 
 public void setRoleAccessId(Integer roleAccessId) {
     this.roleAccessId = roleAccessId;
 }

@ManyToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="role_id", nullable=false)
 public Roles getRoles() {
     return this.roles;
 }
 
 public void setRoles(Roles roles) {
     this.roles = roles;
 }

 
 @Column(name="access", nullable=false, length=100)
 public String getAccess() {
     return this.access;
 }
 
 public void setAccess(String access) {
     this.access = access;
 }




}


