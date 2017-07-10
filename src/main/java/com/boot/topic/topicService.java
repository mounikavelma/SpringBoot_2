package com.boot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class topicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics= new ArrayList<>( Arrays.asList(
			new Topic("Spring","Spring Framework","This is Spring framework Course"),
			new Topic("Java","Core Java","this is core java training course")));

	public List<Topic> getAlltopics() {
		// TODO Auto-generated method stub
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopicById(String id) {
		// TODO Auto-generated method stub
		
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		
		// topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
		/*for (int i=0;i< topics.size();i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
			}
		}
		*/
		
		topicRepository.save(topic);
	}

	public void deleteTopicById(String id) {
		// TODO Auto-generated method stub
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.delete(id);
	}
	
	

}
