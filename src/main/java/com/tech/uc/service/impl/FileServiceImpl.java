package com.tech.uc.service.impl;

import com.tech.uc.entity.File;
import com.tech.uc.mapper.FileMapper;
import com.tech.uc.service.FileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhuyz
 * @since 2020-04-05
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

//    @Autowired
//    private FtpUtil ftpUtil;

    @Autowired
    private FileMapper fileMapper;

    @Transactional
    @Override
    public File insertFile(File file, byte[] bytes) {
//        file = super.insert(file);
//        ftpUtil.upload(file.getFilePath(), file.getId() + "." + file.getFileSuffix(), bytes);
        return file;
    }

    @Override
    public List<File> getFileList(List<String> ids) {
        return fileMapper.getFileList(ids);
    }
}
