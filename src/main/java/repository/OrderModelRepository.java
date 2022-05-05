package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.OrderModel;

public interface OrderModelRepository extends JpaRepository<OrderModel,Integer> {

}
