package basic.function.higherOrder

object HigherOrderFunction extends App {
  val add:(Int, Int) => Int =  _ + _
  val fibonacci:(Int, Int, Int, (Int, Int) => Int) => Int = (x, y, n, f) => {
    if (n == 0) y else fibonacci(y, f(x,y), n-1, f)
  }
  println(fibonacci(0, 1, 5, add))


  //curry function
  val adder = (x: Int) => (y: Int) => {
    x + y
  }
  val add2 = adder(2)
  println(add2(3))
}
