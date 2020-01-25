package com.scala.files

import com.scala.filesystem.FileSystemException

/**
 * @author sahilgogna on 2020-01-25
 */
class File(override val parentPath: String, override val name: String, contents:String)
  extends DirEntry(parentPath, name){
  override def asDirectory: Directory = throw new FileSystemException("File cannot be converted to a directory")

  override def getType: String = "File"

  override def asFile: File = this
}

object File{

  def empty(parentPath:String, name:String):File =
    new File(parentPath,name,"Entry")
}