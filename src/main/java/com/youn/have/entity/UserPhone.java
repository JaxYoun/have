/*
package com.youn.have.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "t_user_phone")
public class UserPhone {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "userId")
    private Integer userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none"))
    private User user;

    @Column(name = "phoneId")
    private Integer phoneId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phoneId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none"))
    private Phone phone;

}
*/
