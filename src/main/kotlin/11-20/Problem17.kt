package `11-20`

import kotlin.math.max

/*
Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1.
subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system.
For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system.
If there is no file in the system, return 0.

Note:

The name of a file contains at least a period and an extension.

The name of a directory or sub-directory will not contain a period.
 */

class FileSystemNode{
    var fileOrDirName:String
    var arrayOfFilesAndDirs:ArrayList<FileSystemNode>

    constructor(fileOrDirName:String, arrayOfFilesAndDirs:ArrayList<FileSystemNode>){
        this.fileOrDirName = fileOrDirName
        this.arrayOfFilesAndDirs = arrayOfFilesAndDirs
    }
}


fun getTreeFromString(currentFilePath:String): FileSystemNode
{
//    println("Current Path: "+currentFilePath)

    val arr = currentFilePath.split("\n\t")//,ignoreCase = true)

    val newArr = arrayListOf<String>()
    var str = ""


    arr.forEach { filePath ->
//        if(str == "\n")
//            str = ""

        if (filePath.startsWith("\t")) {
            str += "\n" + filePath
        }
        else {
//            if(!prevElemEmpty)
                newArr.add(str)
            str = filePath
        }

    }
    newArr.add(str)
    if(newArr[1]=="\n")
        newArr.removeAt(1)

    // At index 1, current fileName
    // At remaining indexes, child filePaths

    val arrayOfFileNodes = arrayListOf<FileSystemNode>()
    newArr
        .filterIndexed { index, s -> index > 1 }
        .forEach { filePath ->
            arrayOfFileNodes.add(getTreeFromString(filePath))
        }
    return FileSystemNode(newArr[1], arrayOfFileNodes)
}

fun getMaximumLengthOfPath(node: FileSystemNode):Pair<Int, Boolean>
{
    var isFileInPath = false
    if(node.fileOrDirName.contains("."))
        isFileInPath = true

    var maxLength = node.fileOrDirName.length
    var childMaxLength = 0
    val childrenNodes = node.arrayOfFilesAndDirs

    if(isFileInPath){
        if(!childrenNodes.isEmpty())
            error("Can't extend after file!!!")
    }

    if(!childrenNodes.isEmpty()){
        maxLength++
        childrenNodes.forEach { currentNode ->
            val currentNodeLengthAndFileStatus = getMaximumLengthOfPath(currentNode)
            isFileInPath = isFileInPath or currentNodeLengthAndFileStatus.second

            if(isFileInPath)
                childMaxLength = max(childMaxLength, currentNodeLengthAndFileStatus.first)
        }
        if(isFileInPath)
            maxLength += childMaxLength
        else maxLength = 0
    }
    return Pair(maxLength, isFileInPath)
}

fun getMaxLengthFromGivenStringTree(currentFilePath:String):Int
{
    val node = getTreeFromString(currentFilePath)
    return getMaximumLengthOfPath(node).first
<<<<<<< HEAD
}
=======
}
>>>>>>> 02b5edcd88dc9c2165269e03cdde353498bf8fd6
