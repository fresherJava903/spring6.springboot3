package basic.function.lambda

object ScalaLambda extends App {
  //anonymous function
  val doubler = new ((Int) => Int) {
    override def apply(v1: Int): Int = v1 * 2
  }
  
//  val doubler = new Function(Int, Int) {
//    override def apply(v1: Int): Int = v1 * 2
//  }

  //lambda expression
  val adder1:(Int, Int) => Int = (x:Int, y:Int) => x + y
  val adder2:(Int, Int) => Int = (x, y) => x + y
  val adder3 = (x:Int, y:Int) => x+ y
}
