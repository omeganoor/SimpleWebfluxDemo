package com.demo.webflux.entity.dao;

import com.demo.webflux.entity.constant.fields.BaseField;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public abstract class BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = BaseField.ID)
  private Long id;

  @Version
  @Column(name = BaseField.VERSION)
  private Long version = 0L;

  @Column(name = BaseField.CREATED_DATE)
  private Date createdDate = new Date();

  @Column(name = BaseField.CREATED_BY)
  private String createdBy = "system";

  @Column(name = BaseField.UPDATED_DATE)
  private Date updatedDate = new Date();

  @Column(name = BaseField.UPDATED_BY)
  private String updatedBy = "system";

  @Column(name = BaseField.IS_DELETED)
  private Integer isDeleted = 0;

  @Column(name = BaseField.USERNAME)
  private String username;
}
