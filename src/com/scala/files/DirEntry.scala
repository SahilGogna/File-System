package com.scala.files

/**
 * @author sahilgogna on 2020-01-22
 */
abstract class DirEntry(val parentPath:String, val name:String) {

  def path: String = parentPath + Directory.SEPARATOR + name

  def  asDirectory: Directory

  def asFile:File

  def getType:String

}
