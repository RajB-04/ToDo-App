package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Tasks;


@Repository
public interface TasksRepo extends JpaRepository<Tasks, Integer> {

}
