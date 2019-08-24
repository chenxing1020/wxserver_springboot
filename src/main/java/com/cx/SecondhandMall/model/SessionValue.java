package com.cx.SecondhandMall.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class SessionValue {
    private String session_key;
    private String openid;
}
