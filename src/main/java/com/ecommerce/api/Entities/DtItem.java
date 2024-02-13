package com.ecommerce.api.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DtItem")
public class DtItem {

    @Id
    @Column(name = "int_item_insert_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dt_item_insert_Date", nullable = false, updatable = false)
@Temporal(TemporalType.TIMESTAMP)
private Date dtItemInsertDate;  // Change to Date type

    @Column(name = "NU_item_id", nullable = false, unique = true)
    private String nuItemId;

    @Column(name = "Int_Qty", nullable = false)
    private int intQty;  // Change to int type

    @Column(name = "DC_Price")
    private BigDecimal dcPrice;  // Change to BigDecimal type

   
}
