package com.example.chinspring;

import com.chinmayie.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer,Integer>
{

}
