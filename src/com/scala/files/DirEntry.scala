package com.scala.files

/**
 * @author sahilgogna on 2020-01-22
 */
abstract class DirEntry(val parentPath:String, val name:String) {

  def path: String = {
    val sepratorIfNecessary =
      if(Directory.ROOT_PATH.equals(parentPath)) ""
      else Directory.SEPARATOR
    parentPath + sepratorIfNecessary + name
  }

  def  asDirectory: Directory

  def asFile:File

  def getType:String

  def isDirectory:Boolean

  def isFile:Boolean

}
