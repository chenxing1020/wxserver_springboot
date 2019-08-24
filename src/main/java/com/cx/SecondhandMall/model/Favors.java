package com.cx.SecondhandMall.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name="favors")
public class Favors {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    String id;

    @Column(name="goodsId")
    String goodsId;

    @Column(name="userId")
    String userId;

    @Column(name="createAt")
    Date createAt;
}
