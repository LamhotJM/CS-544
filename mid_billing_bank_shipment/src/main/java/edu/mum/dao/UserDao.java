package edu.mum.dao;

import edu.mum.domain.User;

public interface UserDao extends GenericDao<User> {
      
	public User findByEmail(String email);

	public User findByBoughtItemShippedZip(String email, String zipCode);
}
