package com.demo.webflux.service.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestParameter implements Serializable {

  private static final long serialVersionUID = 1L;

  private String firstName;

  private String lastName;

  private String address;

  private String phoneNumber;
}
