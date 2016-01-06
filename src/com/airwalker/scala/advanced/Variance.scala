package com.airwalker.scala.advanced

/**
 * Created by Zhang.Min on 2016/1/4.
 */
object Variance extends App{
  val f = new Fruit("F")
  val a = new Apple("A")

  //想想看下面两个X有啥关系
  val x1 = new X(f)
  val x2 = new X(a)
  //答案是没有关系，在scala中泛型默认是不变的，严谨的
  //原因很好理解：Any是String的父类，List[Any]是List[String]的父类吗

  //如果如下定义
  //class X[+T](val x : T){}
  //Fruit是Apple的超类 X(f)是X(a)的超类   方向与参数一致
  //class X[-T](val x : T){}
  //Fruit是Apple的超类 X(f)是X(a)的子类   方向与参数相反

}

class Fruit(val name : String)
class Apple(name : String) extends Fruit(name)


class X[T](val x : T){}


