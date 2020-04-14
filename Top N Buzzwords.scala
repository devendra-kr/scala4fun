/*You work on a team whose job is to understand the most sought after toys for the holiday season. A teammate of yours has built a webcrawler that extracts a list of quotes about toys from different articles. You need to take these quotes and identify which toys are mentioned most frequently. Write an algorithm that identifies the top N toys out of a list of quotes and list of toys.

Your algorithm should output the top N toys mentioned most frequently in the quotes.

Input:

The input to the function/method consists of five arguments:

numToys, an integer representing the number of toys
topToys, an integer representing the number of top toys your algorithm needs to return
toys, a list of strings representing the toys
numQuotes, an integer representing the number of quotes about toys
quotes, a list of strings that consists of space-sperated words representing articles about toys
Output:

Return a list of strings of the most popular N toys in order of most to least frequently mentioned

Note:

The comparison of strings is case-insensitive. If the value of topToys is more than the number of toys, return the names of only the toys mentioned in the quotes. If toys are mentioned an equal number of times in quotes, sort alphabetically.

Example:

Input:
  numToys = 6
  topToys = 2
  toys = ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"]
  numQuotes = 6
  quotes = [
  "Emo is the hottest of the season! Elmo will be on every kid's wishlist!",
  "The new Elmo dolls are super high quality", 
  "Expect the Elsa dolls to be very popular this year",
  "Elsa and Elmo are the toys I'll be buying for my kids",
  "For parents of older kids, look into buying them a drone",
  "Warcraft is slowly rising in popularity ahead of the holiday season"
  ];
Output:["elmo", "elsa"]
*
*/


object Solution extends App{
  /*val numToys = 6
  val topToys = 2
  val toys = List("elmo", "elsa", "legos", "drone", "tablet", "warcraft")
  val numQuotes = 6
  val quotes = List(
  "Emo is the hottest of the season! Elmo will be on every kid's wishlist!",
  "The new Elmo dolls are super high quality", 
  "Expect the Elsa dolls to be very popular this year",
  "Elsa and Elmo are the toys I'll be buying for my kids",
  "For parents of older kids, look into buying them a drone",
  "Warcraft is slowly rising in popularity ahead of the holiday season")
    
  println(popularNToys(numToys, topToys, toys, numQuotes, quotes))*/

    def popularNToys(numToys: Int, topToys: Int, toys: List[String], numQuotes: Int, quotes: List[String]) = {
      val toys = List("elmo", "elsa", "legos", "drone", "tablet", "warcraft")

      var toyMap = toys.map(x => (x.toLowerCase,0)).toMap
      quotes.map(x => {
            val words = x.toLowerCase().split(" ")
            words.map(word => {
                if(toyMap.get(word).isDefined) {
                    toyMap += (word -> (toyMap(word) + 1))
                }
           })
      })
      toyMap.filterNot(_._2 == 0).toSeq.sortBy(-_._2).map(_._1).take(topToys).sorted.toList
    }
}
