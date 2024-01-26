package com.example.example3.service.impl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.example3.entity.Order;
import com.example.example3.service.OrderService;
import com.example.example3.repository.OrderRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }
    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.get();
    }

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    @Override 
    public Order updateOrder(Order order) {
        Order existingOrder =orderRepository.findById(order.getId()).get();
        existingOrder.setThumbnail(order.getThumbnail());
        existingOrder.setProduct(order.getProduct());
        Order updatedOrder = orderRepository.save(existingOrder);
        return updatedOrder;
    }
    @Override
    public void deleteOrder(Long orderId){
        orderRepository.deleteById(orderId);
    }
    
}