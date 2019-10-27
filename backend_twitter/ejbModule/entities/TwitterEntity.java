package entities;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="twitter_tbl")
public class TwitterEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tweetID;
	
	private String tweetBody;
	private LocalTime timestamp;
	public Long getTweetID() {
		return tweetID;
	}
	public void setTweetID(Long tweetID) {
		this.tweetID = tweetID;
	}
	public String getTweetBody() {
		return tweetBody;
	}
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	public LocalTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalTime localTime) {
		this.timestamp = localTime;
	}
}
