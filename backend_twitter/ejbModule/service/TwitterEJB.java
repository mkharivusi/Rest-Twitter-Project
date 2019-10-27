package service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import entities.TwitterEntity;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Session Bean implementation class TwitterEJB
 */

@Stateless
@LocalBean
@Path("/mytwitterapp")
@ApplicationPath("resources")
public class TwitterEJB<Tweet> {

	@PersistenceContext(name = "tweet")
	private EntityManager em;

	public TwitterEJB() {
		// TODO Auto-generated constructor stub
	}

	public void addnew(TwitterEntity twitterentity) {
	
		twitterentity.setTimestamp(java.time.LocalTime.now());
		
		em.persist(twitterentity);
		
		System.out.println("about to send tweet");
		createTweet(twitterentity.getTweetBody());
	}	
	//http://localhost:8080/RestExample/resources/MyRestService/sayHello
	@javax.ws.rs.GET
	@Path("/mytweets")
	@javax.ws.rs.Produces({MediaType.APPLICATION_JSON})
	@SuppressWarnings("unchecked")
	public List<Tweet> ViewAllTransactions() {
		
		List<Tweet> results = null;
		
		Query query = em.createQuery("Select e from twitter_tbl e");
		results = query.getResultList();
		
		return results;
	}
	
	//Twiiter config
	
	public String createTweet(String tweet){
	  
		Twitter twitter = getTwitterinstance(); 
		Status status = null; 
		try {
			  status = twitter.updateStatus(tweet); 
			  System.out.println("do we get here");
			  } catch (TwitterException e)
		  { // TODO Auto-generated catch block 
				  e.printStackTrace(); 
		  }
		  return status.getText();
	  }
	
	public Twitter getTwitterinstance() {
	  
	  ConfigurationBuilder cb = new ConfigurationBuilder();
	  cb.setDebugEnabled(true);
	  cb.setOAuthConsumerKey("VLn0egDouDd4AhJNYm4dxFsa6");
	  cb.setOAuthConsumerSecret(
	  "ccO3dXRXCXrvCdbUl23badSS1N5xaYsXm7apbzbJS72Ohf7ma0");
	  cb.setOAuthAccessToken("287781142-nMoNUss2Cc3vFwAZ1uJL9HStz3oI6WTDyLmU2dTe");
	  cb.setOAuthAccessTokenSecret("vDnWoBm2kj0kAZbvQQJYAunRbTYQMv6sqMffi5AUVR3IU");
	  
	  System.out.println("Twitter instance");
	  
	  TwitterFactory tf = new TwitterFactory(cb.build()); 
	  Twitter twt = tf.getInstance();
	  return twt; 
	}  
}
