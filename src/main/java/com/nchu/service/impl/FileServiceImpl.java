package com.nchu.service.impl;

import com.nchu.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 文件相关业务
 */
public class FileServiceImpl implements FileService {
    /**
     * 单文件上传
     *
     * @param folder 要上传到的文件夹路径
     * @param file   要上传的文件
     * @return 返回文件上传后的url地址
     */
    @Override
    public String fileUpload(String folder, MultipartFile file) {
        return null;
    }

    /**
     * 多文件上传
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
     * 通过url删除指定文件
     *
     * @param url 要删除文件的url地址
     * @return 返回操作结果
     */
    @Override
    public String fileDeleteByUrl(String url) {
        return null;
    }

    /**
     * 通过文件id进行文件删除
     *
     * @param fileId 要删除的文件id
     * @return 返回操作结果
     */
    @Override
    public boolean fileDeleteById(Long fileId) {
        return false;
    }

    /**
     * 多文件删除
     *
     * @param fileIdList 要删除的文件的文件id列表
     * @return 返回删除成功的文件数
     */
    @Override
    public int fileMultiDelete(List<Long> fileIdList) {
        return 0;
    }
}
