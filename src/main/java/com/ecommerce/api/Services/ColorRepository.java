package com.ecommerce.api.Services;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.api.Entities.Color;

@Service
public class ColorRepository {
    
     private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ColorRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Color> fetchDataByNuId(String nuId) {
        String sql = "SELECT * FROM colour_table WHERE Nu_Colour_id = :nuId";

        // Use namedParameterJdbcTemplate to execute the query and map the result to a List of Bridge objects
        Map<String, Object> params = Collections.singletonMap("nuId", nuId);
        return namedParameterJdbcTemplate.query(sql, params, (rs, rowNum) -> new Color(
            rs.getString("vc_cust_code"),
            rs.getInt("Nu_Colour_id"),
            rs.getString("vc_colour")
        ));
    }
}
