package com.project.yzu.dao.admin;
import org.springframework.stereotype.Repository;

import com.project.yzu.entity.admin.User;

@Repository
public interface UserDao {
	public User findByUsername(String username);

}
