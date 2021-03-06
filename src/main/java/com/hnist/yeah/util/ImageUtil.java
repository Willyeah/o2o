package com.hnist.yeah.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 图片处理工具类
 */
public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private  static Logger logger= LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将CommonsMultipartFile转换成File类
     * @param cFile
     * @return
     */
    public  static  File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){
        File newFile= new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return  newFile;
    }

    /**
     * 处理缩略图，并返回新生成图片的相对值路径
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(File thumbnail, String targetAddr) {
        String realFileName = getRandomFileName();
        String exetension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = realFileName + exetension + targetAddr;
        logger.debug("current relativeAddr is:"+relativeAddr);
        //相对路径加上根路径组成
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current relativeAddr is:"+PathUtil.getImgBasePath()+relativeAddr);
        try {
            Thumbnails.of(thumbnail).size(500, 500)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.2f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回相对地址而不是绝对地址当程序能在别电脑上也能跑起来
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录，即home/images/yzb/xxx.jpg
     * 那么 home work yzb 这三个文件夹都得自动创建出来
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (dirPath.exists()) {
            dirPath.mkdirs();
        }

    }

    /**
     * 获取输入文件流的扩展名
     *
     * @param cFile
     * @return
     */
    private static String getFileExtension(File cFile) {
        String originalFileName = cFile.getName();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒+五位随机数
     *
     * @return
     */
    private static String getRandomFileName() {
        //获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());

        return nowTimeStr + rannum;
    }

    public static void main(String[] args) throws IOException {
        basePath = URLDecoder.decode(basePath, "utf-8");
        Thumbnails.of(new File("C:/Users/Administrator/Pictures/杀生丸殿下.jpg")).
                size(500, 500).
                watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.2f).
                outputQuality(0.8f).
                toFile("C:/Users/Administrator/Pictures/杀生丸殿下new2.jpg");
    }
}
