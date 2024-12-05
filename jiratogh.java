///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 21+
//DEPS io.github.dmlloyd.im:issue-migrator:1.0-SNAPSHOT

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import io.github.dmlloyd.im.*;

/**
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
public class jiratogh {

    public static void main(String[] argsArray) throws Exception {
        List<String> args = List.of(argsArray);
        Iterator<String> iterator = args.iterator();
        URI jiraUrl = null;
        URI input = null;
        URI gitHubUrl = null;
        boolean dryRun = false;
        while (iterator.hasNext()) {
            String arg = iterator.next();
            switch (arg) {
                case "--help" -> {
                    System.out.println("""
                        Supported arguments:
                           --help     this message
                           --jira-url the base URL of the JIRA service
                           --input    the input file name or remote URL
                           --dry-run  to not actually commit anything
                           --github   the URL of the target GitHub project
                        """);
                }
                case "--jira-url" -> jiraUrl = new URI(iterator.next());
                case "--input" -> input = new URI(iterator.next());
                case "--dry-run" -> dryRun = true;
                case "--github" -> gitHubUrl = new URI(iterator.next());
                default -> throw new IllegalArgumentException("Unexpected argument: " + arg);
            }
        }
        if (jiraUrl == null) {
            throw new IllegalArgumentException("No JIRA URL given");
        }
        if (input == null) {
            throw new IllegalArgumentException("No input file or URL given");
        }
        if (gitHubUrl == null) {
            throw new IllegalArgumentException("No GitHub URL given");
        }
        // todo: actually do it...
    }
}