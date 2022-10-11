package com.Ddevanle.TodoList.controllers;

import com.Ddevanle.TodoList.model.Item;
import com.Ddevanle.TodoList.repo.TodoRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoitems")
public class Controller {
    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    public List<Item> getAllItems(){
        return todoRepo.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createTodoITem( @NotNull @RequestBody Item item){
        todoRepo.save(item);
        return new ResponseEntity<>("Todo created", HttpStatus.ACCEPTED);
    }
    @PutMapping("/replace")
    public ResponseEntity<Object> replaceTodo(@RequestBody Item item ){
        todoRepo.save(item);
        return new ResponseEntity<>("Todo " + item.getId() + " updated", HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable Long id){
        todoRepo.deleteById(id);
        return new ResponseEntity<>("Todo " + id + " deleted", HttpStatus.ACCEPTED);
    }

}
