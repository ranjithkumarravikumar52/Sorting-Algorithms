# Sorting-Algorithms 
#### Maven Notes
* Group ID and Artifact ID uniquely identifies a project among all the projects
* Follows the same java packaging rules
***
* Clean deletes the target folder
* Compile creates the target folder
***
* Transitive Dependencies
***
#### Issues
* Invalid value in the import maven settings that leads to "unable to import" error. 
    * Resolve it by making sure that the import settings is set to JAVA_HOME rather than from JRE or anything else.
    * And also default VM option should not miss any characters. [link](https://www.jetbrains.com/help/idea/maven-importing.html)
