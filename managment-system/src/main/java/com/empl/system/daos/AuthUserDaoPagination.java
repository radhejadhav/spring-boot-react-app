package com.empl.system.daos;

import com.empl.system.entities.AuthUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthUserDaoPagination extends PagingAndSortingRepository<AuthUser, Long> {
}
