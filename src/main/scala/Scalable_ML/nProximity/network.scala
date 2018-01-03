package Scalable_ML.nProximity

import scala.io.Source

object network {
    //  List of Triplets (  Sub  ,  Obj  ,  Link  )
    var Triplets : List [ ( String , String , String ) ]    =    List ( )
    //  List of Distinct Subjects
    var Subjects  :  List[String]  =  List()
    //  List of Distinct Objects
    var Objects  :  List[String]  =  List()
    //  List of Distinct Links
    var Links  :  List[String]  =  List()
    
    /*
     * Load Triplets from file to populate Triplets, Subjects, Objects, and Links List
     */
    def loadFile ( fname : String )      {
      val lines  =  Source.fromFile(fname).getLines.toList
      for  (  i  <-  0  to  lines.length-1  )  {
        var tokens  =  lines(i).split(",")
        Triplets  =  (  tokens(0)  ,  tokens(2)  ,  tokens(1)  )  ::    Triplets
        
        var  s  =  Subjects.find(  _  ==  tokens(0) )
        if  (s.getOrElse("null")  ==  "null"  )
          Subjects  =  tokens(0)  ::  Subjects
        
        var  o  =  Objects.find(  _  ==  tokens(2) )
        if  (o.getOrElse("null")  ==  "null"  )
          Objects  =  tokens(2)  ::  Objects
          
        var  l  =  Links.find(  _  ==  tokens(1) )
        if  (l.getOrElse("null")  ==  "null"  )
          Links  =  tokens(1)  ::  Links
        
      }
        println("-----------------  SUBJECTS  -------------")
        Subjects.foreach(println)
        println("-----------------  LINKS  -------------")
        Links.foreach(println)
        println("-----------------  OBJECTS  -------------")
        Objects.foreach(println)
        println("-----------------  TRIPLETS  -------------")
        Triplets.foreach(println)
    }    
}
