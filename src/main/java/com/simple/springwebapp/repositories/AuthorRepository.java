package com.simple.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.simple.springwebapp.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
