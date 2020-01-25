package com.scala.command
import com.scala.files.{DirEntry, Directory}
import com.scala.filesystem.State

/**
 * @author sahilgogna on 2020-01-24
 */
class Mkdir(name:String) extends Command {

  def checkIllegal(name: String): Boolean = name.contains(".")

  override def apply(state: State): State = {
    val wd = state.wd
    if(wd.hasEntry(name))
      state.setMessage("Entry "+ name + "already exists!")
    else if(name.contains(Directory.SEPARATOR))
      state.setMessage(name + " must not contain a separator!")
    else if(checkIllegal(name))
      state.setMessage(name+": Illegal entry name!")
    else
      doMkdir(state, name)
  }

  def doMkdir(state: State, name: String): State = {

    def updateStructure(currentDirectory: Directory, path:List[String], newEntry:DirEntry): Directory = {
      /*
      1. Simple case

      someDir
        /a
        /b
        (new) /d

        => new someDir
        /a (reused reference)
        /b (reused reference)
        /d new reference created

        2. nested structure
        /a/b
          /c
          /d
          new /e

          => /(new)a/ (new) b
               /c (reused reference)
               /d (reused reference)
               /e new reference created
       */
      if(path.isEmpty) currentDirectory.addEntry(newEntry)
      else{
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry ,path.tail,newEntry))
      }
    }

    val wd = state.wd
    val fullpath = wd.path

    // 1. get all the directories in the full path
    val allDirsInPath : List[String] = wd.getAllFoldersInPath

    // 2. create new entry directory in the wd
    val newDir = Directory.empty(wd.path,name )

    // 3. update the whole directory structure starting from the root
    // (the directory structure is immutable)
    val newRoot = updateStructure(state.root, allDirsInPath, newDir)

    // 4. find new wd INSTANCE given wd's full path ,in the new directory structure
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)

  }

}
