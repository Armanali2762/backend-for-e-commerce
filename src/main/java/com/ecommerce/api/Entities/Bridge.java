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
public class Bridge {
    String vc_cust_code;
    int Nu_size_id;
    String Nu_id;
    String Nu_Colour_id;
    String VC_Chest;
    String VC_Waist;
    String VC_Neck;
    String VC_Hip;
}
