package com.ecommerce.api.Entities;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class Cloth_Details {
    private String Nu_c_details;
    private int Nu_id;
    private String c_20cm;
    private String c_2005cm;
    private String c_30cm;
    private String c_3005cm;
    private String c_4005cm;
    private String c_1m;
    private String c_1025m;
    private String c_1050m;
    private String halfsleeves;
    private String price;
}
