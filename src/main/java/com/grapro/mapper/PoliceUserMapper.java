package com.grapro.mapper;

import com.grapro.pojo.PoliceUser;

public interface PoliceUserMapper {
    PoliceUser selectBypolicename(String policename);
}
