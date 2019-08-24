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
@Table(name="comments")
public class Comments {
    @Id
    @Column(name="commentId")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy = "uuid")
    String id;

    @Column(name="goodsId")
    String goodsId;

    @Column(name="userId")
    String userId;

    @Column(name="parentId")
    String parentId;

    @Column(name="comment")
    String comment;

    @Column(name="createAt")
    Date createAt;
}
