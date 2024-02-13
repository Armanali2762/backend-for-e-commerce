package com.ecommerce.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.ecommerce.api.DAO.AllcatRepository;
import com.ecommerce.api.DAO.C_TypeRepository;
import com.ecommerce.api.DAO.DtItemRepo;
import com.ecommerce.api.DAO.HdItemRepo;
import com.ecommerce.api.DAO.UserLoginRepository;
import com.ecommerce.api.Entities.All_Categories;
import com.ecommerce.api.Entities.Bridge;
import com.ecommerce.api.Entities.Cloth_Details;
import com.ecommerce.api.Entities.Cloth_Type;
import com.ecommerce.api.Entities.Color;
import com.ecommerce.api.Entities.DtItem;
import com.ecommerce.api.Entities.HdItem;
import com.ecommerce.api.Entities.User;
import com.ecommerce.api.Services.BridgeService;
import com.ecommerce.api.Services.C_DetailsService;
import com.ecommerce.api.Services.ColorRepository;
import com.ecommerce.api.Services.UserAuthenticate;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HomeController {

    @Autowired
    private C_TypeRepository c_TypeRepository;

    @Autowired
    private AllcatRepository allcatRepository;

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private BridgeService bridgeService;

    @Autowired
    private C_DetailsService c_DetailsService;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private HdItemRepo hdItemRepo;

    @Autowired
    private DtItemRepo dtItemRepo;

    // This is for get all categories
    @GetMapping("/all-categories")
    public ResponseEntity<List<All_Categories>> getCategories() {
        List<All_Categories> list = (List<All_Categories>) this.allcatRepository.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    // This is for get clothes accourding to the category
    @GetMapping("/clothes/{ids}")
    public ResponseEntity<List<Cloth_Type>> getClothes(@PathVariable List<Integer> ids) {

        System.out.println("Received ids: " + ids);
        List<Cloth_Type> listPage = this.c_TypeRepository.getAllClothByIds(ids);

        if (listPage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(listPage);
    }

    // This is for Authenticate the User
    @PostMapping("/authenticate")
    public Boolean authenticate(@RequestBody UserAuthenticate userAuthenticate) {
        try {
            String username = userAuthenticate.getUsername();
            String password = userAuthenticate.getPassword();

            User user = this.userLoginRepository.findByEmail(username);
            System.out.println(user);
            if (user != null && user.getPassword().equalsIgnoreCase(password)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Exception occurred during authentication: {}" + e.getMessage());
            return false;
        }
    }

    // This is for fetch the value from the bridge tabel
    @GetMapping("/bridge/{id}")
    public List<Bridge> getBridges(@PathVariable String id) {
        return this.bridgeService.fetchDataByNuId(id);
    }

    // This is for Clothes Details fetch data from database
    @GetMapping("/clothe-details/{id}")
    public List<Cloth_Details> getClothes_Details(@PathVariable String id) {
        return this.c_DetailsService.fetchDataByNuId(id);
    }

    // This is for Color fetch data from database
    @GetMapping("/color/{id}")
    public List<Color> getColor(@PathVariable String id) {
        return this.colorRepository.fetchDataByNuId(id);
    }

    @PostMapping("/HdInsert")
    public ResponseEntity<HdItem> insertHdItem(@RequestBody HdItem hdItem) {
        if (hdItem == null) {
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request if the request body is null
        }

        try {
            hdItemRepo.save(hdItem);
            return ResponseEntity.ok(hdItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return 500 Internal Server Error for database-related errors
        }
    }

    @PostMapping("/DtInsert")
    public ResponseEntity<DtItem> insertDtItem(@RequestBody DtItem dtItem) {
        if (dtItem == null) {
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request if the request body is null
        }
    
        try {
            // Introduce a delay to ensure unique timestamps
            Thread.sleep(1000); // 1000 milliseconds (1 second)
    
            dtItem.setDtItemInsertDate(new Date());
            dtItemRepo.save(dtItem);
            return ResponseEntity.ok(dtItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Return 500 Internal Server Error for database-related errors
        }
    }
    
}
