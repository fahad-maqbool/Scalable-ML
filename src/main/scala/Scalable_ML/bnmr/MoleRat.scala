package Scalable_ML.bnmr

class MoleRat ( foodSource: List[ (Int,Double) ] , min: Double , max:Double , dimensions:Int ){
 // val foodSource : List[ Double ]    =    randInitialize [ Double ] ( min , max , dimensions ).Solution
   // var B : Double
    
    def localMove ( foodSource:List[(Int,Double)]):List[(Int,Double)]={
      val r= scala.util.Random
      val R=1+r.nextInt((foodSource.size-1)+1)
      var R2: Double= (0 + r.nextInt( (100 - 0) + 1 ))/100.0
      //var fs=List[(Int,Double)]()
     foodSource.patch(R-1, Seq((R, min + R2*( (max - min) + 1 ))),1)
    }    
   /* def randSearch ( Dimensions:Int):List[(Int,Double)]={
      val r= scala.util.Random
      var R: Double= (0 + r.nextInt( (100 - 0) + 1 ))/100.0
      
    }*/
}