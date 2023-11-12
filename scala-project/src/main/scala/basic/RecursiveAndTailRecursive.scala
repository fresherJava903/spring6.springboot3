package basic

import scala.jdk.Accumulator

object RecursiveAndTailRecursive extends App {
  println("hello Scala")

//  //var is not recommended in scala
//  var x = 5
//  var result = 1
//  while (x > 0) {
//    result = result * x
//    x = x - 1
//  }
//  println(result)

  def recursiveTask(n: Int): BigInt = {
    if (n == 1) n else n * recursiveTask(n - 1)
  }

  def tailRecursiveTask(n: Int): BigInt = {
    //using nested class
    def helper(n: Int, accumulator: BigInt): BigInt = {
      if (n == 1) accumulator else helper(n-1, accumulator * n)
    }
    helper(n, 1)
  }

  def fibonacci(n1: Int, n2: Int): String = {
    if (n1 < 100) s"$n1, ${fibonacci(n2, n1 + n2)}" else "END"
  }
  
  println(recursiveTask(50))
  println(tailRecursiveTask(50))
  println(fibonacci(0,1))
}


