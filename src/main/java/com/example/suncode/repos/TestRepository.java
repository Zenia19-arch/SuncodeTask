package com.example.suncode.repos;

import com.example.suncode.domain.Test;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface TestRepository extends CrudRepository<Test, Integer> {
}
