package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@InitBinder
	public void intiBinder(WebDataBinder binder) {
		//Date format = dd/MM/yyyy
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value="/list-todos",method=RequestMethod.GET)
	public String showListTodos(ModelMap model) {
		String name= (String)model.get("name");
		model.addAttribute("todos",service.retrieveTodos(name));
		return "list-todos";
	}
	@RequestMapping(value="/addtodo",method=RequestMethod.GET)
	public String showAddTodo(ModelMap model) {
		model.addAttribute("todo",new Todo(0, (String)model.get("name"), "", new Date(), false));
		return "todo";
	}
	@RequestMapping(value="/addtodo",method=RequestMethod.POST)
	public String AddTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		service.addTodos((String)model.get("name"), todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
	
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteTodos(id);
		return "redirect:/list-todos";
	}
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String showUpdateTodo(Model model,@RequestParam int id) {
		Todo todo = service.retrieveTodo(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,  @Valid Todo todo,BindingResult rs) {
		if(rs.hasErrors()) {
			return "todo";
		}
		todo.setUser((String)model.get("name"));
		service.updateTodo(todo);
		
		return "redirect:/list-todos";
	}
	
	
}
