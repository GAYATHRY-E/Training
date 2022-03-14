/**
 * Spring Boot SubMission form for students.
 * class name: StudentReo
 * description : Repository class for SubMission form.
 * @author GAYATHRY E
 * @version jdk 8
 *
 */


package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students, Integer>
{

}
