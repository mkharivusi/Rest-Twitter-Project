 package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.TwitterEntity;

@ManagedBean(name = "tweet")
@SessionScoped
public class Tweet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String tweetBody;
	private LocalTime timestamp;
	public String getTweetBody() {
		return tweetBody;
	}
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	public LocalTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalTime timestamp) {
		this.timestamp = timestamp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public TwitterEntity getentiEntity()
	{
		TwitterEntity twitterEntity = new TwitterEntity();
		
		twitterEntity.setTimestamp(timestamp);
		twitterEntity.setTweetBody(tweetBody);
		
		return twitterEntity;
		
	}
}