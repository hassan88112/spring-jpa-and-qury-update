package com.javatechie.jpa.controller;

import com.javatechie.jpa.Service.CustomerService;
import com.javatechie.jpa.dto.OrderRequest;
import com.javatechie.jpa.dto.OrderResponse;
import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.repository.CustomerRepository;
import com.javatechie.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerService customerService;

    @PostMapping("/addOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
       return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return customerRepository.getJoinInformation();
    }

    @RequestMapping(value = "/empPage/{pageNumber}/{pageSize}" ,method = RequestMethod.GET)
    public Page<Customer> employeePagination(@PathVariable Integer pageNumber,@PathVariable  Integer pageSize){

        return customerService.getCustomerPagination(pageNumber,pageSize);
    }
}
