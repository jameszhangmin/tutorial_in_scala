package com.airwalker.scala.classAndTrait.homework

/**
 * Created by Zhang.Min on 2015/12/29.
 */
class BankAccount {
  private[this] var amount : Long = 0

  def deposit(money : Long) {
    amount += money
    println(s"There is ￥$amount in your account")
  }

  def withdraw(money: Long) {
    assert(amount >= money,"the money you withdraw should be less than your account")
    amount -= money
    println(s"There is ￥$amount in your account")
  }

  def balance = amount
}
