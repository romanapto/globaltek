package com.app.service;

import com.app.persistence.model.es.user.User;
import org.dozer.Mapper;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest {

    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private Mapper mapper;

    //@Before
    public void init() {
    }

    //@Test
    public void createTest01() {
        User user = new User();
        user.setEmail("mail@mail.com");
        user.setFirstName("First name");
        user.setId("Id");
        user.setLastName("Last name");
        user.setPassword("Password");
        user.setRoles(new ArrayList<>());

        List<User> users = new ArrayList<>();
        users.add(user);

        Page<User> page = new PageImpl<>(users, Pageable.unpaged(), users.size());

        //Mockito.when(sellerRepository.findById(seller.getId())).thenReturn(Optional.empty());

    }
}
