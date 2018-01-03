package Scalable_ML.nProximity
import scala.io.Source
 import scala.util.Random

 
 import org.apache.spark._
 import org.apache.spark.graphx._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD
import org.apache.spark.SparkConf

 
class Read_Data {
  
  val filename = "/home/duaa-e-nadeem/fdata"
  for (line <- Source.fromFile(filename).getLines) {
    println(line)
 
 
  }

  
      println("...After Displaying file data.........Each element is displayed separatly.........")
    
    var Subjects:List[String]  =  List()
    var lines = Source.fromFile("/home/duaa-e-nadeem/fdata").getLines.toList
    for(i  <-  0 to lines.length -1  ){
      var s  =  lines(i).split(",")
      Subjects  =  s(0)::Subjects
      s.foreach(println)
    }
 
      println("...........Subjects Only......................")
 
      Subjects.foreach(println)

    
   //After Subjects............
  
    
    
    var Relations:List[String]  =  List()
    
    for(i  <-  0 to lines.length -1  ){
      var r  =  lines(i).split(",")
      Relations  =  r(1)::Relations
    //  r.foreach(println)
      
    }
    println(".....................Relations Only.................")
    Relations.foreach(println)

    //..After Relations.........
    
  
    
    var Objects:List[String]  =  List()
    
    for(i  <-  0 to lines.length -1  ){
      var O  =  lines(i).split(",")
      Objects  =  O(2)::Objects
  //    O.foreach(println)
      
    }
    println(".....................Objects Only.................")
    Objects.foreach(println)
    
    
    println(".....................Random Object .................")
    // code for selecting random object
val random = new Random
val o = Objects(random.nextInt(Objects.length))

println(o)

    
//ri:Single relation of type i such that ri ∈ R (e.g.r1=follower,r2=likes)


val dsub=   Subjects.distinct   
println("distinct subjects in the list are :"+dsub)

val dobj=   Objects.distinct   
println("distinct objects in the list are :"+dobj)

    val drel=   Relations.distinct   
println("distinct relations in the list are :"+drel)

    //no. of distinct elements in subject object and relation
    
   val ldsub= dsub.length
   println("no. of distinct subjects is = "+ldsub)
   
   val ldobj=dobj.length
   println("no. of distinct objects is = "+ldobj)
   
   val ldrel=drel.length
    println("no. of distinct relations is = "+ldrel)
  



  
    val conf = new SparkConf().setAppName("scala spark").setMaster("local")
    val sc = new SparkContext(conf)
    val i = List(1, 2, 3, 4, 5)
    val dataRDD = sc.parallelize(i)
    dataRDD.foreach(println)

/*  val vert = (sc.textFile("/home/duaa-e-nadeem/fdata")
      .map(line => line.split(",")).map( parts => (parts.head.toLong, parts.tail) ))
*/        
    
    
        // create vertices RDD with ID and Name</font>
val vertices=Array((1L, ("Aslam")),(2L, ("Sara")),(3L,("Ayesha")),(4L,("Khoula")),(5L,("Farhan")),(6L,("Ahsan")))
val vRDD= sc.parallelize(vertices)
vRDD.take(1)
  

// Defining a default vertex called nowhere</font>
val nowhere = "nowhere"



//We define an RDD with the above properties that is then used for the edges.
//The edge RDD has the form (src id, dest id, distance ).

// create routes RDD with srcid, destid, distance</font>
val edges = Array(Edge(3L,6L,("share")),Edge(2L,6L,("comment")),Edge(4L,6L,("like")),Edge(3L,6L,("like")),Edge(6L,5L,("like")),Edge(1L,4L,("comment")))
val eRDD= sc.parallelize(edges)  

eRDD.take(2)
<font color="blue">// Array(Edge(1,2,1800), Edge(2,3,800))</font>



//Create a property graph called graph.

// define the graph</font>
val graph = Graph(vRDD,eRDD, nowhere)

// graph vertices</font>
graph.vertices.collect.foreach(println)

// graph edges</font>
graph.edges.collect.foreach(println)  



    
    
//mt code
/*      
val veRDD= sc.parallelize(dsub)
veRDD.take(1).foreach(println)

val verRDD= sc.parallelize(dobj)
veRDD.take(1).foreach(println)

val edgeRDD= sc.parallelize(drel)
edgeRDD.take(1).foreach(println)

// create routes RDD with srcid, destid, distance</font>
val edge = List(Edge(3L,6L,("share")),Edge(2L,6L,("comment")),Edge(4L,6L,("like")),Edge(3L,6L,("like")),Edge(6L,5L,("like")),Edge(1L,4L,("comment")))
val edgesRDD= sc.parallelize(edge)  

//eRDD.take(2)
<font color="blue">// Array(Edge(1,2,1800), Edge(2,3,800))</font>
*/
//ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss

//Create a property graph called graph.

/*// define the graph</font>
val graph1 = Graph(veRDD,edgeRDD// create routes RDD with srcid, destid, distance</font>
val edges = Array(Edge(3L,6L,("share")),Edge(2L,6L,("comment")),Edge(4L,6L,("like")),Edge(3L,6L,("like")),Edge(6L,5L,("like")),Edge(1L,4L,("comment")))
val eRDD= sc.parallelize(edges)  

eRDD.take(2)
<font color="blue">// Array(Edge(1,2,1800), Edge(2,3,800))</font>



//Create a property graph called graph.

// define the graph</font>
val graph = Graph(vRDD,eRDD, nowhere)

// graph vertices</font>
graph.vertices.collect.foreach(println)

// graph edges</font>
graph.edges.collect.foreach(println)  

e)

// graph vertices</font>
graph1.vertices.collect.foreach(println)

// graph edges</font>
graph1.edges.collect.foreach(println)  

*/

    //sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
    
    /*
// define the graph</font>
val graph1 = Graph(veRDD,edgeRDD)

// graph vertices</font>
graph1.vertices.collect.foreach(println)

// graph edges</font>
graph1.edges.collect.foreach(println)  


*/

/*// define the Flight Schema</font>
case class Flight(sub:String, obj:String, rel:String)


// function to parse input into Flight class</font>
def parseFlight(str: String): Flight = {
 val line = str.split(",")
 Flight(line(0), line(1), line(2))
 }


<font color="green">// load the data into a RDD</font>

val textRDD = sc.textFile("/home/duaa-e-nadeem/fdata")

<font color="blue">// MapPartitionsRDD[1] at textFile</font>  

<font color="green">// parse the RDD of csv lines into an RDD of flight classes</font>
val flightsRDD = textRDD.map(parseFlight).cache()




<font color="green">// create airports RDD with ID and Name</font>
val airports = flightsRDD.map(flight => (flight.sub, flight.obj)).distinct  

airports.take(1)
<font color="blue">// Array((14057,PDX))</font>  

<font color="green">// Defining a default vertex called nowhere</font>
//val nowhere = "nowhere"  

<font color="green">// Map airport ID to the 3-letter code to use for printlns</font>
val airportMap = airports.map { case ((org_id), name) => (org_id -> name) }.collect.toList.toMap
<font color="blue">// Map(13024 -> LMT, 10785 -> BTV,…)</font>

*/
}



