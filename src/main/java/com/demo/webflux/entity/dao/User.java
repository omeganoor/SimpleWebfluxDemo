package com.demo.webflux.entity.dao;

import com.demo.webflux.entity.constant.commons.CollectionName;
import com.demo.webflux.entity.constant.fields.UserField;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= CollectionName.USER)
public class User extends BaseEntity {
  private static final long serialVersionUID = 1L;

  @Column(name = UserField.FIRST_NAME)
  private String firstName;

  @Column(name = UserField.LAST_NAME)
  private String lastName;

  @Column(name = UserField.ADDRESS)
  private String address;

  @Column(name = UserField.PHONE_NUMBER)
  private String phoneNumber;

}
