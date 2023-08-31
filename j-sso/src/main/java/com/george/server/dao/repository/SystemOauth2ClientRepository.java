package com.george.server.dao.repository;

import com.george.server.dao.entity.SystemOauth2Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemOauth2ClientRepository extends JpaRepository<SystemOauth2Client, Long> {

    SystemOauth2Client getByClientId(String clientId);

}
