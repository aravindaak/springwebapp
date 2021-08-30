package com.simple.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simple.springwebapp.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
