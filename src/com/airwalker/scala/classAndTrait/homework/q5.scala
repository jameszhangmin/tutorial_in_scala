package com.airwalker.scala.classAndTrait.homework

import java.awt

/**
 * Created by Zhang.Min on 2015/12/29.
 */
class OrderedPoint(x:Int, y:Int) extends java.awt.Point(x, y) with scala.math.Ordered[java.awt.Point]{
  def compare(that: awt.Point): Int = {
    if (this.x <= that.x) {
      if (this.x == that.x) {
        if (this.y < that.y) 1
        else 0
      } else -1
    } else 1
  }
}
