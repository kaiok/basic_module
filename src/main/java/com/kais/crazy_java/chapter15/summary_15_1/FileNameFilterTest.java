package com.kais.crazy_java.chapter15.summary_15_1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kais
 * @date 2022.08.23. 13:42
 */
public class FileNameFilterTest {

    public static void main(String[] args) {
        File file = new File("/Users/kais/projects/DF_project/myfork/smalock-pro-backend/src/main/java/com/df/smalock/entity");
        System.out.println("当前文件夹绝对路径：" + file.getAbsolutePath());
        //FilenameFilter 是一个接口，需要重写他的方法
        FilenameFilter filenameFilter = new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                //重写accept(File dir,String name)方法
                //两个条件：判断是否为文件；判断是否为.java结尾
                return new File(dir,name).isFile() && name.endsWith(".java");
            }
        };
        //判断Test.java文件是否为文件，是否为.java结尾
//        boolean accept = filenameFilter.accept(file,"Test.java");
        //调用File类对象的listFile()方法【此方法作用是获取File类对象的子文件或者文件夹的所有子目录类对象】
        //方法参数位置是文件过滤器接口,返回参数是符合标准的File类对象
        File[] files = file.listFiles(filenameFilter);

        // 根据文件的修改时间对文件进行排序：递增
        Arrays.sort(files,new Comparator<File>(){
            @Override
            public int compare(File o1, File o2) {
                long diff = o1.lastModified() - o2.lastModified();
                if(diff > 0){
                    return 1;
                }else if(diff == 0){
                    return 0;
                }else {
                    return -1;
                }
            }
        });

        //遍历File类对象下的所有文件与文件夹
        for(File file2:files){
            //遍历数组
            System.out.println("文件：" + file2 + "修改时间为：" + file2.lastModified() + file2.isDirectory());
        }
        // 查询file目录下满足过滤条件的所有文件名
        String[] list = file.list();
        for (String fileName :
                list) {
            System.out.println("文件名为：" + fileName);
        }

        //使用lambda表达式形式
/*        File[] listFiles1 = file.listFiles(
                (dir, name) -> new File(dir,name).isFile() && name.endsWith(".java")
        );
        for(File file3:listFiles1 ){
            //遍历数组
            System.out.println(file3);
        }*/
    }

}
