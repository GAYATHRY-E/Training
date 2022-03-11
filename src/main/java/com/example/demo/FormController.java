package com.example.demo;

import java.util.Optional;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class FormController {
	
	@Autowired
	StudentRepo repo;
	@RequestMapping("/")
	public String details()
	{
	log.info("details method started");	
	return "student";
	
	}
	
	@RequestMapping("/details")
	public String details(Students students)
	{
	log.info("details method started with passing parameter students{}",students);		
    repo.save(students);
    log.info("details method ended");
	return "student";
	}
	
	@RequestMapping("/getdetails")
	public String getdetails()
	{
	log.info("getDetails method started");	
	log.info("getDetails method ended");
    return "ViewStudents";
	}	
	
@PostMapping("/getdetails")
public ModelAndView getdetails(@RequestParam int sid) 
{
	log.info("getdetails method started with passing parameter student Id{}",sid);
	ModelAndView mv=new ModelAndView("Retrieve");
	Students students=repo.findById(sid).orElse(null);
    mv.addObject(students);
    log.info("getDetails by id method ended");
    return mv;
} 
@RequestMapping("/students")
@ResponseBody
public List<Students> getStudents()
{
	log.info("getStudents method started");	
	log.info("getStudents method ended");
	return repo.findAll();
}

@RequestMapping("/students/{sid}")
@ResponseBody
public Optional<Students> getStudentById(@PathVariable("sid") int sid)
{

	log.info("getStudentById method started by passing pathvariable{}",sid);	
	log.info("getStudentById method ended");
	return repo.findById(sid);
}

@PostMapping("/students")
public Students saveStudents(@RequestBody Students students)
{
	log.info("saveStudents method started with passing parameter students{}",students);
	repo.save(students);
	log.info("saveStudents method ended");
	return students;
}

@DeleteMapping("/students/{sid}")
public Students deleteStudents(@PathVariable("sid") int sid)
{   
	log.info("deleteStudents method started by passing pathvariable{}",sid);	
	Students std=repo.getOne(sid);
	repo.delete(std);
	log.info("deleteStudents method ended");
	return std;
}

@PutMapping(path="/students", consumes= {"application/json"})
public Students updateStudents(@RequestBody Students students)
{   
	log.info("updateStudents method started with passing parameter students{}",students);
	repo.save(students);
	log.info("updateStudents method ended");
	return students;
}

}
