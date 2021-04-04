package com.neuroapis.classmate.dataLayer;

import com.neuroapis.classmate.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{
}
