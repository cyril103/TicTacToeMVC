package model

trait Subscriber:
  def handler(publisher: Publisher): Unit

