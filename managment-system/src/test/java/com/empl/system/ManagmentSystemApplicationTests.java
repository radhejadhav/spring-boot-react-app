package com.empl.system;

import com.empl.system.daos.AuthUserDao;
import com.empl.system.entities.AuthUser;
import com.empl.system.services.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
class ManagmentSystemApplicationTests {

	@Autowired
	UserService userService;

	@MockBean
	AuthUser authUser;

	@MockBean
	AuthUserDao authUserDao;

	UserDetails createUser(){
		 authUser.setUsername("rohan@gmail.com");
		 authUser.setPassword("testPass");
		 authUser.setFirstName("testName");

		 return authUser;
	}

	@Test
	void contextLoad(){
		Assertions.assertThat(this.userService).isNot(null);
	}

	@Test
	void testUserService(){

		authUser = (AuthUser) createUser();
		authUserDao.save(authUser);
		Assertions.assertThat(userService.loadUserByUsername("rohan@gmail.com")).isEqualTo(authUser);

	}

}
