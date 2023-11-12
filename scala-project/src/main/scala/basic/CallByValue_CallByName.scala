package basic

object CallByValue_CallByName extends App {
  def callByValue(x: Int): Unit = {
    println(x)
    println(x)
  }

  def callByName(x: => Long): Unit = {
    println(x)
    println(x)
  }

  callByValue(123456789)
  callByName(System.nanoTime())
}
