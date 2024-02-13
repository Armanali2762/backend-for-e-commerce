package com.ecommerce.api.Entities;

import java.util.Date;
import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "HdItem")
public class HdItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dt_item_insert_Date", columnDefinition = "TIMESTAMP", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtItemInsertDate; // Change to Date type

    @Column(name = "int_Purchase_order_No", nullable = false)
    private String intPurchaseOrderNo;

    @Column(name = "Dt_purchase_order_date", nullable = false)
    private Date dtPurchaseOrderDate;  // Change to Date type

    @Column(name = "DC_Total_Value")
    private BigDecimal dcTotalValue;  // Change to BigDecimal type

    @Column(name = "INT_total_items")
    private int intTotalItems;  // Change to int type

    // Constructors, getters, setters

    @PrePersist
    protected void onCreate() {
        dtItemInsertDate = new Date();
    }
}
