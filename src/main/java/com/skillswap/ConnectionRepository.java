package com.skillswap;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRepository extends JpaRepository<Connection,Integer>{

   List<Connection> findByReceiverEmail(String receiverEmail); 

}


