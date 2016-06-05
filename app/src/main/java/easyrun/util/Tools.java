package easyrun.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {

	//判断是否有SD卡
	public static boolean hasSdcard(){
		String state = Environment.getExternalStorageState();
		if(state.equals(Environment.MEDIA_MOUNTED)){
			return true;
		}else{
			return false;
		}
	}

	public static Bitmap getPic(String path){
		File mFile=new File(path);
		//若该文件存在
		if (mFile.exists()) {
			Bitmap bitmap=BitmapFactory.decodeFile(path);
			return bitmap;
		}
		return null;
	}


	/**
	* 将Drawable转化为Bitmap
	* */
	public static Bitmap drawableToBitmap(Drawable drawable) {
		// 取 drawable 的长宽
		int w = drawable.getIntrinsicWidth();
		int h = drawable.getIntrinsicHeight();

		// 取 drawable 的颜色格式
		Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
				: Bitmap.Config.RGB_565;
		// 建立对应 bitmap
		Bitmap bitmap = Bitmap.createBitmap(w, h, config);
		// 建立对应 bitmap 的画布
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, w, h);
		// 把 drawable 内容画到画布中
		drawable.draw(canvas);
		return bitmap;
	}

	/**
	 * 把Bitmap转Byte
	 */
	public static byte[] Bitmap2Bytes(Bitmap bm){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		return baos.toByteArray();
	}

	/**
	 * 把Byte转Bitmap
	 */
	public static Bitmap Bytes2Bimap(byte[] b) {
		if (b.length != 0) {
			return BitmapFactory.decodeByteArray(b, 0, b.length);
		} else {
			return null;
		}
	}

	/**
	 * 把头像保存在sd卡中
	 */
	public static void setPicToView(Bitmap mBitmap,String path) {
		String sdStatus = Environment.getExternalStorageState();
		if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
			return;
		}
		FileOutputStream b = null;
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		String filePath =path+"icon.jpg";//图片名字
		Log.v("filePath","file Path = "+filePath);
		File file_target = new File(filePath);
		try {
			file_target.createNewFile();
			b = new FileOutputStream(file_target);
			mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		finally {
			try {
				b.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 把字节数组保存为一个文件
	 */
	public static File getFileFromBytes(byte[] b, String outputFile) {
		BufferedOutputStream stream = null;
		File file = null;
		try {
			file = new File(outputFile);
			if(!file.exists()){
				file.mkdirs();
			}
			String filename = "icon.jpg";
			File fileChild = new File(outputFile,filename);
			FileOutputStream fstream = new FileOutputStream(file);
			stream = new BufferedOutputStream(fstream);
			stream.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return file;
	}

	/**
	 * 获取SD卡根目录路径
	 *
	 * @return
	 */
	public static String getSdCardPath() {
		boolean exist = hasSdcard();
		String sdpath = "";
		if (exist) {
			sdpath = Environment.getExternalStorageDirectory()
					.getAbsolutePath();
		} else {
			sdpath = "不适用";
		}
		return sdpath;

	}

	/**
	 * 由long类型转换成Date类型
	 * */
	public static String transDate(long time){
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		java.util.Date dt = new Date(time * 1000);
		return sdf.format(dt);  //得到精确到秒的表示：08/31/2016 21:08:00
	}
}
