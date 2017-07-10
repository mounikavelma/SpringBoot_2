package com.boot.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseservice;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String topicId){
		return courseservice.getAllCourses(topicId);
	}
	
	@RequestMapping("/courses/{topicId}/courses/{id}")
	public Course getCourseById(@PathVariable("id") String id){
		return courseservice.getCourseById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses/{id}")
	public void addCourse(@RequestBody Course course, @PathVariable("topicId") String  topicId){
		course.setTopic(new Topic(topicId, " ",""));
		courseservice.addCourse(course);;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String  topicId,@PathVariable("id") String id){
		course.setTopic(new Topic(topicId, " ",""));
		courseservice.updateCourse(course);;
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{id}", method=RequestMethod.DELETE)
	public void deleteCourseById(@PathVariable("id") String id){
		courseservice.deleteCourseById(id);
	}

}
