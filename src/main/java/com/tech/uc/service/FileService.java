package com.tech.uc.service;

import com.tech.uc.entity.File;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
public interface FileService extends IService<File> {
    /**
     * 保存文件记录和FTP
     * @param file
     * @param bytes
     * @return
     */
    File insertFile(File file, byte[] bytes);


    /**
     * 批量查询文件列表
     * @param ids
     * @return
     */
    List<File> getFileList(List<String> ids);
}
