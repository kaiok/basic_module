package com.kais.crazy_java.chapter15.summary_15_1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kais
 * @date 2022.08.27. 15:50
 */
public class FileNameFilter2 {

    public static void main(String[] args) {

        File file = new File("/Users/kais/projects/AppleProject/basic_module/src/main/java/com/kais/crazy_java");
        List<File> resultFile = new ArrayList<>();
        getAllFilePath(file,resultFile);

        for (File files : resultFile) {
            System.out.println(files);
        }

    }

    /**
     * @Description:递归遍历目标目录下的所有文件
     * @Author: Kais
     * @Date: 2022/8/27 16:08
     * @return: java.util.List<java.io.File>
     **/
    public static List<File> getAllFilePath(File targetFile, List<File> resultFile){

        File[] files = targetFile.listFiles();
        if(files != null){
            // 遍历该File数据
            for (File file : files) {
                // 当该文件为目录时递归调用该方法
                if(file.isDirectory()){
                    getAllFilePath(file,resultFile);
                }else {
                    resultFile.add(file);
                }
            }
        }
        return resultFile;
    }

}
