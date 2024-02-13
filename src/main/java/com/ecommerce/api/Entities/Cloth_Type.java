package com.ecommerce.api.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name="cloth_types")
public class Cloth_Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Nu_id;
    private int Nu_category_id;
    private String vc_cloth_code;
    private String vc_cloth_Type;
    private String dt_date_insert;
    private String vc_cust_code;
}
