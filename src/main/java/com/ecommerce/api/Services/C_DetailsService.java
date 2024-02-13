package com.ecommerce.api.Services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.api.Entities.Cloth_Details;

@Service
public class C_DetailsService {
    
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public C_DetailsService(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Cloth_Details> fetchDataByNuId(String nuId) {
        String sql = "SELECT * FROM Clothes_Details WHERE Nu_id = :nuId";

        // Use namedParameterJdbcTemplate to execute the query and map the result to a List of Cloth_Details objects
        Map<String, Object> params = Collections.singletonMap("nuId", nuId);
        return namedParameterJdbcTemplate.query(sql, params, (rs, rowNum) -> new Cloth_Details(
            rs.getString("Nu_c_details"),
            rs.getInt("Nu_id"), // Corrected to use getInt for the Nu_id field
            rs.getString("c_20cm"),
            rs.getString("c_2005cm"),
            rs.getString("c_30cm"),
            rs.getString("c_3005cm"),
            rs.getString("c_4005cm"),
            rs.getString("c_1m"),
            rs.getString("c_1025m"),
            rs.getString("c_1050m"),
            rs.getString("halfsleeves"),
            rs.getString("price")
        ));
    }
}
