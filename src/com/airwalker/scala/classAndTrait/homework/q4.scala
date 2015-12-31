package com.airwalker.scala.classAndTrait.homework

/**
 * Created by Zhang.Min on 2015/12/29.
 */
class Point(val x:Int, val y:Int){
  override def toString = s"(x,y):($x,$y)"
}

abstract class Shape {
  def centerPoint:Point
  def className = this.getClass.getSimpleName
  override def toString = s"Shape => $className,Center => $centerPoint"
}
class Rectangle(val leftTop:Point, val rightBottom:Point) extends Shape{
  override def centerPoint = new Point((leftTop.x + rightBottom.x)/2,(leftTop.y + rightBottom.y)/2)
}
class Circle(val centerPoint:Point, val radius:Int) extends Shape

object q4 extends App {
  val rect = new Rectangle(new Point(1,1),new Point(5,1))
  println(rect)

  val circle = new Circle(new Point(5,5), 6)
  println(circle)
}
