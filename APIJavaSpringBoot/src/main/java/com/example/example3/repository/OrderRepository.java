package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.example3.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
