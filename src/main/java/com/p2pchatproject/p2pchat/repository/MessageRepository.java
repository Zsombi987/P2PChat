package com.p2pchatproject.p2pchat.repository;

import com.p2pchatproject.p2pchat.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findAll();

}