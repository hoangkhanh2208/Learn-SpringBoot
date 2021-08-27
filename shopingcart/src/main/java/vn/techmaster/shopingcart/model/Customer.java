package vn.techmaster.shopingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    
    private String name;
    private String phoneNumber;
    private String email;
}
