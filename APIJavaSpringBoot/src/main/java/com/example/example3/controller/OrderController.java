package com.example.example3.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.example3.entity.Order;
import com.example.example3.service.OrderService;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/orders")
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")

public class OrderController {
    private OrderService orderService;

    //Create Order REST API
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order Order){
        Order savedOrder = orderService.createOrder(Order);
        return new ResponseEntity<>(savedOrder,HttpStatus.CREATED);
    }
    //Get ALL Products REST API
    // http://localhost:8000/api/Orders/1
    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long OrderId){
        Order Order=orderService.getOrderById(OrderId);
        return new ResponseEntity<>(Order,HttpStatus.OK);
    }
    //Get ALL Products REST API
    //http://localhost:8000/api/Orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> Orders=orderService.getAllOrders();
        return new ResponseEntity<>(Orders, HttpStatus.OK);

    }
    //Update Orders REST API
    @PutMapping("{id}")
    //http://localhost:8000/api/Orders/1
    public ResponseEntity<Order> updateOrder(@PathVariable("id") Long OrderId,@RequestBody Order Order){
        Order.setId(OrderId);
        Order updatedOrder = orderService.updateOrder(Order);
        return new ResponseEntity<>(updatedOrder,HttpStatus.OK);
    }
    //Delete Order REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long OrderId){
        orderService.deleteOrder(OrderId);
        return new ResponseEntity<>("Order successfully deleted!",HttpStatus.OK);
    }
    
}
