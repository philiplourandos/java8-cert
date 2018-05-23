= Important classes = 

java.io.file.Path - Interface for the location of a resource on the file system. It's not an actual file or directory object per say
java.io.file.Paths - Static helper class to get a java.io.file.Path
java.io.file.Files - Static class to operate on Path 

= Paths.get =

Using the java.net.URI requires an absolute path. Relative paths will not work when using file://
