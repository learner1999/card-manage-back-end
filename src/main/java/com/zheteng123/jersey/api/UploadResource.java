package com.zheteng123.jersey.api;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

/**
 * Created on 2016/12/23.
 */
@Path("upload")
public class UploadResource {

    private static final String[] IMG_TYPE = {"jpg", "png"};

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response uploadImg(@FormDataParam("file") InputStream fileInputStream,
                              @FormDataParam("file") FormDataContentDisposition disposition) {
        String fileName = disposition.getFileName();
        try {
            fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        boolean isImg = false;
        for (String imgType : IMG_TYPE) {
            String[] strs = fileName.split("\\.");
            if (strs[strs.length - 1].equals(imgType)) {
                isImg = true;
                break;
            }
        }

        if (!isImg) {
            return Response.status(Response.Status.BAD_REQUEST).entity("只允许上传图片！").build();
        }

        String webRoot = this.getClass().getResource("/").getPath().split("WEB-INF/classes/")[0];
        String imagePath = webRoot + "public/upload/img/";

        String imageName = Calendar.getInstance().getTimeInMillis()
                + fileName;

        File file = new File(imagePath + imageName);
        try {
            //使用common io的文件写入操作
            FileUtils.copyInputStreamToFile(fileInputStream, file);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return Response.ok().entity("/public/upload/img/" + imageName).build();
    }
}
