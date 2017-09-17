
REM https://stackoverflow.com/questions/21071904/when-adding-a-textlog-to-echo-in-command-line-input-wont-show-up
set JavaResults=java.windows.txt
set java_results=^> _^&^& type _^&^&type _^>^>%JavaResults%
set JniResults=jni.windows.txt
set jni_results=^> _^&^& type _^&^&type _^>^>%JavaResults%




java -jar target/JavaTheCostOfDoingNothing-1.0-SNAPSHOT.jar  com.yahoo.jmh.jmhtest.JavaTest -bm avgt -tu ns %java_results%
java -Djava.library.path=x64\Release -jar target/JavaTheCostOfDoingNothing-1.0-SNAPSHOT.jar  com.yahoo.jmh.jmhtest.JNITest -tu ns -bm avgt %jni_results%
