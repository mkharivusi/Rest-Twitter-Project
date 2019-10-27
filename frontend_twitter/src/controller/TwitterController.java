package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedProperty;

import model.Tweet;
import service.TwitterEJB;



@ManagedBean(name = "twittercontroller")
@SessionScoped
public class TwitterController
{
	@EJB 
	private TwitterEJB<Tweet> twitterEJB;
	
	@ManagedProperty(value="#{tweet}")
	private Tweet tweet;
	
	private List<Tweet> tweetList = new ArrayList<>();
	
	public TwitterEJB<Tweet> getTwitterEJB() {
		return twitterEJB;
	}

	public void setTwitterEJB(TwitterEJB<Tweet> twitterEJB) {
		this.twitterEJB = twitterEJB;
	}

	public List<Tweet> getTweetList() {
		return tweetList;
	}

	public void setTweetList(List<Tweet> tweetList) {
		this.tweetList = tweetList;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public String addnewTweet()
	{
		twitterEJB.addnew(tweet.getentiEntity());
		tweetList = twitterEJB.ViewAllTransactions();
		
		return "tweetsList.xhtml";
	}
}
