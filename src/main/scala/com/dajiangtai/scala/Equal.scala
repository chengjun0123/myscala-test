package com.dajiangtai.scala

/**
  * Created by chengjun on 2020/10/11.
  */
trait Equal {
  def isEqual(x: Any): Boolean
  def isNotEqual(x: Any): Boolean = !isEqual(x)

}
