package com.zhuolang.starryserver.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUploadUtil {
    public static List<String> fileList = new ArrayList<>();
    /**
     * 上传单个文件例子，返回上传后的文件名，上传失败则返回null
     * @param file
     * @param request
     * @return
     */
    public static String uploadFile(MultipartFile file,HttpServletRequest request){
        String fileName = "";
        String filePath = "";
        try {
            if (file != null) {
                String picture = file.getOriginalFilename();
                System.out.println("原fileName========================" + picture);

                // filePath : 文件路径：项目路径 + /img  例：http://localhost:8081/starry/ + img/
                // fileName : UUID生成文件名+原文件的文件后缀  例：e69ce244-fc71-499a-b276-798930fd8c38 + .zip
                // 访问该文件的路径为 ：http://localhost:8081/starry/img/e69ce244-fc71-499a-b276-798930fd8c38.zip
                filePath = request.getSession().getServletContext().getRealPath("/") + "img/";
                fileName = UUID.randomUUID() + picture.substring(picture.lastIndexOf("."));

                File targetFile = new File(filePath, fileName); // 新建文件
                if (!targetFile.exists()) { // 判断文件的路径是否存在
                    targetFile.mkdirs(); // 如果文件不存在 在目录中创建文件夹 这里要注意mkdir()和mkdirs()的区别
                }
                // 保存
                file.transferTo(targetFile);

            }
        }catch (org.springframework.web.multipart.MaxUploadSizeExceededException e){
            e.printStackTrace();
            return null;
        }catch (Exception e) {//进行错误处理
            e.printStackTrace();
            return null;
        }
        return fileName;
    }

    /**
     * 上传多个文件例子，返回上传后的文件名列表，上传失败则返回null
     * 单个上传错误还没处理，待更新
     * @param file
     * @param request
     * @return
     */
    public static List<String> uploadFileList(MultipartFile file[],HttpServletRequest request){
        List<String> stringList = new ArrayList<>();
        try {
            if (file != null) {
                for (int i = 0; i < file.length; i++) {
                    String picture = file[i].getOriginalFilename();
                    System.out.println("原fileName========================" + picture);

                    // filePath : 文件路径：项目路径 + /img  例：http://localhost:8081/starry/ + img/
                    // fileName : UUID生成文件名+原文件的文件后缀  例：e69ce244-fc71-499a-b276-798930fd8c38 + .zip
                    // 访问该文件的路径为 ：http://localhost:8081/starry/img/e69ce244-fc71-499a-b276-798930fd8c38.zip
                    String filePath = request.getSession().getServletContext().getRealPath("/") + "img/";
                    String fileName = UUID.randomUUID() + picture.substring(picture.lastIndexOf("."));

                    File targetFile = new File(filePath, fileName); // 新建文件
                    if (!targetFile.exists()) { // 判断文件的路径是否存在
                        targetFile.mkdirs(); // 如果文件不存在 在目录中创建文件夹 这里要注意mkdir()和mkdirs()的区别
                    }
                    file[i].transferTo(targetFile);
                    // 将单个上传成功的文件添加到list中
                    stringList.add(fileName);
                }
            }
        }catch (Exception e) {//进行错误处理
            e.printStackTrace();
            return null;
        }
        return stringList;
    }

    /**
     * 获取文件列表
     * @param strPath
     * @return
     */
    public static List<String> getFileList(String strPath) {

        File fileDir = new File(strPath);
        if (null != fileDir && fileDir.isDirectory()) {
            File[] files = fileDir.listFiles();

            if (null != files) {
                for (int i = 0; i < files.length; i++) {
                    // 如果是文件夹 继续读取
                    if (files[i].isDirectory()) {
                        getFileList(files[i].getAbsolutePath());
                    } else {
                        String strFileName = files[i].getAbsolutePath();
                        if (null != strFileName && strFileName.endsWith(".log")) {
//                            System.out.println("web server log ---" + strFileName);
                            fileList.add(strFileName);
                        }
                    }
                }

            } else {
                if (null != fileDir) {
                    String strFileName = fileDir.getAbsolutePath();
                    if (null != strFileName && strFileName.endsWith(".log")) {
//                        System.out.println("web server log ---" + strFileName);
                        fileList.add(strFileName);
                    }
//                    // 排除jar cmd 和 xlsx （根据需求需要）
//                    if (null != strFileName && !strFileName.endsWith(".jar") && !strFileName.endsWith(".cmd")
//                            && !strFileName.endsWith(".xlsx")) {
//                        System.out.println("---" + strFileName);
//                        fileList.add(fileDir);
//                    }
                }
            }
        }
        // 定义的全去文件列表的变量
        return fileList;
    }

    /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param dir
     *            要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            System.out.println("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = deleteDirectory(files[i]
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            System.out.println("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            System.out.println("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }

}
