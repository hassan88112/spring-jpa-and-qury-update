package com.javatechie.jpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderResponse {

 //   private String name;
  //  private String productName;
    private String email;

    private int price;

    public OrderResponse(/*String name, String productName ,*/ String email ,int price) {
      /*  this.name = name;
        this.productName = productName;*/
        this.email=email;
        this.price=price;

    }


}
