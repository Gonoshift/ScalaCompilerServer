package org.k2.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ScalaShellCompiler implements ICompiler{
    
    public String runCompiler(String filename) {

        //Per testare il jar lanciare scala nomejar.jar, se da nullpointerexception scala -cp /usr/share/scala/lib/scala-library.jar:nomejar.jar nomejar

        List<String> params = Arrays.asList("/bin/sh", "-c", "scalac /opt/tomcat/uploads/"+filename+"/sourcecode.scala -d /opt/tomcat/uploads/"+filename+"/sourcecode.jar");
        ProcessBuilder pb = new ProcessBuilder(params);
        pb.redirectErrorStream(true);
        Process p;

        String result = "";
        try {
            p = pb.start();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                sb.append(line+"\n");
            }
            result = sb.toString();

            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
