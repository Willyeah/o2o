package com.hnist.yeah.util;

public class PathUtil {
    private static String seperator= System.getProperty("file.seperator");
    //返回项目图片的根路径
    public static String getImgBasePath(){
        String os= System.getProperty("os.name");
        String basePath="";
        if (os.toLowerCase().startsWith("win")){
            basePath="D:/projectdev/image";
        }else{
            basePath="/home/yzb/image";
        }
        basePath=basePath.replace("/",seperator);
        return basePath;
    }
    //返回项目的子路径
    public static String getShopImgPath(long shopId){
        String imagePath="/upload/item/shop/"+shopId+"/";
        return imagePath.replace("/",seperator);
    }
}
