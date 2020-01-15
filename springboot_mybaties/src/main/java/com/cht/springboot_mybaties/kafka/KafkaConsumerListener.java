package com.cht.springboot_mybaties.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import com.cht.springboot_mybaties.config.WebSocketServer;
import com.cht.springboot_mybaties.model.Book;
import com.google.gson.Gson;

/**
 * 从kafka接收数据
 * @author Administrator
 */
public class KafkaConsumerListener {
	    /**
	     * 从分组为store中topic的book中取数据
	     * @param record
	     */
	    @KafkaListener(topics = {"book"},groupId = "store")
	    public void receiveRemoteControlResult(ConsumerRecord<String,byte[]> record){
	        String s = new String(record.value());
	        Gson gson = new Gson();
	        Book book = gson.fromJson(s, Book.class);
	        System.out.println(book.toString());
	        WebSocketServer.sendInfo(book.getId()+":"+book.getTitle());
	    }
}
