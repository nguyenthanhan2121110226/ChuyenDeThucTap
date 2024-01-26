package com.example.example3.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private Long id;
    @Column(name = "thumbnail", nullable = true, length = 255)
    private String thumbnail;
    
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
