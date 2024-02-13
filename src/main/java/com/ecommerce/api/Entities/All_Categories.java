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
@Table(name="all_categories")
public class All_Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nu_category_id;
    private String VC_Comp_code; 
    private String vc_Category_Name;
}
