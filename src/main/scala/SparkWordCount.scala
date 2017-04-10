import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by david on 10/04/2017.
  */
object SparkWordCount {
  def main(args:Array[String]) : Unit = {
//    System.setProperty("hadoop.home.dir", "/Users/david/Documents")
//    val conf = new SparkConf().setAppName("SparkWordCount").setMaster("local[*]")
//    val sc = new SparkContext(conf)
//    val tf = sc.textFile(args(0))
//    val splits = tf.flatMap(line => line.split(" ")).map(word =>(word,1))
//    val counts = splits.reduceByKey((x,y)=>x+y)
//    splits.saveAsTextFile(args(1))
//    counts.saveAsTextFile(args(2))

    val conf = new SparkConf()
    conf.setAppName("Datasets Test")
    conf.setMaster("local[2]")
    val sc = new SparkContext(conf)
    println(sc)
  }
}