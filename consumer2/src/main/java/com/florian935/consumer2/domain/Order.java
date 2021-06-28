package com.florian935.consumer2.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = PRIVATE)
public class Order {

    String uuid;
    String name;
    int quantity;
    double price;
}
