package Main

import scala.util.Try

/*Find the top 10 trending hashtags in twitter. You can write a standalone java class(es) / interfaces as deemed to be fit.
Assumptions & notes :
1) A tweet is a text being input by tweeters.
2) A main method in a java class to be implemented which takes the tweet as an input.
3) You need to extract hashtag from a tweet text (Ex: sachin is hashtag in the tweet -> " Worlds best cricketer is #sachin")
4) Maintain a data structure that keeps tracking of the count of each hashtag that is coming to your main method
5) print the list of top 10 hashtags at the end of main method execution
*
*/

object TrendingTweet extends App {
  val TOP_TWEETS = 10
  val n = Try(scala.io.StdIn.readLine().toInt).getOrElse(0)
  var ls = scala.collection.mutable.MutableList[String]()
  for (i <- 1 to n)
    ls +:= scala.io.StdIn.readLine()
  ls.flatMap(s => s.split(" ").filter(_.startsWith("#"))).groupBy(x => x).map(x => (x._1, x._2.length)).toSeq.sortBy(x => (-x._2, x._1))
    .map(_._1).take(TOP_TWEETS).map(println(_))
}
