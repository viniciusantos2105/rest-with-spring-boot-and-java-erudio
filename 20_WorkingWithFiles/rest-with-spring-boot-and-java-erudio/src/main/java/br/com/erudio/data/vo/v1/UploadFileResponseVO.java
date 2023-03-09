package br.com.erudio.data.vo.v1;

import lombok.Data;

import java.io.Serializable;

@Data
public class UploadFileResponseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
