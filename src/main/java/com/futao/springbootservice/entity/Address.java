package com.futao.springbootservice.entity;

import com.futao.starter.fustack.db.IdTimeEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author futao
 * @date 2020/12/2
 */
@Getter
@Setter
public class Address extends IdTimeEntity {
    /**
     * "江西省宜春市丰城市怡丰花园9栋2层"
     */
    private String address;
    /**
     * 28.153810854
     */
    private Double latitude;
    /**
     * 115.768890427
     */
    private Double longitude;
    /**
     * "美澳口腔门诊部"
     */
    private String placeName;
}
