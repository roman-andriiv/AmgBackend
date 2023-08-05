package com.andriiv.amgbackend.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Roman Andriiv (05.08.2023 - 09:07)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
}
