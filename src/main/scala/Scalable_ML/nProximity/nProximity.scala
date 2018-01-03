package Scalable_ML.nProximity
import org.apache.spark._
 import org.apache.spark.graphx._

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
//import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD
import org.apache.spark.SparkConf
 //import dua._

/**
 * @author ${user.name}
 */
//Scalable_ML.nProximity.nProximity

object nProximity {
  def main(args : Array[String]) {
    println( "Hello nProximity!" )
    network.loadFile("/home/duaa-e-nadeem/fdata")
    //val R  =  new Read_Data

/*
    
    type    VertexId=    Long    
    
    val vertices:RDD[(VertexId, String)] = sc.parallelize(List((1L,“Alice”),(2L,“Bob”),(3L,“Charlie”)))    
    class Edge[ED](val srcId: VertexId,val dstId:VertexId,val attr:ED)    
val edges: RDD[Edge[String]]=sc.parallelize(List( Edge(1L,2L,“coworker”),Edge(2L,3L,“friend”)))
*/    //val A=new FlightApp
    //val count= fdata.count()
   
  /*  
    val conf = new SparkConf().setAppName("scala spark").setMaster("local")
    val sc = new SparkContext(conf)
    val i = List(1, 2, 3, 4, 5)
    val dataRDD = sc.parallelize(i)
    dataRDD.foreach(println)


* 
* 
* 
*         <font color="green">// create vertices RDD with ID and Name</font>
val vertices=Array((1L, ("SFO")),(2L, ("ORD")),(3L,("DFW")))
val vRDD= sc.parallelize(vertices)
vRDD.take(1)
<font color="blue">// Array((1,SFO))</font>  

<font color="green">// Defining a default vertex called nowhere</font>
val nowhere = "nowhere"



//We define an RDD with the above properties that is then used for the edges.
//The edge RDD has the form (src id, dest id, distance ).

<font color="green">// create routes RDD with srcid, destid, distance</font>
val edges = Array(Edge(1L,2L,1800),Edge(2L,3L,800),Edge(3L,1L,1400))
val eRDD= sc.parallelize(edges)  

eRDD.take(2)
<font color="blue">// Array(Edge(1,2,1800), Edge(2,3,800))</font>



//Create a property graph called graph.

<font color="green">// define the graph</font>
val graph = Graph(vRDD,eRDD, nowhere)
<font color="green">// graph vertices</font>
graph.vertices.collect.foreach(println)
<font color="blue">// (2,ORD)</font>
<font color="blue">// (1,SFO)</font>
<font color="blue">// (3,DFW)</font>  

<font color="green">// graph edges</font>
graph.edges.collect.foreach(println)  

<font color="blue">// Edge(1,2,1800)</font>
<font color="blue">// Edge(2,3,800)</font>
<font color="blue">// Edge(3,1,1400)</font>
* */



  
  }
}