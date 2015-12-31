package com.airwalker.scala.classAndTrait

/**
 * Created by Zhang.Min on 2015/12/28.
 */


abstract class Language
case class Chinese(name : String) extends Language //注意 不带参的构造函数已经废弃;参数name是val，所以这里不需要加val
case class English(name : String) extends Language



object CaseClassExample extends App {
  def m(p : Language) {
    p match {
        //case Chinese => println("This is a chinese") 会报错为什么？这里传进来的是什么类还是实例
      case Chinese(_) => println("This is a chinese") //(_)表示不关心name是什么，但如果是Chinese("SiChuan")不会被匹配到
      case English(_) => println("This is an english")
      case _ => println("This is unknown")
    }
  }
  m(Chinese("A"))



  println(">>>>>>>>>>>>>>>>>>>>>>>>PART2>>>>>>>>>>>>>>>>>>>>>")

  val m = Map(1 -> 2)
  m.get(1) match {
    case Some(v) => println(v)
    case None => println("No such key")
  }
}