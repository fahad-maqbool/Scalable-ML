package Scalable_ML

/**
 * @author :	Kamran Mazhar
 * @affiliation	:	University of Sargodha
 */

class randInit  [T](Population:Int  ,  chromoLength:Int  , minVal:T  , maxVal:T  ) {
  val rnd = new scala.util.Random
  var initData  =  minVal  match{
    case minVal:Int  =>  List(List(0))
    case minVal:Double  =>  List(List(0.0))
  }
 
  minVal match{
    case minVal:Int  =>  {
      for  (  i  <-  1 to Population-1  )  {
        var temp  =  List.fill(chromoLength)(  minVal.asInstanceOf[Int]  +  rnd.nextInt(  maxVal.asInstanceOf[Int]  -  minVal.asInstanceOf[Int]  )  )
        initData  =  temp  ::  initData 
      }
      
      
    }
    case minVal:Double  =>  {
      var temp:List[Double]  =  List()  
      for  (  i  <-  1 to Population-1){
      var toadd:Double  =  minVal + (  (rnd.nextInt( 100 ).toDouble/100).toDouble  *  (maxVal.asInstanceOf[Double]-minVal.asInstanceOf[Double] ).toDouble  ).toDouble
      
           var frac  =  toadd - toadd.toInt
           frac  =  frac*100
           frac  = frac.toInt
           frac = frac/100
           toadd = toadd.toInt+frac
           temp  =  toadd  ::  temp 
           initData= temp :: initData
     
      }
    }
  }
}