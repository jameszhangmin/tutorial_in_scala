package com.airwalker.scala.classAndTrait

/**
 * Created by Zhang.Min on 2015/12/28.
 */
object MatchExample extends App {
  //一般用法
  val value = 1
  val result = value match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other numer"
  }
  println("result of match is " + result)

  //另一个比较普遍的用法，加上逻辑判断
  val result2 = value match {
    case i if i == 1 => "one"
    case i if i == 2 => "two"
    case _ => "some other numer"
  }
  println("result2 of match is " + result2)

  def t(obj : Any) = obj match {
    case x : Int => println("Int")
    case s : String => println("String")
    case _ => println("unknown type")
  }
  t(1)
  t("me")
  t(1L)
}
