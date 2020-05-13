package com.demo.webflux.service.model;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseParameter implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;

  private Long version;

  private Date createdDate;

  private String createdBy;

  private Date updatedDate;

  private String updatedBy;

  private Integer isDeleted;

  private String username;

  private String firstName;

  private String lastName;

  private String address;

  private String phoneNumber;

}
