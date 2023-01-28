package com.javatechie.jpa.Service;

import com.javatechie.jpa.entity.Customer;
import com.javatechie.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Page<Customer> getCustomerPagination(Integer pageNumber, Integer pageSize) {

        Sort sort=Sort.by(Sort.Direction.ASC,"name");
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);  // to get page and next page and second page
        return customerRepository.findAll(pageable);
    }
}
