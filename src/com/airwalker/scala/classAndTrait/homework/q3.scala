package com.airwalker.scala.classAndTrait.homework

/**
 * Created by Zhang.Min on 2015/12/29.
 */
class Point1(val x : Int, val y : Int) {
  override def toString = (s"This point's coordinate is x: $x , y: $y")
}

object Point1 {
  def apply(x : Int, y : Int) = new Point1(x,y)
}
