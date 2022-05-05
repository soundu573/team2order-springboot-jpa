package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import entity.OrderModel;
import exception.ResourceNotFoundException;
import repository.OrderModelRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class NameBoardcontroller {
	@Autowired
	OrderModelRepository orderModelRepository; 
	
	@GetMapping("/orders")
	public List<OrderModel> getAllOrders(){
		return orderModelRepository.findAll();
	}
	/* View Orders---->/admin/getAllOrders (GET)
	 * Edit Orders---->/admin/editOrder/{orderId} (PUT)
	 * Cancel Orders---->/admin/deleteOrder (DELETE)
	 * 
	 * Add Order--->/user/addOrder (POST)
	 * Edit Order---->/user/editOrder/{orderId} (PUT)
	 * Cancel Order--->/user/deleteOrder/{orderId} (DELETE)*/
	
		@GetMapping("/orders/{orderId}")
		public ResponseEntity<OrderModel> getOrderById(@PathVariable(value="orderId") int orderModelId)
		throws ResourceNotFoundException{
			OrderModel order = orderModelRepository.findById(orderModelId).orElseThrow(()->new ResourceNotFoundException("Order Id not found "+orderModelId));
			return ResponseEntity.ok().body(order);
		}
 
	
	@PostMapping("/orders")
	public OrderModel createEmployee(@RequestBody OrderModel order ) {
	return orderModelRepository.save(order);
}
	@PutMapping("/orders/{orderId}")
	public ResponseEntity<OrderModel> updateOrder(@PathVariable(value="orderId") int orderModelId,@RequestBody OrderModel orderDetails)
		throws ResourceNotFoundException{
			OrderModel order =orderModelRepository.findById(orderModelId).orElseThrow(()->new ResourceNotFoundException("Order Id not found "+orderModelId));
			
			order.setOrderName(orderDetails.getOrderName());
			order.setOrderDescription(orderDetails.getOrderDescription());
			order.setOrderDate(orderDetails.getOrderDate());
		    order.setOrderPrice(orderDetails.getOrderPrice());
		    order.setOrderAddress(orderDetails.getOrderAddress());
		    order.setOrderPhone(orderDetails.getOrderPhone());
			order.setOrderEmail(orderDetails.getOrderEmail());
			final OrderModel updatedOrder=orderModelRepository.save(order);
			return ResponseEntity.ok(updatedOrder);
			}
	
	@DeleteMapping("/orders/{orderId}")
	public Map<String,Boolean> deleteOrder(@PathVariable(value="orderId")int orderModelId )
	throws ResourceNotFoundException{
		OrderModel order =orderModelRepository.findById(orderModelId).orElseThrow(()->new ResourceNotFoundException("Order Id not found "+orderModelId));
		orderModelRepository.delete(order);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
	
	

