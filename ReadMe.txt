Compile the code :

javac -classpath ./classes -sourcepath ./src -d ./classes ./src/fr/insarouen/asi/prog/asiaventure/elements/objets/PiedDeBicheTest.java 

java -cp classes fr.insarouen.asi.prog.asiaventure.Main

----------------------------------------------------------------------------------------------------------

Compile the tests :

javac -classpath /usr/share/java/junit4.jar:/usr/share/java/hamcrest-core-1.1.jar:/usr/share/java/hamcrest-library-1.1.jar:./classes:./classestest -sourcepath ./srctest:./src -d ./classestest ./srctest/fr/insarouen/asi/prog/asiaventure/elements/objets/PiedDeBicheTest.java 

----------------------------------------------------------------------------------------------------------

Execute the tests (example) :

java -cp classes:classestest:/usr/share/java/junit4.jar org.junit.runner.JUnitCore fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBicheTest

----------------------------------------------------------------------------------------------------------

Generate the documentation :

javadoc -encoding utf8 -docencoding utf8 -charset utf8 -sourcepath ./src $(find ./ -name *.java) -d doc/

