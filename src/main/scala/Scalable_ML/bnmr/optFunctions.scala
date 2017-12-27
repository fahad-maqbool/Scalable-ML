package Scalable_ML.bnmr

object optFunctions {
  //..................helping functions..................//
  def TermZakharov(xs:List[(Int,Double)]): Double = {
      if(xs.isEmpty) 0 
      else
         Math.pow(xs.head._2,2)+TermZakharov(xs.tail)
    }
    def Term1Zakharov(xs:List[(Int,Double)]): Double = {
    if(xs.isEmpty) 0 
    else
      Math.pow(0.5*(xs.head._1)*(xs.head._2),2)+Term1Zakharov(xs.tail)
    }
    def TermAckely(xs: List[(Int,Double)]): Double = {
      if (xs.isEmpty) 0
      else 
  	  (xs.head._2 * xs.head._2) + TermAckely(xs.tail)
      }
    def Term1Ackely(xs: List[(Int,Double)],c: Double): Double = {
      if (xs.isEmpty) 0
      else 
  	  Math.cos(xs.head._2 * c) + Term1Ackely(xs.tail,c)
      }
    def TermPerm(xs: List[(Int,Double)], i: Int): Double = {
      var beta=10 
      if (xs.isEmpty) 0
      else 
       (Math.pow((Math.pow((xs.head._1),i)+beta)*((Math.pow((xs.head._2/xs.head._1),i)-1)),2))+TermPerm(xs.tail,i)
      }
  def TermDixonPrice(xs:List[(Int,Double)]): Double = {
      if(xs.isEmpty || xs.tail.isEmpty) 0 
      else
         (xs.tail.head._1)*Math.pow((2*Math.pow(xs.tail.head._2,2)-(xs.head._2)),2) + TermDixonPrice(xs.tail)
    }
  def TermRastrigin(xs:List[(Int,Double)]): Double = {
      if(xs.isEmpty) 0 
      else
        (Math.pow(xs.head._2,2)-(10*(Math.cos((2*Math.PI*xs.head._2)))))+TermRastrigin(xs.tail)
    }
  def TermGriewank(xs:List[(Int,Double)]): Double = {
      if(xs.isEmpty) 0 
      else
       (Math.pow(xs.head._2,2))/4000 +  TermGriewank(xs.tail)
    }
   def Term2Griewank(xs:List[(Int,Double)]): Double = {
      if(xs.isEmpty) 0 
      else
       Math.cos((xs.head._2)/(Math.pow(xs.head._1,0.5)))*Term2Griewank(xs.tail)
   }
  def TermSchwefel(xs:List[(Int,Double)]): Double = {
      if(xs.isEmpty) 0 
      else
        (xs.head._2)*Math.sin((Math.pow(Math.abs(xs.head._2),0.5)))+TermSchwefel(xs.tail)
    }
  def TermLevy(xs: List[(Int,Double)]): Double = {
      if (xs.isEmpty || xs.tail.isEmpty) 0
      else  Math.pow((1+(xs.head._2-1)/4)-1,2)*(1+10*Math.pow((Math.sin(Math.PI*(1+(xs.head._2-1)/4)+1)),2)) +  TermLevy(xs.tail)
      }
  def TermPerm(xs: List[(Int,Double)], i: Int, Beta:Double): Double = {
  if(xs.isEmpty) 0
  else
     Math.pow((Math.pow(xs.head._1,i)+Beta)*(Math.pow(xs.head._2/xs.head._1,i)-1),2)+TermPerm(xs.tail,i,Beta)
  }
  def TermPermZero(xs: List[(Int,Double)], i: Int, Beta: Double): Double = {
  if(xs.isEmpty) 0
  else
  {
     Math.pow((xs.head._1+Beta)*(Math.pow(xs.head._2,i)-(1/Math.pow(xs.head._1,i))),2)+TermPermZero(xs.tail,i, Beta)
  }
  }
     //..................Function Implementation..................//
    def Michalewicz(xs: List[(Int,Double)],m: Double): Double = {
      if (xs.isEmpty) 0
      else -1*(Math.sin(xs.head._2) *Math.pow(Math.sin((xs.head._1 *xs.head._2 *xs.head._2)/Math.PI),2*m)) + Michalewicz(xs.tail,m)
      }
    def StyblinskiTang(xs: List[(Int,Double)]): Double = {
      if (xs.isEmpty) 0
      else 0.5*((Math.pow(xs.head._2 ,4)) - (16*Math.pow(xs.head._2 ,2)) + (5*xs.head._2)) + StyblinskiTang(xs.tail)
      }
    def Ackely(xs: List[(Int,Double)], dimensions: Int,a: Double, b:Double, c:Double): Double = {
      var sum1=(-a)*(Math.exp(-b*(Math.sqrt((1/dimensions)*TermAckely(xs)))))
      var sum2=(-1)*(Math.exp((1/dimensions)*Term1Ackely(xs,c)))
      if (xs.isEmpty) 0
      else 
  	  sum1+sum2
     }
    def Powell(xs: List[(Int,Double)]): Double = {
      if (xs.isEmpty) 0
      else Math.pow(((xs.head._2)+(10*(xs.tail.head._2))),2) + 5*(Math.pow(xs.tail.tail.head._2-xs.tail.tail.tail.head._2,2)) + Math.pow(xs.tail.head._2-2*xs.tail.tail.head._2,4)+ 10*(Math.pow(xs.head._2-xs.tail.tail.tail.head._2,4)) + Powell(xs.tail.tail.tail.tail)
  }
  def Zakharov(xs:List[(Int,Double)]): Double = {
     if(xs.isEmpty) 0 
     else TermZakharov(xs)+Math.pow(Term1Zakharov(xs),2)+Math.pow(Term1Zakharov(xs),4)
    }
  def DixonPrice(xs:List[(Int,Double)]): Double = {
     if(xs.isEmpty) 0 
     else Math.pow((xs.head._2)-1,2)+TermDixonPrice(xs)
    }
  def  Rastrigin(xs:List[(Int,Double)], dimensions:Int): Double = {
  if(xs.isEmpty) 0 
      else
        10*dimensions+TermRastrigin(xs)
  }
  def Griewank(xs:List[(Int,Double)]): Double = {
      if(xs.isEmpty) 0 
      else
        TermGriewank(xs)-Term2Griewank(xs)+1
    }
  def Trid(xs: List[(Int,Double)]): Double = {
      if (xs.isEmpty ) 0
      else 
     Math.pow((xs.head._2-1),2)- (if(xs.tail.isEmpty) 0 else { (xs.tail.head._2)*(xs.head._2)}) + 
     Trid(xs.tail)
  }
   def RosenBrock(xs:List[(Int,Double)]): Double = {
      if(xs.isEmpty || xs.tail.isEmpty) 0 
      else
        100*Math.pow(((xs.tail.head._2)-(Math.pow(xs.head._2,2))),2)+(Math.pow((xs.head._2)-1,2))+RosenBrock(xs.tail)
    }
  def Schwefel(xs:List[(Int,Double)],dimensions:Int): Double = {
      if(xs.isEmpty) 0 
      else
        418.9829*dimensions-TermSchwefel(xs)
    }
  def Levy(xs: List[(Int,Double)]): Double = {
      if (xs.isEmpty) 0
      else  Math.pow((Math.sin(Math.PI*(1+(xs.head._2-1)/4))), 2) + TermLevy(xs) + (Math.pow(((1+(xs.last._2-1)/4)-1),2) * (1+Math.pow((Math.sin(2*Math.PI*(1+(xs.last._2-1)/4))),2)))
      }
   def SumSquares(xs:List[(Int,Double)]): Double = {
      if(xs.isEmpty) 0 
      else
        (xs.head._1)*math.pow(xs.head._2,2)+SumSquares(xs.tail)
    }
  def SumOfDiffPowers(xs:List[(Int,Double)]): Double ={
      if(xs.isEmpty) 0
      else
        Math.pow(Math.abs(xs.head._2),xs.head._1+1)+SumOfDiffPowers(xs.tail)
    }
  def Sphere(xs:List[(Int,Double)]): Double ={
      if(xs.isEmpty) 0
      else
        Math.pow(xs.head._2,2)+Sphere(xs.tail)
    }
  def RotatedHyperEllipsoid(xs:List[(Int,Double)],dimension:Int): Double = {
      if(xs.isEmpty) 0 
      else
        dimension*math.pow(xs.head._2,2)+RotatedHyperEllipsoid(xs.tail,dimension-1)
    }
  def Perm(xs: List[(Int,Double)], i: Int, Dimensions: Int, Beta:Double): Double = {
  if(xs.isEmpty || i>Dimensions) 0
  else
  {
     TermPerm(xs,i, Beta) + Perm(xs,i+1, Dimensions, Beta)
  }
  }
  def PermZero(xs: List[(Int,Double)], i: Int, Dimensions: Int, Beta:Double): Double = {
  if(xs.isEmpty || i>Dimensions) 0
  else
  {
     TermPermZero(xs,i, Beta) + PermZero(xs,i+1, Dimensions, Beta)
  }
  }
}