IF %USERNAME% == Justus ( 
    E:\\Eclipse\Java\eclipse.exe -vm java.exe -application org.eclipse.jdt.core.JavaCodeFormatter -verbose -config E:\\Programmieren\org.eclipse.jdt.core.prefs *.java
) ELSE (
    \..\..\..\Eclipse\eclipse.exe -vm java.exe -application org.eclipse.jdt.core.JavaCodeFormatter -verbose -config ..\..\org.eclipse.jdt.core.prefs *.java
)