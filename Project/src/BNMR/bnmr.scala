package BNMR
object bnmr {
  def getData():(Int, Int, Int, Int)={
    println("Enter the Number of Random values to be generated:\n")
    val N = scala.io.StdIn.readInt()
    println("Enter the Number of Dimensions:\n")
    val Dimensions= scala.io.StdIn.readInt()
    println("Enter the minimum and maximum value of range:\n")
    val minVal = scala.io.StdIn.readInt()
    val maxVal = scala.io.StdIn.readInt()
    val Data:(Int, Int, Int, Int)=(N, Dimensions, minVal, maxVal)
    Data
    }
   def populationInitialization(N:Int, Dimensions: Int, minVal:Double, maxVal:Double): List[(Int,Double)]={
     var Population = List[(Int,Double)]()
  val r = scala.util.Random
for(i <- 1 to N)
    {
      for(Dimensions <- 1 to N)
      {
var R: Double= (0 + r.nextInt( (100 - 0) + 1 ))/100.0
  Population=Population:::List((Dimensions,minVal + R*( (maxVal - minVal) + 1 )))
    }
    }
  Population.foreach(x => println(x._1+" "+x._2))
  Population
   }
  def FitnessCalculation(Population: List[(Int,Double)], Dimensions: Int): List[Double]={
    println("press: \n1 for Ackley\n2 for Griewank\n3 for Levy\n4 for Rastrigin\n5 for Schwefel\n6 for Perm 0,d,b\n7 for Rotated Hyper Ellipsoid\n8 for Sphere\n9 for Sum of Different Powers\n s/S for Sum Squares\nt/T for Trid\nz/Z for Zakharov\nd/D for Dixon Price\nr/R for Rosenbrock\nm/M for Michalewicz\nb/B for Perm d,b\np/P for Powell\ny/Y for Styblinski")
    val input = scala.io.StdIn.readChar()
    input match {
      case 'm'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Michalewicz(_,10.0)).toList
      case 'y'=> {Population.grouped(Dimensions).map(BNMR.optFunctions.StyblinskiTang(_)).toList}
      //values a,b,c need change
      case '1'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Ackely(_,Dimensions,20,2,10)).toList
       //values Beta need change
      case 'b'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Perm(_,1,Dimensions,10.0)).toList
      case 'p'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Powell(_)).toList
      case 'z'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Zakharov(_)).toList
      case 'd'=> Population.grouped(Dimensions).map(BNMR.optFunctions.DixonPrice(_)).toList
      case '4'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Rastrigin(_,Dimensions)).toList
      case '2'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Griewank(_)).toList
      case 't'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Trid(_)).toList
      case 'r'=> Population.grouped(Dimensions).map(BNMR.optFunctions.RosenBrock(_)).toList
      case '5'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Schwefel(_,Dimensions)).toList
      case '3'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Levy(_)).toList
      case '7'=> Population.grouped(Dimensions).map(BNMR.optFunctions.RotatedHyperEllipsoid(_,Dimensions)).toList
      case '8'=> Population.grouped(Dimensions).map(BNMR.optFunctions.Sphere(_)).toList
      case '9'=> Population.grouped(Dimensions).map(BNMR.optFunctions.SumOfDiffPowers(_)).toList
      case 's'=> Population.grouped(Dimensions).map(BNMR.optFunctions.SumSquares(_)).toList
      //values Beta need change
      case '6'=> Population.grouped(Dimensions).map(BNMR.optFunctions.PermZero(_,1,Dimensions,10.0)).toList
      //case _=> println("invalid selection")
    }
  }
  def probabilityCalculation( xs: List[Double], s:Double): List[Double]={
      var R=2
     xs.map(x => x * R / s)
     }
}