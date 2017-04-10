import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by david on 10/04/2017.
  */
object SparkWordCount {
  def main(args:Array[String]) : Unit = {
    System.setProperty("hadoop.home.dir", "/Users/david/Documents")
    val conf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val tf = sc.textFile(args(0))
    val splits = tf.flatMap(line => line.split(" ")).map(word =>(word,1))
    val counts = splits.reduceByKey((x,y)=>x+y)
    val wordsWithCounts = counts.filter((word) => word._1.length() > 4).sortBy((wordCount) => -wordCount._2)
    val top10 = wordsWithCounts.take(10)
    //top10.foreach((s) => println (s"${s._1} appears ${s._2} times"))
    top10 foreach { s =>
      println (s"${s._1} appears ${s._2} times")
    }
  }
}