MapReduce Archetype
============================

Quickly setup a MapReduce Maven artifact that includes: 

 - Mapper and Reducer classes
 - ...and the corresponding unit test classes based on MRUnit 
 - job configuration
 - dependency setup using Cloudera's Hadoop dist
 - a sample run script
 

Install
----------------------------

You install the archetype on your own box by cloning the repo and running 
the Maven installer. Like this: 

    git clone git://github.com/robinsp/mapreduce-archetype.git 
    cd mapreduce-archetype
    mvn install
    
    
Usage 
-----------------------------

Once installed on your own box you quickly create your own MapReduce artifact
like this:

    mvn archetype:generate -DarchetypeCatalog=local

this starts an interactive session where you enter: 

 - the number of the mapreduce-archetype
 - group id, artifact id and version
 - a java package
 - the name of your main class
 
Run `mvn package` to build a jar, and take a look at run.sh.sample for how to execute your job. 


Example run
-------------------------------------------------------
 The example below creates a project directory in `~/src/mapreduce` and 
 create source files (with tests) named: 
 
  - com.robinspainhour.example.Sample
  - com.robinspainhour.example.SampleMapper
  - com.robinspainhour.example.SampleReducer

Sample run: 

    mybox:~$ cd ~/src
    mybox:~$ mvn archetype:generate -DarchetypeCatalog=local
    [INFO] Scanning for projects...	
    [INFO] Searching repository for plugin with prefix: 'archetype'.
    [INFO] ------------------------------------------------------------------------
    [INFO] Building Maven Default Project
    [INFO]    task-segment: [archetype:generate] (aggregator-style)
    [INFO] ------------------------------------------------------------------------
    <snip>
    Choose archetype:
    1: local -> mapreduce-archetype (mapreduce-archetype)
    Choose a number: : 1
    Define value for property 'groupId': : com.robinspainhour.example
    Define value for property 'artifactId': : mapreduce
    Define value for property 'version': 1.0-SNAPSHOT: 
    Define value for property 'package': com.robinspainhour.example: 
    Define value for property 'main-class-name': : Sample
    Confirm properties configuration:
    groupId: com.robinspainhour.example
    artifactId: mapreduce
    version: 1.0-SNAPSHOT
    package: com.robinspainhour.example
    main-class-name: Sample
    Y: 
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESSFUL
    [INFO] ------------------------------------------------------------------------
    mybox:~$ 
