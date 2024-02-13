package com.ecommerce.api.Services;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.ecommerce.api.Entities.Bridge;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class BridgeService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BridgeService(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Bridge> fetchDataByNuId(String nuId) {
        String sql = "SELECT * FROM bridge_table WHERE Nu_id = :nuId";

        // Use namedParameterJdbcTemplate to execute the query and map the result to a List of Bridge objects
        Map<String, Object> params = Collections.singletonMap("nuId", nuId);
        return namedParameterJdbcTemplate.query(sql, params, (rs, rowNum) -> new Bridge(
            rs.getString("vc_cust_code"),
            rs.getInt("Nu_size_id"),
            rs.getString("Nu_id"),
            rs.getString("Nu_Colour_id"),
            rs.getString("VC_Chest"),
            rs.getString("VC_Waist"),
            rs.getString("VC_Neck"),
            rs.getString("VC_Hip")
        ));
    }
}

