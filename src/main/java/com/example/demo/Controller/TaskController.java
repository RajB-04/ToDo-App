package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.Tasks;
import com.example.demo.Service.TasksService;
import org.springframework.ui.Model;

// @RestController
// @RequestMapping("/tasks")
// public class TaskController {
//     @Autowired
//     private TasksService tasksService;

//     @GetMapping("/")
//     public List<Tasks> getAllTasks(){
//         return tasksService.getAllTasks();
//     }

//     @GetMapping("/{taskid}")
//     public Tasks getTask(@PathVariable int taskid){
//         Tasks task = tasksService.getTask(taskid);
//         return task;
//     }

//     @PostMapping("/add")
//     public void addTask(Tasks task){
//         tasksService.addTask(task);
//     }

//     @PutMapping("/update/{taskid}")
//     public void updateTask(@PathVariable int taskid, Tasks task){
//         tasksService.updateTask(task);
//     }

//     @DeleteMapping("/delete/{taskid}")
//     public void deleteTask(@PathVariable int taskid){
//         tasksService.deleteTask(taskid);
    
//     }
// }

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("/")
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", tasksService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/add-form")
    public String showAddForm() {
        return "addTask";
    }

    @PostMapping("/add")
    public String addTask(Tasks task) {
        tasksService.addTask(task);
        return "redirect:/tasks/";
    }

    @GetMapping("/updateForm/{taskid}")
    public String showUpdateForm(@PathVariable int taskid, Model model) {
        Tasks etask = tasksService.getTask(taskid);
        model.addAttribute("task", etask);
        return "updateTask";
    }

    @PostMapping("/update/{taskid}")
    public String updateTask(Tasks task) {
        tasksService.updateTask(task);
        return "redirect:/tasks/";
    }

    @GetMapping("/delete/{taskid}")
    public String deleteTask(@PathVariable int taskid) {
        tasksService.deleteTask(taskid);
        return "redirect:/tasks/";
    }
}

