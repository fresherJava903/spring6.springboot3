//package OOP.demo
//
//abstract class MyList {
//  def head: Int
//  def tail: MyList
//  def isEmpty: Boolean
//  def ++(list: MyList): MyList
//  def printElements: String
//  override def toString = s"${printElements}"
//}
//
//object Empty extends MyList {
//  def head: Int = throw new NoSuchElementException()
//  def tail: MyList = throw new NoSuchElementException()
//  def isEmpty: Boolean = true
//  def ++(list: MyList): MyList = list
//  def printElements:String = ""
//}
//
//class Node(val h: Int, val t:MyList) extends MyList {
//  def head: Int = h
//  def tail: MyList = t
//  def isEmpty: Boolean = false
//  def ++(list: MyList): MyList = new Node(h, tail ++ list)
//  def printElements: String = if (tail.isEmpty) s"$h" else s"$h, ${tail.printElements}"
//}
//
//object Test extends App {
//  val numbers = new Node(1, new Node(2, new Node(3, Empty)))
//  println(numbers)
//  println(numbers ++ new Node(4, Empty))
//}