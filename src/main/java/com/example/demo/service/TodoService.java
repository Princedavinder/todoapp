package com.example.demo.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;

@Service
public class TodoService {
	private static  List<Todo> todos = new ArrayList<>();
	private static int todoCount=3;
	
	static {
		todos.add(new Todo(1, "prince", "i want to learn spring boot", new Date(), false));
		todos.add(new Todo(2, "prince", "i want to learn spring mircroservices", new Date(), false));
		todos.add(new Todo(3, "prince", "i want to learn spring cloud", new Date(), false));
		
	}
	
	public List<Todo> retrieveTodos(String user){
		List<Todo> filteredTodos = new ArrayList<>();
		for(Todo todo:todos) {
			if(todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void updateTodo(Todo todo) {
		todos.remove(todo);
		todos.add(todo);
	}
	public Todo retrieveTodo(int id){
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
	
	public void addTodos(String user,String desc,Date date,Boolean isDone) {
		todos.add(new Todo(++todoCount, user, desc, date, isDone));
	}
	
	public void deleteTodos(int id) {
		Iterator<Todo> iterator = todos.iterator();
		
		while(iterator.hasNext()) {
			Todo todo = iterator.next();
			if(todo.getId()==id) {
				iterator.remove();
			}
		}
	}
	
}
