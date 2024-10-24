package com.example.demo.soap.repositories;


import com.example.demo.soap.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository  extends JpaRepository<Task,Long> {

}
