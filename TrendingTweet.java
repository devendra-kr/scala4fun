package Main;

/*Find the top 10 trending hashtags in twitter. You can write a standalone java class(es) / interfaces as deemed to be fit.
Assumptions & notes :
1) A tweet is a text being input by tweeters.
2) A main method in a java class to be implemented which takes the tweet as an input.
3) You need to extract hashtag from a tweet text (Ex: sachin is hashtag in the tweet -> " Worlds best cricketer is #sachin")
4) Maintain a data structure that keeps tracking of the count of each hashtag that is coming to your main method
5) print the list of top 10 hashtags at the end of main method execution
* 
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TrendingTweet {

	public static void main(String args[]) throws Exception {
		int TOP_TWEETS = 10; // Display top N tweets.
		
		TrendingTweet trendingTweet = new TrendingTweet();
		String[] tweets = trendingTweet.readTweets(); // Reading input from STDIN

		Map<String, Integer> tweetCounts = new HashMap<String, Integer>(); // Use to store hashtag and its count.

		for (int i = 0; i < tweets.length; i++) {
			List<String> hashtags = trendingTweet.hashtagExtracter(tweets[i]); // Extract hashtag from a tweet text.
			hashtags.forEach(tag -> {
				if (tweetCounts.containsKey(tag))
					tweetCounts.put(tag, tweetCounts.get(tag) + 1);
				else
					tweetCounts.put(tag, 1);
			});
		}

		 /* Sort the Map based on most tweet count followed by tweet. */
		List<Entry<String, Integer>> list = trendingTweet.sortByValueDescFollowedByKey(tweetCounts); 

		trendingTweet.print(list, TOP_TWEETS); // Print the output.
	}

	public String[] readTweets() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = Integer.parseInt(s);
		String[] tweets = new String[n];
		for (int i = 0; i < n; i++)
			tweets[i] = sc.nextLine();
		sc.close();
		return tweets;
	}

	public List<String> hashtagExtracter(String str) {
		List<String> hashtags = new ArrayList<String>();
		String[] arr = str.split(" ");
		for(int i = 0; i < arr.length; i++)
			if(arr[i].startsWith("#"))
				hashtags.add(arr[i]);
		/*while (str.contains("#")) {
			int beginIndex = str.indexOf("#");
			int endIndex = str.indexOf(" ", beginIndex);
			if (endIndex == -1)
				endIndex = str.length();
			hashtags.add(str.substring(beginIndex, endIndex));
			str = str.replaceFirst("#", "");
		}*/
		return hashtags;
	}

	public List<Entry<String, Integer>> sortByValueDescFollowedByKey(Map<String, Integer> map) {
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
				int value = (m2.getValue()).compareTo(m1.getValue());
				if (value == 0)
					return -(m2.getKey()).compareTo(m1.getKey());
				else
					return value;
			}
		});
		return list;
	}

	public void print(List<Entry<String, Integer>> list, int TOP_TWEETS) {
		int count = 1;
		for (Map.Entry<String, Integer> entry : list) {
			if (count <= TOP_TWEETS)
				System.out.println(entry.getKey());
			else
				break;
			count++;
		}
	}
}
