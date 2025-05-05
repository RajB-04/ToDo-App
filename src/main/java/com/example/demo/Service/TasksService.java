package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Tasks;
import com.example.demo.Repo.TasksRepo;


@Service
public class TasksService {
    @Autowired
    private TasksRepo tasksRepo;

    public List<Tasks> getAllTasks(){
        return tasksRepo.findAll();
    }

    public Tasks getTask(int taskid){
        return tasksRepo.findById(taskid).orElse(null);
    }

    public void addTask(Tasks task){
        tasksRepo.save(task);
    }
    public void updateTask(Tasks task){
        // Tasks ut = tasksRepo.findById(taskid).orElse(null);
        // if (ut != null) {
        //     ut.setTaskName(task.getTaskName());
        //     ut.setTaskStatus(task.getTaskStatus());
        // }
        tasksRepo.save(task);
    }
    public void deleteTask(int taskid){
        tasksRepo.deleteById(taskid);
    }
}
