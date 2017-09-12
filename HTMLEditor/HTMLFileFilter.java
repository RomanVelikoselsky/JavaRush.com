<<<<<<< HEAD
package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by v.roman on 08.08.2017.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String temp = f.getName().toLowerCase();
        return temp.endsWith(".html") || temp.endsWith(".htm") || f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
=======
package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by v.roman on 08.08.2017.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String temp = f.getName().toLowerCase();
        return temp.endsWith(".html") || temp.endsWith(".htm") || f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
>>>>>>> 150b183e56bce5788ac88e08113791e83b497b73
