package com.nchu.service.impl;

import com.nchu.service.FileService;
import com.nchu.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 文件相关业务的本地存储实现
 */
@Service
public class LocalFileServiceImpl implements FileService {
    /*创建可缓存线程池,由于文件存储执行速度慢,为了不影响系统响应速度,需要用在后台线程执行*/
    static ExecutorService pool = Executors.newCachedThreadPool();

    /**
     * TODO 单文件上传
     *
     * @param serverPath 文件服务器路径,此处为本地目路径
     * @param file       要上传的文件
     * @return 返回文件上传后的文件信息
     */
    @Override
    public String fileUpload(String serverPath, MultipartFile file) throws IOException {
        String fileName = getRandomName(file.getOriginalFilename());
        /*创建目录*/
        File uploadDir = new File(serverPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        file.transferTo(new File(serverPath + "\\" + fileName));
        return fileName;
    }

    /**
     * TODO 多文件上传
     *
     * @param folder 要上传到的文件夹路径
     * @param files  要上传的文件列表
     * @return 返回所有上传文件的url地址
     */
    @Override
    public List<String> fileMultiUpload(String folder, List<MultipartFile> files) {
        return null;
    }

    /**
     * TODO 通过url删除指定文件
     *
     * @param url 要删除文件的url地址
     * @return 返回操作结果
     */
    @Override
    public boolean fileDeleteByUrl(String url) {
        return false;
    }

    /**
     * TODO 多文件删除
     *
     * @param fileIdList 要删除的文件的文件url列表
     * @return 返回删除成功的文件数
     */
    @Override
    public int fileMultiDelete(List<Long> fileIdList) {
        return 0;
    }

    /**
     * 获取随机文件名
     *
     * @param originalFilename 原始文件名
     * @return 返回文件的后缀名
     */
    private String getRandomName(String originalFilename) {
        StringBuilder stringBuilder = new StringBuilder();
        /*将系统时间毫秒加上随机UUID值生成唯一的随机文件名*/
        stringBuilder.append(System.currentTimeMillis() + UUIDUtils.getUUID());
         /*获取文件名最后一个"."字符所在的下标直到字符串结尾即是文件后缀名*/
        stringBuilder.append(originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length()));
        return stringBuilder.toString();
    }

    /**
     * 文件存储执行任务
     *
     * @deprecated
     */
    class SaveFileRunnable implements Runnable {
        Map<String, MultipartFile> files;

        public SaveFileRunnable(Map<String, MultipartFile> files) {
            this.files = files;
        }

        @Override
        public void run() {
            for (Map.Entry<String, MultipartFile> entry : files.entrySet()) {
                try {
                    entry.getValue().transferTo(new File(entry.getKey()));
                } catch (IOException e) {
                    System.out.println(entry.getKey() + ":写入失败");
                    e.printStackTrace();
                    continue;
                }
            }
        }
    }

}
