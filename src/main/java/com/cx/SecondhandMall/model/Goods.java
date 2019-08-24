package com.cx.SecondhandMall.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "goods")
public class Goods {
    @Id
    @Column(name = "goodsId")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;


    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "originalPrice")
    private double originalPrice;

    //Join imageList
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "goodimages",
               joinColumns = {@JoinColumn(name = "goodsId")},
               inverseJoinColumns = {@JoinColumn(name = "imageId")})
    private List<Images> images;

    @Column(name = "createAt")
    Date createAt;

    public enum Category {
        学习用品, 动植物, 生活美妆, 交通出行, 电子设备, 穿搭
    }

}