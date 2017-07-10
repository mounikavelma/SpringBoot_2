package com.boot.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private topicService topicservice;
	
	@RequestMapping("/topics")
	public List<Topic> getAlltopics(){
		return topicservice.getAlltopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable("id") String id){
		return topicservice.getTopicById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic){
		 topicservice.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id){
		 topicservice.updateTopic(id,topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopicById(@PathVariable("id") String id){
		 topicservice.deleteTopicById(id);
	}

}
