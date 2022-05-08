package com.empl.system.services;

import com.empl.system.daos.AuthUserDaoPagination;
import com.empl.system.entities.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PagingUserService {

    @Autowired
    private AuthUserDaoPagination authUserDaoPagination;

    public Page<AuthUser>  getPage(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return authUserDaoPagination.findAll(pageable);
    }
}
