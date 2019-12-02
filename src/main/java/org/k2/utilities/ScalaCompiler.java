package org.k2.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class ScalaCompiler {

    public static String runCompiler(String filename) {

        //Per testare il jar lanciare scala nomejar.jar, se da nullpointerexception scala -cp /usr/share/scala/lib/scala-library.jar:nomejar.jar nomejar

        List<String> params = Arrays.asList("/bin/sh", "-c", "scalac /opt/tomcat/uploads/"+filename+"/sourcecode.scala -d /opt/tomcat/uploads/"+filename+"/compiledcode.jar");
        ProcessBuilder pb = new ProcessBuilder(params);
        Process p;
        String result = "";
        try {
            p = pb.start();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringJoiner sj = new StringJoiner(System.getProperty("line.separator"));
            reader.lines().iterator().forEachRemaining(sj::add);
            result = sj.toString();

            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
