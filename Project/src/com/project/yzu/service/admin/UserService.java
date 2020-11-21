package com.project.yzu.service.admin;
import org.springframework.stereotype.Service;

import com.project.yzu.entity.admin.User;

@Service
public interface UserService {
	public User findByUsername(String username);
}
