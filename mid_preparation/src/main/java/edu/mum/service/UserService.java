package edu.mum.service;

import java.math.BigDecimal;
import java.util.List;

import edu.mum.domain.User;
 
public interface UserService {

	public void save(User user);
	public List<User> findAll();
 	public User update(User user);
 	public List<User> findAllJoinFetch();
 	
 	//
 	public List<User> findAllBatch();
	public User findBySoldItemInitialPrice(String string, String string2,BigDecimal j);
}