package Scalable_ML

import scala.io.Source

/**
 * @author :	Fahad Maqbool
 * @affiliation	:	University of Sargodha
 */

object Network {
    
    var Triplets : List [ ( String , String , String ) ]    =    List ( )    //  List of Triplets (  Sub  ,  Obj  ,  Link  )
    
    var Subjects  :  List[String]  =  List()    //  List of Distinct Subjects
    
    var Objects  :  List[String]  =  List()    //  List of Distinct Objects
    
    var Links  :  List[String]  =  List()    //  List of Distinct Links
   
    /*
     * Load Triplets from file to populate Triplets, Subjects, Objects, and Links List
     */
    def loadFile ( fname : String )      {
      
      //  Get List of Triplets from source file
      val lines  =  Source.fromFile(fname).getLines.toList
      
      for  (  i  <-  0  to  lines.length-1  )  {
        
        //  Break each triplet into subject, link, object
        var tokens  =  lines(i).split(",")
        Triplets  =  (  tokens(0)  ,  tokens(2)  ,  tokens(1)  )  ::    Triplets
        
        //  Extract Unique Subjects
        var  s  =  Subjects.find(  _  ==  tokens(0) )
        if  (s.getOrElse("null")  ==  "null"  )
          Subjects  =  tokens(0)  ::  Subjects
       
        //  Extract Unique Objects
        var  o  =  Objects.find(  _  ==  tokens(2) )
        if  (o.getOrElse("null")  ==  "null"  )
          Objects  =  tokens(2)  ::  Objects
        
        //  Extract Unique Links
        var  l  =  Links.find(  _  ==  tokens(1) )
        if  (l.getOrElse("null")  ==  "null"  )
          Links  =  tokens(1)  ::  Links
        
      }
    }
    
    override def toString():  String  =  {
      
      var args  =  "-----------------  SUBJECTS  -------------\n"
      args  +=  Subjects.toString()
      
      args  +=  "\n-----------------  LINKS  -------------\n"
      args  +=  Links.toString()
      
      args  +=  "\n-----------------  OBJECTS  -------------\n"
      args  +=  Objects.toString()
      
      args  +=  "\n-----------------  TRIPLETS  -------------\n"
      args  +=  Triplets.toString()
      
      args
    }
 
}