package com.cx.SecondhandMall.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "user")
public class User {
    @Id
    @Column(name = "userId")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    String userId;

    @Column(name = "openId")
    String openId;

    @Column(name = "stuId")
    String stuId;

    @Column(name = "avatar")
    String avatar;

    @Column(name = "campus")
    @Enumerated(EnumType.STRING)
    campusEnum campus;

    @Column(name = "college")
    @Enumerated(EnumType.STRING)
    collegeEnum college;


    public enum campusEnum {
        九龙湖校区, 四牌楼校区
    }

    public enum collegeEnum {
        建筑学院, 机械学院, 能环学院, 信息学院, 土木学院, 电子学院, 数学学院, 自动化学院, 计算机学院,
        物理学院, 生医学院, 材料学院, 人文学院, 经管学院, 电气学院, 外国语学院, 体育学院, 化工学院, 交通学院,
        仪科学院, 艺术学院, 法学院, 医学院, 公卫学院, 吴健雄学院, 软件学院, 微电子学院, 网安学院, 其他学院
    }
}
