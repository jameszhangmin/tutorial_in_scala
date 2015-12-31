package com.airwalker.scala.classAndTrait.homework

/**
 * Created by Zhang.Min on 2015/12/29.
 */

class Person(name : String) {
  val _name = name.split("\\s+")  //可能多个空格，这里用\\s+
  val firstName = _name(0)
  val lastName = _name(1)
}
