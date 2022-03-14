/**
 * Spring Boot SubMission form for students.
 * class name: FormController
 * description : Controller class for SubMission form.
 * @author GAYATHRY E
 * @version jdk 8
 *
 */

package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	//method level comments
	/**
	 * @return student
	 */
	@RequestMapping("/")
	public String details()
	{
	log.debug("details method started");	//use debug
	return "student";
	
	}

	/**
	 * @param students
	 * @return student
	 */
	@RequestMapping("/details")
	public String details(Students students)
	{
	log.info("details method started with passing parameter students{}",students);		
    repo.save(students);
    log.debug("details method ended");
	return "student";
	}
	
	/**
	 * @return ViewStudents
	 */
	@RequestMapping("/getdetails")
	public String getdetails()
	{
	log.debug("getDetails method started");	
	log.debug("getDetails method ended");
    return "ViewStudents";
	}	
/**
 * @param sid
 * @return mv
 */
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

/**
 * @return repo.findAll
 */
@RequestMapping("/students")
@ResponseBody
public List<Students> getStudents()
{
	log.debug("getStudents method started");	
	log.debug("getStudents method ended");
	return repo.findAll();
}
/**
 * @param sid
 * @return repo.findById
 */
@RequestMapping("/students/{sid}")
@ResponseBody
public Optional<Students> getStudentById(@PathVariable("sid") int sid)
{

	log.debug("getStudentById method started by passing pathvariable{}",sid);	
	log.debug("getStudentById method ended");
	return repo.findById(sid);
}
/**
 * @param students
 * @return students
 */
@PostMapping("/students")
public Students saveStudents(@RequestBody Students students)
{
	log.info("saveStudents method started with passing parameter students{}",students);
	repo.save(students);
	log.debug("saveStudents method ended");
	return students;
}
/**
 * @param sid
 * @return std
 */
@DeleteMapping("/students/{sid}")
public Students deleteStudents(@PathVariable("sid") int sid)
{   
	log.info("deleteStudents method started by passing pathvariable{}",sid);	
	Students std=repo.getOne(sid);
	repo.delete(std);
	log.debug("deleteStudents method ended");
	return std;
}
/**
 * @param students
 * @return students
 */
@PutMapping(path="/students", consumes= {"application/json"})
public Students updateStudents(@RequestBody Students students)
{   
	log.info("updateStudents method started with passing parameter students{}",students);
	repo.save(students);
	log.debug("updateStudents method ended");
	return students;
}

}

